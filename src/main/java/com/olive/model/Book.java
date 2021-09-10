package com.olive.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	private Integer bookId;
	private String bookName;
	private Double bookCost;
	private String bookType;
	private String author;
	
}
