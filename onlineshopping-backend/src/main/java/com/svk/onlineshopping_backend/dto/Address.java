package com.svk.onlineshopping_backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @Column(name= "user_id")
    private int userId;
    @Column(name = "address_line_one")
    private String addressLineOne;
    @Column(name = "address_line_two")
    private String addressLineTwo;
    private String city;
    private String state;
    @Column(name = "postal_code")
    private String postalCode;
    private String country;
    @Column(name="is_shipping")
    private boolean shipping;
    @Column(name="is_billing")
    private boolean billing;
    
    
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getAddressLineOne() {
        return addressLineOne;
    }
    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }
    public String getAddressLineTwo() {
        return addressLineTwo;
    }
    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public boolean isShipping() {
        return shipping;
    }
    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }
    public boolean isBilling() {
        return billing;
    }
    public void setBilling(boolean billing) {
        this.billing = billing;
    }
    @Override
    public String toString() {
        return "Address [id=" + id + ", userId=" + userId + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
                + addressLineTwo + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", country="
                + country + ", shipping=" + shipping + ", billing=" + billing + "]";
    }


    
    
}
