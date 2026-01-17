package com.hackerrank.sample.strategy.impl;

import com.hackerrank.sample.constants.Messages;
import com.hackerrank.sample.dto.request.AttributeRequestDto;
import com.hackerrank.sample.exception.InvalidAttributeException;
import com.hackerrank.sample.strategy.CategoryValidatorStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DeportsFitnessCategoryValidator implements CategoryValidatorStrategy {

    private static final Set<String> DEPORTS_FITNESS_ATTRIBUTES = Set.of(
            "PESO TOTAL", "NIVELES", "AJUSTABLE",
            "TALLA", "MATERIAL"
    );

    @Override
    public void validateCategory(List<AttributeRequestDto> attributeRequestDtos) {
        if(attributeRequestDtos == null || attributeRequestDtos.isEmpty()){
            throw new InvalidAttributeException(Messages.CATEGORY_DEPORTS_MESSAGE);
        }

        boolean hasRequiredAttributes = attributeRequestDtos.stream()
                .map(attr -> attr.attributeName().toUpperCase())
                .anyMatch(DEPORTS_FITNESS_ATTRIBUTES::contains);

        if(!hasRequiredAttributes){
            throw new InvalidAttributeException(Messages.INVALID_CATEGORY_DEPORTS_MESSAGE+DEPORTS_FITNESS_ATTRIBUTES);
        }
    }
}
