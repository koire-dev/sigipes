package com.personalAdministrative.BDSigipes.repository;

import com.personalAdministrative.BDSigipes.entities.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
}
