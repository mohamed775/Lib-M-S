package com.app.controller;




import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookDto;
import com.app.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

	
	private final  BookService  bookService ;
	
	
	@GetMapping
	public List<BookDto> getAllBooks(){
		return  bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public BookDto getBookById(@PathVariable Long id) {
		return bookService.getBookById(id).get();
	}
	
	@PostMapping
	public BookDto addBook(@RequestBody BookDto bookDto) {
		return bookService.CreateBook(bookDto);
	}
	
	@PutMapping
	public BookDto updateBook(@RequestBody BookDto bookDto) {
		return bookService.updateBook(bookDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook (@PathVariable Long id) {
		return bookService.deleteBookById(id);
	}
	
	
	@PostMapping("/{userId}/borrow/{bookId}")
	public BookDto borrowBook(@PathVariable Long userId ,@PathVariable Long bookId) {
		return bookService.borrowBook(userId, bookId);
	}
	
	
	@PostMapping("/{userId}/return/{bookId}")
	public BookDto returnBook(@PathVariable Long bookId) {
		return bookService.returnBook( bookId);
	}

	
	
	
}
