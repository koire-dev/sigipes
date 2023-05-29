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
public class IndicesModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idIndices;

    @Column(nullable = false)
    private int value;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "indices", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("indices")
    private Set<CategoryModel> category;
}
