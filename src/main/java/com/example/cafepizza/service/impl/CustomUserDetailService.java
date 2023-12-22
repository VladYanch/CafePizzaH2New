package com.example.cafepizza.service.impl;

import com.example.cafepizza.model.User;
import com.example.cafepizza.repository.UserRepository;
import com.example.cafepizza.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserService, UserDetailsService {

    private UserRepository repository;

    public CustomUserDetailService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }
}
