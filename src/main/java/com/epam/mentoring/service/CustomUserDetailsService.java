package com.epam.mentoring.service;

import com.epam.mentoring.entity.UserEntity;
import com.epam.mentoring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginAttemptService loginAttemptService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        if (loginAttemptService.isBlocked()) {
            user.setEnabled(false);
            userRepository.save(user);
            throw new RuntimeException("You were blocked");
        }

        return User.withUsername(user.getUsername())
            .password(user.getPassword())
            .authorities(user.getAuthority().split(","))
            .build();
    }
}