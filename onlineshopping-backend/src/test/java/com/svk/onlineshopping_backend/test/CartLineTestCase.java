package com.svk.onlineshopping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.svk.onlineshopping_backend.dao.CartLineDAO;
import com.svk.onlineshopping_backend.dao.ProductDAO;
import com.svk.onlineshopping_backend.dao.UserDAO;
import com.svk.onlineshopping_backend.dto.Cart;
import com.svk.onlineshopping_backend.dto.CartLine;
import com.svk.onlineshopping_backend.dto.Product;
import com.svk.onlineshopping_backend.dto.User;

public class CartLineTestCase {

    private static AnnotationConfigApplicationContext context;
    
    private static CartLineDAO cartLineDAO=null;
    private static ProductDAO productDAO=null;
    private static UserDAO userDAO=null;
    
    private Product product=null;
    private User user=null;
    private Cart cart=null;
    private CartLine cartLine=null;
    
    @BeforeClass
    public static void init()
    {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.svk.onlineshopping_backend");
        context.refresh();
        productDAO = (ProductDAO)context.getBean("productDAO");
        userDAO = (UserDAO)context.getBean("userDAO");
        cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
    }
    
    @Test
    public void testAddNewCartLine()
    {
        //1. get the user
        user = userDAO.getByEmail("akumar@shopping-karo.com");
        
        //2. fetch the cart
        cart = user.getCart();
        
        //3. get the product
        product=productDAO.get(1);
        
        //create a new cart line
        cartLine= new CartLine();
        
        cartLine.setBuyingPrice(product.getUnitPrice());
        
        cartLine.setProductCount(cartLine.getProductCount() + 1);
        cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
        cartLine.setAvaliable(true);
        cartLine.setCartId(cart.getId());
        
        cartLine.setProduct(product);
        
        assertEquals("Failed to add the cart line", true, cartLineDAO.add(cartLine));
        
        //update the cart
        cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
        
        cart.setCartLines(cart.getCartLines() + 1);
        
        assertEquals("Failed to update the carte", true, cartLineDAO.updateCart(cart));
    }
    
    
}
