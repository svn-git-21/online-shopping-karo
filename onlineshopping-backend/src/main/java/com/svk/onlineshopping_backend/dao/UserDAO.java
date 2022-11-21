package com.svk.onlineshopping_backend.dao;

import java.util.List;

import com.svk.onlineshopping_backend.dto.Address;
import com.svk.onlineshopping_backend.dto.Cart;
import com.svk.onlineshopping_backend.dto.User;

public interface UserDAO {

    //add an user
    boolean addUser(User user);
    
    User getByEmail(String email);
    
    //add an address
    boolean addAddress(Address address);
    
    Address getBillingAddress(User user);
    List<Address> listShippingAddress(User user);
    
//    alternative
//    Address getBillingAddress(int userId);
//    List<Address> listShippingAddress(int userId);
    
    //add a cart
    boolean updateCart(Cart cart);
}
