package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketAdmin;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author frank
 * @date 2019-05-14
 */
@Repository
public interface TicketAdminRepository extends PagingAndSortingRepository<TicketAdmin, Integer>, JpaSpecificationExecutor<TicketAdmin> {

    /**
     * 根据用户名查询系统管理员
     *
     * @param username 用户名
     * @return 系统管理员
     */
    TicketAdmin findByUsername(String username);
}
