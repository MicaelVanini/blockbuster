package it.contrader.blockbuster.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model per gestire l'entità Movie
 * @author Vanno
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@NotNull @NotEmpty @NotBlank
	private float price;
	
	@Column
	@NotNull @NotEmpty @NotBlank
	private String title;
	
	@Column
	@NotNull @NotEmpty @NotBlank
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="gender_id")
	private Gender genederId;
	
	@ManyToMany(mappedBy = "movies")
	private List<User> users = new ArrayList<>();
}
