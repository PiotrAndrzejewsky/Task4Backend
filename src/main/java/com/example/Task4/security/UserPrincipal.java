package com.example.Task4.security;

import com.example.Task4.user.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserPrincipal implements UserDetails {
    private UserEntity mUserEntity;

    public UserPrincipal(UserEntity userEntity){
        this.mUserEntity = userEntity;
    }

    public UserPrincipal() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.mUserEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.mUserEntity.getUsername();
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