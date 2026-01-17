package com.hackerrank.sample.service.impl;

import com.hackerrank.sample.dto.response.VendorResponseDto;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.mapper.VendorMapper;
import com.hackerrank.sample.model.Category;
import com.hackerrank.sample.repository.VendorRepository;
import com.hackerrank.sample.service.VendorService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository,VendorMapper vendorMapper){
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    @Cacheable(
            value = "vendorById",
            key = "#id",
            unless = "#result == null"
    )
    @Transactional(readOnly = true)
    public VendorResponseDto getById(Long id) {
        return vendorRepository.findById(id)
                .map(vendorMapper::toResponseDto)
                .orElseThrow(() -> new NoSuchResourceFoundException("El vendedor no existe"));
    }

    @Override
    @Cacheable(
            value = "vendorByIdAndVendorCategory",
            key = "#id",
            unless = "#result == null"
    )
    @Transactional(readOnly = true)
    public VendorResponseDto getVendorByIdAndVendorCategory(Long id, Long categoryId) {
        return vendorRepository.getByIdAndVendorCategory_Id(id, categoryId)
                .map(vendorMapper::toResponseDto)
                .orElseThrow(() -> new NoSuchResourceFoundException("El vendedor no existe para esa categoria"));

    }
}
