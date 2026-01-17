package com.hackerrank.sample.service;

import com.hackerrank.sample.dto.request.ProductRequestDTO;
import com.hackerrank.sample.dto.response.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    String createPorduct(ProductRequestDTO productDto);
    ProductResponseDto getProductById(Long id);
    Page<ProductResponseDto> getAllProducts(Pageable pageable);
}
