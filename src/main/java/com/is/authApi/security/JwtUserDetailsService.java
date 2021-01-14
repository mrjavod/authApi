package com.is.authApi.security;

import com.is.authApi.model.User;
import com.is.authApi.security.jwt.JwtUser;
import com.is.authApi.security.jwt.JwtUserFactory;
import com.is.authApi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by User on 14.11.2019
 */
@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

        private final UserService userService;

        @Autowired
        public JwtUserDetailsService(UserService userService) {
            this.userService = userService;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userService.findByUsername(username);

            if(user == null){
                throw new UsernameNotFoundException("User with username: " + username + " not found");
                //return null;
            }

            JwtUser jwtUser = JwtUserFactory.create(user);
            log.info("IN loadUserByUsername - user with username {} successfully loaded", username);

            return jwtUser;
        }
}
