package com.is.authApi.repository;

import com.is.authApi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 14.11.2019
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
