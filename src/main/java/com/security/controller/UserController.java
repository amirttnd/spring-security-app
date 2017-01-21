package com.security.controller;

import com.security.domain.Users;
import com.security.model.UserModel;
import com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/user/create";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute UserModel userModel) {
        Users users= Users.create(userModel);
        userRepository.save(users);
        return userModel.toString();
    }

    @Autowired
    UserRepository userRepository;

}
