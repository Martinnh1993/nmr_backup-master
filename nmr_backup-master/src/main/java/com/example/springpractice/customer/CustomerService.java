package com.example.springpractice.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

        @Autowired
        private CustomerRepo customerRepo;


        public List<Customer> getAllCustomers() {
            return customerRepo.findAll();
        }

        public void saveCustomer(Customer customer) {
            this.customerRepo.save(customer);
        }

        public Customer getCustomerById(int id){
            Optional<Customer> optional = customerRepo.findById(id);
            Customer customer = null;
            if(optional.isPresent()) {
                customer = optional.get();
            } else {
                throw new RuntimeException(" Employee not found for id" + id);
            }
            return customer;
        }

    public void deleteCustomerById(int id) {
        this.customerRepo.deleteById(id);
    }

}

