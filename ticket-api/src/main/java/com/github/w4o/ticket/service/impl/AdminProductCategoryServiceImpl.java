package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.domain.TicketProductCategory;
import com.github.w4o.ticket.dto.CreateProductCategoryParam;
import com.github.w4o.ticket.dto.UpdateProductCategoryParam;
import com.github.w4o.ticket.repository.TicketProductCategoryRepository;
import com.github.w4o.ticket.service.AdminProductCategoryService;
import com.github.w4o.ticket.vo.ProductCategoryOptionsVo;
import com.github.w4o.ticket.vo.ProductCategoryOptionsWithChildrenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @date 2019-05-24
 */
@Service
public class AdminProductCategoryServiceImpl implements AdminProductCategoryService {

    private final TicketProductCategoryRepository productCategoryRepository;

    @Autowired
    public AdminProductCategoryServiceImpl(TicketProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public Page<TicketProductCategory> list(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return productCategoryRepository.findAll((Specification<TicketProductCategory>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();

            list.add(criteriaBuilder.equal(root.get("deleted").as(Integer.class), 0));

            if (!StringUtils.isEmpty(name)) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%"));
            }
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get("sort")));

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
    }

    @Override
    public List<ProductCategoryOptionsVo> categoryOptions() {
        List<ProductCategoryOptionsVo> result = new ArrayList<>();
        Sort sort = Sort.by("sort");
        Iterable<TicketProductCategory> allList = productCategoryRepository.findAll(sort);
        allList.forEach(c -> result.add(new ProductCategoryOptionsVo(c.getId(), c.getName())));
        return result;
    }

    @Override
    public List<ProductCategoryOptionsWithChildrenVo> optionsWithChildren() {
        List<ProductCategoryOptionsWithChildrenVo> result = new ArrayList<>();

        Sort sort = Sort.by("parentId");
        Iterable<TicketProductCategory> allList = productCategoryRepository.findAll(sort);

        List<ProductCategoryOptionsWithChildrenVo> voList = new ArrayList<>();

        allList.forEach(c -> voList.add(
                ProductCategoryOptionsWithChildrenVo.builder()
                        .id(c.getId())
                        .label(c.getName())
                        .parentId(c.getParentId())
                        .build()
        ));


        voList.forEach(vo -> {
            if (vo.getParentId().equals(0)) {
                result.add(vo);
            }

            voList.forEach(e -> {
                if (e.getParentId().equals(vo.getId())) {
                    if (vo.getChildren() == null) {
                        vo.setChildren(new ArrayList<>());
                    }
                    vo.getChildren().add(e);
                }
            });
        });

        return result;
    }

    @Override
    public TicketProductCategory create(CreateProductCategoryParam param) {
        TicketProductCategory existing = productCategoryRepository.findByName(param.getName());
        Assert.isNull(existing, "商品分类已存在: " + param.getName());

        TicketProductCategory ticketProductCategory = new TicketProductCategory();
        ticketProductCategory.preInsert();
        ticketProductCategory.setName(param.getName());
        ticketProductCategory.setDescription(param.getDescription());
        ticketProductCategory.setIcon(param.getIcon());
        ticketProductCategory.setNavStatus(param.getNavStatus());
        ticketProductCategory.setParentId(param.getParentId());
        ticketProductCategory.setShowStatus(param.getShowStatus());
        ticketProductCategory.setProductUnit(param.getProductUnit());
        ticketProductCategory.setSort(param.getSort());
        return productCategoryRepository.save(ticketProductCategory);
    }

    @Override
    public TicketProductCategory update(Integer id, UpdateProductCategoryParam param) {
        TicketProductCategory ticketProductCategory =
                productCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("商品分类不存在"));

        ticketProductCategory.preUpdate();
        ticketProductCategory.setDescription(param.getDescription());
        ticketProductCategory.setIcon(param.getIcon());
        ticketProductCategory.setNavStatus(param.getNavStatus());
        ticketProductCategory.setParentId(param.getParentId());
        ticketProductCategory.setShowStatus(param.getShowStatus());
        ticketProductCategory.setProductUnit(param.getProductUnit());
        ticketProductCategory.setSort(param.getSort());
        return productCategoryRepository.save(ticketProductCategory);
    }

    @Override
    public TicketProductCategory delete(Integer id) {
        TicketProductCategory ticketProductCategory =
                productCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("商品分类不存在"));
        ticketProductCategory.preDelete();
        return productCategoryRepository.save(ticketProductCategory);
    }
}
