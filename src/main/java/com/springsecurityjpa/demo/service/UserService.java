package com.springsecurityjpa.demo.service;

import com.springsecurityjpa.demo.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByUsername(String username);


}
