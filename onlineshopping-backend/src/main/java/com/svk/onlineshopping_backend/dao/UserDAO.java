package com.svk.onlineshopping_backend.dao;

import com.svk.onlineshopping_backend.dto.Address;
import com.svk.onlineshopping_backend.dto.Cart;
import com.svk.onlineshopping_backend.dto.User;

public interface UserDAO {

    //add an user
    boolean addUser(User user);
    
    //add an address
    boolean addAddress(Address address);
    
    //add a cart
    boolean addCart(Cart cart);
}
