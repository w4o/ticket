package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketScenicPhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author frank
 * @date 2019-05-27
 */
@Repository
public interface TicketScenicPhotoRepository extends CrudRepository<TicketScenicPhoto, Integer> {
}
