package com.github.w4o.ticket.service;

import com.github.w4o.ticket.dto.AuthInfoResult;
import com.github.w4o.ticket.dto.LoginParam;
import com.github.w4o.ticket.dto.LoginResult;

/**
 * @author frank
 * @date 2019-05-20
 */
public interface AdminAuthService {

    /**
     * 管理员登陆
     *
     * @param loginParam 登陆参数，包含username和password
     * @return token
     */
    LoginResult login(LoginParam loginParam);

    /**
     * 根据用户名获取管理员信息
     *
     * @param username 用户名
     * @return 管理员
     */
    AuthInfoResult getAdminInfo(String username);
}
