package com.github.w4o.ticket.storage;

import com.github.w4o.ticket.domain.TicketStorage;
import com.github.w4o.ticket.service.TicketStorageService;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.InputStream;

/**
 * @author frank
 * @date 2019-05-27
 */
@Data
public class StorageService {

    private String active;
    private Storage storage;

    private final TicketStorageService ticketStorageService;

    public StorageService(TicketStorageService ticketStorageService) {
        this.ticketStorageService = ticketStorageService;
    }

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     */
    public TicketStorage store(InputStream inputStream, long contentLength, String contentType, String fileName) {
        String key = generateKey(fileName);
        storage.store(inputStream, contentLength, contentType, key);

        String url = generateUrl(key);
        TicketStorage storage = new TicketStorage();
        storage.setName(fileName);
        storage.setSize((int) contentLength);
        storage.setType(contentType);
        storage.setKey(key);
        storage.setUrl(url);
        return ticketStorageService.add(storage);
    }

    /**
     * 生成key
     */
    private String generateKey(String originalFilename) {
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);
        String key;
        TicketStorage storage;
        do {
            key = RandomStringUtils.randomAlphanumeric(20) + suffix;
            storage = ticketStorageService.findByKey(key);
        }
        while (storage != null);
        return key;
    }

    /**
     * 生成url
     */
    private String generateUrl(String keyName) {
        return storage.generateUrl(keyName);
    }
}
