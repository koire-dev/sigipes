package com.personalAdministrative.BDSigipes.entities;

import com.fasterxml.jackson.core.SerializableString;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class statut implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStatut;

    @Column(name="Statut_personnel", nullable=false)
    private String libelleStat;

}