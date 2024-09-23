package com.durgaprasad.SpringSec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public static String greet(){
        return "Hi DP";
    }
    @GetMapping("/")
    public static String greet2(){
        return "Hi DP";
    }

}
