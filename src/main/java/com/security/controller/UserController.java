package com.security.controller;

import com.security.domain.UserRoles;
import com.security.domain.Users;
import com.security.model.UserModel;
import com.security.repository.UserRepository;
import com.security.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/user/create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute UserModel userModel) {
        Users users = Users.create(userModel);
        UserRoles userRoles = UserRoles.create(userModel.getUsername(), "ROLE_USER");
        userRepository.save(users);
        userRolesRepository.save(userRoles);
        return "redirect:/user/create?msg=success";
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

}
