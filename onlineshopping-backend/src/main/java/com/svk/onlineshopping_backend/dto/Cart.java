package com.svk.onlineshopping_backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
//    @Column(name = "user_id")
//    private int userId;
    
    /*--------------------------------*/
    @OneToOne
    private User user;
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    /*--------------------------------*/
    
    @Column(name="grand_total")
    private double grandTotal;
    @Column(name = "cart_lines")
    private int cartLines;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
//    public int getUserId() {
//        return userId;
//    }
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
    public double getGrandTotal() {
        return grandTotal;
    }
    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    public int getCartLines() {
        return cartLines;
    }
    public void setCartLines(int cartLines) {
        this.cartLines = cartLines;
    }
    @Override
    public String toString() {
        return "Cart [id=" + id + ", user=" + user + ", grandTotal=" + grandTotal + ", cartLines=" + cartLines + "]";
    }

    
    
}
