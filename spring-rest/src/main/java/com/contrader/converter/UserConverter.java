package com.contrader.converter;

import com.contrader.dto.UserDTO;
import com.contrader.model.User;

public class UserConverter extends AbstractConverter<User,UserDTO>{

	/**
	 * Metodo per la conversione da User(model) a User(DTO)
	 * @param User oggetto da conertire
	 * @return UserDTO oggetto convertito */
	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO(user.getId(),user.getUserName(),user.getPassword(),user.getUsertype(),user.getMovies());
			}
		return userDTO;
	}
	
	/**
	 * Metodo per la conversione da User(DTO) a User(model)
	 * @param UserDTO oggetto da conertire
	 * @return User oggetto convertito */
	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User(userDTO.getId(),userDTO.getUserName(),userDTO.getPassword(),userDTO.getUsertype(),userDTO.getMovies());
		}
		return user;
	}
}
