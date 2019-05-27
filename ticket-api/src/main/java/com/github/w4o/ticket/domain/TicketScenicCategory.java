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
@Table(name = "ticket_scenic_category")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketScenicCategory extends BaseDataEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "scenic_count")
    private Integer scenicCount;
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
        this.scenicCount = 0;
    }

}
