package com.olive.runner;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.olive.model.Book;
import com.olive.repo.ProductRepo;
@Component
public class QueryTestRunner implements CommandLineRunner{
	@Autowired
	private ProductRepo repo;

	public void run(String... args) throws Exception {
		repo.deleteAll();
		System.out.println("Runner Class Started............");
		/*
		Optional<Book> book = repo.getBookById(101);
		System.out.println(book);
		*/
		
		/*
		 repo.getBookByAuthorAndBookType("Hari Singh", "PL")
		.forEach(System.out::println);
		 */
		
		/*
		repo.getBookByBookCostAndBookId(400.0, 100)
		.forEach(System.out::println);
		*/
		
		/*
		repo.getBookByAuthorOrBookType("Hari Singh", null)
		.forEach(System.out::println);
		*/
		
		/*
		Integer count = repo.getBookDataCount(103);
		System.out.println(count);
		*/
		
		/*
		Boolean exits = repo.isBookDataExits("Hari Singh Ka");
		System.out.println(exits);
		*/
		
		/*
	 repo.getBookByIdSortedWithAuthor(102)
	 .forEach(System.out::println);
		*/
		
		/*
	 repo.getBookByIdSortedWithBookCost(102)
	 .forEach(System.out::println);
		*/
		
		
		 repo.getBookByIdSortedWithBookCostDecOrder(102)
		 .forEach(System.out::println);
		 
		 
        System.out.println("Product Data Save into MongoDB");
      
	}

}
