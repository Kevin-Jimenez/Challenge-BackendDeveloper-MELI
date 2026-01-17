package com.hackerrank.sample.dto.response;

import com.hackerrank.sample.model.Attribute;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDto(
        Long productId,
        String name,
        BigDecimal price,
        String currency,
        String stock,
        Integer quantity,
        String condition,
        String description,
        String reference,
        List<String> images,
        String shippingFree,
        String categoryName,
        String vendorName,
        List<AttributeResponseDto> attributes
) { }
