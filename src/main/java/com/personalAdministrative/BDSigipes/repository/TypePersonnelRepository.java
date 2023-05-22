package com.personalAdministrative.BDSigipes.repository;

import com.personalAdministrative.BDSigipes.entities.TypePersonnelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePersonnelRepository extends JpaRepository<TypePersonnelModel, Long> {
}
