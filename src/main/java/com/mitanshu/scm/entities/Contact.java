package com.mitanshu.scm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Contact {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    private String email;
    private String phone;
    @Column(length = 1000)
    private String about;
    private String address;
    private String picture;
    private boolean isFavourite = false;
    private String websiteUrl;
    private String facebookUrl;

    @ManyToOne
    private User user;
}
