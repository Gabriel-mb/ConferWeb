package com.Confer.ConferWeb.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @Column(name = "supplier_id")
    private Integer supplierId;

    @Column(name = "name")
    private String supplierName;

    @OneToMany(mappedBy = "supplier")
    private List<Equipment> equipment;

    @Override
    public String toString() {
        return supplierName;
    }
}
