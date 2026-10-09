package org.example.webfluxplayground.tests.sec07.dto;

public record CalculatorResponse(
        Integer first,
        Integer second,
        String operation,
        Double result
) {
}
