package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketPermission;
import org.springframework.data.repository.CrudRepository;

/**
 * @author frank
 * @date 2019-05-21
 */
public interface TicketPermissionRepository extends CrudRepository<TicketPermission, Integer> {
}
