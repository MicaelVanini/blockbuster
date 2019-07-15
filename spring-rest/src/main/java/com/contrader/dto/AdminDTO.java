package com.contrader.dto;
import java.util.List;

import com.contrader.model.Movie;
import com.contrader.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
	private List<Movie> movies;
	
	private List<User> users;
}
