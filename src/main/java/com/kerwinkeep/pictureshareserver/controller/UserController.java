package com.kerwinkeep.pictureshareserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.kerwinkeep.pictureshareserver.daoi.UserDao;
import com.kerwinkeep.pictureshareserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody JSONObject jsonObject) {

        String account = jsonObject.get("account").toString();
        String password = jsonObject.get("password").toString();
        String name = jsonObject.get("name").toString();

        if(1 == userDao.insertUser(account, password, name)){
            return "Success.";
        }
        return "Failed! Maybe the account already exists.";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody JSONObject jsonObject) {

        String account = jsonObject.get("account").toString();
        String password = jsonObject.get("password").toString();

        User user = userDao.verifyLogin(account,password);
        if(user != null){
            return String.valueOf(user.getId());
        }
        return "The account or password is incorrect.";

    }
}
