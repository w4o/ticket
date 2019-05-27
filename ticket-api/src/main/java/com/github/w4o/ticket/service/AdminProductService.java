package com.github.w4o.ticket.service;

import com.github.w4o.ticket.domain.TicketProduct;
import com.github.w4o.ticket.dto.CreateProductParam;
import com.github.w4o.ticket.dto.UpdateProductParam;
import org.springframework.data.domain.Page;

/**
 * @author frank
 * @date 2019-05-24
 */
public interface AdminProductService {

    /**
     * 商品列表
     *
     * @param name 检索条件：商品名
     * @param page 当前页码
     * @param size 分页条数
     * @return 分页列表
     */
    Page<TicketProduct> list(String name, Integer page, Integer size);

    /**
     * 创建商品
     *
     * @param param 创建商品参数
     * @return 商品实体
     */
    TicketProduct create(CreateProductParam param);

    /**
     * 创建商品
     *
     * @param id    商品主键id
     * @param param 创建商品参数
     * @return 商品实体
     */
    TicketProduct update(Integer id, UpdateProductParam param);

    /**
     * 创建商品
     *
     * @param id 商品主键id
     * @return 商品实体
     */
    TicketProduct delete(Integer id);
}
