package com.lg.user.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
