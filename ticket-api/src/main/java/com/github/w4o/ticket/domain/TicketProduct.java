package com.github.w4o.ticket.domain;

import com.github.w4o.ticket.commons.BaseDataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author frank
 * @date 2019-05-24
 */
@Entity
@Table(name = "ticket_product")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketProduct extends BaseDataEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "sub_title")
    private String subTitle;
    @Column(name = "description")
    private String description;
    @Column(name = "sn")
    private String sn;
    @Column(name = "price")
    private Double price;
    @Column(name = "original_price")
    private Double originalPrice;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "unit")
    private String unit;
    @Column(name = "sort")
    private Integer sort;

}
