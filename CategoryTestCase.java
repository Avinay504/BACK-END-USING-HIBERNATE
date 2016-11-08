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
	static
	Category category;
	
	@Autowired
	static
	CategoryDAO categoryDAO;
	
	
	@BeforeClass	
	public static void init(){
	    context=new AnnotationConfigApplicationContext();
	    context.scan("com.niit.shoppingcart");
	    context.refresh();
	    category=(Category)context.getBean("category");
	    categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	     
	}
	
	@Test
	 public void createCategoryTestCase(){
		
	    category.setId("MOB_07");
		category.setName("SAMSUNG");
		category.setDescription("This is the best phone.");
		 
		 Boolean status=categoryDAO.save(category);
		 
		 Assert.assertEquals("Create Category Test Case",true,status);
	 }
	 @Test
	 public void updateCategoryTestcase(){
		 
		 category.setId("3");
		 category.setName("ravi");
		 category.setDescription("He lives in bengaluru ");
		 
		 Boolean status=categoryDAO.update(category); 
		 
		 Assert.assertEquals("Update Category Test case", true,status);
	 }
	 @Test
	 public void deleteCategoryTestCase(){
		 category.setId("1");
		 category.setName("avinay");
		 category.setDescription("This is my name");
		 
         Boolean status=categoryDAO.delete(category) ;
		 
		 Assert.assertEquals("Update Category Test case", true,status);
		 
	 }
     @Test
     public void getCategoryTestCase(){
    	 
    	 Assert.assertEquals("Get Category Test Case",null,categoryDAO.get("avi"));
    	 
     }
     @Test
     public void getAllCategoryTestCase(){
    	  Assert.assertEquals("Get All category Test Case", categoryDAO.list().size());
     }
}
	 