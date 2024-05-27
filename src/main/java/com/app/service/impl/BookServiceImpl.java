package com.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dto.BookDto;
import com.app.dto.UserDto;
import com.app.entity.Book;
import com.app.entity.User;
import com.app.mapper.BookMapper;
import com.app.mapper.UserMapper;
import com.app.repositroy.BookRepo;
import com.app.repositroy.UserRepo;
import com.app.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo ;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private BookMapper mapper ;
	
	
	
	
	@Override
	public List<BookDto> getAllBooks() {
		List<Book> books = bookRepo.findAll();
		return books.stream().map(mapper::bookMapper).collect(Collectors.toList());
	}

	@Override
	public Optional<BookDto> getBookById(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		BookDto dto = mapper.bookMapper(book.get());
		return Optional.of(dto);
	}

	@Override
	public BookDto CreateBook(BookDto bookDto) {
		
		Book book = mapper.bookUnMapper(bookDto);
		bookRepo.save(book);
		
		return bookDto;
	}

	@Override
	public BookDto updateBook(BookDto bookDto) {
		
		BookDto dto = getBookById(bookDto.getBookId()).get();
		
		
		Book book = mapper.bookUnMapper(dto);
		
		book.setBookId(bookDto.getBookId());
		book.setAuther(bookDto.getBookAuther());
		book.setTitle(bookDto.getBookTitle());
		book.setRate(bookDto.getBookRate());
		book.setBorrowed(bookDto.isBorrowed());
		book.setBorrowedBy(bookDto.getBookBorrowedBy());
		
		bookRepo.save(book);
		
		BookDto retuenData = mapper.bookMapper(book);
		
		return retuenData;
	}
	

	@Override
	public String deleteBookById(Long id) {
		
		bookRepo.deleteById(id);
		
		return "Book deleted succesfully with id  :  " +id;
	}


	@Override
	public BookDto borrowBook(Long userId, Long bookId) {
		
        BookDto bookDto = getBookById(bookId).get();
        
		User user = userRepo.findById(userId).get();

        if (bookDto.isBorrowed()) {
             throw new RuntimeException(" already borrowe befor by user " + user.getUserName() ) ;
		}
        
		Book book = mapper.bookUnMapper(bookDto);
		
		book.setBookId(bookId);
		book.setBorrowed(true);
		book.setBorrowedBy(user);	
		bookRepo.save(book);
		
		BookDto returnBook = mapper.bookMapper(book);
		
		return returnBook;
		
		
	}
	
	
	
	@Override
	public BookDto returnBook( Long bookId) {

        BookDto bookDto = getBookById(bookId).orElseThrow(()-> new RuntimeException("book with id : " + bookId + " not found " ));
		
		
		Book book = mapper.bookUnMapper(bookDto);

		book.setBookId(bookId);
		book.setBorrowed(false);
		book.setBorrowedBy(null);
		
		bookRepo.save(book);

		BookDto returnBook = mapper.bookMapper(book);

		return returnBook;
	}

}
