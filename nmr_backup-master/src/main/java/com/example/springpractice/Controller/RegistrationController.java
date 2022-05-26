package com.example.springpractice.Controller;

import com.example.springpractice.user.User;
import com.example.springpractice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;
    @GetMapping("/registration")
    String registration(){
        return "registration";
    }

//    @PostMapping("/addNewUser")
//    public String addNewUser(@ModelAttribute User user){
//        userService.addNewUser(user);
//        return "/registration";
//
//    }
}


