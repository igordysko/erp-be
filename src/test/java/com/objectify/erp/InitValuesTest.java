package com.objectify.erp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class InitValuesTest {

    @Test
    public void bcryptTest() {
        String encryptedAdminPassword = "$2a$10$V4tMyhy89g3r5P9pyu7DI.GyBN0h9FYgr/W4/vSuev12b/W9.6V/G";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Assert.assertTrue(passwordEncoder.matches("admin", encryptedAdminPassword));
    }
}
