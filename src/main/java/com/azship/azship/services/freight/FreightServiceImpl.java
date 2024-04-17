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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Json;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerFreight customerFreight = customerFreightService.findById(freightDto.customerFreightId()).orElseThrow();

        JsonNode customerFreightProperties = objectMapper.readTree(customerFreight.getFreightProperties());
        JsonNode inputProperties = freightDto.properties();

        if(!doesJsonNodeContainsAllExpectedKeys(customerFreightProperties, inputProperties)) {
            throw new IllegalArgumentException("The properties input does not contain all required properties");
        }

        String propertiesAsString = objectMapper.writeValueAsString(inputProperties);
        Freight freight = new Freight(customerFreight, propertiesAsString);

        return freightRepository.save(freight).getId();
    }

    private boolean doesJsonNodeContainsAllExpectedKeys(JsonNode expectedJsonNode, JsonNode actualJsonNode) {
        List<String> expectedKeys = getJsonNodeKeys(expectedJsonNode);
        List<String> actualKeys = getJsonNodeKeys(actualJsonNode);
        return actualKeys.containsAll(expectedKeys);
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
        int page = dto.pagination().page();
        int size = dto.pagination().size();

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Freight> resultPage = freightRepository.findByPropertyAndPagination(propertyName, pageRequest);

        return resultPage.map(freight -> new FreightIdPropertiesDto(freight.getId(), freight.getProperties()));
    }

    private List<String> getJsonNodeKeys(JsonNode jsonNode) {
        List<String> keys = new ArrayList<>();
        Iterator<String> iterator = jsonNode.fieldNames();
        iterator.forEachRemaining(keys::add);
        return keys;
    }
}
