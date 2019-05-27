package com.github.w4o.ticket.service;

import com.github.w4o.ticket.domain.TicketScenic;
import com.github.w4o.ticket.dto.CreateScenicParam;
import org.springframework.data.domain.Page;

/**
 * @author frank
 * @date 2019-05-25
 */
public interface AdminScenicService {

    /**
     * 景点列表
     *
     * @param name 检索条件：景点名
     * @param page 当前页码
     * @param size 分页条数
     * @return 分页列表
     */
    Page<TicketScenic> list(String name, Integer page, Integer size);

    /**
     * 创建景点
     *
     * @param param 创建景点参数
     */
    void create(CreateScenicParam param);

}
