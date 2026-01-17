package com.hackerrank.sample.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.hackerrank.sample.dto.response.VendorResponseDto;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.mapper.VendorMapper;
import com.hackerrank.sample.model.Category;
import com.hackerrank.sample.model.Vendor;
import com.hackerrank.sample.repository.VendorRepository;
import com.hackerrank.sample.service.impl.VendorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class VendorServiceTest {

    @Mock
    private VendorRepository vendorRepository;

    @Mock
    private VendorMapper vendorMapper;

    @InjectMocks
    private VendorServiceImpl vendorService;

    @Test
    @DisplayName("getById - Debe retornar DTO cuando el vendedor existe")
    void getById_Success() {
        Long id = 1L;
        Vendor mockVendor = new Vendor(1L, "HP", "Colombia",
                new Category(1L, "Tecnologia","Productos de Tecnologia"));
        VendorResponseDto expectedDto = new VendorResponseDto(1L,"HP","Colombia", 1);

        when(vendorRepository.findById(id)).thenReturn(Optional.of(mockVendor));
        when(vendorMapper.toResponseDto(mockVendor)).thenReturn(expectedDto);

        VendorResponseDto result = vendorService.getById(id);

        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(vendorRepository).findById(id);
        verify(vendorMapper).toResponseDto(mockVendor);
    }

    @Test
    @DisplayName("getById - Debe lanzar NoSuchResourceFoundException cuando no existe")
    void getById_NotFound() {

        Long id = 1L;
        when(vendorRepository.findById(id)).thenReturn(Optional.empty());

        NoSuchResourceFoundException exception = assertThrows(NoSuchResourceFoundException.class, () -> {
            vendorService.getById(id);
        });

        assertEquals("El vendedor no existe", exception.getMessage());
        verify(vendorRepository).findById(id);
        verifyNoInteractions(vendorMapper);
    }

    @Test
    @DisplayName("getVendorByIdAndVendorCategory - Debe retornar DTO cuando existe relación")
    void getVendorByIdAndVendorCategory_Success() {
        Long id = 1L;
        Long categoryId = 10L;
        Vendor mockVendor = new Vendor(1L, "HP", "Colombia",
                new Category(1L, "Tecnologia","Productos de Tecnologia"));
        VendorResponseDto expectedDto = new VendorResponseDto(1L,"HP","Colombia", 1);

        when(vendorRepository.getByIdAndVendorCategory_Id(id, categoryId))
                .thenReturn(Optional.of(mockVendor));
        when(vendorMapper.toResponseDto(mockVendor)).thenReturn(expectedDto);


        VendorResponseDto result = vendorService.getVendorByIdAndVendorCategory(id, categoryId);

        assertNotNull(result);
        verify(vendorRepository).getByIdAndVendorCategory_Id(id, categoryId);
    }

    @Test
    @DisplayName("getVendorByIdAndVendorCategory - Debe lanzar excepción si no existe combinación")
    void getVendorByIdAndVendorCategory_NotFound() {

        Long id = 1L;
        Long categoryId = 10L;
        when(vendorRepository.getByIdAndVendorCategory_Id(id, categoryId))
                .thenReturn(Optional.empty());

        NoSuchResourceFoundException exception = assertThrows(NoSuchResourceFoundException.class, () -> {
            vendorService.getVendorByIdAndVendorCategory(id, categoryId);
        });

        assertEquals("El vendedor no existe para esa categoria", exception.getMessage());
    }
}
