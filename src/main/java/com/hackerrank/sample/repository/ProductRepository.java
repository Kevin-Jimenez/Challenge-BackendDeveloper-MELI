package com.hackerrank.sample.repository;

import com.hackerrank.sample.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @EntityGraph(attributePaths = {
            "productAttributes",
            "productCategory",
            "productVendor"
    })
    Page<Product> findAll(Pageable pageable);
}
