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
public class EpiId implements Serializable {

    @Column(name = "epiName")
    private String epiName;

    @Column(name = "numCa")
    private Integer numCa;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EpiId epiId = (EpiId) o;
        return Objects.equals(epiName, epiId.epiName) && Objects.equals(numCa, epiId.numCa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(epiName, numCa);
    }
}
