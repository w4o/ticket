package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketRolePermissionRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author frank
 * @date 2019-05-22
 */
@Repository
public interface TicketRolePermissionRelationRepository extends CrudRepository<TicketRolePermissionRelation, Integer> {

    /**
     * 根据角色id查询
     *
     * @param roleId 角色id
     * @return 结果
     */
    Iterable<TicketRolePermissionRelation> findByRoleId(Integer roleId);
}
