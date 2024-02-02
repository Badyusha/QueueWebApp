package com.QueueWebApp.models;

import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullName", columnDefinition = "text")
    private String fullName;

    @Column(name = "login", columnDefinition = "text")
    private String login;


    @Column(name = "password", columnDefinition = "text")
    private String password;

    @Column(name = "passwordSalt")
    private byte[] passwordSalt;

    public User() {
    }

    public User(String fullName, String login, String password, byte[] passwordSalt) {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.passwordSalt = passwordSalt;
    }

    public Long getId() {
        return id;
    }

    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}