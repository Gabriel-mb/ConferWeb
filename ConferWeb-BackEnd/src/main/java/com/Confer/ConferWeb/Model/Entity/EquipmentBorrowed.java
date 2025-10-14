package com.Confer.ConferWeb.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "borrowed")
public class EquipmentBorrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrowed")
    private Integer idBorrowed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "id_equipment", referencedColumnName = "id_equipment"),
            @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    })
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @Column(name = "date")
    private Date date;

    @Override
    public String toString() {
        return "Borrowed{" +
                ", equipment=" + equipment +
                ", date=" + date +
                '}';
    }
}
