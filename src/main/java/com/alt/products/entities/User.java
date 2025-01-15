package com.alt.products.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "app_user") 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstname;
    private String email;

    @Column(nullable = false)
    private String password;
}
