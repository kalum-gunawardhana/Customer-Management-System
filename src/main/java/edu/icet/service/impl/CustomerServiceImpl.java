package edu.icet.service.impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerDao;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerDao customerDao;
    final ModelMapper modelMapper;

    @Override
    public void addCustomer(Customer customer) {
        customerDao.save(modelMapper.map(customer, CustomerEntity.class));
    }

    @Override
    public List<Customer> getAllCustomers() {
        ArrayList<Customer> cusArrayList = new ArrayList<>();
        List<CustomerEntity> customerDaoAll = customerDao.findAll();

        customerDaoAll.forEach(customerEntity -> {
            cusArrayList.add(modelMapper.map(customerEntity, Customer.class));
        });

        return cusArrayList;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDao.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.save(modelMapper.map(customer, CustomerEntity.class));
    }

    @Override
    public Customer searchCustomer(Integer id) {
        Optional<CustomerEntity> customerEntity = customerDao.findById(id);
        return modelMapper.map(customerEntity, Customer.class);
    }

    @Override
    public List<Customer> searchCuastomerByName(String name) {
        List<CustomerEntity> byName = customerDao.findByName(name);
        ArrayList<Customer> customerArrayList = new ArrayList<>();

        byName.forEach(customerEntity -> {
            customerArrayList.add(modelMapper.map(customerEntity, Customer.class));
        });
        return customerArrayList;
    }
}
