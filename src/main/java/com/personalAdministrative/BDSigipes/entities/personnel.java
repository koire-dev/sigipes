package com.personalAdministrative.BDSigipes.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class personnel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String matricule;

    @Column(name="Noms_Prenoms", nullable=false)
    private String nom_prenom;

    @Column(name="Date_naissance", nullable=false)
    private Date date_naissance;

    @Column(name="Lieu_naissance", nullable=false)
    private String lieu_naissance;

    @Column(name="Date_recrutement", nullable=false)
    private Date date_embauche;

    @Column(name="Administration_affectation", nullable=false)
    private String administration;

    @Column(name="Date_mise_retraite", nullable=false)
    private Date date_retraite;

    @Column(name="Type_personnel", nullable=false)
    private typePersonnel Type;

    @Column(name="Service", nullable=false)
    private service Service;

    @Column(name="Corps", nullable=false)
    private corps Corps;

    @Column(name="Grade", nullable=false)
    private grade Grade;

    @Column(name="Catégorie", nullable=false)
    private categorie Cat;

    @Column(name="Indice_solde", nullable=false)
    private String indice_solde;


}
