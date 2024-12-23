package com.mitanshu.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/services")
    public String services() {
        return "services";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String postLogin() {
//        return "redirect:/user/dashboard";
//    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

}
