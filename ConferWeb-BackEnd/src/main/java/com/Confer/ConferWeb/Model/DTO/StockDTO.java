package com.Confer.ConferWeb.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private String equipmentName;
    private Integer employeeId;
    private String supplierName;
    private Integer supplierId;
    private Integer quantity;
    private Date date;

    public StockDTO(String equipmentName, String supplierName, Integer supplierId, Integer quantity) {
        this.equipmentName = equipmentName;
        this.supplierName = supplierName;
        this.supplierId = supplierId;
        this.quantity = quantity;
    }
}
