package com.app.mapper;

import org.springframework.stereotype.Component;

import com.app.dto.BookDto;
import com.app.entity.Book;

@Component
public class BookMapper {

	public BookDto bookMapper(Book book) {

		BookDto dto = new BookDto();
		dto.setBookId(book.getBookId());
		dto.setBookTitle(book.getTitle());
		dto.setBookAuther(book.getAuther());
		dto.setBookRate(book.getRate());
		dto.setBorrowed(book.isBorrowed());
		dto.setBookBorrowedBy(book.getBorrowedBy());

		return dto;

	}

	public Book bookUnMapper(BookDto dto) {

		Book book = new Book();
		book.setTitle(dto.getBookTitle());
		book.setAuther(dto.getBookAuther());
		book.setRate(dto.getBookRate());
		book.setBorrowed(dto.isBorrowed());
		book.setBorrowedBy(dto.getBookBorrowedBy());

		return book;

	}
	
}
