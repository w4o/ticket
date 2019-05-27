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
@Table(name = "ticket_scenic_photo")
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketScenicPhoto extends BaseDataEntity {
    @Column(name = "scenic_id")
    private Integer scenicId;
    @Column(name = "path")
    private String path;
}
