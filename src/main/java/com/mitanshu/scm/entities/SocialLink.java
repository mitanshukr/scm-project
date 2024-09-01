package com.mitanshu.scm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SocialLink {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String url;

    @ManyToOne
    private User user;
}
