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
@Table(name = "ClientEntity")
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String address;

    public Client(String login, String password, String email, String name, String surname, String address) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.address = address;
    }
}