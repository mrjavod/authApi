package com.is.authApi.service;

import com.is.authApi.model.User;

import java.util.List;

/**
 * Created by User on 14.11.2019.
 */
public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
