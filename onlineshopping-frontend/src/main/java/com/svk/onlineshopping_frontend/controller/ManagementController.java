package com.svk.onlineshopping_frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.svk.onlineshopping_backend.dao.CategoryDAO;
import com.svk.onlineshopping_backend.dao.ProductDAO;
import com.svk.onlineshopping_backend.dto.Category;
import com.svk.onlineshopping_backend.dto.Product;
import com.svk.onlineshopping_frontend.util.FileUploadUtility;
import com.svk.onlineshopping_frontend.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name="operation", required=false) String operation)
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title","Manage Product");
		
		Product nProduct = new Product();
		
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("Product",nProduct);
		
		if(operation !=null)
		{
			if(operation.equals("Product"))
			{
				mv.addObject("message", "Product Submitted Successfully");
			}
			else if(operation.equals("category"))
			{
			    mv.addObject("message", "Category Submitted Successfully");
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
    public ModelAndView showEditProduct(@PathVariable int id)
    {
        ModelAndView mv = new ModelAndView("page");
        
        mv.addObject("userClickManageProduct", true);
        mv.addObject("title","Manage Product");
        
        Product nProduct = productDAO.get(id);
        
        mv.addObject("Product", nProduct);
        return mv;
    }
	
	
	//handling product submission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("Product") Product mProduct, 
			BindingResult results, Model model, HttpServletRequest request)
	{
		
	    //handle image validation for new product
	    
	    if(mProduct.getId() ==0) 
        {
            //image validation if id is 0
	        new ProductValidator().validate(mProduct, results);
        }
        else
        {
          if(!mProduct.getFile().getOriginalFilename().equals(""))
          {
              new ProductValidator().validate(mProduct, results);
          }
        }
		
		
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title","Manage Product");
			model.addAttribute("message", "Validation failed");
			return "page";
			
		}
		logger.info(mProduct.toString());
		
		if(mProduct.getId() ==0) 
		{
		    //create a new product if id is 0
		    productDAO.add(mProduct);
		}
		else
		{
		  //update a product if id is not 0
		    productDAO.update(mProduct);
		}
		
		
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		return "redirect:/manage/products?operation=Product";
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) 
	{
	    
	    //fetch the product from database
	    Product product = productDAO.get(id);
	    boolean isActive =product.isActive();
	    
	    //activation and deactivation
	    product.setActive(!product.isActive()); 
	    
	    //updating the product
	    productDAO.update(product);
	    
        return (isActive)? "You have successfully deactivated the product" + product.getId() 
                            :"You have successfully activated the product" + product.getId() ;
	    
	}
	
	//To handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)
	{
	    categoryDAO.add(category);
        return "redirect:/manage/products?operation=category";
	    
	}
	
	
	
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}
	
    @ModelAttribute("category")
    public Category getCategory()
    {
        return new Category();
    }

}
