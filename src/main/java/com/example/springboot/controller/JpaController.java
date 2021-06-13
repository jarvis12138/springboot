package com.example.springboot.controller;

import com.example.springboot.model.ProductCategory;
import com.example.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@RestController
public class JpaController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public Page<ProductCategory> productList() {
        PageRequest pageable = PageRequest.of(0, 2, Sort.Direction.ASC, "cId");
        Page<ProductCategory> all = productService.findAll(pageable);
        return all;
    }

}
