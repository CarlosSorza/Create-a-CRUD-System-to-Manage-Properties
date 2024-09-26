package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        customer = new Customer(customerDetails.getFirstName(), customerDetails.getLastName());
        customerService.save(customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        if (customerService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
