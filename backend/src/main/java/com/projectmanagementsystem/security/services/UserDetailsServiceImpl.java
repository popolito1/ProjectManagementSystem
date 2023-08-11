package com.projectmanagementsystem.security.services;

import com.projectmanagementsystem.models.UserModel;
import com.projectmanagementsystem.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username)
                .orElseThrow(()
                        -> new UsernameNotFoundException
                        ("user Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
