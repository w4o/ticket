package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.component.AdminLogHelper;
import com.github.w4o.ticket.component.JwtTokenUtil;
import com.github.w4o.ticket.domain.TicketAdmin;
import com.github.w4o.ticket.domain.TicketPermission;
import com.github.w4o.ticket.domain.TicketRole;
import com.github.w4o.ticket.dto.AuthInfoResult;
import com.github.w4o.ticket.dto.LoginParam;
import com.github.w4o.ticket.dto.LoginResult;
import com.github.w4o.ticket.repository.TicketAdminRepository;
import com.github.w4o.ticket.repository.AdminUserDetailsRepository;
import com.github.w4o.ticket.service.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author frank
 * @date 2019-05-20
 */
@Service
public class AdminAuthServiceImpl implements AdminAuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AdminUserDetailsRepository userDetailsRepository;
    private final AdminLogHelper adminLogHelper;
    private final TicketAdminRepository adminRepository;

    private HashMap<String, String> permissionsMap = null;

    @Autowired
    public AdminAuthServiceImpl(PasswordEncoder passwordEncoder,
                                JwtTokenUtil jwtTokenUtil,
                                AdminUserDetailsRepository userDetailsRepository,
                                AdminLogHelper adminLogHelper,
                                TicketAdminRepository adminRepository) {
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsRepository = userDetailsRepository;
        this.adminLogHelper = adminLogHelper;
        this.adminRepository = adminRepository;
    }

    @Override
    public LoginResult login(LoginParam loginParam) {
        UserDetails userDetails = userDetailsRepository.findByUsername(loginParam.getUsername());
        if (!passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
        adminLogHelper.loginSucceed();
        // TODO 之后增加登陆时间
        return new LoginResult(token);
    }

    @Override
    @Cacheable(value = "adminInfo", key = "#username")
    public AuthInfoResult getAdminInfo(String username) {
        TicketAdmin admin = adminRepository.findByUsername(username);
        AuthInfoResult result = new AuthInfoResult();
        result.setUsername(username);
        result.setAvatar(admin.getAvatar());
        Set<String> perms = new HashSet<>();
        Set<String> roles = new HashSet<>();
        for (TicketRole role : admin.getRoles()) {
            roles.add(role.getName());
            for (TicketPermission permission : role.getPermissions()) {
                perms.add(permission.getPermission());
            }
        }
        result.setRoles(roles.toArray(new String[0]));
        result.setPerms(perms.toArray(new String[0]));
        return result;
    }

}
