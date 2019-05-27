package com.github.w4o.ticket.dto;

import lombok.Data;

/**
 * @author frank
 * @date 2019-05-27
 */
@Data
public class CreateScenicParam {
    private String name;
    private String shortName;
    private Integer categoryId;
    private String sellPoint;
    private String openTime;
    private String address;
    private String picUrl;
    private String description;
    private String notice;
    private String[] photo;
}
