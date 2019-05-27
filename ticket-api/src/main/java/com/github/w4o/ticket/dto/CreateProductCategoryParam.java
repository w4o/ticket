package com.github.w4o.ticket.dto;

import lombok.Data;

/**
 * @author frank
 * @date 2019-05-24
 */
@Data
public class CreateProductCategoryParam {

    private String name;
    private String productUnit;
    private String description;
    private String icon;
    private Integer navStatus;
    private Integer parentId;
    private Integer showStatus;
    private Integer sort;
}
