package com.api.almaximo.services;

import com.api.almaximo.dtos.ProductListDto;
import com.api.almaximo.dtos.ProductSupplierDto;
import com.api.almaximo.dtos.SelectDto;
import com.api.almaximo.respositories.IProductRepository;
import com.api.almaximo.respositories.IProductSupplierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;
import java.util.logging.Level;

@Service
public class ProductService {

    private static final Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IProductSupplierRepository productSupplierRepository;


    public List<ProductListDto> getAllProducts() {
        List<Object[]> results = productRepository.getAllProducts();
        List<ProductListDto> products = results.stream().map(result -> {
            ProductListDto product = new ProductListDto();
            product.setId(((Number) result[0]).intValue());
            product.setName((String) result[1]);
            product.setProductKey((String) result[2]);
            byte activeByte = (byte) result[3];
            boolean active = activeByte != 0;
            product.setActive(active);
            double price = (double) result[4];
            product.setPrice(String.valueOf(price));
            product.setTypeProduct((String) result[5]);
            return product;
        }).collect(Collectors.toList());

        return products;
    }

    public ProductListDto getProduct(long id) {
        Object result = productRepository.getProductById(id);
        if (result == null) {
            return null;
        }
        Object[] resultArray = (Object[]) result;
        ProductListDto product = new ProductListDto();
        product.setId(((Number) resultArray[0]).intValue());
        product.setName((String) resultArray[1]);
        product.setProductKey((String) resultArray[2]);
        byte activeByte = (byte) resultArray[3];
        boolean active = activeByte != 0;
        product.setActive(active);
        double price = (double) resultArray[4];
        product.setPrice(String.valueOf(price));
        product.setTypeProduct((String) resultArray[5]);
        return product;
    }


    public Integer createProduct(String name, BigDecimal price, String productKey, Integer typeProductId, Integer supplierId, String supplierProductKey, Double supplierCost) {
        return productRepository.createProduct(
                name,
                price,
                productKey,
                typeProductId,
                supplierId,
                supplierProductKey,
                BigDecimal.valueOf(supplierCost)
        );
    }

    public Integer updateProduct(int id,String name, BigDecimal price, String productKey, Integer typeProductId) {
        return productRepository.update(
                id,
                name,
                price,
                productKey,
                typeProductId
        );
    }

    public boolean deleteProduct(int id) {
        int  response = productRepository.deleteById(id);
        return response == 1 ? false:true;
    }

    public List<SelectDto> getTypes(){
        List<Object[]> results = productRepository.getTypes();
        List<SelectDto> types = results.stream().map(result -> {
            SelectDto type = new SelectDto();
            type.setId(((Number) result[0]).intValue());
            type.setName((String) result[2]);
            return type;
        }).collect(Collectors.toList());
        return types;
    }

    public List<SelectDto> getSuppliers(){
        List<Object[]> results = productRepository.getSuppliers();
        List<SelectDto> suppliers = results.stream().map(result -> {
            SelectDto supplier = new SelectDto();
            supplier.setId(((Number) result[0]).intValue());
            supplier.setName((String) result[2]);
            return supplier;
        }).collect(Collectors.toList());
        return suppliers;
    }

    public List<ProductSupplierDto> getAllProductsSuppliers(int id) {
        List<Object[]> results = productSupplierRepository.getAllProductsSuppliers(id);
        List<ProductSupplierDto> products = results.stream().map(result -> {
            ProductSupplierDto product = new ProductSupplierDto();
            product.setId(((Number) result[4]).intValue());
            product.setSupplierName(((String) result[0]));
            product.setSupplierProductKey(((String) result[1]));
            product.setSupplierCost(((Number) result[2]).doubleValue());
            product.setSupplierId(((Number) result[3]).intValue());
            return product;
        }).collect(Collectors.toList());

        return products;
    }

    public ProductSupplierDto getProductSupplier(int id) {
        Object result = productSupplierRepository.getProductSupplierById(id);
        if (result == null) {
            return null;
        }

        Object[] resultArray = (Object[]) result;
        ProductSupplierDto product = new ProductSupplierDto();
        product.setId(((Number) resultArray[0]).intValue());
        product.setSupplierName(((String) resultArray[2]));
        product.setSupplierProductKey(((String) resultArray[3]));
        product.setSupplierCost(((Number) resultArray[4]).doubleValue());
        product.setSupplierId(((Number) resultArray[1]).intValue());
        return product;
    }

    @Transactional
    public Integer updateProductSupplier(int id, int supplierId, String supplierProductKey, double supplierCost) {
        logger.log(Level.INFO, "Updating product supplier with id: " + id+ " supplierId: " + supplierId + " supplierProductKey: " + supplierProductKey + " supplierCost: " + supplierCost);
        return productSupplierRepository.updateProductSupplier(
                supplierId,
                supplierProductKey,
                supplierCost,
                id
        );
    }

    public boolean deleteProductSupplier(int id) {
        int response = productSupplierRepository.deleteProductSupplierById(id);
        return response == 1 ? false : true;
    }


}
