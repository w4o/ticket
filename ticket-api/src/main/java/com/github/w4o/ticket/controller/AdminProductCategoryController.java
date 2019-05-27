package com.github.w4o.ticket.controller;

import com.github.w4o.ticket.commons.CommonResult;
import com.github.w4o.ticket.dto.CreateProductCategoryParam;
import com.github.w4o.ticket.dto.UpdateProductCategoryParam;
import com.github.w4o.ticket.service.AdminProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author frank
 * @date 2019-05-25
 */
@RestController
@RequestMapping("/admin/product_category")
public class AdminProductCategoryController {


    private final AdminProductCategoryService productCategoryService;

    @Autowired
    public AdminProductCategoryController(AdminProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    /**
     * 获取商品分类列表
     */
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "page") Integer page,
                             @RequestParam(value = "size") Integer size,
                             @RequestParam(value = "name", required = false) String name) {
        return new CommonResult().okPage(productCategoryService.list(name, page, size));
    }

    /**
     * 获取商品分类下拉列表项
     */
    @GetMapping("/options")
    public CommonResult options() {
        return new CommonResult().okList(productCategoryService.categoryOptions());
    }

    /**
     * 获取商品分类下拉列表：层级形式
     *
     * @return
     */
    @GetMapping("/options_children")
    public CommonResult optionsWithChildren() {
        return new CommonResult().okList(productCategoryService.optionsWithChildren());
    }

    /**
     * 创建商品分类
     */
    @PutMapping()
    public CommonResult createCategory(@RequestBody CreateProductCategoryParam param) {
        return new CommonResult().ok(productCategoryService.create(param));
    }

    /**
     * 修改商品分类
     */
    @PostMapping("/{id}")
    public CommonResult updateCategory(@PathVariable(value = "id") Integer id,
                                       @RequestBody UpdateProductCategoryParam param) {
        return new CommonResult().ok(productCategoryService.update(id, param));
    }

    /**
     * 删除商品分类
     */
    @DeleteMapping("/{id}")
    public CommonResult deleteCategory(@PathVariable(value = "id") Integer id) {
        return new CommonResult().ok(productCategoryService.delete(id));
    }

}
