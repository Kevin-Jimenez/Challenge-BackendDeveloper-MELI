package com.hackerrank.sample.strategy.impl;

import com.hackerrank.sample.constants.Messages;
import com.hackerrank.sample.dto.request.AttributeRequestDto;
import com.hackerrank.sample.exception.InvalidAttributeException;
import com.hackerrank.sample.strategy.CategoryValidatorStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class TechnologieCategoryValidator implements CategoryValidatorStrategy {

    private static final Set<String> TECH_ATTRIBUTES = Set.of(
            "RAM", "PROCESADOR", "ALMACENAMIENTO",
            "RESOLUCION", "CONECTIVIDAD", "CAPACIDAD"
    );

    @Override
    public void validateCategory(List<AttributeRequestDto> attributeRequestDtos) {
        if(attributeRequestDtos == null || attributeRequestDtos.isEmpty()){
            throw new InvalidAttributeException(Messages.CATEGORY_TECHNOLOGY_MESSAGE);
        }

        boolean hasRequiredAttributes = attributeRequestDtos.stream()
                .map(attr -> attr.attributeName().toUpperCase())
                .anyMatch(TECH_ATTRIBUTES::contains);

        if(!hasRequiredAttributes){
            throw new InvalidAttributeException(Messages.INVALID_CATEGORY_TECHNOLOGY_MESSAGE+TECH_ATTRIBUTES);
        }
    }
}
