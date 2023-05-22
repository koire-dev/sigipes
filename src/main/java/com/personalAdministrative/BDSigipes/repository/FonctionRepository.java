package com.personalAdministrative.BDSigipes.repository;

import com.personalAdministrative.BDSigipes.entities.FonctionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionRepository extends JpaRepository<FonctionModel, Long> {
}
