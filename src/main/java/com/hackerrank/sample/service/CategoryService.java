package com.hackerrank.sample.service;

import com.hackerrank.sample.dto.response.CategoryResponseDto;

public interface CategoryService {

    CategoryResponseDto getCategoryById(Long id);
}
