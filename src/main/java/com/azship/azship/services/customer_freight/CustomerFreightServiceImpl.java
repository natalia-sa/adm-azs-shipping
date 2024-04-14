package com.azship.azship.services.customer_freight;

import com.azship.azship.dtos.customer_freight.CustomerFreightCustomerIdFreightPropertiesDto;
import com.azship.azship.models.customer.Customer;
import com.azship.azship.models.customer_freight.CustomerFreight;
import com.azship.azship.repositories.customer_freight.CustomerFreightRepository;
import com.azship.azship.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
class CustomerFreightServiceImpl implements CustomerFreightService {

    @Autowired
    private CustomerFreightRepository customerFreightRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public JpaRepository<CustomerFreight, Long> getRepository() {
        return customerFreightRepository;
    }

    @Override
    public CustomerFreight save(CustomerFreightCustomerIdFreightPropertiesDto customerFreightDto) {
        Customer customer = customerService.findById(customerFreightDto.customerId()).orElseThrow();
        CustomerFreight customerFreight = new CustomerFreight(customer, customerFreightDto.freightProperties());
        return customerFreightRepository.save(customerFreight);
    }
}
