package entities;
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
	
	@OneToMany
	@JoinColumn(name = "id_movie")
	@NotNull @NotEmpty @NotBlank
	private Movie film;
	
	@NotNull @NotEmpty @NotBlank
	private Usertype usertype;

}
