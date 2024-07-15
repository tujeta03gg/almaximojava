package com.api.almaximo.dtos;

public class ProductSupplierDto {

    private Integer id;
    private String supplierName;
    private String supplierProductKey;
    private Double supplierCost;
    private Integer supplierId;

    public ProductSupplierDto() {
    }

    public ProductSupplierDto(Integer id, String supplierName, String supplierProductKey, Double supplierCost, int supplierId) {
        this.id = id;
        this.supplierName = supplierName;
        this.supplierProductKey = supplierProductKey;
        this.supplierCost = supplierCost;
        this.supplierId = supplierId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
}
