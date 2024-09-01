package com.mitanshu.scm.service;

import com.mitanshu.scm.entities.User;
import com.mitanshu.scm.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void save(User u) {
        userRepo.save(u);
    }
}
