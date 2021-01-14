package com.is.authApi.rest;

import com.is.authApi.dto.UserDto;
import com.is.authApi.model.User;
import com.is.authApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * REST controller user connected requests.
 */
public class UserRestControllerV1 {

    private final UserService userService;

    @Autowired
    public UserRestControllerV1(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){

        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
