package com.Confer.ConferWeb.Repository;

import com.Confer.ConferWeb.Model.Entity.Stock;
import com.Confer.ConferWeb.Model.Entity.StockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockId> {

    @Query("SELECT s FROM Stock s WHERE s.stockId.equipmentName = :equipmentName AND s.stockId.supplierId = :supplierId")
    Stock findByEquipmentNameAndSupplierId(
            @Param("equipmentName") String equipmentName,
            @Param("supplierId") Integer supplierId);

    @Query("SELECT DISTINCT s.id.equipmentName FROM Stock s")
    List<String> findAllEquipmentNames();



}