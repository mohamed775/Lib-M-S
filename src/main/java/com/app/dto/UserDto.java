package com.app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter


@NoArgsConstructor
public class UserDto {

	
	private Long id ;

	private String name;
	
	private String userPhone ;
	
	
	private String userAddress ;
	
}
