package com.personalAdministrative.BDSigipes.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class corps implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long idCorps;

    @Column(name="Libelle_corps", nullable=false)
    private String libelleCorps;

}
