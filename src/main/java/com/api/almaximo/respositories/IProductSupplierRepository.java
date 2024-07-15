package com.api.almaximo.respositories;

import com.api.almaximo.models.ProductSupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductSupplierRepository extends JpaRepository<ProductSupplierModel,Long> {

    @Query(value = "EXEC GetProductSupplierByProduct :ProductID", nativeQuery = true)
    List<Object[]> getAllProductsSuppliers(@Param("ProductID") long productId);

    @Query(value = "EXEC GetProductSupplierById :ProductSupplierID", nativeQuery = true)
    Object getProductSupplierById(@Param("ProductSupplierID") long productSupplierId);

    @Query(value = "EXEC UpdateProductSupplier :SupplierID,:SupplierProductKey,:SupplierCost,:ID", nativeQuery = true)
    Integer updateProductSupplier(
            @Param("SupplierID") long supplierId,
            @Param("SupplierProductKey") String supplierProductKey,
            @Param("SupplierCost") double supplierCost,
            @Param("ID") long id
    );
    @Query(value = "EXEC DeleteProductSupplier :ID", nativeQuery = true)
    int deleteProductSupplierById(@Param("ID") long id);


}
