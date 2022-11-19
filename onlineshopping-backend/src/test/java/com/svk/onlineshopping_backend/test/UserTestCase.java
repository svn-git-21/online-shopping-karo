package com.svk.onlineshopping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.svk.onlineshopping_backend.dao.UserDAO;
import com.svk.onlineshopping_backend.dto.Address;
import com.svk.onlineshopping_backend.dto.Cart;
import com.svk.onlineshopping_backend.dto.User;

public class UserTestCase {
    
    private static AnnotationConfigApplicationContext context;
    private static UserDAO userDAO;
    private User user = null;
    private Cart cart = null;
    private Address address = null;
    
    @BeforeClass
    public static void init()
    {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.svk.onlineshopping_backend");
        context.refresh();
        
        userDAO = (UserDAO) context.getBean("userDAO");
    }
    
    @Test
    public void testAdd()
    {
        user = new User() ;
        user.setFirstName("Hrithik");
        user.setLastName("Roshan");
        user.setEmail("hr@gmail.com");
        user.setContactNumber("1234512345");
        user.setRole("USER");
        user.setPassword("123456");
        
        assertEquals("Failed to add user", true, userDAO.addUser(user));
        
        address = new Address();
        address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
        address.setAddressLineTwo("Near Kaabil Store");
        address.setCity("Mumbai");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setPostalCode("400001");
        address.setBilling(true);
        
        address.setUserId(user.getId());
        assertEquals("Failed to add address", true, userDAO.addAddress(address));
        
        if(user.getRole().equals("USER"))
        {
            cart = new Cart();
            cart.setUserId(user.getId());
            assertEquals("Failed to add cart", true, userDAO.addCart(cart));
            
            address = new Address();
            address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
            address.setAddressLineTwo("Near Kudrat Store");
            address.setCity("Mumbai");
            address.setState("Maharashtra");
            address.setCountry("India");
            address.setPostalCode("400001");
            address.setShipping(true);
            
            address.setUserId(user.getId());
            assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));
            
        }
        
    }

}
