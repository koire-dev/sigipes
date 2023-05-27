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
public class CorpsModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long idCorps;

    @Column(name="label", nullable=false)
    private String label;

//    @JsonIgnore
//    @OneToMany(mappedBy = "corps")
//    private Set<PersonnelModel> personnel;

}
