package com.apsi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "UserEntity")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String password;
    private String email;

    public User(String login, String encode, String email, String name, String surname) {
        this.login = login;
        this.password = encode;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }
}