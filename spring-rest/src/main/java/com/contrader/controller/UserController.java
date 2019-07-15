package com.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contrader.dto.LoginDTO;
import com.contrader.dto.UserDTO;
import com.contrader.service.UserService;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	public UserDTO login(@RequestBody LoginDTO loginDTO) {
		return userService.findByUserNameAndPassword(loginDTO.getUserName(), loginDTO.getPassword());
	}
}
