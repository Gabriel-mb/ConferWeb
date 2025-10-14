package com.Confer.ConferWeb.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StockId implements Serializable {

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "supplier_id")
    private Integer supplierId;

    // equals() e hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return Objects.equals(equipmentName, stockId.equipmentName) &&
                Objects.equals(supplierId, stockId.supplierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentName, supplierId);
    }
}