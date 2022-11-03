package com.svk.onlineshopping_frontend.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle" , "The page is not constructed");
		mv.addObject("errorDescription" , "The page you are looking for is not avaliable now!");
		mv.addObject("title", "404 Not Found");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView ProductNotFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle" , "Product Not Avaliable");
		mv.addObject("errorDescription" , "The product you are looking for is not avaliable now!");
		mv.addObject("title", "Product Unavaliable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle" , "Contact your administrator");
		
		//only for debegging application
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription" , sw.toString());
		mv.addObject("title", "Error");
		return mv;
	}
	
	
}
