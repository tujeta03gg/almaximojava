package com.api.almaximo.models;
import jakarta.persistence.*;

@Entity
@Table(name="productSupplier")
public class ProductSupplierModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String supplierProductKey;

    private Double supplierCost;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "Id")
    private ProductModel product;

    @ManyToOne
    @JoinColumn(name = "supplierId" , referencedColumnName = "Id")
    private SupplierModel supplier;

    public ProductSupplierModel() {
    }

    public ProductSupplierModel(Integer id, String supplierProductKey, Double supplierCost, ProductModel product, SupplierModel supplier) {
        this.id = id;
        this.supplierProductKey = supplierProductKey;
        this.supplierCost = supplierCost;
        this.product = product;
        this.supplier = supplier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierProductKey() {
        return supplierProductKey;
    }

    public void setSupplierProductKey(String supplierProductKey) {
        this.supplierProductKey = supplierProductKey;
    }

    public Double getSupplierCost() {
        return supplierCost;
    }

    public void setSupplierCost(Double supplierCost) {
        this.supplierCost = supplierCost;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public SupplierModel getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierModel supplier) {
        this.supplier = supplier;
    }
}
