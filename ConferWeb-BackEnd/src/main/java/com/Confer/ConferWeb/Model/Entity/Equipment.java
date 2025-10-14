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
@Table(name = "equipments")
public class Equipment {

    @Id
    @Column(name = "id_equipment")
    private Integer idEquipment;

    @Column(name = "name", nullable = false)
    private String nameEquip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "equipment")
    private List<EquipmentBorrowed> borrowings;

    @Override
    public String toString() {
        return "Equipment{" +
                "idEquipment=" + idEquipment +
                ", nameEquip='" + nameEquip + '\'' +
                ", supplier=" + supplier +
                '}';
    }
}
