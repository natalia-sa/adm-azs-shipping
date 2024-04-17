package com.azship.azship.services.freight;

import com.azship.azship.dtos.Freight.FreightDto;
import com.azship.azship.dtos.Freight.FreightIdCustomerFreightIdPropertiesDto;
import com.azship.azship.dtos.Freight.FreightIdPropertiesDto;
import com.azship.azship.dtos.Freight.FreightPropertyNamePropertyValuePaginationDto;
import com.azship.azship.models.customer_freight.CustomerFreight;
import com.azship.azship.models.freight.Freight;
import com.azship.azship.repositories.freight.FreightRepository;
import com.azship.azship.services.customer_freight.CustomerFreightService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FreightServiceImpl implements FreightService {

    @Autowired
    private FreightRepository freightRepository;

    @Autowired
    private CustomerFreightService customerFreightService;

    @Override
    public JpaRepository<Freight, Long> getRepository() {
        return freightRepository;
    }

    @Override
    public Long save(FreightDto freightDto) throws JsonProcessingException {
        CustomerFreight customerFreight = customerFreightService.findById(freightDto.customerFreight()).orElseThrow();
        String propertiesAsString = new ObjectMapper().writeValueAsString(freightDto.properties());
        Freight freight = new Freight(customerFreight, propertiesAsString);
        return freightRepository.save(freight).getId();
    }

    @Transactional
    @Override
    public void update(FreightIdCustomerFreightIdPropertiesDto freightDto) throws JsonProcessingException {
        Freight freight = freightRepository.findById(freightDto.freightId()).orElseThrow();
        CustomerFreight customerFreight = customerFreightService.findById(freightDto.customerFreightId()).orElseThrow();
        String propertiesAsString = new ObjectMapper().writeValueAsString(freightDto.properties());
        freight.setCustomerFreight(customerFreight);
        freight.setProperties(propertiesAsString);
    }

    @Override
    public Page<FreightIdPropertiesDto> findByPropertyAndPagination(FreightPropertyNamePropertyValuePaginationDto dto) {
        String propertyName = dto.propertyName();
        Object propertyValue = dto.propertyValue();
        int page = dto.pagination().page();
        int size = dto.pagination().size();

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Freight> resultPage = freightRepository.findByPropertyAndPagination(propertyName, pageRequest);

        return resultPage.map(freight -> new FreightIdPropertiesDto(freight.getId(), freight.getProperties()));
    }
}
