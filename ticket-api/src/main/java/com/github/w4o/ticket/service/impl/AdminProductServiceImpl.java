package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.domain.TicketProduct;
import com.github.w4o.ticket.dto.CreateProductParam;
import com.github.w4o.ticket.dto.UpdateProductParam;
import com.github.w4o.ticket.repository.TicketProductRepository;
import com.github.w4o.ticket.service.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @date 2019-05-24
 */
@Service
public class AdminProductServiceImpl implements AdminProductService {

    private final TicketProductRepository productRepository;

    @Autowired
    public AdminProductServiceImpl(TicketProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<TicketProduct> list(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return productRepository.findAll((Specification<TicketProduct>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();

            list.add(criteriaBuilder.equal(root.get("deleted").as(Integer.class), 0));

            if (!StringUtils.isEmpty(name)) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%"));
            }

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
    }

    @Override
    public TicketProduct create(CreateProductParam param) {
        return null;
    }

    @Override
    public TicketProduct update(Integer id, UpdateProductParam param) {
        return null;
    }

    @Override
    public TicketProduct delete(Integer id) {
        return null;
    }
}
