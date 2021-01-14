package com.is.authApi.repository;

import com.is.authApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 14.11.2019
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
