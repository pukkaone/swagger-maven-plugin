package com.github.kongchen.smp.integration;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.swagger.jackson.AbstractModelConverter;
import io.swagger.util.Json;

public class PropertyNamingModelConverter extends AbstractModelConverter {

    /**
     * Constructor.
     */
    public PropertyNamingModelConverter() {
        super(Json.mapper());
        super._mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }
}
