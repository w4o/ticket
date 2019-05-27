package com.github.w4o.ticket.service.impl;

import com.github.w4o.ticket.domain.Auth;
import com.github.w4o.ticket.repository.AdminUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * spring security 授权使用
 *
 * @author frank
 * @date 2019-05-14
 */
@Service
public class AdminUserDetailsServiceImpl implements UserDetailsService {

    private final AdminUserDetailsRepository userDetailsRepository;

    @Autowired
    public AdminUserDetailsServiceImpl(AdminUserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Auth admin = userDetailsRepository.findByUsername(username);

        if (admin == null) {
            throw new UsernameNotFoundException(username);
        }
        return admin;
    }

}
