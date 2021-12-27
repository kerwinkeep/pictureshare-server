package com.kerwinkeep.pictureshareserver.controller;

import com.kerwinkeep.pictureshareserver.daoi.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;
}
