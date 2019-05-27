package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author frank
 * @date 2019-05-20
 */
public interface TicketRoleRepository extends PagingAndSortingRepository<TicketRole, Integer>, JpaSpecificationExecutor<TicketRole> {

    /**
     * 根据名称查找角色信息
     *
     * @param name 角色名
     * @return 角色实体
     */
    TicketRole findByName(String name);
}
