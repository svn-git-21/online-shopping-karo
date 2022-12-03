package com.svk.onlineshopping_frontend.Model;

import java.io.Serializable;

import com.svk.onlineshopping_backend.dto.Address;
import com.svk.onlineshopping_backend.dto.User;

public class RegisterModel implements Serializable{
    
    private User user;
    private Address billing;
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Address getBilling() {
        return billing;
    }
    public void setBilling(Address billing) {
        this.billing = billing;
    }
    

}
