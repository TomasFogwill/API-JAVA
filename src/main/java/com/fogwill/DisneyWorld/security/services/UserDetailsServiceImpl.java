package com.fogwill.DisneyWorld.security.services;

import com.fogwill.DisneyWorld.security.models.MainUser;
import com.fogwill.DisneyWorld.security.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userService.getByUsername(username).get();
       return MainUser.build(user);
    }
    
}
