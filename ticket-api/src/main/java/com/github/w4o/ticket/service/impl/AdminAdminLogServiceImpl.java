package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.domain.TicketAdminLog;
import com.github.w4o.ticket.repository.TicketAdminLogRepository;
import com.github.w4o.ticket.service.AdminAdminLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author frank
 * @date 2019-05-17
 */
@Service
public class AdminAdminLogServiceImpl implements AdminAdminLogService {

    private final TicketAdminLogRepository adminLogRepository;

    @Autowired
    public AdminAdminLogServiceImpl(TicketAdminLogRepository adminLogRepository) {
        this.adminLogRepository = adminLogRepository;
    }

    @Override
    public Page<TicketAdminLog> list(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        return adminLogRepository.findAll(pageable);
    }
}
