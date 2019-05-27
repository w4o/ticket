package com.github.w4o.ticket.controller;

import com.github.w4o.ticket.commons.CommonResult;
import com.github.w4o.ticket.domain.TicketAdmin;
import com.github.w4o.ticket.dto.CreateAdminParam;
import com.github.w4o.ticket.dto.UpdateAdminParam;
import com.github.w4o.ticket.service.AdminAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author frank
 * @date 2019-05-16
 */
@RestController
@RequestMapping("/admin/admin")
@Api(tags = "系统管理-管理员")
public class AdminAdminController {

    private final AdminAdminService adminService;

    @Autowired
    public AdminAdminController(AdminAdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 管理员列表
     */
    @ApiOperation("获取管理员列表")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "username", required = false) String username,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size) {
        return new CommonResult().okPage(adminService.list(username, page, size));
    }

    /**
     * 管理员信息
     */
    @ApiOperation("获取指定管理员信息")
    @GetMapping("/read/{id}")
    public CommonResult read(@PathVariable("id") Integer id) {
        return new CommonResult().ok(adminService.info(id));
    }

    /**
     * 创建管理员
     */
    @ApiOperation("创建管理员信息")
    @PutMapping("/create")
    public CommonResult create(@RequestBody CreateAdminParam createAdminParam) {
        TicketAdmin admin = adminService.create(createAdminParam);
        return new CommonResult().ok(admin);
    }

    /**
     * 更新管理员
     */
    @ApiOperation("更新指定管理员信息")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable("id") Integer id,
                               @RequestBody UpdateAdminParam updateAdminParam) {
        TicketAdmin admin = adminService.updateById(id, updateAdminParam);
        return new CommonResult().ok(admin);
    }

    /**
     * 删除管理员
     */
    @ApiOperation("指定指定管理员")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") Integer id) {
        adminService.deleteById(id);
        return new CommonResult().ok();
    }
}
