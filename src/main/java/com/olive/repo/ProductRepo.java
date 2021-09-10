package com.olive.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.olive.model.Book;


public interface ProductRepo extends MongoRepository<Book, Integer> {
	//sql:select bookName,author from book where bookCost>400.0

	// @Query(value="{where clause}",fields="{select clause}")

	//sql: select * from book where bookId=?
	@Query("{bookId:?0}")       
	Optional<Book> getBookById(Integer id);

	//sql: select * from book where author=? and bookType=?
	@Query("{author:?0,bookType:?1}") //by default and 
	//  @Query("{$and:[{author:?0},{bookType:?1}]}")
	List<Book> getBookByAuthorAndBookType(String author,String bookType);

	//sql: select * from book where bookCost>? and bookId!=?
	//  @Query("{bookCost:{$gt:?0},bookId:{$ne:?1}}") //by defalut and
	@Query("{$and:[{bookCost:{$gt:?0}},{bookId:{$ne:?1}}]}")
	List<Book> getBookByBookCostAndBookId(Double cost,Integer ids);

	//sql: select * from book where author=? or bookType=?
	@Query("{$or:[{author:?0},{bookType:?1}]}")
	List<Book> getBookByAuthorOrBookType(String author,String bookType);

	/*
	 * Here applying the Projection means select field 
	 */

	//here paasing Id which is greater than value and checking the how many 
	// no of record are their
	@Query(value = "{bookId:{$gt:?0}}",count=true)
	Integer getBookDataCount(Integer id); 
	
	//Passing input data and checking this record exits or not
	@Query(value = "{author:?0}",
			fields = "{bookName:1,author:1}",
			exists=true)
	   Boolean isBookDataExits(String author);

	//Here applying the sorting based on given condition author ass order
	//SQL: SELECT * FROM BOOK WHERE BOOKID > ? sort by author asc
	@Query(value = "{bookId:{$gt:?0}}",sort = "{author:1}")
	List<Book> getBookByIdSortedWithAuthor(Integer id);
	
	//Here applying the sorting based on given condition bookCost ass order
		//SQL: SELECT * FROM BOOK WHERE BOOKID > ? sort by bookcost asc
		@Query(value = "{bookId:{$gt:?0}}",sort = "{bookCost:1}")
		List<Book> getBookByIdSortedWithBookCost(Integer id);
		

		//Here applying the sorting based on given condition bookCost desc order
			//SQL: SELECT * FROM BOOK WHERE BOOKID > ? sort by bookcost desc
			@Query(value = "{bookId:{$gt:?0}}",sort = "{bookCost:-1}")
			List<Book> getBookByIdSortedWithBookCostDecOrder(Integer id);
		

}
