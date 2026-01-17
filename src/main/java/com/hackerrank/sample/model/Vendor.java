package com.hackerrank.sample.model;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Long id;
    @Column(name = "vendor_name")
    private  String vendorName;

    @Column(name = "vendor_location")
    private  String vendorLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category vendorCategory;

    public Vendor() {
    }

    public Vendor(Long id, String vendorName, String vendorLocation, Category vendorCategory) {
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

    public Category getVendorCategory() {
        return vendorCategory;
    }

    public void setVendorCategory(Category vendorCategory) {
        this.vendorCategory = vendorCategory;
    }
}
