package com.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import com.contrader.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * Metodo per leggere un utente dal db tramite username e password
	 * @param String username
	 * @param String password
	 * @return User
	 */
	public User findUserByUserNameAndPassword(String username,String password);
	
	/**
	 * Metodo per leggere tutti gli utenti dal db tramite username
	 * @param String username
	 * @return List<User>
	 */
	public List<User> findAllByUserName(String username);
	
	/**
	 * Metodo per leggere tutti gli utenti dal db tramite id
	 * @param long id
	 * @return User
	 */
	public User findUserById(long id);
}
