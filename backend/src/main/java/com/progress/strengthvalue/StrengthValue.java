package com.progress.strengthvalue;

import com.progress.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "strengthValues")
public class StrengthValue {

    @Id
    @Column(name = "id")    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "reps")
    private Integer reps;

    @Column(name = "oneRepMax")
    private Double oneRepMax;

    @Column(name = "includeInTotal")
    private Boolean includeInTotal;

    @Column(name = "orderNumber")
    private int orderNumber;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public StrengthValue() { }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public StrengthValue(
        Long userid, 
        String name, 
        String description,
        Double weight, 
        Integer reps, 
        Double onerepmax, 
        Boolean includeintotal, 
        Integer ordernumber) {
            this.userId = userid;
            this.name = name; 
            this.description = description;
            this.weight = weight;
            this.reps = reps;
            this.oneRepMax = onerepmax;
            this.includeInTotal = includeintotal;
            this.orderNumber = ordernumber;
    }

    // region Getter/Setter
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getReps() {
        return reps;
    }
    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Double getOneRepMax() {
        return oneRepMax;
    }
    public void setOneRepMax(Double oneRepMax) {
        this.oneRepMax = oneRepMax;
    }

    public Boolean getIncludeInTotal() {
        return includeInTotal;
    }
    public void setIncludeInTotal(Boolean includeInTotal) {
        this.includeInTotal = includeInTotal;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    // endregion
}
