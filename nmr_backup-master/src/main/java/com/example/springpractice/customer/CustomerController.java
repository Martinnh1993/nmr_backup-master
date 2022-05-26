package com.example.springpractice.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class CustomerController {

    @Autowired
    private CustomerService customerService;


    //display list of employees
    @GetMapping("/viewCustomerPage")
    public String viewCustomerPage(Model model){
        model.addAttribute("listOfCustomers",customerService.getAllCustomers());
        return "reservation/reservationPage";
    }

    //add new employee
    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "reservation/customer/newCustomer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:viewCustomerPage";
    }

    @GetMapping("/showCustomerUpdateForm/{id}")
    public String showCustomerUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer",customer);
        return "reservation/updateCustomer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id")int id) {
        this.customerService.deleteCustomerById(id);
        return "redirect:/viewCustomerPage";
    }
}
