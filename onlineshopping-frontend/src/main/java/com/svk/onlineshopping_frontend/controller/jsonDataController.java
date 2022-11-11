package com.svk.onlineshopping_frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svk.onlineshopping_backend.dao.ProductDAO;
import com.svk.onlineshopping_backend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class jsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProduct()
	{
		return productDAO.listActiveProduct();
	}
	
	@RequestMapping("/admin/all/products")
    @ResponseBody
    public List<Product> getAllProductForAdmin()
    {
        return productDAO.list();
    }
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable int id)
	{
		return productDAO.listActiveProductByCategory(id);
	}

}
