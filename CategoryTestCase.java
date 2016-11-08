package com.niit.ShoppingCartBackEnd;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTestCase {
	
	@Autowired
	static
	AnnotationConfigApplicationContext context;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@BeforeClass	
	public static void init(){
	    context=new AnnotationConfigApplicationContext();
	    context.scan("com.niit.shoppingcart");
	    context.refresh();
	    
	    CategoryDAO categoryDAO=(CategoryDAO)context.getBean("CategoryDAO");
	    Category category=(Category)context.getBean("Category");
	}
	
	@Test
	 public void createCategoryTestCase(){
		 category.setId("MOB_07");
		 category.setName("SAMSUNG");
		 category.setDescription("This is the best phone.");
		 
		 Boolean status=categoryDAO.save(category);
		 
		 Assert.assertEquals("Create Category Test Case",true,status);
	 }

	
	}


