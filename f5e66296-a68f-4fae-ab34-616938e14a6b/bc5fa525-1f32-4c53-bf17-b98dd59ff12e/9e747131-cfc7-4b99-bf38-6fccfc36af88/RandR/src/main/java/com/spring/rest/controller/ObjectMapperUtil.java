package com.spring.rest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

public final class ObjectMapperUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private ObjectMapperUtil() {}

    public static Map<String, Object> convertToMap(Object obj) {
        return OBJECT_MAPPER.convertValue(
            obj,
            new TypeReference<Map<String, Object>>() {}
        );
    }
}