package com.github.w4o.ticket.controller;

import com.github.w4o.ticket.commons.CommonResult;
import com.github.w4o.ticket.dto.CreateScenicParam;
import com.github.w4o.ticket.service.AdminScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author frank
 * @date 2019-05-25
 */
@RestController
@RequestMapping("/admin/scenic")
public class AdminScenicController {

    private final AdminScenicService scenicService;

    @Autowired
    public AdminScenicController(AdminScenicService scenicService) {
        this.scenicService = scenicService;
    }

    /**
     * 获取景点列表
     */
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "page") Integer page,
                             @RequestParam(value = "size") Integer size,
                             @RequestParam(value = "name", required = false) String name) {
        return new CommonResult().okPage(scenicService.list(name, page, size));
    }

    /**
     * 创建景点
     */
    @PutMapping
    public CommonResult create(@RequestBody CreateScenicParam param) {
        scenicService.create(param);
        return new CommonResult().ok();
    }

}
