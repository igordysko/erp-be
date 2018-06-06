package com.objectify.erp.dao;

import com.objectify.erp.domain.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeDao extends JpaRepository<Income, Long>{
}
