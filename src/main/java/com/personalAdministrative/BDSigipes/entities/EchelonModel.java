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
public class EchelonModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEchelon;

    @Column(nullable = false)
    private int value;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "echelon", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("echelon")
    private Set<CategoryModel> category;
}
