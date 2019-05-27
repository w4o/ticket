package com.github.w4o.ticket.controller;

import com.github.w4o.ticket.commons.CommonResult;
import com.github.w4o.ticket.domain.TicketStorage;
import com.github.w4o.ticket.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author frank
 * @date 2019-05-27
 */
@RestController
@RequestMapping("/admin/storage")
@Validated
public class AdminStorageController {

    private final StorageService storageService;

    @Autowired
    public AdminStorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        TicketStorage storage = storageService.store(file.getInputStream(), file.getSize(), file.getContentType(), originalFilename);
        return new CommonResult().ok(storage);
    }
}
