package com.hackerrank.sample.dto.request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.util.List;

public class ProductRequestDTO {

        @NotBlank(message = "El nombre del producto es obligatorio.")
        String productName;

        @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0.")
        @NotNull(message = "El precio del producto es obligatorio.")
        BigDecimal productPrice;

        @NotBlank(message = "El tipo de moneda es obligatorio.")
        @Pattern(
                regexp = "^(COP|USD|EUR|ARS)$",
                message = "La moneda debe ser COP, USD, EUR o ARS"
        )
        String productCurrency;

        @Min(value = 1, message = "El stock del producto debe ser minimo de 1.")
        @NotNull(message = "El stock es obligatorio.")
        Integer productQuantity;

        @NotBlank(message = "La condicion del producto es obligatoria.")
        String productCondition;

        @NotBlank(message = "La descripcion del producto es obligatoria.")
        String productDescription;

        @Range(min = 0, max = 1, message = "Debe especificar si el envio es gratiuto o no.")
        @NotNull(message = "Envio gratuito es obligatorio.")
        Integer productFreeShipping;

        @NotBlank(message = "La marca del producto es obligatoria.")
        String productBrand;

        @NotBlank(message = "La referencia del producto es obligatoria.")
        String productReference;

        @NotNull(message = "Debe especificar un ID de vendedor valido.")
        Long productVendorId;

        @NotNull(message = "Debe especificar un ID de categoria valido.")
        Long productCategoryId;

        List<AttributeRequestDto> productAttributes;

        List<String> productImages;

        public ProductRequestDTO() {

        }
        public ProductRequestDTO(String productName, BigDecimal productPrice, String productCurrency, Integer productQuantity, String productCondition, String productDescription, Integer productFreeShipping, String productBrand, String productReference, Long productVendorId, Long productCategoryId, List<AttributeRequestDto> productAttributes, List<String> productImages) {
                this.productName = productName;
                this.productPrice = productPrice;
                this.productCurrency = productCurrency;
                this.productQuantity = productQuantity;
                this.productCondition = productCondition;
                this.productDescription = productDescription;
                this.productFreeShipping = productFreeShipping;
                this.productBrand = productBrand;
                this.productReference = productReference;
                this.productVendorId = productVendorId;
                this.productCategoryId = productCategoryId;
                this.productAttributes = productAttributes;
                this.productImages = productImages;
        }

        public String getProductName() {
                return productName;
        }

        public void setProductName(String productName) {
                this.productName = productName;
        }

        public BigDecimal getProductPrice() {
                return productPrice;
        }

        public void setProductPrice(BigDecimal productPrice) {
                this.productPrice = productPrice;
        }

        public String getProductCurrency() {
                return productCurrency;
        }

        public void setProductCurrency(String productCurrency) {
                this.productCurrency = productCurrency;
        }

        public Integer getProductQuantity() {
                return productQuantity;
        }

        public void setProductQuantity(Integer productQuantity) {
                this.productQuantity = productQuantity;
        }

        public String getProductCondition() {
                return productCondition;
        }

        public void setProductCondition(String productCondition) {
                this.productCondition = productCondition;
        }

        public String getProductDescription() {
                return productDescription;
        }

        public void setProductDescription(String productDescription) {
                this.productDescription = productDescription;
        }

        public Integer getProductFreeShipping() {
                return productFreeShipping;
        }

        public void setProductFreeShipping(Integer productFreeShipping) {
                this.productFreeShipping = productFreeShipping;
        }

        public String getProductBrand() {
                return productBrand;
        }

        public void setProductBrand(String productBrand) {
                this.productBrand = productBrand;
        }

        public String getProductReference() {
                return productReference;
        }

        public void setProductReference(String productReference) {
                this.productReference = productReference;
        }

        public Long getProductVendorId() {
                return productVendorId;
        }

        public void setProductVendorId(Long productVendorId) {
                this.productVendorId = productVendorId;
        }

        public Long getProductCategoryId() {
                return productCategoryId;
        }

        public void setProductCategoryId(Long productCategoryId) {
                this.productCategoryId = productCategoryId;
        }

        public List<AttributeRequestDto> getProductAttributes() {
                return productAttributes;
        }

        public void setProductAttributes(List<AttributeRequestDto> productAttributes) {
                this.productAttributes = productAttributes;
        }

        public List<String> getProductImages() {
                return productImages;
        }

        public void setProductImages(List<String> productImages) {
                this.productImages = productImages;
        }
}
