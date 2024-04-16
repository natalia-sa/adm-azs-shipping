package com.azship.azship.services.customer_freight;

import com.azship.azship.dtos.customer_freight.CustomerFreightCustomerIdFreightPropertiesDto;
import com.azship.azship.models.customer_freight.CustomerFreight;
import com.azship.azship.services.basic.BasicService;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CustomerFreightService extends BasicService<CustomerFreight, Long> {

    CustomerFreight save(CustomerFreightCustomerIdFreightPropertiesDto customerFreightDto) throws JsonProcessingException;
}
