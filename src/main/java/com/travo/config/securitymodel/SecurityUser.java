package com.travo.config.securitymodel;

import com.travo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityUser implements UserDetails {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private Boolean enable;
    private User userInfo;

    public SecurityUser() {
    }

    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Boolean enable, User userInfo) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enable = enable;
        this.userInfo = userInfo;
    }

    public boolean isEnable() {
        return enable;
    }

    public User getUserInfo() {
        return userInfo;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return enable;
    }
}
