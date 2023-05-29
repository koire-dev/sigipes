package com.personalAdministrative.BDSigipes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ClassModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClass;

    @Column(nullable = false)
    private String label;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "classes", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("classes")
    private Set<CategoryModel> category;
}
