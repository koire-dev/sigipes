package com.personalAdministrative.BDSigipes.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class grade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGrade;

    @Column(name="Libelle_grade", nullable=false)
    private String libelleGrade;

}
