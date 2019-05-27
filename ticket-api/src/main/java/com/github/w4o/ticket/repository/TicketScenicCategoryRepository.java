package com.github.w4o.ticket.repository;

import com.github.w4o.ticket.domain.TicketScenicCategory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author frank
 * @date 2019-05-25
 */
@Repository
public interface TicketScenicCategoryRepository extends CrudRepository<TicketScenicCategory, Integer>,
        JpaSpecificationExecutor<TicketScenicCategory> {

    /**
     * 根据parentId查询景点分类集合
     *
     * @param parentId 父id
     * @return 景点分类集合
     */
    Iterable<TicketScenicCategory> findByParentId(Integer parentId);

    /**
     * 根据分类名查询景点分类
     *
     * @param name 分类名
     * @return 景点分类集合
     */
    TicketScenicCategory findByName(String name);

    /**
     * 查询未删除集合
     *
     * @return 景点分类集合
     */
    Iterable<TicketScenicCategory> findByDeletedIsFalse();
}
