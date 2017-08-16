package com.edgon.medicahospitalaria.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientModel {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("age")
    @Expose
    private int age;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("adress")
    @Expose
    private String adress;

    @SerializedName("postal_code")
    @Expose
    private int postalCode;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password1")
    @Expose
    private String password1;

    @SerializedName("password2")
    @Expose
    private String password2;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                " name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", postalCode=" + postalCode +
                ", email='" + email + '\'' +
                ", password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
