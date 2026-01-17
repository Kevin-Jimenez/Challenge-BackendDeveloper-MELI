package com.hackerrank.sample.strategy;

import com.hackerrank.sample.dto.request.AttributeRequestDto;

import java.util.List;

public interface CategoryValidatorStrategy {
    void validateCategory(List<AttributeRequestDto> attributeRequestDtos);
}
