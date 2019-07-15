package com.contrader.service;

import org.springframework.stereotype.Service;

import com.contrader.dao.UserRepository;
import com.contrader.dto.UserDTO;
import com.contrader.model.User;

@Service
public class UserService extends AbstractService<User, UserDTO>{

	/**
	 * Metodo per trovare un utente tramite username e password nel db
	 * @param username
	 * @param password
	 * @return
	 */
	public UserDTO findByUserNameAndPassword(String username, String password) {
		return converter.toDTO(((UserRepository) repository).findUserByUserNameAndPassword(username, password));
	}
}
