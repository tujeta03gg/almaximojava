package com.api.almaximo.respositories;

import com.api.almaximo.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface  IProductRepository extends JpaRepository<ProductModel,Long> {

    @Query(value = "EXEC GetAllProducts", nativeQuery = true)
    List<Object[]> getAllProducts();

    @Query(value = "EXEC GetProductById :ProductId", nativeQuery = true)
    Object getProductById(@Param("ProductId") Long productId);

    @Query(value = "EXEC CreateProduct :Name, :Price, :ProductKey, :TypeID, :SupplierID, :SupplierProductKey, :SupplierCost", nativeQuery = true)
    Integer createProduct(
            @Param("Name") String name,
            @Param("Price") BigDecimal price,
            @Param("ProductKey") String productKey,
            @Param("TypeID") Integer typeId,
            @Param("SupplierID") Integer supplierId,
            @Param("SupplierProductKey") String supplierProductKey,
            @Param("SupplierCost") BigDecimal supplierCost
    );

    @Query(value = "EXEC UpdateProduct :Name, :ProductKey,:Price, :TypeID, :ID", nativeQuery = true)
    Integer update(
            @Param("ID") long id,
            @Param("Name") String name,
            @Param("Price") BigDecimal price,
            @Param("ProductKey") String productKey,
            @Param("TypeID") Integer typeId
    );
    @Query(value = "EXEC DeleteProduct :ID", nativeQuery = true)
    int deleteById(@Param("ID") long id);

    @Query(value = "EXEC GetAllTypes", nativeQuery = true)
    List<Object[]> getTypes();

    @Query(value = "EXEC GetAllSuppliers", nativeQuery = true)
    List<Object[]> getSuppliers();

}
