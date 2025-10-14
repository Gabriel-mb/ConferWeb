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
public class EquipmentDTO {

    private String nameEquip;
    private Integer idEquipment;
    private String supplierName;
    private Integer supplierId;
    private String employeeName;
    private String status;
    private Date date;
}
