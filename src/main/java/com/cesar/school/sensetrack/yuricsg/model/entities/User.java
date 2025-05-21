package com.cesar.school.sensetrack.yuricsg.model.entities;

import com.cesar.school.sensetrack.yuricsg.model.dtos.CreateUserDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;
    private String email;
    private String password;

    public User() {}

    public User(CreateUserDTO dto) {
        this.username = dto.username();
        this.email = dto.email();
        this.password = dto.password();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
