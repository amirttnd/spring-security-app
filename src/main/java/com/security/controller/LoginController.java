package com.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @Secured("ROLE_USER")
    @RequestMapping("/index")
    public String success() {
        return "index";
    }

    @ResponseBody
    @Secured("ROLE_ADMIN")
    @RequestMapping("/adminPage")
    public String adminPage() {
        return "Welcome on Admin Page";
    }

    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}
