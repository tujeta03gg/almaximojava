package com.api.almaximo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String productKey;
    private Boolean deleted;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "typeId")
    private TypeModel typeProduct;

    public ProductModel(int id, String name,  Double price,String productKey, TypeModel typeProduct) {
        this.id = id;
        this.name = name;
        this.productKey = productKey;
        this.price = price;
        this.typeProduct = typeProduct;
    }

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TypeModel getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeModel typeProduct) {
        this.typeProduct = typeProduct;
    }

}
