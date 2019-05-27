package com.github.w4o.ticket.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author frank
 * @date 2019-05-27
 */
@Data
@Builder
public class ScenicCategoryVo {

    private Integer id;
    private String name;
    private Integer parentId;
    private Integer scenicCount;
    private Integer sort;
    private Integer showStatus;
    private Integer navStatus;

    private List<ScenicCategoryVo> children;
}
