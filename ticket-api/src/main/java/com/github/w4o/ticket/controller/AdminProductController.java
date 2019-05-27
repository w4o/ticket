package com.github.w4o.ticket.controller;

import com.github.w4o.ticket.commons.CommonResult;
import com.github.w4o.ticket.service.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author frank
 * @date 2019-05-24
 */
@RestController
@RequestMapping("/admin/product")
public class AdminProductController {

    private final AdminProductService productService;

    @Autowired
    private AdminProductController(AdminProductService productService) {
        this.productService = productService;
    }

    /**
     * 获取商品列表
     */
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "page") Integer page,
                             @RequestParam(value = "size") Integer size,
                             @RequestParam(value = "name", required = false) String name) {
        return new CommonResult().okPage(productService.list(name, page, size));
    }


}
