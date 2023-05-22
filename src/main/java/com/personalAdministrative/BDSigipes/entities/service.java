package com.personalAdministrative.BDSigipes.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idService;

    @Column(name="Libelle_service", nullable=false)
    private String libelleService;

}

