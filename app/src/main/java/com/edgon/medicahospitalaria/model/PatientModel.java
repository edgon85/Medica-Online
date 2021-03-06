package com.edgon.medicahospitalaria.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientModel {


    @SerializedName("id")
    @Expose
    private int id;



    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("age")
    @Expose
    private Object age;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("adress")
    @Expose
    private String adress;
    @SerializedName("postal_code")
    @Expose
    private Object postalCode;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", postalCode=" + postalCode +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
