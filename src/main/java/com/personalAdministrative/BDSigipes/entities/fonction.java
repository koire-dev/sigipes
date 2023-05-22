package com.personalAdministrative.BDSigipes.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class fonction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFonction;

    @Column(name="Libelle_Fonction", nullable=false)
    private String fct;

}
