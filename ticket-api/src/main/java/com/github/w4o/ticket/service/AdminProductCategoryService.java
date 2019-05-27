package com.github.w4o.ticket.service;

import com.github.w4o.ticket.domain.TicketProductCategory;
import com.github.w4o.ticket.dto.CreateProductCategoryParam;
import com.github.w4o.ticket.dto.UpdateProductCategoryParam;
import com.github.w4o.ticket.vo.ProductCategoryOptionsVo;
import com.github.w4o.ticket.vo.ProductCategoryOptionsWithChildrenVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author frank
 * @date 2019-05-24
 */
public interface AdminProductCategoryService {

    /**
     * 商品分类列表
     *
     * @param name 检索条件：商品分类名
     * @param page 当前页码
     * @param size 分页条数
     * @return 分页列表
     */
    Page<TicketProductCategory> list(String name, Integer page, Integer size);

    /**
     * 获取商品分类下拉列表项数据
     *
     * @return 结果集合
     */
    List<ProductCategoryOptionsVo> categoryOptions();

    /**
     * 获取商品分类下拉列表项数据：联动形式
     *
     * @return 结果集合
     */
    List<ProductCategoryOptionsWithChildrenVo> optionsWithChildren();

    /**
     * 创建商品分类
     *
     * @param param 创建商品分类参数
     * @return 商品分类实体
     */
    TicketProductCategory create(CreateProductCategoryParam param);

    /**
     * 修改商品分类
     *
     * @param id    商品分类主键id
     * @param param 修改商品分类参数
     * @return 商品分类实体
     */
    TicketProductCategory update(Integer id, UpdateProductCategoryParam param);

    /**
     * 逻辑删除商品分类
     *
     * @param id 商品分类主键id
     * @return 商品分类实体
     */
    TicketProductCategory delete(Integer id);
}
