package com.svk.onlineshopping_frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.svk.onlineshopping_backend.dao.CategoryDAO;
import com.svk.onlineshopping_backend.dao.ProductDAO;
import com.svk.onlineshopping_backend.dto.Category;
import com.svk.onlineshopping_backend.dto.Product;

@Controller
public class PageController {
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		//Passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = "/contacts")
	public ModelAndView contacts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contacts");
		mv.addObject("userClickContacts",true);
		return mv;
	}
	
	
	//method to show all products and based on category
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProduct()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProduct",true);
		return mv;
	}
	
	//method to show all products and based on category
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		//category DAO to fetch a single category
		Category category = new Category();
		category = categoryDAO.get(id);
		mv.addObject("title",category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProduct",true);
		return mv;
	}
	
	@RequestMapping(value ="/show/{id}/products")
	public ModelAndView showSingleProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		Product product =productDAO.get(id);
		
		//update the view count
		product.setViews(product.getViews() +1 );
		productDAO.update(product);
		mv.addObject("title", product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		return mv;
		
	}

}
