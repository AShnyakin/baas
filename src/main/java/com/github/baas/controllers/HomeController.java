package com.github.baas.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("production")
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Welcome to storage";
    }
}