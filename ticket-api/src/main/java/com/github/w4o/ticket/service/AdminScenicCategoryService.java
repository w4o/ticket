package com.github.w4o.ticket.service;

import com.github.w4o.ticket.domain.TicketScenicCategory;
import com.github.w4o.ticket.dto.CreateScenicCategoryParam;
import com.github.w4o.ticket.dto.UpdateScenicCategoryParam;
import com.github.w4o.ticket.vo.ScenicCategoryOptionsVo;
import com.github.w4o.ticket.vo.ScenicCategoryOptionsWithChildrenVo;
import com.github.w4o.ticket.vo.ScenicCategoryVo;

import java.util.List;

/**
 * @author frank
 * @date 2019-05-25
 */
public interface AdminScenicCategoryService {

    /**
     * 景点分类列表
     *
     * @param name 检索条件：景点分类名
     * @return 列表
     */
    List<ScenicCategoryVo> list(String name);

    /**
     * 获取景点分类下拉列表项数据
     *
     * @return 结果集合
     */
    List<ScenicCategoryOptionsVo> categoryOptions();

    /**
     * 获取景点分类下拉列表项数据：联动形式
     *
     * @return 结果集合
     */
    List<ScenicCategoryOptionsWithChildrenVo> optionsWithChildren();

    /**
     * 创建景点分类
     *
     * @param param 创建景点分类参数
     * @return 景点分类实体
     */
    TicketScenicCategory create(CreateScenicCategoryParam param);

    /**
     * 修改景点分类
     *
     * @param id    景点分类主键id
     * @param param 修改景点分类参数
     * @return 景点分类实体
     */
    TicketScenicCategory update(Integer id, UpdateScenicCategoryParam param);

    /**
     * 逻辑删除景点分类
     *
     * @param id 景点分类主键id
     * @return 景点分类实体
     */
    TicketScenicCategory delete(Integer id);
}
