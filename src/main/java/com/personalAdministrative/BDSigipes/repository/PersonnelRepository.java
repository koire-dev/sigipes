package com.personalAdministrative.BDSigipes.repository;

import com.personalAdministrative.BDSigipes.entities.PersonnelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<PersonnelModel, String> {
}
