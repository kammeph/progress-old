package com.progress.user;

public class UserDto {

    private long id;
    private String userName;
    private String gender;
    private Integer genderNumber;
    private String token;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getGenderNumber() {
        return genderNumber;
    }
    public void setGenderNumber(Integer genderNumber) {
        this.genderNumber = genderNumber;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}