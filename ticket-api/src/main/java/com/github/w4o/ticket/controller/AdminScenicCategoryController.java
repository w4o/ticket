package com.github.w4o.ticket.controller;

import com.github.w4o.ticket.commons.CommonResult;
import com.github.w4o.ticket.dto.CreateScenicCategoryParam;
import com.github.w4o.ticket.dto.UpdateScenicCategoryParam;
import com.github.w4o.ticket.service.AdminScenicCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author frank
 * @date 2019-05-25
 */
@RestController
@RequestMapping("/admin/scenic_category")
public class AdminScenicCategoryController {

    private final AdminScenicCategoryService scenicCategoryService;

    @Autowired
    public AdminScenicCategoryController(AdminScenicCategoryService scenicCategoryService) {
        this.scenicCategoryService = scenicCategoryService;
    }

    /**
     * 获取景点分类列表
     */
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "name", required = false) String name) {
        return new CommonResult().okList(scenicCategoryService.list(name));
    }

    /**
     * 获取景点分类下拉列表项
     */
    @GetMapping("/options")
    public CommonResult options() {
        return new CommonResult().okList(scenicCategoryService.categoryOptions());
    }

    /**
     * 获取景点分类下拉列表：层级形式
     */
    @GetMapping("/options_children")
    public CommonResult optionsWithChildren() {
        return new CommonResult().okList(scenicCategoryService.optionsWithChildren());
    }


    /**
     * 创建景点分类
     */
    @PutMapping()
    public CommonResult createCategory(@RequestBody CreateScenicCategoryParam param) {
        return new CommonResult().ok(scenicCategoryService.create(param));
    }

    /**
     * 修改景点分类
     */
    @PostMapping("/{id}")
    public CommonResult updateCategory(@PathVariable(value = "id") Integer id,
                                       @RequestBody UpdateScenicCategoryParam param) {
        return new CommonResult().ok(scenicCategoryService.update(id, param));
    }

    /**
     * 删除景点分类
     */
    @DeleteMapping("/{id}")
    public CommonResult deleteCategory(@PathVariable(value = "id") Integer id) {
        return new CommonResult().ok(scenicCategoryService.delete(id));
    }

}
