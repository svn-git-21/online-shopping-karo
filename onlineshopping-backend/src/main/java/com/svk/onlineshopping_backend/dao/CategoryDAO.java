package com.svk.onlineshopping_backend.dao;

import java.util.List;
import com.svk.onlineshopping_backend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
}
