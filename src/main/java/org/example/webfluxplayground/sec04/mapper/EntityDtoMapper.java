package org.example.webfluxplayground.sec04.mapper;

import org.example.webfluxplayground.sec04.dto.CustomerDto;
import org.example.webfluxplayground.sec04.entity.Customer;

public class EntityDtoMapper {

    public static Customer toEntity(CustomerDto dto) {
        var customer = new Customer();
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        customer.setId(dto.id());
        return customer;
    }

    public static CustomerDto toDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }
}
