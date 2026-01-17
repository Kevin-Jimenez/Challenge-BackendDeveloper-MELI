package com.hackerrank.sample.service;

import com.hackerrank.sample.dto.request.AttributeRequestDto;
import com.hackerrank.sample.dto.request.ProductRequestDTO;
import com.hackerrank.sample.dto.response.AttributeResponseDto;
import com.hackerrank.sample.dto.response.ProductResponseDto;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.mapper.ProductMapper;
import com.hackerrank.sample.model.Attribute;
import com.hackerrank.sample.model.Category;
import com.hackerrank.sample.model.Product;
import com.hackerrank.sample.model.Vendor;
import com.hackerrank.sample.repository.ProductRepository;
import com.hackerrank.sample.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    @Mock
    private ProductValidatorService productValidatorService;
    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    @DisplayName("getProductById - Debe retornar 200 y un ProductResponseDto cuando el producto existe")
    void getProductById_Success(){
        Long id = 1L;
        Vendor mockVendor = new Vendor(1L, "HP", "Colombia",
                new Category(1L, "Tecnologia","Productos de Tecnologia"));
        Category mockCategory = new Category(1L, "Tecnologia","Productos de Tecnologia");

        Attribute attribute = new Attribute();
        List<Attribute> attributeList = List.of(attribute,attribute);
        Product productMock = new Product(1L,"Producto 1",new BigDecimal(1000),"COP",1,1,"Excelente producto",1,"HP",
                "ML-123",10,attributeList,"https://cdn.tienda.com/images/s23-back.jpg",mockCategory, mockVendor);

        ProductResponseDto expectedDto = new ProductResponseDto(1L, "Producto 1", new BigDecimal(1000), "COP", "Con Stock",
                10,"Nuevo","Excelente producto","ML-123", List.of("https://cdn.tienda.com/images/s23-front.jpg","https://cdn.tienda.com/images/s23-back.jpg"),
                "Envío Gratis","Tecnologia","HP",List.of(new AttributeResponseDto(1L,"RAM","8GB")));

        when(productRepository.findById(id)).thenReturn(Optional.of(productMock));
        when(productMapper.toResponseDto(productMock)).thenReturn(expectedDto);

        ProductResponseDto result = productService.getProductById(id);

        assertNotNull(result);
        assertEquals(expectedDto.name(), result.name());
        verify(productRepository).findById(id);
    }

    @Test
    @DisplayName("getProductById - Debe retornar 404 y un NoSuchResourceFoundException cuando el producto no existe")
    void getProductById_NotFound(){
        Long id = 1L;

        when(productRepository.findById(id)).thenReturn(Optional.empty());

        NoSuchResourceFoundException exception = assertThrows(NoSuchResourceFoundException.class, () -> {
            productService.getProductById(id);
        });

        assertEquals("No existe ningun producto con el identificador", exception.getMessage());
        verify(productRepository).findById(id);
        verifyNoInteractions(productMapper);
    }

    @Test
    @DisplayName("getAllProducts - Debe retornar 200 y un Page de ProductResponseDto")
    void getAllProducts_Success(){
        Pageable pageable = PageRequest.of(0,10);
        Vendor mockVendor = new Vendor();
        mockVendor.setId(1L);
        mockVendor.setVendorName("HP");
        mockVendor.setVendorLocation("Colombia");

        mockVendor.setVendorCategory(new Category(1L, "Tecnologia","Productos de Tecnologia"));

        Category mockCategory = new Category(1L, "Tecnologia","Productos de Tecnologia");
        Attribute attribute = new Attribute();
        List<Attribute> attributeList = List.of(attribute,attribute);

        Product productMock = new Product(1L,"Producto 1",new BigDecimal(1000),"COP",1,1,"Excelente producto",1,"HP",
                "ML-123",10,attributeList,"https://cdn.tienda.com/images/s23-back.jpg",mockCategory, mockVendor);

        Page<Product> entityPage = new PageImpl<>(List.of(productMock));

        ProductResponseDto expectedDto = new ProductResponseDto(1L, "Producto 1", new BigDecimal(1000), "COP", "Con Stock",
                10,"Nuevo","Excelente producto","ML-123", List.of("https://cdn.tienda.com/images/s23-front.jpg","https://cdn.tienda.com/images/s23-back.jpg"),
                "Envío Gratis","Tecnologia","HP",List.of(new AttributeResponseDto(1L,"RAM","8GB")));


        when(productRepository.findAll(any(Pageable.class))).thenReturn(entityPage);
        when(productMapper.toResponseDto(productMock)).thenReturn(expectedDto);

        Page<ProductResponseDto> result = productService.getAllProducts(pageable);

        assertNotNull(result);
        assertEquals(result.getTotalElements(),1L);
        verify(productRepository).findAll(pageable);
        verify(productMapper).toResponseDto(productMock);
    }

    @Test
    @DisplayName("createPorduct - Debe retornar 200 y mensaje de creacion del producto")
    void createPorduct_Success(){
        String expected = "Producto creado correctamente";

        Vendor mockVendor = new Vendor(1L, "HP", "Colombia",
                new Category(1L, "Tecnologia","Productos de Tecnologia"));

        Category mockCategory = new Category(1L, "Tecnologia","Productos de Tecnologia");
        Attribute attribute = new Attribute();
        List<Attribute> attributeList = List.of(attribute,attribute);

        Product productMock = new Product(1L,"Producto 1",new BigDecimal(1000),"COP",1,1,"Excelente producto",
                1,"HP", "ML-123",10,attributeList,
                "https://cdn.tienda.com/images/s23-back.jpg",mockCategory, mockVendor);

        AttributeRequestDto attributeRequestDto = new AttributeRequestDto("Ram","16 GB");
        List<AttributeRequestDto> attributes = new ArrayList<>();
        attributes.add(attributeRequestDto);
        ProductRequestDTO requestDTO = new ProductRequestDTO(
                "Producto 1",
                new BigDecimal("1000"),
                "COP", 15, "1",
                "Excelente producto",
                1, "HP", "ML-123",
                1L, 1L,
                attributes,
                List.of("https://cdn.tienda.com/images/s23-front.jpg","https://cdn.tienda.com/images/s23-back.jpg")
        );

        doNothing().when(productValidatorService).validate(requestDTO);
        when(productMapper.toEntity(requestDTO)).thenReturn(productMock);
        when(productRepository.save(productMock)).thenReturn(productMock);

        String result = productService.createPorduct(requestDTO);

        assertNotNull(result);
        assertEquals(expected,result);
        verify(productRepository).save(productMock);
        verify(productMapper).toEntity(requestDTO);
    }
}
