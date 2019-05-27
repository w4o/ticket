package com.github.w4o.ticket.service;

import com.github.w4o.ticket.domain.TicketAdminLog;
import org.springframework.data.domain.Page;

/**
 * @author frank
 * @date 2019-05-17
 */
public interface AdminAdminLogService {
    /**
     * 后台日志列表
     *
     * @param page 当前页码
     * @param size 分页条数
     * @return 分页列表
     */
    Page<TicketAdminLog> list(Integer page, Integer size);

}
