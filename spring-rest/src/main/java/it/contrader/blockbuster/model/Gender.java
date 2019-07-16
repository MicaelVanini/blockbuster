package it.contrader.blockbuster.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gender {
	@Column
	@NotNull @NotEmpty @NotBlank
	private long id;
	
	@Column
	@NotNull @NotEmpty @NotBlank
	private String name;
}
