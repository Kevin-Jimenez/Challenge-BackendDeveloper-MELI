package com.hackerrank.sample.service.impl;

import com.hackerrank.sample.dto.request.ProductRequestDTO;
import com.hackerrank.sample.dto.response.CategoryResponseDto;
import com.hackerrank.sample.dto.response.VendorResponseDto;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.service.CategoryService;
import com.hackerrank.sample.service.ProductValidatorService;
import com.hackerrank.sample.service.VendorService;
import com.hackerrank.sample.strategy.CategoryValidatorFactory;
import com.hackerrank.sample.strategy.CategoryValidatorStrategy;
import org.springframework.stereotype.Service;

@Service
public class ProductValidatorServiceImpl implements ProductValidatorService {

    private final CategoryValidatorFactory validatorFactory;
    private final CategoryService categoryService;
    private final VendorService vendorService;

    public ProductValidatorServiceImpl(CategoryValidatorFactory validatorFactory, CategoryService categoryService,
                                       VendorService vendorService){
        this.validatorFactory = validatorFactory;
        this.categoryService = categoryService;
        this.vendorService = vendorService;

    }

    @Override
    public void validate(ProductRequestDTO requestDTO) {
        CategoryResponseDto category = categoryService.getCategoryById(requestDTO.getProductCategoryId());
        VendorResponseDto vendor = vendorService.getVendorByIdAndVendorCategory(requestDTO.getProductVendorId(), category.getId());
        if(vendor == null){
            throw new NoSuchResourceFoundException("No existe un vendedor con la categoria");
        }
        CategoryValidatorStrategy validatorStrategy = validatorFactory.getCategoryValidatorStrategy(category.getCategoryName());
        validatorStrategy.validateCategory(requestDTO.getProductAttributes());
    }
}
