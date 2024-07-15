package com.api.almaximo.dtos;

public class ProductListDto {

    private Integer id;
    private String name;
    private String productKey;
    private String price;
    private String typeProduct;
    private String active;

    public ProductListDto(Integer id, String name, String productKey, String price, String typeProduct, String active) {
        this.id = id;
        this.name = name;
        this.productKey = productKey;
        this.price = price;
        this.typeProduct = typeProduct;
        this.active = active;
    }

    public ProductListDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active ? "No" : "Sí";
    }

    @Override
    public String toString() {
        return "ProductListDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productKey='" + productKey + '\'' +
                ", price='" + price + '\'' +
                ", typeProduct='" + typeProduct + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
