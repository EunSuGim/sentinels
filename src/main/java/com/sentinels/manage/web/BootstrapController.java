package com.sentinels.manage.web;

import org.springframework.web.bind.annotation.RequestMapping;

public class BootstrapController {
    @RequestMapping("/dashboard")
    public String dashboard(){
        return "index";
    }
}
