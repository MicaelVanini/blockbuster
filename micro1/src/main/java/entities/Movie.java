package entities;
import java.util.Date;

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
	@NotNull @NotEmpty @NotBlank
	private Gender gender;
	
	@NotNull @NotEmpty @NotBlank
	private String title;
	
	private Date date;
	
	@NotNull @NotEmpty @NotBlank
	private float price;

}
