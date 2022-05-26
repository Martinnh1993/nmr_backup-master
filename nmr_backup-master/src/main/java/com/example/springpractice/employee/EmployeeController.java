package com.example.springpractice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    //Admin front page
    @GetMapping("/admin")
    String admin(){
        return "admin/admin";
    }


    @Autowired
    private EmployeeService employeeService;


    //display list of employees
    @GetMapping("/viewEmployeePage")
    public String viewEmployeePage(Model model){
    model.addAttribute("listOfEmployees",employeeService.getAllEmployees());
    return "admin/employee/employeePage";
    }

    //add new employee
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "admin/employee/newEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Validated @ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:viewEmployeePage";
    }

    @GetMapping("/showEmployeeUpdateForm/{id}")
    public String showEmployeeUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "admin/employee/updateEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id")int id) {
    this.employeeService.deleteEmployeeById(id);
    return "redirect:/viewEmployeePage";
    }
}

