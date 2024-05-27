package com.app.dto;

import org.springframework.beans.factory.annotation.Value;

import com.app.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

	private Long bookId;

	private String bookTitle;

	private String bookAuther;

	private int bookRate;
	
	@Value("false")
	private boolean isBorrowed ;
	
	private User bookBorrowedBy ;


}
