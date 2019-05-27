package com.github.w4o.ticket.domain;

import com.github.w4o.ticket.commons.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author frank
 * @date 2019-05-14
 */
@Entity
@Table(name = "ticket_admin")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketAdmin extends BaseEntity {

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 备注信息
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标记
     */
    @Column(name = "deleted")
    private Integer deleted;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ticket_admin_role_relation",
            joinColumns = {@JoinColumn(name = "admin_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<TicketRole> roles;

    public void preInsert() {
        this.deleted = 0;
        this.createTime = new Date();
    }
}
