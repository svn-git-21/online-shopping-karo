package com.svk.onlineshopping_frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.svk.onlineshopping_backend.dao.CategoryDAO;
import com.svk.onlineshopping_backend.dto.Category;
import com.svk.onlineshopping_backend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProduct()
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title","Manage Product");
		
		Product nProduct = new Product();
		
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("Product",nProduct);
		
		return mv;
	}
	
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}

}
