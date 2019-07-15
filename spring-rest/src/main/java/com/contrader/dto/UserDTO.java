package com.contrader.dto;

import java.util.List;

import com.contrader.model.Movie;
import com.contrader.model.User.Usertype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private long id;	
	
	private String userName;

	private String password;
	
	private Usertype usertype;
	
	private List<Movie> movies;
}


