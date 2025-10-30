package com.Confer.ConferWeb.Services.security;

import com.Confer.ConferWeb.Model.Entity.Users;
import com.Confer.ConferWeb.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = this.loginRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Users not found"));
        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), new ArrayList<>());
    }
}
