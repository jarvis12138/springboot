package com.example.springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "s_product_category")
public class ProductCategory {
    @Id
    private int cId;

    private String name;

}
