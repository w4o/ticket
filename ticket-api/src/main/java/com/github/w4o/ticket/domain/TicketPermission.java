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
@Table(name = "ticket_permission")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketPermission extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "permission")
    private String permission;
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "type")
    private Integer type;
}