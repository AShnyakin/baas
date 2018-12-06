package com.github.baas.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Welcome to storage";
    }
}