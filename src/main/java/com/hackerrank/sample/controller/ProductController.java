package com.hackerrank.sample.controller;

import com.hackerrank.sample.dto.request.ProductRequestDTO;
import com.hackerrank.sample.dto.response.ProductResponseDto;
import com.hackerrank.sample.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Tag(name = "Productos", description = "Creacion del producto, obtener listado de productos paginado y producto por id")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @Operation(summary = "Crear producto", description = "Creacion del producto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto creado correctamente"),
            @ApiResponse(responseCode = "404", description = "Recursos no encontrados"),
            @ApiResponse(responseCode = "400", description = "Error de validacion en los datos enviados.")
    })
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequestDTO requestDTO){
        return ResponseEntity.ok(productService.createPorduct(requestDTO));
    }

    @Operation(summary = "Obtener pagina de productos", description = "Lista todos los productos paginados por defecto 20 productos por pagina.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de productos"),
            @ApiResponse(responseCode = "404", description = "No se encontro ningun producto"),
            @ApiResponse(responseCode = "400", description = "Error en los datos enviados.")
    })
    @GetMapping("")
    public Page<ProductResponseDto> getAllProducts(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        return productService.getAllProducts(pageable);
    }

    @Operation(summary = "Obtener producto por id", description = "Retorna los detalles de un producto especifico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna el detalle del producto"),
            @ApiResponse(responseCode = "404", description = "No existe ningun producto con el identificador"),
            @ApiResponse(responseCode = "400", description = "Error en los datos enviados.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
}