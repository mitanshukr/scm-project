package com.mitanshu.scm.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Table(name = "users")
@Data
public class User {
    @Id
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private boolean isEmailVerified;
    private String picture;
    private boolean isDisabled;

    @Enumerated(EnumType.STRING)
    private SignupProvider provider = SignupProvider.SELF;
    private String providerId = null;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();
}
