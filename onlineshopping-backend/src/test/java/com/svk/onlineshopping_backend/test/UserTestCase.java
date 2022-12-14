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
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.svk.onlineshopping_backend");
        context.refresh();

        userDAO = (UserDAO) context.getBean("userDAO");
    }

//    @Test
//    public void testAdd()
//    {
//        user = new User() ;
//        user.setFirstName("Hrithik");
//        user.setLastName("Roshan");
//        user.setEmail("hr@gmail.com");
//        user.setContactNumber("1234512345");
//        user.setRole("USER");
//        user.setPassword("123456");
//        
//        assertEquals("Failed to add user", true, userDAO.addUser(user));
//        
//        address = new Address();
//        address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//        address.setAddressLineTwo("Near Kaabil Store");
//        address.setCity("Mumbai");
//        address.setState("Maharashtra");
//        address.setCountry("India");
//        address.setPostalCode("400001");
//        address.setBilling(true);
//        
//        address.setUserId(user.getId());
//        assertEquals("Failed to add address", true, userDAO.addAddress(address));
//        
//        if(user.getRole().equals("USER"))
//        {
//            cart = new Cart();
//            cart.setUser(user);
//            assertEquals("Failed to add cart", true, userDAO.addCart(cart));
//            
//            address = new Address();
//            address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//            address.setAddressLineTwo("Near Kudrat Store");
//            address.setCity("Mumbai");
//            address.setState("Maharashtra");
//            address.setCountry("India");
//            address.setPostalCode("400001");
//            address.setShipping(true);
//            
//            address.setUserId(user.getId());
//            assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));
//            
//        }
//        
//    }

//    @Test
//    public void testAdd()
//    {
//        user = new User() ;
//        user.setFirstName("Hrithik");
//        user.setLastName("Roshan");
//        user.setEmail("hr@gmail.com");
//        user.setContactNumber("1234512345");
//        user.setRole("USER");
//        user.setPassword("123456");
//
//        if(user.getRole().equals("USER"))
//        {
//            cart = new Cart();
//            cart.setUser(user);
//            user.setCart(cart);  
//        }
//        
//        //add the user
//        assertEquals("Failed to add user", true, userDAO.addUser(user));
//        
//    }

//    @Test
//    public void addUserTest()
//    {
//        user = userDAO.getByEmail("hr@gmail.com");
//        cart =user.getCart();
//        cart.setGrandTotal(6000);
//        cart.setCartLines(2);
//        assertEquals("Failed to update the cart", true, userDAO.updateCart(cart));
//    }

    /*
     * @Test
     * public void testAddAddress() {
     * // we need to add an user
     * user = new User();
     * user.setFirstName("Hrithik");
     * user.setLastName("Roshan");
     * user.setEmail("hr@gmail.com");
     * user.setContactNumber("1234512345");
     * user.setRole("USER");
     * user.setPassword("123456");
     * 
     * assertEquals("Failed to add user", true, userDAO.addUser(user));
     * 
     * // we are going to add address
     * address = new Address();
     * address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
     * address.setAddressLineTwo("Near Kaabil Store");
     * address.setCity("Mumbai");
     * address.setState("Maharashtra");
     * address.setCountry("India");
     * address.setPostalCode("400001");
     * address.setBilling(true);
     * 
     * //attach the address to the user
     * address.setUser(user);
     * assertEquals("Failed to add address", true, userDAO.addAddress(address));
     * 
     * 
     * // we are also going to add shipping address
     * address = new Address();
     * address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
     * address.setAddressLineTwo("Near Kudrat Store");
     * address.setCity("Mumbai");
     * address.setState("Maharashtra");
     * address.setCountry("India");
     * address.setPostalCode("400001");
     * address.setShipping(true);
     * 
     * address.setUser(user);
     * assertEquals("Failed to add shipping address", true,
     * userDAO.addAddress(address));
     * 
     * 
     * }
     */

//    @Test
//    public void testAddAddress() {
//        user = userDAO.getByEmail("hr@gmail.com");
//        // we are also going to add shipping address
//        address = new Address();
//        address.setAddressLineOne("301/B Jadoo Society, Kishan Kanhaiya Nagar");
//        address.setAddressLineTwo("Near Kudrat Store");
//        address.setCity("Bangalore");
//        address.setState("Karnataka");
//        address.setCountry("India");
//        address.setPostalCode("400001");
//        address.setShipping(true);
//
//        address.setUser(user);
//        assertEquals("Failed to add shipping address", true,
//                userDAO.addAddress(address));
//    }
    
    @Test
    public void testGetAddress()
    {
        user = userDAO.getByEmail("hr@gmail.com");
        assertEquals("Failed to fetch the list of address", 2, userDAO.listShippingAddress(user).size());
        assertEquals("Failed to fetch the billing address", "Mumbai", userDAO.getBillingAddress(user).getCity());
    }

}
