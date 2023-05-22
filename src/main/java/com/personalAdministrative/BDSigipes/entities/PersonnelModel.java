package com.personalAdministrative.BDSigipes.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonnelModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String matricule;

    @Column(name="nom_prenom", nullable=false)
    private String nom_prenom;

    @Column(name="date_naissance", nullable=false)
    private Date date_naissance;

    @Column(name="lieu_naissance", nullable=false)
    private String lieu_naissance;

    @Column(name="date_embauche", nullable=false)
    private Date date_embauche;

    @Column(name="administration", nullable=false)
    private String administration;

    @Column(name="date_retraite", nullable=false)
    private Date date_retraite;

    @Column(name="type_personnel", nullable=false)
    private TypePersonnelModel typePersonnel;

    @Column(name="service", nullable=false)
    private ServiceModel service;

    @Column(name="corps", nullable=false)
    private CorpsModel corps;

    @Column(name="grade", nullable=false)
    private GradeModel grade;

    @Column(name="categorie", nullable=false)
    private CategorieModel categorie;

    @Column(name="indice_solde", nullable=false)
    private String indice_solde;
}
