package com.github.w4o.ticket.domain;

import com.github.w4o.ticket.commons.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author frank
 * @date 2019-05-20
 */
@Entity
@Table(name = "ticket_admin_role_relation")
@Data
@EqualsAndHashCode(callSuper = true)
public class TicketAdminRoleRelation extends BaseEntity {

    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "role_id")
    private Integer roleId;
}
