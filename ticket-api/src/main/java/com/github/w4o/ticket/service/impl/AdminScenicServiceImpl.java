package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.domain.TicketScenic;
import com.github.w4o.ticket.domain.TicketScenicPhoto;
import com.github.w4o.ticket.dto.CreateScenicParam;
import com.github.w4o.ticket.repository.TicketScenicPhotoRepository;
import com.github.w4o.ticket.repository.TicketScenicRepository;
import com.github.w4o.ticket.service.AdminScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @date 2019-05-25
 */
@Service
public class AdminScenicServiceImpl implements AdminScenicService {

    private final TicketScenicRepository scenicRepository;
    private final TicketScenicPhotoRepository scenicPhotoRepository;

    @Autowired

    public AdminScenicServiceImpl(TicketScenicRepository scenicRepository,
                                  TicketScenicPhotoRepository scenicPhotoRepository) {
        this.scenicRepository = scenicRepository;
        this.scenicPhotoRepository = scenicPhotoRepository;
    }

    @Override
    public Page<TicketScenic> list(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return scenicRepository.findAll((Specification<TicketScenic>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();

            list.add(criteriaBuilder.equal(root.get("deleted").as(Integer.class), 0));

            if (!StringUtils.isEmpty(name)) {
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%"));
            }

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(CreateScenicParam param) {

        TicketScenic ticketScenic = new TicketScenic();
        ticketScenic.preInsert();
        ticketScenic.setName(param.getName());
        ticketScenic.setAddress(param.getAddress());
        ticketScenic.setCategoryId(param.getCategoryId());
        ticketScenic.setDescription(param.getDescription());
        ticketScenic.setNotice(param.getNotice());
        ticketScenic.setOpenTime(param.getOpenTime());
        ticketScenic.setShortName(param.getShortName());
        // 保存景点数据
        ticketScenic = scenicRepository.save(ticketScenic);

        //如果景点相册不为空，创建对应数据
        List<TicketScenicPhoto> photos = new ArrayList<>();
        if (param.getPhoto() != null) {
            for (String url : param.getPhoto()) {
                TicketScenicPhoto photo = new TicketScenicPhoto();
                photo.preInsert();
                photo.setPath(url);
                photo.setScenicId(ticketScenic.getId());
                photos.add(photo);
            }
            scenicPhotoRepository.saveAll(photos);
        }
    }
}
