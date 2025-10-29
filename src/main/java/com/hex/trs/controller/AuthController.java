package com.hex.trs.controller;

 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/public/hello")  //all general public
    public String helloPublic(){
        return "Hey Friend How r u";
    }

    @GetMapping("/employee/hello") //all registered users
    public String helloAll(){
        return "Hey Employee How r u";
    }

    @GetMapping("/customer/hello") //all registered customers
    public String helloCustomer(Principal principal){
        String username = principal.getName();
        return "Hey Customer: " + username +"!!  How r u";
    }

    @GetMapping("/executive/hello") //all registered executives
    public String helloExecutive(Principal principal){
        return "Hey Executive: " + principal.getName() + "!! How r u";
    }
}
