package com.app.Service;



import com.app.Repository.UserRepo;


import com.app.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepo userRepository;

    public CustomUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(usernameOrEmail).get();
        String password;
        String name;
        Set<GrantedAuthority> setrole;
        if (user == null) {
            throw new UsernameNotFoundException("User is not found");
        } else {
            name = user.getUsername();
            password = user.getPassword();
            Set<String> role = user.getRole();
            setrole = new HashSet<>();
            for (String role1 : role) {
                setrole.add(new SimpleGrantedAuthority(role1));
            }
        }
        return new org.springframework.security.core.userdetails.User(name, password, setrole);
    }

}

