package com.hackerrank.sample.service.impl;

import com.hackerrank.sample.dto.response.CategoryResponseDto;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.mapper.CategoryMapper;
import com.hackerrank.sample.repository.CategoryRepository;
import com.hackerrank.sample.service.CategoryService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository,CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Cacheable(
            value = "categoryById",
            key = "#id",
            unless = "#result == null"
    )
    @Transactional(readOnly = true)
    public CategoryResponseDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toResponseDto)
                .orElseThrow(() ->
                        new NoSuchResourceFoundException("La categoria no existe"));

    }
}
