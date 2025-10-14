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
public class BorrowedDTO {

    private String equipmentName;
    private Integer idEquipment;
    private Integer employeeId;
    private String supplierName;
    private Integer supplierId;
    private Date date;
}
