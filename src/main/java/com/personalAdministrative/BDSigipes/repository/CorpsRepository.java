package com.personalAdministrative.BDSigipes.repository;

import com.personalAdministrative.BDSigipes.entities.CorpsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorpsRepository extends JpaRepository<CorpsModel, Long> {
}
