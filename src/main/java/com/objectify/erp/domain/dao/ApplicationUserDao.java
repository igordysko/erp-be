package com.objectify.erp.domain.dao;

import com.objectify.erp.infrastructure.security.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserDao extends JpaRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);

}
