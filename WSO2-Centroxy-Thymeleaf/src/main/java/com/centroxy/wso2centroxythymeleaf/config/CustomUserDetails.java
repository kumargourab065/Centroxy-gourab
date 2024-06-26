package com.centroxy.wso2centroxythymeleaf.config;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.centroxy.wso2centroxythymeleaf.entity.Userdetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class CustomUserDetails implements UserDetails{



    private Userdetails userdetails;

    public CustomUserDetails(Userdetails user) {
        super();
        this.userdetails = user;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userdetails.getRole());
      return Arrays.asList(simpleGrantedAuthority);
    }



    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return userdetails.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userdetails.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}

