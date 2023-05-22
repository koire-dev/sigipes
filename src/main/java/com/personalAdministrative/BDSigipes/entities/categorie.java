package com.personalAdministrative.BDSigipes.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategorie;

    @Column(name="Libelle_catégorie", nullable=false)
    private String libelleCat;

}
