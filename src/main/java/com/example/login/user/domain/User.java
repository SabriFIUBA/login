package com.example.login.user.domain;

//import lombok.Data;
import org.hibernate.type.IntegerType;

import javax.persistence.*;
import java.util.Objects;
//import java.math.BigDecimal;
//import java.sql.Timestamp;

//@Data
@Entity
@Table(name = "users", schema = "login")

public class User {
    public User(){}

    public User(Long id_, String name_, String password_) {
        id = id_;
        name = name_;
        password = password_;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }

//    @Id
//    @Column(name = "id", columnDefinition = "INTEGER")
//    private Long Id;
//
//    @Column(name = "name", columnDefinition = "NVARCHAR")
//    private String Name;
//
//    @Column(name = "password", columnDefinition = "NVARCHAR")
//    private String Password;
}
