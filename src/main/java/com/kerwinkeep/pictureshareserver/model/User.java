package com.kerwinkeep.pictureshareserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class User {
    @Id
    @Column(name = "id")
    long id;

    @Column(name = "account", unique = true, nullable = false, length = 20)
    String account;

    @Column(name = "password", nullable = false, length = 20)
    String password;

    @Column(name= "name", length = 20)
    String name;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
