package com.personalAdministrative.BDSigipes.repository;

import com.personalAdministrative.BDSigipes.entities.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
