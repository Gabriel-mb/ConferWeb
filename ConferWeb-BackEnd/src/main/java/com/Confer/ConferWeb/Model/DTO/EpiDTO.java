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
public class EpiDTO {
    private String epiName;
    private Integer numCa;
    private Integer quantity;
    private Date date;
    private Integer employeeId;

    public EpiDTO(String epiName, Integer numCa, Integer quantity) {
        this.epiName = epiName;
        this.numCa = numCa;
        this.quantity = quantity;
    }

}
