package com.sentinels.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BootstrapController {
    @RequestMapping("/dashboard")
    public String dashboard(){
        return "index";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}