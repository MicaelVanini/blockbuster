package com.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contrader.dao.UserRepository;
import com.contrader.dto.UserDTO;
import com.contrader.model.User;
import com.controller.converter.ConverterUser;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	/**
	 * Metodo che sfruttera il repository per leggere la lista di tutti gli utenti dal db
	 * @return List<UserDTO>
	 */
	public List<UserDTO> getListaUserDTO() {
		return ConverterUser.toListDTO((List<User>) userRepository.findAll());
	}
	
	/**
	 * Metodo che sfruttera il repository per leggere un utente dal db tramite id
	 * @param long id
	 * @return UserDTO
	 */
	public UserDTO getUserDTOById(long id) {
		return ConverterUser.toDTO(userRepository.findUserById(id));
	}

	/**
	 * Metodo che sfruttera il repository per leggere un utente dal db tramite username e password
	 * @param String username
	 * @param String password
	 * @return UserDTO
	 */
	public UserDTO getByUsernameAndPassword(String username, String password) {
		final User user = userRepository.findUserByUserNameAndPassword(username, password);
		return ConverterUser.toDTO(user);
	}

	/**
	 * Metodo che sfruttera il repository per inserire un utente nel db
	 * @param UserDTO userDTO
	 * @return boolean
	 */
	public boolean insertUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}
	
	/**
	 * Metodo che sfruttera il repository per aggoirnare un utente nel db
	 * @param UserDTO userDTO
	 * @return boolean
	 */
	public boolean updateUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}
	
	
	/**
	 * Metodo che sfruttera il repository per rimuovere un utente nel db
	 * @param UserDTO userDTO
	 */
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
	
	/**
	 * Metodo che sfruttera il repository per leggere un utente dal db tramite username
	 * @param String username
	 * @return UserDTO
	 */
	public List<UserDTO> findUserDTOByUsername(String username) {
		
		final List<User> list = userRepository.findAllByUserName(username);
		final List<UserDTO> userDTOs = new ArrayList<>();
		list.forEach(i -> userDTOs.add(ConverterUser.toDTO(i)));
		return userDTOs;
		
	
	}
}
