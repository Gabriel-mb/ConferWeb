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
@Table(name = "epis")
public class Epi {

    @EmbeddedId
    private EpiId epiId;

    @Column(name = "quantity")
    private Integer quantity;
}
