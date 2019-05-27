package com.github.w4o.ticket.domain;

import com.github.w4o.ticket.commons.BaseDataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author frank
 * @date 2019-05-27
 */
@Entity
@Table(name = "ticket_storage")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketStorage extends BaseDataEntity {
    @Column(name = "`key`")
    private String key;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "size")
    private Integer size;
    @Column(name = "url")
    private String url;
}
