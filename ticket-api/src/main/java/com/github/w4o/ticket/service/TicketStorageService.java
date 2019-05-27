package com.github.w4o.ticket.service;

import com.github.w4o.ticket.domain.TicketStorage;

/**
 * @author frank
 * @date 2019-05-27
 */
public interface TicketStorageService {

    /**
     * 添加storage
     *
     * @param ticketStorage storage实体
     * @return entity
     */
    TicketStorage add(TicketStorage ticketStorage);

    /**
     * 根据key查找
     *
     * @param key key
     * @return entity
     */
    TicketStorage findByKey(String key);
}
