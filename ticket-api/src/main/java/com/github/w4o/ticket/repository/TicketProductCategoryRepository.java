package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketProductCategory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author frank
 * @date 2019-05-24
 */
@Repository
public interface TicketProductCategoryRepository
        extends PagingAndSortingRepository<TicketProductCategory, Integer>,
        JpaSpecificationExecutor<TicketProductCategory> {

    /**
     * 根据分类名查询
     *
     * @param name 分类名
     * @return 商品分类实体
     */
    TicketProductCategory findByName(String name);
}
