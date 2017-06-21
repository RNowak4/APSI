package com.apsi.logic.controllers;

import com.apsi.logic.exceptions.UserAlreadyExistsException;
import com.apsi.logic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void registerNewUser(@RequestParam("userName") final String userName,
                                @RequestParam("password") final String password)
            throws UserAlreadyExistsException {

        userService.register(userName, password);
    }
}
