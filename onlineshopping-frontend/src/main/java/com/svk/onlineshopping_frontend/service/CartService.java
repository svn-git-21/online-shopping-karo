package com.svk.onlineshopping_frontend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svk.onlineshopping_backend.dao.CartLineDAO;
import com.svk.onlineshopping_backend.dto.Cart;
import com.svk.onlineshopping_backend.dto.CartLine;
import com.svk.onlineshopping_backend.dto.Product;
import com.svk.onlineshopping_frontend.Model.UserModel;

@Service("cartService")
public class CartService {
    
    @Autowired
    private CartLineDAO cartLineDAO;
    
    @Autowired
    private HttpSession session;
    
    //returns the cart of the user who had logged in
    private Cart getCart()
    {
        return ((UserModel)session.getAttribute("userModel")).getCart();
    }
    
    //returns the entire cart line
    public List<CartLine> getCartLines()
    {
        return cartLineDAO.list(this.getCart().getId());
    }

    public String updateCartLine(int cartLineId, int count) {
        // fetch the cart line
        CartLine cartLine = cartLineDAO.get(cartLineId);
        
        if(cartLine == null)
        {
            return "result=error";
        }
        else
        {
            Product product = cartLine.getProduct();
            double oldTotal =cartLine.getTotal();
            if(product.getQuantity() <= count)
            {
                count = product.getQuantity();
            }
            cartLine.setProductCount(count);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setTotal(product.getUnitPrice() * count);
            cartLineDAO.update(cartLine);
            
            Cart cart =this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
            cartLineDAO.updateCart(cart);
            
            
            return "result=updated";
        }
    }

    public String deleteCartLine(int cartLineId) {
        // fetch the cart line
        CartLine cartLine = cartLineDAO.get(cartLineId);
        if(cartLine == null)
        {
            return "result=error";
        }
        else
        {
            //update the cart
            Cart cart =this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
            cart.setCartLines(cart.getCartLines() -1);
            cartLineDAO.updateCart(cart);
            
            //remove the cartline
            cartLineDAO.delete(cartLine);
            
            return "result=deleted";
        }
    }

}
