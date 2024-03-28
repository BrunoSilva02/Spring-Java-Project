package com.project.bookstore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "user_id", unique = true, nullable = false)
    public UUID id;

    @Setter
    @Column(name = "user_name")
    public String name;

    @Setter
    @Column(name = "user_email")
    public String email;

    @Setter
    @Column(name = "user_password_hashed")
    public String password;
}
