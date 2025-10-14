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
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "idEmployee")
    private Integer idEmployee;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EquipmentBorrowed> borrowings;

    public Employee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }
}
