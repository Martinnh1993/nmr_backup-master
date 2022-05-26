package com.example.springpractice.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class HomepageController {

    @GetMapping("/")
    String getHomepage(Model model){
        model.addAttribute("something", "this is coming from the controller");
        // thymeleaf knows that is has to look in the template folder for a file with the specified name
        return "index";
    }

    @PostMapping("/login")
    String login(){
        return "login";
    }

    @PostMapping("/admin")
    String admin(){
        return "admin";
    }

    @PostMapping("admin/employees")
    String employees() {
        return "admin/employees/index";
    }


    @PostMapping("admin/motorhomes")
    String motorhomes() {
        return "admin/motorhomes/index";
    }

    @PostMapping ("admin/reservations")
    String reservation() {
        return "reservation/reservationPage";
    }
}
