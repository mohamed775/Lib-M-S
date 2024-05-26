package com.app.dto;

import com.app.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

	private Long bookId;

	private String bookTitle;

	private String bookAuther;

	private int BookRate;
	
	private User bookBorrowedBy ;


}
