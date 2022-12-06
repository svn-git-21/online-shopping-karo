package com.svk.onlineshopping_frontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.svk.onlineshopping_backend.dao.CategoryDAO;
import com.svk.onlineshopping_backend.dao.ProductDAO;
import com.svk.onlineshopping_backend.dto.Category;
import com.svk.onlineshopping_backend.dto.Product;
import com.svk.onlineshopping_frontend.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger logger =LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("Inside PageController index method -- INFO");
		logger.debug("Inside PageController index method -- DEBUG");
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
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("page");
		Product product =productDAO.get(id);
		 
		if(product == null) throw new ProductNotFoundException();
		
		//update the view count
		product.setViews(product.getViews() +1 );
		productDAO.update(product);
		mv.addObject("title", product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		return mv;
		
	}
	

	//login page
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(name="error" , required=false) String error,
            @RequestParam(name="logout" , required=false) String logout )
    {
        ModelAndView mv = new ModelAndView("login");
        
        if (error!=null) {
            mv.addObject("message", "Invalid credentials");
        }
        if (logout!=null) {
            mv.addObject("logout", "User has successfully logged out!");
        }

        mv.addObject("title","Login");
        return mv;
    }
    
  //access-denied page handler
    @RequestMapping(value = "/access-denied")
    public ModelAndView accessDenied()
    {
        ModelAndView mv = new ModelAndView("error");
        
        
        mv.addObject("title","403 - Access Denied");
        mv.addObject("errorTitle","Aha!  Caught You");
        mv.addObject("errorDescription","You are not authorized to view this page!");
        return mv;
    }
    
  //Logout mapping
    @RequestMapping(value = "/perform-logout")
    public String logout(HttpServletRequest request, HttpServletResponse response)
    {
       Authentication auth= SecurityContextHolder.getContext().getAuthentication();
       
       if(auth!=null)
       {
           new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       
       return "redirect:/login?logout";
    }

}
