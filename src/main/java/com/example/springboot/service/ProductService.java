package com.example.springboot.service;

import com.example.springboot.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductService extends JpaRepository<ProductCategory, Integer> {

}
