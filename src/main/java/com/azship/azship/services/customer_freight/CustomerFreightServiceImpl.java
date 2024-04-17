package com.azship.azship.services.customer_freight;

import com.azship.azship.dtos.customer_freight.CustomerFreightCustomerIdFreightPropertiesDto;
import com.azship.azship.dtos.customer_freight.CustomerIdFreightPropertiesDto;
import com.azship.azship.models.customer.Customer;
import com.azship.azship.models.customer_freight.CustomerFreight;
import com.azship.azship.repositories.customer_freight.CustomerFreightRepository;
import com.azship.azship.services.customer.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public CustomerFreight save(CustomerFreightCustomerIdFreightPropertiesDto customerFreightDto) throws JsonProcessingException {
        Customer customer = customerService.findById(customerFreightDto.customerId()).orElseThrow();
        String propertiesAsString = new ObjectMapper().writeValueAsString(customerFreightDto.freightProperties());
        CustomerFreight customerFreight = new CustomerFreight(customer, propertiesAsString);
        return customerFreightRepository.save(customerFreight);
    }

    public List<CustomerIdFreightPropertiesDto> findCustomerIdAndFreightProperties() {
        List<CustomerFreight> customerFreights = customerFreightRepository.findAll();
        return customerFreights
                .stream()
                .map(customerFreight -> new CustomerIdFreightPropertiesDto(customerFreight.getId(), customerFreight.getFreightProperties()))
                .toList();
    }
}
