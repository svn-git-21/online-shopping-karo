package com.svk.onlineshopping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.svk.onlineshopping_backend.dao.CategoryDAO;
import com.svk.onlineshopping_backend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.svk.onlineshopping_backend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		
//		category = new Category();
//		
//		category.setName("Freedge");
//		category.setDescription("This is some description for Freedge!");
//		category.setImageURL("FDGE_1.png");
//		
//		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//		
//		
//	}
	
//	@Test
//	public void testGetCategory() {
//		
//		category = categoryDAO.get(1);
//		
//		assertEquals("Successfully fetched a single category inside the table!","Laptop",category.getName());
//		
//		
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		
//		category = categoryDAO.get(1);
//		category.setName("Laptop");
//		
//		assertEquals("Successfully updated a single category inside the table!","Laptop",categoryDAO.update(category));
//		
//		
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		
//		category = categoryDAO.get(4);
//		
//		assertEquals("Successfully deleted a single category inside the table!",true,categoryDAO.delete(category));
//		
//		
//	}
	
	@Test
	public void testListCategory() {
		
		category = categoryDAO.get(4);
		
		assertEquals("Successfully fetched list of category inside the table!",3,categoryDAO.list().size());
		
		
	}
	
	

}
