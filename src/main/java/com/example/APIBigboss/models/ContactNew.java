package com.example.APIBigboss.models;


import com.sun.istack.NotNull;
import java.util.Set;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class ContactNew {
    @Id
    // set up primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String userName;
    private String phoneNumber;
    private String email;
    public ContactNew() {
    }

    public ContactNew(int id, String userName, String phoneNumber, String email) {
        this.id = id;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
