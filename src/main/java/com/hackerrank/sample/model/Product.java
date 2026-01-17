package com.hackerrank.sample.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_currency")
    private String productCurrency;

    @Column(name = "product_stock")
    private Integer productStock;

    @Column(name = "product_condition")
    private Integer productCondition;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_free_shipping")
    private Integer productFreeShipping;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_reference")
    private String productReference;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attribute> productAttributes = new ArrayList<>();

    @Column(columnDefinition = "TEXT", name = "product_images")
    private String productImages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category productCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor productVendor;

    public Product() {
    }
    public Product(Long id, String productName, BigDecimal productPrice, String productCurrency, Integer productStock, Integer productCondition, String productDescription, Integer productFreeShipping, String productBrand, String productReference, Integer productQuantity, List<Attribute> productAttributes, String productImages, Category productCategory, Vendor productVendor) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCurrency = productCurrency;
        this.productStock = productStock;
        this.productCondition = productCondition;
        this.productDescription = productDescription;
        this.productFreeShipping = productFreeShipping;
        this.productBrand = productBrand;
        this.productReference = productReference;
        this.productQuantity = productQuantity;
        this.productAttributes = productAttributes;
        this.productImages = productImages;
        this.productCategory = productCategory;
        this.productVendor = productVendor;
    }

    public void addAttribute(Attribute attribute) {
        productAttributes.add(attribute);
        attribute.setProduct(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(Integer productCondition) {
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

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public List<Attribute> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(List<Attribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public Vendor getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(Vendor productVendor) {
        this.productVendor = productVendor;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCurrency='" + productCurrency + '\'' +
                ", productStock=" + productStock +
                ", productCondition=" + productCondition +
                ", productDescription='" + productDescription + '\'' +
                ", productFreeShipping=" + productFreeShipping +
                ", productBrand='" + productBrand + '\'' +
                ", productReference='" + productReference + '\'' +
                ", productQuantity=" + productQuantity +
                ", productAttributes=" + productAttributes +
                ", productImages='" + productImages + '\'' +
                ", productCategory=" + productCategory +
                ", productVendor=" + productVendor +
                '}';
    }
}
