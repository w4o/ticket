package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.domain.TicketAdmin;
import com.github.w4o.ticket.dto.AdminReadResult;
import com.github.w4o.ticket.dto.CreateAdminParam;
import com.github.w4o.ticket.dto.UpdateAdminParam;
import com.github.w4o.ticket.repository.TicketAdminRepository;
import com.github.w4o.ticket.service.AdminAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author frank
 * @date 2019-05-14
 */
@Service
public class AdminAdminServiceImpl implements AdminAdminService {

    private final TicketAdminRepository adminRepository;

    @Autowired
    public AdminAdminServiceImpl(TicketAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Page<TicketAdmin> list(String username, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return adminRepository.findAll((Specification<TicketAdmin>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();

            list.add(criteriaBuilder.equal(root.get("deleted").as(Integer.class), 0));

            if (!StringUtils.isEmpty(username)) {
                list.add(criteriaBuilder.like(root.get("username").as(String.class), "%" + username + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
    }

    @Override
    public AdminReadResult info(Integer id) {
        TicketAdmin admin = adminRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        AdminReadResult result = new AdminReadResult();
        result.setId(admin.getId());
        result.setAvatar(admin.getAvatar());
        result.setUsername(admin.getUsername());
        result.setRemark(admin.getRemark());
        return result;
    }

    @Override
    public TicketAdmin create(CreateAdminParam createAdminParam) {

        TicketAdmin existing = adminRepository.findByUsername(createAdminParam.getUsername());
        Assert.isNull(existing, "管理员已存在: " + createAdminParam.getUsername());

        String rawPassword = createAdminParam.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);

        TicketAdmin admin = new TicketAdmin();
        admin.preInsert();
        admin.setAvatar(createAdminParam.getAvatar());
        admin.setUsername(createAdminParam.getUsername());
        admin.setRemark(createAdminParam.getRemark());
        admin.setPassword(encodedPassword);

        return adminRepository.save(admin);
    }

    @Override
    public TicketAdmin updateById(Integer id, UpdateAdminParam updateAdminParam) {
        TicketAdmin admin = adminRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        admin.setRemark(updateAdminParam.getRemark());
        admin.setAvatar(updateAdminParam.getAvatar());
        admin.setUpdateTime(new Date());
        adminRepository.save(admin);
        return admin;
    }

    @Override
    public void deleteById(Integer id) {
        TicketAdmin admin = adminRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        admin.setDeleted(1);
        adminRepository.save(admin);
    }
}
