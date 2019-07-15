package com.contrader.converter;

import java.util.List;

public interface Converter<Entity, DTO> {
	/**
	 * Metodo per convertire DTO in Entity(model)
	 * @param DTO
	 * @return Entity(model)
	 */
	public Entity toEntity(DTO dto);
	
	/**
	 * Metodo per convertire Entity(model) in DTO
	 * @param Entity(model)
	 * @return DTO
	 */
	public DTO toDTO(Entity entity);
	
	public List<Entity> toEntityList(Iterable<DTO> dtoList);
	
	public List<DTO> toDTOList(Iterable<Entity> entityList);	
}
