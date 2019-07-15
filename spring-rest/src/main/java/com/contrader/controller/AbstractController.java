package com.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.contrader.service.ServiceDTO;

public class AbstractController<DTO>{
	@Autowired
	protected ServiceDTO<DTO> service;
	
	/**
	 * Metodo per prelevare tutto dal db
	 * @return Iterable<DTO>
	 */
	@GetMapping("/getall")
	public Iterable<DTO> getAl(){
		return service.getAll();
	}
	
	/**
	 * Metodo per rimuovere un oggetto dal db in base al sui id
	 * @param id
	 */
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") long id) {
		service.delete(id);
	}
	
	@PutMapping("/update")
	public DTO update(@RequestBody DTO dto) {
		return service.update(dto);
	}
	
	@PostMapping("/insert")
	public DTO insert(@RequestBody DTO dto) {
		return service.insert(dto);
	}
	
	@GetMapping("/read")
	public DTO read(long id) {
		return service.read(id);
	}
}
