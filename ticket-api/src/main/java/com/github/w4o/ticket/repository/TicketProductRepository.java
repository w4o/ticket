package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketProduct;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author frank
 * @date 2019-05-24
 */
public interface TicketProductRepository
        extends PagingAndSortingRepository<TicketProduct, Integer>,
        JpaSpecificationExecutor<TicketProduct> {
}
