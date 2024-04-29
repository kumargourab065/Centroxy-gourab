package com.centroxy.config;

import com.centroxy.entity.User;
import com.centroxy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username);

        if(user==null){
            throw new UsernameNotFoundException("User not found");

        }
        UserPassword userPassword = new UserPassword(user);
        return userPassword;
    }



}
