package com.durgaprasad.SpringSec.controller;

import com.durgaprasad.SpringSec.model.Users;
import com.durgaprasad.SpringSec.service.JWTService;
import com.durgaprasad.SpringSec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){

        return service.register(user);
    }

    @GetMapping("/users")
    public List<Users> users(){

        return service.getUsers();
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        Authentication authentication = authManager.
                authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.genarateToken(user.getUsername());
        return "failed";
    }

    @GetMapping("/logout")
    public String logout(){
        return "logout Successful";
    }


}
