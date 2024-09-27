package com.telusko.ecom_proj.repo;

import com.telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

//URL to access H2 in-mem DB: http://localhost:8080/h2-console

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
    @Query("SELECT p from Product p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%',:keyword,'%'))")

    List<Product> searchProducts(String keyword);



}
