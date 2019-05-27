package com.github.w4o.ticket.dto;

import lombok.Data;

/**
 * @author frank
 * @date 2019-05-24
 */
@Data
public class CreateScenicCategoryParam {

    private String name;
    private String description;
    private String icon;
    private Integer navStatus;
    private Integer parentId;
    private Integer showStatus;
    private Integer sort;
}
