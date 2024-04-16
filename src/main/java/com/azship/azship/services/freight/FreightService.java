package com.azship.azship.services.freight;

import com.azship.azship.dtos.Freight.FreightDto;
import com.azship.azship.dtos.Freight.FreightIdCustomerFreightIdPropertiesDto;
import com.azship.azship.dtos.Freight.FreightIdPropertiesDto;
import com.azship.azship.dtos.Freight.FreightPropertyNamePropertyValuePaginationDto;
import com.azship.azship.models.freight.Freight;
import com.azship.azship.services.basic.BasicService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface FreightService extends BasicService<Freight, Long> {

    Long save(FreightDto freightDto) throws JsonProcessingException;

    void update(FreightIdCustomerFreightIdPropertiesDto freightDto) throws JsonProcessingException;

    List<FreightIdPropertiesDto> findByPropertyAndPagination(FreightPropertyNamePropertyValuePaginationDto dto);
}
