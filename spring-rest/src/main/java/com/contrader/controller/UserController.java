package com.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contrader.dto.UserDTO;
import com.contrader.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private HttpSession session;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Metodo per gestire il login che restiuirà una stringa che rappresenta la schermata da aprire
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {
		try {
			session = request.getSession();
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
			final String ruolo = userDTO.getUserName();
		
			if (!StringUtils.isEmpty(ruolo)) {
				session.setAttribute("utenteCollegato", userDTO);
			
				switch (ruolo){
					case "admin":
						/*AZIONI*/
						/*Esempio:
						 * List<UserDTO> tmpUserList = userService.getListaUserDTO();
						List<UserDTO> userList = new ArrayList<>();
						for(UserDTO user: tmpUserList) {
							if(user.getUserName().equals("user")) {
								userList.add(user);
							}
						}
						int patientNumber = userList.size();
						session.setAttribute("patientnumber", patientNumber);
						session.setAttribute("utenteCollegato", userDTO.getUserName());
						request.setAttribute("errore", "");*/
						return "homeAdmin";
					case "user":
						/*AZIONI*/
						return "homeUser";
					default:
						request.setAttribute("errore", "");
						return "index";
				}
			}
		}catch(Exception ex) {
			request.setAttribute("errore", "Wrong username or password");
			return "index";
		}
		return "index";
	}
	
	/**
	 * Metodo per gestire il logut che restiuirà una stringa che rappresenta la schermata di logout
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
