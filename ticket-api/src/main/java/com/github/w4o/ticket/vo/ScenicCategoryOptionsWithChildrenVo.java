package com.github.w4o.ticket.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author frank
 * @date 2019-05-25
 */
@Data
@Builder
public class ScenicCategoryOptionsWithChildrenVo {
    private Integer id;
    private String label;
    private Integer parentId;
    private List<ScenicCategoryOptionsWithChildrenVo> children;
}
