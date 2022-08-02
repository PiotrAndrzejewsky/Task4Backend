package com.example.Task4.user;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long mUserId;

    @Column(name = "username")
    private String mUsername;

    @Column(name = "password")
    private String mPassword;

    @Column(name = "email")
    private String mEmail;

    @Column(name = "last_login_time")
    private LocalDateTime mLastLoginTime;

    @Column(name = "registration_time")
    private LocalDateTime mRegistrationTime = LocalDateTime.now();

    @Column(name = "active")
    private boolean mActive = true;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String email) {
        this.mUsername = username;
        this.mPassword = password;
        this.mEmail = email;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public LocalDateTime getLastLoginTime() {
        return mLastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        mLastLoginTime = lastLoginTime;
    }

    public LocalDateTime getRegistrationTime() {
        return mRegistrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        mRegistrationTime = registrationTime;
    }

    public boolean isActive() {
        return mActive;
    }

    public void setActive(boolean active) {
        mActive = active;
    }
}
