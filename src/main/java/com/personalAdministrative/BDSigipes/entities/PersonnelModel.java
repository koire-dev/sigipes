package com.personalAdministrative.BDSigipes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "typeId", referencedColumnName = "idType")
    @JsonIgnoreProperties("personnel")
    private TypePersonnelModel typePersonnel;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "serviceId", referencedColumnName = "idService")
    @JsonIgnoreProperties("personnel")
    private ServiceModel service;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "corpsId", referencedColumnName = "idCorps")
    @JsonIgnoreProperties("personnel")
    private CorpsModel corps;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "gradeId", referencedColumnName = "idGrade")
    @JsonIgnoreProperties("personnel")
    private GradeModel grade;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId", referencedColumnName = "idCategory")
    @JsonIgnoreProperties("personnel")
    private CategoryModel category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "statusId", referencedColumnName = "idStatus")
    @JsonIgnoreProperties("personnel")
    private StatusModel status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "functionId", referencedColumnName = "idFunction")
    @JsonIgnoreProperties("personnel")
    private FunctionModel function;
}
