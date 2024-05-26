package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.BookDto;

public interface BookService {

	public List<BookDto> getAllBooks();

	public Optional<BookDto> getBookById(Long id);

	public BookDto CreateBook(BookDto bookDto);

	public BookDto updateBook(BookDto bookDto);

	public String deleteBookById(Long id);
	
	public BookDto borrowBook (Long id , BookDto bookDto);

	public BookDto returnBook (Long id , BookDto bookDto);

}
