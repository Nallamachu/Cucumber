package com.cucumber;

import com.cucumber.annotation.DefaultDataTableCellTransformer;
import com.cucumber.annotation.DefaultDataTableEntryTransformer;
import com.cucumber.annotation.DefaultParameterTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;

public class CucumberTypeRegistryConfigurer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }
}
