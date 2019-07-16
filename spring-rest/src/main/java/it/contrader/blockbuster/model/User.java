package it.contrader.blockbuster.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model per gestire l'entità User
 * Avrà un enum innestanto che definisce i tipi di utenti
 * @author Vanno
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	/**
	 * Enum che che definisce i tipi di tenti
	 * @author Vanno
	 *
	 */
	public enum Usertype {
		ADMIN,
		USER
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@NotNull @NotEmpty @NotBlank
	private String username;
	
	@Column
	@NotNull @NotEmpty @NotBlank
	private String password;
	
	@Column
	@NotNull @NotEmpty @NotBlank
	private Usertype usertype;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "user_movie",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "project_id")}
	)
	List<Movie> movies = new ArrayList<>();
}
