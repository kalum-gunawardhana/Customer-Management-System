package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    final CustomerService customerService;

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id){
       customerService.deleteCustomer(id);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @GetMapping("search/{id}")
    public Customer searchCustomer(@PathVariable Integer id){
        return customerService.searchCustomer(id);
    }

    @GetMapping("/searchbyname/{name}")
    public List<Customer> searchCustomerByName(@PathVariable String name){
        return customerService.searchCuastomerByName(name);
    }
}
