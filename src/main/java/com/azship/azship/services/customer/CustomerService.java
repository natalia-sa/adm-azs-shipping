package com.azship.azship.services.customer;

import com.azship.azship.dtos.customer.CustomerNameCnpjDto;
import com.azship.azship.models.customer.Customer;
import com.azship.azship.services.basic.BasicService;

public interface CustomerService extends BasicService<Customer, Long> {

    Customer save(CustomerNameCnpjDto customerDto);

}
