package com.example.a20190530_chandragudimetla_nycschools.data;

import com.google.gson.annotations.SerializedName;

public class School {
    @SerializedName("school_name")
    private String schoolName;
    @SerializedName("overview_paragraph")
    private String description;
    @SerializedName("primary_address_line_1")
    private String streetAddress;
    @SerializedName("state_code")
    private String state;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("school_email")
    private String email;
    @SerializedName("zip")
    private String zipCode;
    @SerializedName("city")
    private String city;
    @SerializedName("dbn")
    private String dbn;
    private String fullAddress;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getFullAddress() {
        return fullAddress = streetAddress + "\n" + city + ", " + state +" "+ zipCode;
    }
}
