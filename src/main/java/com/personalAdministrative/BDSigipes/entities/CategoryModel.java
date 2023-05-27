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
public class CategoryModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategory;

    @Column(name="label", nullable=false)
    private String label;

//    private ClassModel classes;
//    private IndicesModel indices;
//    private EchelonModel echelon;

//    @JsonIgnore
//    @OneToMany(mappedBy = "category")
//    private Set<PersonnelModel> personnel;

}
