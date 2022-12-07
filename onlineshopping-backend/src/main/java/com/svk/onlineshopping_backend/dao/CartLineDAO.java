package com.svk.onlineshopping_backend.dao;

import java.util.List;

import com.svk.onlineshopping_backend.dto.Cart;
import com.svk.onlineshopping_backend.dto.CartLine;

public interface CartLineDAO {
    
    public CartLine get(int id);
    
    public boolean add(CartLine cartLine);
    public boolean update(CartLine cartLine);
    public boolean delete(CartLine cartLine);
    public List<CartLine> list(int cartId);
    
    //other business methods related to the cart line
    
    public List<CartLine> listAvaliable(int cartId);
    public CartLine getByCartAndProduct(int cartId, int productId);
    
  //add a cart
    boolean updateCart(Cart cart);

}
