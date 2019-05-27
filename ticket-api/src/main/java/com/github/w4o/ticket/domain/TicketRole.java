package com.github.w4o.ticket.domain;

import com.github.w4o.ticket.commons.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author frank
 * @date 2019-05-17
 */
@Entity
@Table(name = "ticket_role")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketRole extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "deleted")
    private Integer deleted;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ticket_role_permission_relation",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<TicketPermission> permissions;

    public void preInsert() {
        this.deleted = 0;
        this.createTime = new Date();
    }
}
