package com.github.w4o.ticket.domain;

import com.github.w4o.ticket.commons.BaseDataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author frank
 * @date 2019-05-25
 */
@Entity
@Table(name = "ticket_scenic")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketScenic extends BaseDataEntity {
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "sell_point")
    private String sellPoint;
    @Column(name = "open_time")
    private String openTime;
    @Column(name = "address")
    private String address;
    @Column(name = "address_lng")
    private String addressLng;
    @Column(name = "address_lat")
    private String addressLat;
    @Column(name = "notice")
    private String notice;
    @Column(name = "description")
    private String description;
}
