package com.github.w4o.ticket.service;

import com.github.w4o.ticket.domain.TicketRole;
import com.github.w4o.ticket.dto.CreateRoleParam;
import com.github.w4o.ticket.dto.PermissionsResult;
import com.github.w4o.ticket.dto.UpdateRoleParam;
import org.springframework.data.domain.Page;

/**
 * @author frank
 * @date 2019-05-17
 */
public interface AdminRoleService {

    /**
     * 列表查询
     *
     * @param name 搜索条件：name
     * @param page 当前页码
     * @param size 分页条数
     * @return 分页列表
     */
    Page<TicketRole> list(String name, Integer page, Integer size);

    /**
     * 创建新角色
     *
     * @param createRoleParam 参数
     * @return 角色实体
     */
    TicketRole create(CreateRoleParam createRoleParam);

    /**
     * 更新角色信息
     *
     * @param id              角色id
     * @param updateRoleParam 参数
     * @return 角色实体
     */
    TicketRole updateById(Integer id, UpdateRoleParam updateRoleParam);

    /**
     * 逻辑删除角色信息
     *
     * @param id 角色id
     * @return 角色实体
     */
    TicketRole deleteById(Integer id);

    /**
     * 获取系统权限和对应角色已分配的权限
     *
     * @param roleId 角色ID
     * @return 结果
     */
    PermissionsResult getPermissions(Integer roleId);

    /**
     * 更新角色权限
     *
     * @param roleId      角色ID
     * @param permissions 权限数组
     */
    void updatePermissions(Integer roleId, Integer[] permissions);
}
