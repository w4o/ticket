package com.github.w4o.ticket.dto;

import com.github.w4o.ticket.vo.PermissionVo;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author frank
 * @date 2019-05-21
 */
@Data
public class PermissionsResult {
    private List<PermissionVo> permissions;
    private Set<Integer> assignedPermissions;
}
