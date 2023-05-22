package com.personalAdministrative.BDSigipes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

}
