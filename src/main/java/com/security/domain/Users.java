package com.security.domain;

import com.security.model.UserModel;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;
    Boolean enabled = true;
    Date dateCreated;
    Date lastUpdated;


    public Users(UserModel userModel) {
        this.username = userModel.getUsername();
        this.password = userModel.getPassword();
        this.enabled = userModel.getEnabled();
    }

    @PrePersist
    public void onCreate() {
        dateCreated = new Date();
        lastUpdated = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        lastUpdated = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enabled;
    }

    public void setEnable(Boolean enable) {
        this.enabled = enable;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public static Users create(UserModel userModel){
        return new Users(userModel);
    }
}
