package com.example.cafepizza.service;


import com.example.cafepizza.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User saveUser(User user);

}
