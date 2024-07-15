package com.api.almaximo.controllers;

import com.api.almaximo.dtos.ProductCreateDto;
import com.api.almaximo.dtos.ProductListDto;
import com.api.almaximo.dtos.ProductSupplierDto;
import com.api.almaximo.dtos.SelectDto;
import com.api.almaximo.models.ProductModel;
import com.api.almaximo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping(path = "/all")
    public List<ProductListDto> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping(path = "/{id}")
    public ProductListDto getProduct(@PathVariable int id) {
        return this.productService.getProduct(id);
    }

    @PostMapping(path = "/add")
    public Integer addProduct(@RequestBody ProductCreateDto product) {
        return this.productService.createProduct(product.getName(), BigDecimal.valueOf(product.getPrice()),product.getProductKey(),product.getTypeId(),product.getSupplierId(),product.getSupplierProductKey(),product.getSupplierCost());
    }

    @PutMapping(path = "/{id}")
    public Integer updateProduct(@RequestBody ProductCreateDto product, @PathVariable int id) {
        return this.productService.updateProduct(id, product.getName(), BigDecimal.valueOf(product.getPrice()),product.getProductKey(),product.getTypeId());
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteProduct(@PathVariable int id) {
        return this.productService.deleteProduct(id);
    }

    @GetMapping(path = "/get_types")
    public List<SelectDto> getTypes() {
        return this.productService.getTypes();
    }
    @GetMapping(path = "/get_suppliers")
    public List<SelectDto> getSuppliers() {
        return this.productService.getSuppliers();
    }

    @GetMapping(path = "/products/{id}")
    public List<ProductSupplierDto> getSuppliersByProduct(@PathVariable int id) {
        return this.productService.getAllProductsSuppliers(id);
    }

    @GetMapping(path = "/get_product/{id}")
    public ProductSupplierDto getSupplierById(@PathVariable int id) {
        return this.productService.getProductSupplier(id);
    }

    @PutMapping(path = "/edit/{id}")
    public Integer updateProductSupplier(@RequestBody ProductSupplierDto productSupplier, @PathVariable int id) {
        return this.productService.updateProductSupplier(
                id,
                productSupplier.getSupplierId(),
                productSupplier.getSupplierProductKey(),
                productSupplier.getSupplierCost()

        );
    }

    @DeleteMapping(path = "/ProductSupplier/{id}")
    public boolean deleteProductSupplier(@PathVariable int id) {
        return this.productService.deleteProductSupplier(id);
    }
}
