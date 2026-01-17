package com.hackerrank.sample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.sample.dto.request.AttributeRequestDto;
import com.hackerrank.sample.dto.request.ProductRequestDTO;
import com.hackerrank.sample.dto.response.AttributeResponseDto;
import com.hackerrank.sample.dto.response.ProductResponseDto;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST /create - Debe retornar 200 al crear el producto")
    void createProduct_Success() throws Exception {
        AttributeRequestDto attributeRequestDto = new AttributeRequestDto("Ram","16 GB");
        List<AttributeRequestDto> attributes = new ArrayList<>();
        attributes.add(attributeRequestDto);

        ProductRequestDTO requestDTO = new ProductRequestDTO(
                "Smartphone Samsung Galaxy S23",
                new BigDecimal("3499000"),
                "COP", 15, "1",
                "Smartphone de alta gama con pantalla AMOLED de 6.1 pulgadas, 8GB de RAM y 256GB de almacenamiento.",
                1, "Samsung", "SM-S23-256",
                1L, 3L,
                attributes,
                List.of("https://cdn.tienda.com/images/s23-front.jpg","https://cdn.tienda.com/images/s23-back.jpg")
        );
        when(productService.createPorduct(any(ProductRequestDTO.class))).thenReturn("Producto creado correctamente");

        mockMvc.perform(post("/api/v1/product/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("Producto creado correctamente"));
    }

    @Test
    @DisplayName("POST /create - Debe retornar 400 al crear el producto")
    void createProduct_Error() throws Exception {
        AttributeRequestDto attributeRequestDto = new AttributeRequestDto("Ram","16 GB");
        List<AttributeRequestDto> attributes = new ArrayList<>();
        attributes.add(attributeRequestDto);

        ProductRequestDTO requestDTO = new ProductRequestDTO(
                null,
                new BigDecimal("3499000"),
                "COP", 15, "1",
                "Smartphone de alta gama con pantalla AMOLED de 6.1 pulgadas, 8GB de RAM y 256GB de almacenamiento.",
                1, "Samsung", "SM-S23-256",
                1L, 3L,
                attributes,
                List.of("https://cdn.tienda.com/images/s23-front.jpg","https://cdn.tienda.com/images/s23-back.jpg")
        );
        when(productService.createPorduct(any(ProductRequestDTO.class))).thenReturn("El nombre del producto es obligatorio.");

        mockMvc.perform(post("/api/v1/product/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.details.productName").value("El nombre del producto es obligatorio."));
    }

    @Test
    @DisplayName("GET / - Debe retornar 200 y una página de productos")
    void getAllProducts_Success() throws Exception {

        ProductResponseDto dto = new ProductResponseDto(1L, "Producto 1", new BigDecimal(1000), "COP", "Con Stock",
                10,"Nuevo","Excelente producto","ML-123",List.of("https://cdn.tienda.com/images/s23-front.jpg","https://cdn.tienda.com/images/s23-back.jpg"),
                "Envío Gratis","Tecnologia","HP",List.of(new AttributeResponseDto(1L,"RAM","8GB")));
        Page<ProductResponseDto> page = new PageImpl<>(Collections.singletonList(dto));

        when(productService.getAllProducts(any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/api/v1/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("Producto 1"))
                .andExpect(jsonPath("$.content[0].vendorName").value("HP"))
                .andExpect(jsonPath("$.content[0].reference").value("ML-123"))
                .andExpect(jsonPath("$.content[0].description").value("Excelente producto"))
                .andExpect(jsonPath("$.content[0].condition").value("Nuevo"))
                .andExpect(jsonPath("$.totalElements").value(1));
    }

    @Test
    @DisplayName("GET /{id} - Debe retornar 200 y el producto si existe")
    void getById_Success() throws Exception {
        ProductResponseDto dto = new ProductResponseDto(1L, "Producto 1", new BigDecimal(1000), "COP", "Con Stock",
                10,"Nuevo","Excelente producto","ML-123",List.of("https://cdn.tienda.com/images/s23-front.jpg","https://cdn.tienda.com/images/s23-back.jpg"),
                "Envío Gratis","Tecnologia","HP",List.of(new AttributeResponseDto(1L,"RAM","8GB")));

        when(productService.getProductById(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/v1/product/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Producto 1"))
                .andExpect(jsonPath("$.currency").value("COP"))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.categoryName").value("Tecnologia"));
    }

    @Test
    @DisplayName("GET /{id} - Debe retornar 404 y el producto no existe")
    void getById_NotFound() throws Exception {
        ProductResponseDto dto = new ProductResponseDto(1L, "Producto 1", new BigDecimal(1000), "COP", "Con Stock",
                10,"Nuevo","Excelente producto","ML-123",List.of("https://cdn.tienda.com/images/s23-front.jpg","https://cdn.tienda.com/images/s23-back.jpg"),
                "Envío Gratis","Tecnologia","HP",List.of(new AttributeResponseDto(1L,"RAM","8GB")));

        when(productService.getProductById(1L)).thenThrow(new NoSuchResourceFoundException("No existe ningun producto con el identificador"));

        mockMvc.perform(get("/api/v1/product/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.details").value("No existe ningun producto con el identificador"));
    }
}
