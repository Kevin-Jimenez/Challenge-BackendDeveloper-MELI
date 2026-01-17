package com.hackerrank.sample.service.impl;

import com.hackerrank.sample.dto.request.ProductRequestDTO;
import com.hackerrank.sample.dto.response.ProductResponseDto;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.mapper.ProductMapper;
import com.hackerrank.sample.model.Product;
import com.hackerrank.sample.repository.ProductRepository;
import com.hackerrank.sample.service.ProductService;
import com.hackerrank.sample.service.ProductValidatorService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final ProductValidatorService validatorService;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,
                              ProductValidatorService validatorService){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.validatorService = validatorService;
    }


    @Override
    @Transactional
    public String createPorduct(ProductRequestDTO productDto) {
        validatorService.validate(productDto);
        Product productSave = productMapper.toEntity(productDto);
        if(productSave.getProductAttributes() != null){
            productSave.getProductAttributes().forEach(attr -> {
                attr.setProduct(productSave);
            });
        }
        productSave.setProductStock(1);
        productRepository.save(productSave);
        return "Producto creado correctamente";
    }

    @Override
    @Cacheable(
            value = "productById",
            key = "#id",
            unless = "#result == null"
    )
    @Transactional(readOnly = true)
    public ProductResponseDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toResponseDto)
                .orElseThrow(() ->
                        new NoSuchResourceFoundException("No existe ningun producto con el identificador"));
    }

    @Override
    @Cacheable(
            value = "productsPage",
            key = "T(java.lang.String).format('%s-%s-%s', #pageable.pageNumber, #pageable.pageSize, #pageable.sort)"
    )
    @Transactional(readOnly = true)
    public Page<ProductResponseDto> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(productMapper::toResponseDto);
    }
}
