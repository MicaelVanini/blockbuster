package com.contrader.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
	
	public enum Usertype 
	{
		ADMIN,
		USER
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	@NotNull @NotEmpty @NotBlank
	private String username;
	
	@NotNull @NotEmpty @NotBlank
	private String password;
	
	@NotNull @NotEmpty @NotBlank
	private Usertype usertype;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "userMovie", 
        joinColumns = { @JoinColumn(name = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_movie") }
        )
	private List<Movie> movies;
	
}
