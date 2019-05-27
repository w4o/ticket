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
@Table(name = "ticket_product_category")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketProductCategory extends BaseDataEntity {

    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "name")
    private String name;
    @Column(name = "product_count")
    private Integer productCount;
    @Column(name = "product_unit")
    private String productUnit;
    @Column(name = "sort")
    private Integer sort;
    @Column(name = "icon")
    private String icon;
    @Column(name = "show_status")
    private Integer showStatus;
    @Column(name = "nav_status")
    private Integer navStatus;
    @Column(name = "description")
    private String description;

    @Override
    public void preInsert() {
        super.preInsert();
        this.productCount = 0;
    }

}
