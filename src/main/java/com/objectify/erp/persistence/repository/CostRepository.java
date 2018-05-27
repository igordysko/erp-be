package com.objectify.erp.persistence.repository;

import com.objectify.erp.domain.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long>{
}
