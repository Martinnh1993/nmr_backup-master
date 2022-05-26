package com.example.springpractice.Controller;

import com.example.springpractice.employee.EmployeeService;
import com.example.springpractice.user.User;
import com.example.springpractice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/login")
    String login(){
        return "/login";
    }


    @PostMapping("/checkUser")
    public String checkUser(@ModelAttribute User user, Model model){
        model.addAttribute("listOfEmployees",employeeService.getAllEmployees());
        model.addAttribute("admin",userService.getAdminName(user.getUsername(),user.getPassword()));
        return userService.checkUser(user,"/login","admin/admin", "admin/reservationPage");
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@ModelAttribute User user, Model model){
        model.addAttribute("listOfEmployees",employeeService.getAllEmployees());
        return userService.addUser(user, "login", "admin/admin", "admin/employee/employeePage");
    }


}
