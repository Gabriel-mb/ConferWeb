package com.Confer.ConferWeb.Repository;

import com.Confer.ConferWeb.Model.Entity.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query("SELECT s.supplierId FROM Supplier s WHERE s.supplierName = :name")
    Integer findSupplierIdBySupplierName(@Param("name") String name);

    @Query("SELECT s.supplierName FROM Supplier s")
    List<String> findAllSupplierNames();
}
