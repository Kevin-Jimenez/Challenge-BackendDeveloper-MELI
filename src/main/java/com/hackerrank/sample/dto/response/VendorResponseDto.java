package com.hackerrank.sample.dto.response;


public class VendorResponseDto {
    private Long id;
    private  String vendorName;
    private  String vendorLocation;
    private Integer vendorCategory;

    public VendorResponseDto() {
    }
    public VendorResponseDto(Long id, String vendorName, String vendorLocation, Integer vendorCategory) {
        this.id = id;
        this.vendorName = vendorName;
        this.vendorLocation = vendorLocation;
        this.vendorCategory = vendorCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorLocation() {
        return vendorLocation;
    }

    public void setVendorLocation(String vendorLocation) {
        this.vendorLocation = vendorLocation;
    }

    public Integer getVendorCategory() {
        return vendorCategory;
    }

    public void setVendorCategory(Integer vendorCategory) {
        this.vendorCategory = vendorCategory;
    }
}
