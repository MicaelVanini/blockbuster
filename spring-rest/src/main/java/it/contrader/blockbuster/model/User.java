package it.contrader.blockbuster.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String username;
	
	@Column
	private String password;
	
	@Column
	private Usertype usertype;
	
}
