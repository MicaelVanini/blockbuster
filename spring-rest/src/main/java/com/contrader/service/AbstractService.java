package com.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.contrader.converter.Converter;

public class AbstractService<Entity, DTO> implements ServiceDTO<DTO>{

	@Autowired
	protected CrudRepository<Entity,Long> repository;
	@Autowired
	protected Converter<Entity,DTO> converter;
	
	/**
	 * Metodo per prelevare tutto dal db
	 * @return List<DTO>
	 */
	@Override
	public Iterable<DTO> getAll() {
		return converter.toDTOList(repository.findAll());
	}

	/**
	 * Metodo per prelevare un singolo elemento dal suo id dal db
	 * @param long id
	 * @return DTO
	 */
	@Override
	public DTO read(long id) {
		return converter.toDTO(repository.findById(id).get());
	}

	/**
	 * Metodo per inserire un oggeto nel db
	 * @param DTO dto
	 * @return DTO
	 */
	@Override
	public DTO insert(DTO dto) {
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}

	/**
	 * Metodo per aggiornare un oggeto nel db
	 * @param DTO dto
	 * @return DTO
	 */
	@Override
	public DTO update(DTO dto) {
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}

	/**
	 * Metodo per eliminare un oggeto nel db tramite il suo id
	 * @param DTO dto
	 * @return DTO
	 */
	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

}
