package com.azship.azship.services.customer;

import com.azship.azship.dtos.CustomerNameCnpjDto;
import com.azship.azship.models.Customer;
import com.azship.azship.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void save(CustomerNameCnpjDto customerDto) {
        Customer customer = new Customer(customerDto.name(), customerDto.cnpj());
        customerRepository.save(customer);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
