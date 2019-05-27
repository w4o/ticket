package com.github.w4o.ticket.domain;

import com.github.w4o.ticket.commons.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author frank
 * @date 2019-05-17
 */
@Entity
@Table(name = "ticket_admin_log")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketAdminLog extends BaseEntity {

    @Column(name = "admin")
    private String admin;
    @Column(name = "path")
    private String path;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "action")
    private String action;
    @Column(name = "type")
    private Integer type;
    @Column(name = "result")
    private String result;
    @Column(name = "ip")
    private String ip;
}
