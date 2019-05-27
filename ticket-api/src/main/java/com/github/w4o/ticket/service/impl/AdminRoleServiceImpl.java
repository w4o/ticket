package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.domain.TicketPermission;
import com.github.w4o.ticket.domain.TicketRole;
import com.github.w4o.ticket.domain.TicketRolePermissionRelation;
import com.github.w4o.ticket.dto.CreateRoleParam;
import com.github.w4o.ticket.dto.PermissionsResult;
import com.github.w4o.ticket.dto.UpdateRoleParam;
import com.github.w4o.ticket.repository.TicketPermissionRepository;
import com.github.w4o.ticket.repository.TicketRolePermissionRelationRepository;
import com.github.w4o.ticket.repository.TicketRoleRepository;
import com.github.w4o.ticket.service.AdminRoleService;
import com.github.w4o.ticket.vo.PermissionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * @author frank
 * @date 2019-05-17
 */
@Service
@Slf4j
public class AdminRoleServiceImpl implements AdminRoleService {

    private final TicketRoleRepository roleRepository;
    private final TicketPermissionRepository permissionRepository;
    private final TicketRolePermissionRelationRepository rolePermissionRelationRepository;

    @Autowired
    public AdminRoleServiceImpl(TicketRoleRepository roleRepository,
                                TicketPermissionRepository permissionRepository,
                                TicketRolePermissionRelationRepository rolePermissionRelationRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.rolePermissionRelationRepository = rolePermissionRelationRepository;
    }

    @Override
    public Page<TicketRole> list(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return roleRepository.findAll((Specification<TicketRole>) (root, criteriaQuery, criteriaBuilder) -> {
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
    public TicketRole create(CreateRoleParam createRoleParam) {
        TicketRole existing = roleRepository.findByName(createRoleParam.getName());
        Assert.isNull(existing, "角色已存在: " + createRoleParam.getName());

        TicketRole role = new TicketRole();
        role.preInsert();
        role.setName(createRoleParam.getName());
        role.setDescription(createRoleParam.getDescription());
        roleRepository.save(role);
        return role;
    }

    @Override
    public TicketRole updateById(Integer id, UpdateRoleParam updateRoleParam) {
        TicketRole role = roleRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        // 如果修改角色名，需要检查修改后的角色名在数据库中是否存在
        if (!role.getName().equals(updateRoleParam.getName())) {
            TicketRole existing = roleRepository.findByName(updateRoleParam.getName());
            Assert.isNull(existing, "角色已存在: " + updateRoleParam.getName());
        }

        role.setName(updateRoleParam.getName());
        role.setDescription(updateRoleParam.getDescription());
        role.setUpdateTime(new Date());

        roleRepository.save(role);
        return role;
    }

    @Override
    public TicketRole deleteById(Integer id) {
        TicketRole role = roleRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        role.setDeleted(1);
        role.setUpdateTime(new Date());
        roleRepository.save(role);
        return role;
    }

    @Override
    public PermissionsResult getPermissions(Integer roleId) {

        PermissionsResult result = new PermissionsResult();
        TicketRole role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("角色不存在，roleId：" + roleId));

        Set<Integer> assignedPermissions = new HashSet<>();
        role.getPermissions().forEach(p -> assignedPermissions.add(p.getId()));
        result.setAssignedPermissions(assignedPermissions);

        Iterable<TicketPermission> allPermission = permissionRepository.findAll();
        List<PermissionVo> permissionVoList = new ArrayList<>();

        allPermission.forEach(permission -> permissionVoList.add(
                PermissionVo.builder()
                        .id(permission.getId())
                        .label(permission.getName())
                        .permission(permission.getPermission())
                        .parentId(permission.getParentId())
                        .type(permission.getType())
                        .build()
        ));

        List<PermissionVo> permissions = new ArrayList<>();

        for (PermissionVo vo : permissionVoList) {
            if (vo.getParentId().equals(0)) {
                permissions.add(vo);
            }

            for (PermissionVo iv : permissionVoList) {
                if (iv.getParentId().equals(vo.getId())) {
                    if (vo.getChildren() == null) {
                        vo.setChildren(new ArrayList<>());
                    }
                    vo.getChildren().add(iv);
                }
            }
        }

        result.setPermissions(permissions);

        return result;
    }

    @Override
    public void updatePermissions(Integer roleId, Integer[] permissions) {

        Iterable<TicketRolePermissionRelation> iterable = rolePermissionRelationRepository.findByRoleId(roleId);
        rolePermissionRelationRepository.deleteAll(iterable);

        List<TicketRolePermissionRelation> saves = new ArrayList<>();
        for (Integer pId : permissions) {
            TicketRolePermissionRelation r = new TicketRolePermissionRelation();
            r.setRoleId(roleId);
            r.setPermissionId(pId);
            saves.add(r);
        }
        rolePermissionRelationRepository.saveAll(saves);
    }
}
