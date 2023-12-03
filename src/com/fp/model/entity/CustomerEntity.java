package com.fp.model.entity;




public class CustomerEntity {

    private int id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phone;
    private String userName;
    private String password;
    private String address;

    public CustomerEntity() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.birthDate = "0000-00-00";
        this.phone = "";
        this.userName = "";
        this.password = "";
        this.address = "";
    }
    public CustomerEntity(int id, String firstName, String lastName, String birthDate, String phone, String userName, String password, String address){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
