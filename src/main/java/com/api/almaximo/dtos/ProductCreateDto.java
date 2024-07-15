package com.api.almaximo.dtos;

public class ProductCreateDto {
    private String name;
    private String productKey;
    private Double price;
    private Integer typeId;
    private Integer supplierId;
    private String supplierProductKey;
    private Double supplierCost;

    public ProductCreateDto() {
    }

    public ProductCreateDto(String name, String productKey, Double price, Integer typeId, Integer supplierId, String supplierProductKey, Double supplierCost) {
        this.name = name;
        this.productKey = productKey;
        this.price = price;
        this.typeId = typeId;
        this.supplierId = supplierId;
        this.supplierProductKey = supplierProductKey;
        this.supplierCost = supplierCost;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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
}
