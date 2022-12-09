package com.svk.onlineshopping_frontend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svk.onlineshopping_backend.dao.CartLineDAO;
import com.svk.onlineshopping_backend.dao.ProductDAO;
import com.svk.onlineshopping_backend.dto.Cart;
import com.svk.onlineshopping_backend.dto.CartLine;
import com.svk.onlineshopping_backend.dto.Product;
import com.svk.onlineshopping_frontend.Model.UserModel;

@Service("cartService")
public class CartService {
    
    @Autowired
    private CartLineDAO cartLineDAO;
    
    @Autowired
    private ProductDAO productDAO;
    
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

//    public String updateCartLine(int cartLineId, int count) {
//        // fetch the cart line
//        CartLine cartLine = cartLineDAO.get(cartLineId);
//        
//        if(cartLine == null)
//        {
//            return "result=error";
//        }
//        else
//        {
//            Product product = cartLine.getProduct();
//            double oldTotal =cartLine.getTotal();
//            if(product.getQuantity() <= count)
//            {
//                count = product.getQuantity();
//            }
//            cartLine.setProductCount(count);
//            cartLine.setBuyingPrice(product.getUnitPrice());
//            cartLine.setTotal(product.getUnitPrice() * count);
//            cartLineDAO.update(cartLine);
//            
//            Cart cart =this.getCart();
//            cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
//            cartLineDAO.updateCart(cart);
//            
//            
//            return "result=updated";
//        }
//    }

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

    public String addCartLine(int productId) {
        String response = null;
        
        Cart cart = this.getCart();
        CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
        
        if(cartLine == null)
        {
            //add a new cart line
            cartLine =new CartLine();
            
            //fetch the product
            Product product = productDAO.get(productId);
            
            cartLine.setCartId(cart.getId());
            cartLine.setProduct(product);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setProductCount(1);
            cartLine.setTotal(product.getUnitPrice());
            cartLine.setAvaliable(true);
            cartLineDAO.add(cartLine);
            
            cart.setCartLines(cart.getCartLines() +1);
            cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
            cartLineDAO.update(cartLine);
            
            response = "result=added";
        }
        else
        {
            //check if the cart line has reached the maximum count
            if(cartLine.getProductCount() < 3)
            {
                //update the product count for the cart line
                response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() +1);
            }
            else
            {
                response = "result=maximum";
            }
        }
        return response;

    }

    public String manageCartLine(int cartLineId, int count) {
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
            
            //check if the product is avaliable
            if(product.getQuantity() < count)
            {
                return "result=unavaliable";
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

}
