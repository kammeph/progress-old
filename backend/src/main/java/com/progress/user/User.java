package com.progress.user;

import java.util.Set;

import com.progress.strengthvalue.StrengthValue;
import com.progress.volumeadjustment.VolumeAdjustment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName", unique = false, nullable = false)
    private String userName;

    @Column(name = "passwordHash", unique = false, nullable = false)
    private String passwordHash;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<StrengthValue> strengthValues;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.REMOVE)
    private Set<VolumeAdjustment> volumeCharacteristics;

    public User() {}
    public User(String username, String passwordhash, Gender gender) {
        this.userName = username;
        this.passwordHash = passwordhash;
        this.gender = gender;
    }

    // region Getter/Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Integer getGenderNumber() {
        return gender.ordinal();
    }
    // endregion
}
