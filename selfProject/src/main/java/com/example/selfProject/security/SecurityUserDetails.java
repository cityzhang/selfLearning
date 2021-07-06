package com.example.selfProject.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.DigestUtils;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
public class SecurityUserDetails implements UserDetails {
    private Collection<? extends GrantedAuthority> authorities;
    private String username;

    public SecurityUserDetails(String userName, Collection<? extends GrantedAuthority> authorities){
        this.setUsername(userName);

        this.setAuthorities(authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
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
