package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.domain.TicketScenicCategory;
import com.github.w4o.ticket.dto.CreateScenicCategoryParam;
import com.github.w4o.ticket.dto.UpdateScenicCategoryParam;
import com.github.w4o.ticket.repository.TicketScenicCategoryRepository;
import com.github.w4o.ticket.service.AdminScenicCategoryService;
import com.github.w4o.ticket.vo.ScenicCategoryOptionsVo;
import com.github.w4o.ticket.vo.ScenicCategoryOptionsWithChildrenVo;
import com.github.w4o.ticket.vo.ScenicCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @date 2019-05-25
 */
@Service
public class AdminScenicCategoryServiceImpl implements AdminScenicCategoryService {

    private final TicketScenicCategoryRepository scenicCategoryRepository;

    @Autowired
    public AdminScenicCategoryServiceImpl(TicketScenicCategoryRepository scenicCategoryRepository) {
        this.scenicCategoryRepository = scenicCategoryRepository;
    }

    @Override
    public List<ScenicCategoryVo> list(String name) {
        Iterable<TicketScenicCategory> allList = scenicCategoryRepository.findAll((Specification<TicketScenicCategory>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();

            list.add(criteriaBuilder.equal(root.get("deleted").as(Integer.class), 0));

            if (!StringUtils.isEmpty(name)) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%"));
            }

            criteriaQuery.orderBy(criteriaBuilder.asc(root.get("parentId")));

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        });
        List<ScenicCategoryVo> voList = new ArrayList<>();
        allList.forEach(e -> voList.add(
                ScenicCategoryVo.builder()
                        .id(e.getId())
                        .parentId(e.getParentId())
                        .name(e.getName())
                        .sort(e.getSort())
                        .navStatus(e.getNavStatus())
                        .showStatus(e.getShowStatus())
                        .scenicCount(e.getScenicCount())
                        .build()
        ));

        List<ScenicCategoryVo> result = new ArrayList<>();

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
    public List<ScenicCategoryOptionsVo> categoryOptions() {
        List<ScenicCategoryOptionsVo> result = new ArrayList<>();
        Iterable<TicketScenicCategory> list = scenicCategoryRepository.findByParentId(0);
        list.forEach(e -> result.add(
                ScenicCategoryOptionsVo.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .build()
        ));
        return result;
    }

    @Override
    public List<ScenicCategoryOptionsWithChildrenVo> optionsWithChildren() {

        Iterable<TicketScenicCategory> list = scenicCategoryRepository.findByDeletedIsFalse();

        List<ScenicCategoryOptionsWithChildrenVo> voList = new ArrayList<>();

        list.forEach(e -> voList.add(
                ScenicCategoryOptionsWithChildrenVo.builder()
                        .id(e.getId())
                        .label(e.getName())
                        .parentId(e.getParentId())
                        .build()
        ));

        List<ScenicCategoryOptionsWithChildrenVo> result = new ArrayList<>();
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
    public TicketScenicCategory create(CreateScenicCategoryParam param) {
        TicketScenicCategory existing = scenicCategoryRepository.findByName(param.getName());
        Assert.isNull(existing, "景点分类已存在: " + param.getName());

        TicketScenicCategory category = new TicketScenicCategory();
        category.preInsert();
        category.setName(param.getName());
        category.setDescription(param.getDescription());
        category.setIcon(param.getIcon());
        category.setNavStatus(param.getNavStatus());
        category.setParentId(param.getParentId());
        category.setShowStatus(param.getShowStatus());
        category.setSort(param.getSort());
        return scenicCategoryRepository.save(category);
    }

    @Override
    public TicketScenicCategory update(Integer id, UpdateScenicCategoryParam param) {
        TicketScenicCategory category =
                scenicCategoryRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("景点分类不存在"));

        category.preUpdate();
        category.setDescription(param.getDescription());
        category.setIcon(param.getIcon());
        category.setNavStatus(param.getNavStatus());
        category.setParentId(param.getParentId());
        category.setShowStatus(param.getShowStatus());
        category.setSort(param.getSort());
        return scenicCategoryRepository.save(category);
    }

    @Override
    public TicketScenicCategory delete(Integer id) {
        TicketScenicCategory category =
                scenicCategoryRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("商品分类不存在"));
        category.preDelete();
        return scenicCategoryRepository.save(category);
    }
}
