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
    private String number;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="date_birth", nullable=false)
    private Date date_birth;

    @Column(name="lieu_birth", nullable=false)
    private String lieu_birth;

    @Column(name="date_hiring", nullable=false)
    private Date date_hiring;

    @Column(name="administration", nullable=false)
    private String administration;

    @Column(name="date_retirement", nullable=false)
    private Date date_retirement;

    @Column(name="indices_sold", nullable=false)
    private String indices_sold;

//    private TypePersonnelModel typePersonnel;
//
//    private ServiceModel service;
//
//    private CorpsModel corps;
//
//    private GradeModel grade;
//
//    private CategoryModel category;
//
//    private StatusModel status;
//
//    private FunctionModel function;
}
