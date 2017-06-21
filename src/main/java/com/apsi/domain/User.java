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
    private String password;

    public User(String login, String encode) {
        this.login = login;
        this.password = encode;
    }
}