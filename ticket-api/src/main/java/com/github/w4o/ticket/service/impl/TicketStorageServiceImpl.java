package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.domain.TicketStorage;
import com.github.w4o.ticket.repository.TicketStorageRepository;
import com.github.w4o.ticket.service.TicketStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author frank
 * @date 2019-05-27
 */
@Service
public class TicketStorageServiceImpl implements TicketStorageService {

    private final TicketStorageRepository storageRepository;

    @Autowired
    public TicketStorageServiceImpl(TicketStorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public TicketStorage add(TicketStorage ticketStorage) {
        return storageRepository.save(ticketStorage);
    }

    @Override
    public TicketStorage findByKey(String key) {
        return storageRepository.findByKey(key);
    }
}
