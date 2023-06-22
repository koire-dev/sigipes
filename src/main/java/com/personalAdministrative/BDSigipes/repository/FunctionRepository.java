package com.personalAdministrative.BDSigipes.repository;

import com.personalAdministrative.BDSigipes.entities.FunctionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionRepository extends JpaRepository<FunctionModel, Long> {
}
