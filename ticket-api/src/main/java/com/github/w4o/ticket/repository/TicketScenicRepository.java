package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketScenic;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author frank
 * @date 2019-05-25
 */
@Repository
public interface TicketScenicRepository extends PagingAndSortingRepository<TicketScenic, Integer>,
        JpaSpecificationExecutor<TicketScenic> {
}
