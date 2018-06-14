package com.objectify.erp.security;

import com.objectify.erp.dao.ApplicationUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile(value = "prod")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ApplicationUserDao applicationUserDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        if (user.getRoles() != null) {
            List<String> roles = user.getRoles()
                    .stream()
                    .map(role -> role.name())
                    .collect(Collectors.toList());

            builder.roles(roles.toArray(new String[0]));
        }
        return builder.build();
    }

}
