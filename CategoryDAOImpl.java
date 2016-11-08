package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl()
	{
		
	}
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
    @Transactional
	public boolean save(Category category) {
	    try {
	    	if (get (category.getId())!=null)
	    	{
	    		return false;
	    	}
	    	sessionFactory.openSession().save(category);
             return true;
		} catch (HibernateException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
			return false;
			
		}
	}
    @Transactional
	public boolean update(Category category) {
		try {
		    sessionFactory.openSession().update(category);
             return true;
		} catch (HibernateException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
			return false;
			
		}
	}
    @Transactional
	public boolean delete(Category category) {
		try {
	    	sessionFactory.openSession().delete(category);
             return true;
		} catch (HibernateException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
			return false;
			
		}
    }
	public Category get (String id){
		return(Category) sessionFactory.openSession().get(Category.class,id);
		
	}

	    public List<Category> list() {
	    	//select * from category
	    
	    	String hql="from Category";
	    //we need to change hql into db specific query
	    
	    	Query query=(Query) sessionFactory.openSession();
            return  query.list();
	}
	    

		
		
}
	
	
	