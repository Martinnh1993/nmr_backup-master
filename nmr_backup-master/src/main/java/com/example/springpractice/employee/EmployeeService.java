package com.example.springpractice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    //dependency injection to use UserRepo class
    @Autowired
    private EmployeeRepo employeeRepo;
/*
    private checkEmail(){
        employeeRepo.
    }

 */

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public void saveEmployee(Employee employee) {
        this.employeeRepo.save(employee);
    }

    public Employee getEmployeeById(int id){
        Optional<Employee> optional = employeeRepo.findById(id);
        Employee employee = null;
        if(optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id" + id);
        }
        return employee;
    }


    public void deleteEmployeeById(int id) {
        this.employeeRepo.deleteById(id);
    }



}
