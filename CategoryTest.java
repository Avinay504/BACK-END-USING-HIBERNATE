package com.aj.james.backendproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aj.james.backendproject.config.ApplicationConfig;
import com.aj.james.backendproject.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
			
		AnnotationConfigApplicationContext annotationApplication = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		System.out.println("AppcOntext");
		
		annotationApplication.scan("com.aj.james.backendproject");

		System.out.println("refresh");
		
		Category category =  (Category) annotationApplication.getBean("category");
		System.out.println(""+category);
		System.out.println("category");
	}

}
