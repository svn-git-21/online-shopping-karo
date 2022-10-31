package com.svk.onlineshopping_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.svk.onlineshopping_backend.dao.CategoryDAO;
import com.svk.onlineshopping_backend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();
	
//	static {
//
//		// TV Category
//		Category category = new Category();
//		category.setId(1);
//		category.setName("TV");
//		category.setDescription("Television");
//		category.setImageURL("IMAGE_TV.png");
//
//		categories.add(category);
//
//		// Mobile Category
//		category = new Category();
//		category.setId(2);
//		category.setName("Mobile");
//		category.setDescription("Description for Mobile");
//		category.setImageURL("IMAGE_MOBILE.png");
//
//		categories.add(category);
//
//		// Laptop Category
//		category = new Category();
//		category.setId(3);
//		category.setName("Laptop");
//		category.setDescription("Description for Laptop");
//		category.setImageURL("IMAGE_LAPTOP.png");
//
//		categories.add(category);
//	}
	
//	@Override
//	public Category get(int id) {
//		for (Category category : categories) {
//			if(category.getId() == id)
//				return category;
//		}
//		return null;
//	}

	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
	}

	@Override
	public boolean add(Category category) {
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
