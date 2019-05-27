package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketAdminLog;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author frank
 * @date 2019-05-17
 */
public interface TicketAdminLogRepository extends PagingAndSortingRepository<TicketAdminLog, Integer> {
}
