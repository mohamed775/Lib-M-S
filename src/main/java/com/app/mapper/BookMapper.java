package com.app.mapper;

import com.app.dto.BookDto;
import com.app.entity.Book;


public class BookMapper {

	public BookDto userMapper(Book book) {

		BookDto dto = new BookDto();
		dto.setBookId(book.getBookId());
		dto.setBookTitle(book.getTitle());
		dto.setBookAuther(book.getAuther());
		dto.setBookRate(book.getRate());
		dto.setBookBorrowedBy(book.getBorrowedBy());

		return dto;

	}

	public Book userUnMapper(BookDto dto) {

		Book book = new Book();
		book.setBookId(dto.getBookId());
		book.setTitle(dto.getBookTitle());
		book.setAuther(dto.getBookAuther());
		book.setRate(dto.getBookRate());
		book.setBorrowedBy(dto.getBookBorrowedBy());

		return book;

	}
	
}
