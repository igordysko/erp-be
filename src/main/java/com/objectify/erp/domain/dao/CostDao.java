package com.objectify.erp.domain.dao;

import com.objectify.erp.domain.model.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostDao extends JpaRepository<Cost, Long>{
}
