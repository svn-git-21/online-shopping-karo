package com.svk.onlineshopping_frontend.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Message;

	public ProductNotFoundException() {
		this("Product Not avaliable");
	}
	
	public ProductNotFoundException(String message) {
		Message = System.currentTimeMillis() + " : " +message;
	}

	public String getMessage() {
		return Message;
	}
	
	

}
