package com.progress.strengthvalue;

public class StrengthValueDto {
    private Long id;
    private String name;
    private String description;
    private Double weight;
    private Integer reps;
    private Double oneRepMax;
    private Boolean includeInTotal;
    private Integer orderNumber;
    private Long totalStrengthValueId;

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

    public Integer getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getTotalStrengthValueId() {
        return totalStrengthValueId;
    }
    public void setTotalStrengthValueId(Long totalStrengthValueId) {
        this.totalStrengthValueId = totalStrengthValueId;
    }
}
