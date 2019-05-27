package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketStorage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author frank
 * @date 2019-05-27
 */
@Repository
public interface TicketStorageRepository extends CrudRepository<TicketStorage, Integer> {

    /**
     * 根据Key获取
     *
     * @param key key
     * @return storage实体
     */
    TicketStorage findByKey(String key);
}
