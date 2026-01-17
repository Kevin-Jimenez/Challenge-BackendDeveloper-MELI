package com.hackerrank.sample.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.sample.dto.request.ProductRequestDTO;
import com.hackerrank.sample.dto.response.ProductResponseDto;
import com.hackerrank.sample.model.ENUM.Condition;
import com.hackerrank.sample.model.ENUM.Stock;
import com.hackerrank.sample.model.Product;
import org.mapstruct.*;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = AttributeMapper.class)
public interface ProductMapper {

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "productPrice", target = "price")
    @Mapping(source = "productCurrency", target = "currency")
    @Mapping(source = "productQuantity", target = "quantity")
    @Mapping(source = "productDescription", target = "description")
    @Mapping(source = "productReference", target = "reference")
    @Mapping(source = "productAttributes", target = "attributes")
    @Mapping(source = "productCategory.categoryName", target = "categoryName")
    @Mapping(source = "productVendor.vendorName", target = "vendorName")
    @Mapping(source = "productImages", target = "images", qualifiedByName = "mapImages")
    @Mapping(source = "productStock", target = "stock", qualifiedByName = "mapStockStatus")
    @Mapping(source = "productCondition", target = "condition", qualifiedByName = "mapConditionStatus")
    @Mapping(source = "productFreeShipping", target = "shippingFree", qualifiedByName = "mapShipping")
    ProductResponseDto toResponseDto(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "productPrice", target = "productPrice")
    @Mapping(source = "productCurrency", target = "productCurrency")
    @Mapping(source = "productQuantity", target = "productQuantity")
    @Mapping(source = "productDescription", target = "productDescription")
    @Mapping(source = "productBrand", target = "productBrand")
    @Mapping(source = "productReference", target = "productReference")
    @Mapping(source = "productAttributes", target = "productAttributes")
    @Mapping(source = "productCategoryId", target = "productCategory.id")
    @Mapping(source = "productVendorId", target = "productVendor.id")
    @Mapping(source = "productImages", target = "productImages", qualifiedByName = "unmapImages")
    @Mapping(source = "productCondition", target = "productCondition")
    @Mapping(source = "productFreeShipping", target = "productFreeShipping")
    Product toEntity(ProductRequestDTO requestDto);

    @AfterMapping
    default void linkAttributes(@MappingTarget Product product) {
        if (product.getProductAttributes() != null) {
            product.getProductAttributes()
                    .forEach(attr -> attr.setProduct(product));
        }
    }

    List<ProductResponseDto> toResponseDtoList(List<Product> products);


    @Named("unmapImages")
    default String unmapImages(List<String> images) {
        if (images == null || images.isEmpty()) return "[]";
        try {
            return new ObjectMapper().writeValueAsString(images);
        } catch (Exception e) { return "[]"; }
    }


    @Named("mapStockStatus")
    default String mapStockStatus(Integer id) {
        if (id == null) return "N/A";
        return Stock.fromId(id);
    }

    @Named("mapConditionStatus")
    default String mapConditionStatus(Integer id) {
        if (id == null) return "No especificada";
        return Condition.fromId(id);
    }

    @Named("mapShipping")
    default String mapShipping(Integer shipping) {
        if (shipping == null) return "No";
        return shipping == 1 ? "Envío Gratis" : "Costo de Envío";
    }

    @Named("mapImages")
    default List<String> mapImages(String imagesJson) {
        if (imagesJson == null || imagesJson.isBlank()) {
            return Collections.emptyList();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    imagesJson,
                    new TypeReference<List<String>>() {}
            );
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}