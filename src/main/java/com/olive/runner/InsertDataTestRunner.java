package com.olive.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.olive.model.Book;
import com.olive.repo.ProductRepo;
//@Component
public class InsertDataTestRunner implements CommandLineRunner{
	@Autowired
	private ProductRepo repo;

	public void run(String... args) throws Exception {
		System.out.println("Runner Class Started............");
        repo.save(new Book(101, "Core JAVA", 300.0, "PL", "Hari Singh"));
        repo.save(new Book(102, "ADV JAVA", 400.0, "PL", "Henamt Singh"));
        repo.save(new Book(103, "Hibernate", 500.0, "PL", "Himansu Kumar"));
        repo.save(new Book(104, "Spring", 600.0, "PL", "Rohit Kumar"));
        repo.save(new Book(105, "Spring Boot", 300.0, "PL","Mohit Kumar"));
       System.out.println("Product Data Save into MongoDB");
      
	}

}
