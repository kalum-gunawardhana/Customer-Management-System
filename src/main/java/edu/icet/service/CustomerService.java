package edu.icet.service;

import edu.icet.dto.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    void deleteCustomer(Integer id);

    void updateCustomer(Customer customer);

    Customer searchCustomer(Integer id);

    List<Customer> searchCuastomerByName(String name);
}
