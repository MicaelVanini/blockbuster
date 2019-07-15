package com.controller.converter;

import java.util.ArrayList;
import java.util.List;

import com.contrader.dto.UserDTO;
import com.contrader.model.User;

public class ConverterUser {

	/**
	 * Metodo per la conversione da User(model) a User(DTO)
	 * @param User oggetto da conertire
	 * @return UserDTO oggetto convertito */
	public static UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUserName(user.getUserName());
			userDTO.setPassword(user.getPassword());
			userDTO.setFilm(user.getFilm());
			userDTO.setUsertype(user.getUsertype());
		}
		return userDTO;
	}
	
	/**
	 * Metodo per la conversione da User(DTO) a User(model)
	 * @param UserDTO oggetto da conertire
	 * @return User oggetto convertito */
	public static User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setId(userDTO.getId());
			user.setUserName(userDTO.getUserName());
			user.setPassword(userDTO.getPassword());
			user.setFilm(userDTO.getFilm());
			user.setUsertype(userDTO.getUsertype());
		}
		return user;
	}

	/**
	 * Metodo per la conversione da List<User> a List<UserDTO>
	 * @param List<User> oggetto da convertire
	 * @return List<UserDTO> oggetto convertito */
	public static List<UserDTO> toListDTO(List<User> list) {
		List<UserDTO> listUserDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (User user : list) {
				listUserDTO.add(ConverterUser.toDTO(user));
			}
		}
		return listUserDTO;
	}
	
	/**
	 * Metodo per la conversione da List<UserDTO> a List<User>
	 * @param List<UserDTO> oggetto da convertire
	 * @return List<User> oggetto convertito */
	public static List<User> toListEntity(List<UserDTO> listUserDTO) {
		List<User> list = new ArrayList<>();
		if (!listUserDTO.isEmpty()) {
			for (UserDTO userDTO : listUserDTO) {
				list.add(ConverterUser.toEntity(userDTO));
			}
		}
		return list;
	}
}
