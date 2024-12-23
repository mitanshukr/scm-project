package com.mitanshu.scm.service;

import com.mitanshu.scm.entities.User;
import com.mitanshu.scm.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User u) {
        u.setId(generateUniqueId());
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setRoleList(List.of("USER"));
        userRepo.save(u);
    }

    private static String generateUniqueId() {
        return UUID.randomUUID().toString();  // Generates a 36-character unique ID
    }
}
