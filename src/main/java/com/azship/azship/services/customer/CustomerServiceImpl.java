package com.azship.azship.services.customer;

import com.azship.azship.dtos.customer.CustomerNameCnpjDto;
import com.azship.azship.models.customer.Customer;
import com.azship.azship.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(CustomerNameCnpjDto customerDto) {
        Customer customer = new Customer(customerDto.name(), customerDto.cnpj());
        return customerRepository.save(customer);
    }

    @Override
    public JpaRepository<Customer, Long> getRepository() {
        return customerRepository;
    }
}
