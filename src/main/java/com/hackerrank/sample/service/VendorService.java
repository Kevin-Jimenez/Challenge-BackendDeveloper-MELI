package com.hackerrank.sample.service;

import com.hackerrank.sample.dto.response.VendorResponseDto;

public interface VendorService {

    VendorResponseDto getById(Long id);

    VendorResponseDto getVendorByIdAndVendorCategory(Long id, Long  categoryId);
}
