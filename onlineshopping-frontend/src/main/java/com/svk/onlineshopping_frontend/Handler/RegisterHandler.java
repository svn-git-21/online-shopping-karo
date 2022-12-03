package com.svk.onlineshopping_frontend.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.svk.onlineshopping_backend.dao.UserDAO;
import com.svk.onlineshopping_backend.dto.Address;
import com.svk.onlineshopping_backend.dto.Cart;
import com.svk.onlineshopping_backend.dto.User;
import com.svk.onlineshopping_frontend.Model.RegisterModel;

@Component
public class RegisterHandler {

    @Autowired
    private UserDAO userDAO;

    public RegisterModel init() {
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel, User user) {
        registerModel.setUser(user);
    }

    public void addBilling(RegisterModel registerModel, Address billing) {
        registerModel.setBilling(billing);
    }

    public String saveAll(RegisterModel model) {
        String transitionValue = "success";
        // getting the user
        User user = model.getUser();

        if (user.getRole().equals("USER")) {
            Cart cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
        }
        // save the user
        userDAO.addUser(user);

        // getting the address
        Address billing = model.getBilling();
        billing.setUserId(user.getId());
        billing.setBilling(true);

        // save the address
        userDAO.addAddress(billing);
        return transitionValue;

    }

    public String validateUser(User user, MessageContext error) {
        String transitionValue = "success";

        // checking if password is matching with confirm password
        if (!(user.getPassword().equals(user.getConfirmPassword()))) {
            error.addMessage(new MessageBuilder()
                    .error()
                    .source("confirmPassword")
                    .defaultText("Password doesnt match !")
                    .build());
            transitionValue = "failure";
        } 
        
        //check the uniqueness of the email id
        if(userDAO.getByEmail(user.getEmail())!=null)
        {
            error.addMessage(new MessageBuilder()
                    .error()
                    .source("email")
                    .defaultText("Email id already exists, kindly use different email id")
                    .build());
            transitionValue="failure";
        }
        return transitionValue;
    }
}
