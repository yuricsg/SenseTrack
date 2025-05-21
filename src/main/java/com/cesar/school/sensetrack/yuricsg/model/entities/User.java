package com.cesar.school.sensetrack.yuricsg.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class User {

    private String username;
    private String email;
    private String password;


}
