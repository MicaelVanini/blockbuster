 package com.contrader.model;
import java.util.Date;
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
@AllArgsConstructor
@NoArgsConstructor
public class Movie
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "id_gender")
	private Gender gender;
	
	@NotNull @NotEmpty @NotBlank
	private String title;
	
	private Date date;
	
	@NotNull @NotEmpty @NotBlank
	private float price;
	
	@ManyToMany(mappedBy = "movies")
	private List<User> user;

}
