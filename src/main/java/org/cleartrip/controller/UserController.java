package org.cleartrip.controller;

import org.cleartrip.model.User;
import org.cleartrip.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity addUser(User user) {
        userService.addUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

}
