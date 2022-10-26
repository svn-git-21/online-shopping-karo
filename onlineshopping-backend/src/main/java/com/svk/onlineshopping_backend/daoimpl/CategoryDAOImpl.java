package com.svk.onlineshopping_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.svk.onlineshopping_backend.dao.CategoryDAO;
import com.svk.onlineshopping_backend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		// TV Category
		Category category = new Category();
		category.setId(1);
		category.setName("TV");
		category.setDescription("Television");
		category.setImageURL("IMAGE_TV.png");

		categories.add(category);

		// Mobile Category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description for Mobile");
		category.setImageURL("IMAGE_MOBILE.png");

		categories.add(category);

		// Laptop Category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Description for Laptop");
		category.setImageURL("IMAGE_LAPTOP.png");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		for (Category category : categories) {
			if(category.getId() == id)
				return category;
		}
		return null;
	}

}
