package com.example.springpractice.employee;

import com.example.springpractice.Person;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.example.springpractice.user.User;
import lombok.*;

@Entity
@Data
public class Employee extends Person {

    @NotEmpty(message = "Job Title is required")
    private String jobTitle;

    private boolean admin;

    @Override
    public String toString() {
        return "Employee{" +
                "jobTitle='" + jobTitle + '\'' +
                ", admin=" + admin +
                '}';
    }
}
