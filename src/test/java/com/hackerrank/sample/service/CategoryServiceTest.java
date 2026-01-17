package com.hackerrank.sample.service;

import com.hackerrank.sample.dto.response.CategoryResponseDto;
import com.hackerrank.sample.dto.response.VendorResponseDto;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.mapper.CategoryMapper;
import com.hackerrank.sample.model.Category;
import com.hackerrank.sample.model.Vendor;
import com.hackerrank.sample.repository.CategoryRepository;
import com.hackerrank.sample.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryMapper categoryMapper;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    @DisplayName("getCategoryById - Debe retornar DTO cuando la categoria existe")
    void getCategoryById_Success() {
        Long id = 1L;
        Category mockCategory = new Category();
        mockCategory.setId(1L);
        mockCategory.setCategoryName("Tecnologia");
        mockCategory.setCategoryDescription("Productos de tecnologia");

        CategoryResponseDto expectedDto = new CategoryResponseDto(1L,"Tecnologia","Productos de tecnologia");

        when(categoryRepository.findById(id)).thenReturn(Optional.of(mockCategory));
        when(categoryMapper.toResponseDto(mockCategory)).thenReturn(expectedDto);

        CategoryResponseDto result = categoryService.getCategoryById(id);

        assertNotNull(result);
        assertEquals(expectedDto, result);
        assertEquals(expectedDto.getId(), result.getId());
        assertEquals(expectedDto.getCategoryName(), result.getCategoryName());
        assertEquals(expectedDto.getCategoryDescription(), result.getCategoryDescription());
        verify(categoryRepository).findById(id);
        verify(categoryMapper).toResponseDto(mockCategory);
    }

    @Test
    @DisplayName("getCategoryById - Debe retornar excepcion, cuando la categoria no existe")
    void getCategoryById_NotFound(){
        Long id = 1L;
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        NoSuchResourceFoundException exception = assertThrows(NoSuchResourceFoundException.class, () -> {
            categoryService.getCategoryById(id);
        });

        assertEquals("La categoria no existe", exception.getMessage());
    }
}
