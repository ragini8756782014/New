package com.example.Bastion.entitty.crmentity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bi_api_tbl_users")
public class User {

    @Id
    private int id;

    @Column(name = "user_email",nullable = false)
    private String user_email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "userName",nullable = false)
    private String userName;

    @Column(name = "user_role")
    private String user_role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user_name) {
        this.userName = user_name;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }





}
