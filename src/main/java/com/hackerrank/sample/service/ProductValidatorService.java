package com.hackerrank.sample.service;

import com.hackerrank.sample.dto.request.ProductRequestDTO;

public interface ProductValidatorService {
    void validate(ProductRequestDTO requestDTO);
}
