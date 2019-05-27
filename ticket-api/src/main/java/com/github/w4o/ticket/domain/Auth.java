package com.github.w4o.ticket.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author frank
 * @date 2019-05-16
 */
@Entity
@Table(name = "ticket_admin")
@Data
public class Auth implements UserDetails {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "avatar")
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ticket_admin_role_relation",
            joinColumns = {@JoinColumn(name = "admin_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<TicketRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> auths = new ArrayList<>();

        List<TicketRole> roles = this.getRoles();
        for (TicketRole role : roles) {
            for (TicketPermission permission : role.getPermissions()) {
                auths.add(new SimpleGrantedAuthority(permission.getPermission()));
            }
        }

        return auths;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
