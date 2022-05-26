package com.example.springpractice.user;
import com.example.springpractice.employee.Employee;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    //change so it gets name from employee
    private String email;

    @Column(unique = true,
    nullable = false)
    private String username;

    @Column(nullable = false)
    private  String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_email", referencedColumnName = "email")
    private Employee employee;

    /*
    //Constructor
    public User(){}

    //Setters


    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Getters

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    to be deleted if lombok works like expected
     */
}
