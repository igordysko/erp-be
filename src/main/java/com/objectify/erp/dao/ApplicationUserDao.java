package com.objectify.erp.dao;

import com.objectify.erp.security.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserDao extends JpaRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);

}
