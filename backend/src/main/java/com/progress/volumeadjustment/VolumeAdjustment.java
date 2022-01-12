package com.progress.volumeadjustment;

import java.util.Set;

import com.progress.user.Gender;
import com.progress.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "volumeAdjustments")
public class VolumeAdjustment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sets")
    private Double sets;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "volumeProperty")
    private VolumeProperty volumeProperty;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "volumeAdjustment_user", joinColumns = {
            @JoinColumn(name = "volumeAdjustmentId") }, inverseJoinColumns = { @JoinColumn(name = "userId") })
    private Set<User> users;

    // region Getter Setter
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

    public Double getSets() {
        return sets;
    }

    public void setSets(Double sets) {
        this.sets = sets;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getVolumePropertyNumber() {
        return volumeProperty.ordinal();
    }

    public VolumeProperty getVolumeProperty() {
        return volumeProperty;
    }

    public void setVolumeProperty(VolumeProperty volumeProperty) {
        this.volumeProperty = volumeProperty;
    }
    // endregion
}
