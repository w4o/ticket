package com.github.w4o.ticket.service;

import com.github.w4o.ticket.domain.TicketAdmin;
import com.github.w4o.ticket.dto.AdminReadResult;
import com.github.w4o.ticket.dto.CreateAdminParam;
import com.github.w4o.ticket.dto.UpdateAdminParam;
import org.springframework.data.domain.Page;

/**
 * @author frank
 * @date 2019-05-14
 */
public interface AdminAdminService {

    /**
     * 管理员列表
     *
     * @param username 检索条件：用户名
     * @param page     当前页码
     * @param size     分页条数
     * @return 分页列表
     */
    Page<TicketAdmin> list(String username, Integer page, Integer size);

    /**
     * 管理员信息
     *
     * @param id 管理员id
     * @return 管理员信息
     */
    AdminReadResult info(Integer id);

    /**
     * 创建管理员
     *
     * @param createAdminParam 创建参数
     * @return 管理员实体
     */
    TicketAdmin create(CreateAdminParam createAdminParam);

    /**
     * 根据ID更新管理员信息
     *
     * @param id               id
     * @param updateAdminParam 更新参数
     * @return 管理员实体
     */
    TicketAdmin updateById(Integer id, UpdateAdminParam updateAdminParam);

    /**
     * 根据ID删除管理员
     *
     * @param id id
     */
    void deleteById(Integer id);
}
