package com.personalAdministrative.BDSigipes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class TypePersonnelModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idType;

    @Column(name="label", nullable=false)
    private String label;

//    @JsonIgnore
//    @OneToMany(mappedBy = "typePersonnel")
//    private Set<PersonnelModel> personnel;

}
