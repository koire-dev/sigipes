package com.personalAdministrative.BDSigipes.repository;

import com.personalAdministrative.BDSigipes.entities.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusModel, Long> {
}
