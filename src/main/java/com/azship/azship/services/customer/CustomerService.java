package com.azship.azship.services.customer;

import com.azship.azship.dtos.CustomerNameCnpjDto;
import com.azship.azship.models.Customer;

import java.util.List;

public interface CustomerService {

    void save(CustomerNameCnpjDto customerDto);

    void update();

    void delete();

    List<Customer> findAll();
}
