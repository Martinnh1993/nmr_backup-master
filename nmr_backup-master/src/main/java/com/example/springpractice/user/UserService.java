package com.example.springpractice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String addUser(User user, String loginPage, String adminPage, String reservationPage){
        return userRepo.addUser(user, loginPage, adminPage, reservationPage);
    }

    public String checkUser(User user, String loginPage, String adminPage, String employeePage) {
        return userRepo.checkUser(user, loginPage, adminPage, employeePage);
    }

    public String getAdminName(String username, String password){
        return userRepo.getAdminName(username, password);
    }
}
