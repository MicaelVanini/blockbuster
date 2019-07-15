package com.contrader.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<Entity, DTO> implements Converter<Entity,DTO>{
	
	/**
	 * Metodo per convertire List<DTO> in List<Entity>(model)
	 * @param List<DTO>
	 * @return List<Entity>(model)
	 */
	@Override
	public List<Entity> toEntityList (Iterable<DTO> listDTO){
		List<Entity> list = new ArrayList<Entity>();
		if(listDTO != null) {
			for(DTO dto: listDTO) {
				Entity entity = toEntity(dto);
				list.add(entity);
			}
		}
		return list;
	}
	
	/**
	 * Metodo per convertire List<Entity>(model) in List<DTO>
	 * @param List<Entity>(model)
	 * @return List<DTO>
	 */
	@Override
	public List<DTO> toDTOList(Iterable<Entity> listEntity){
		List<DTO> list = new ArrayList<DTO>();
		if(listEntity != null) {
			for(Entity entity: listEntity) {
				DTO dto = toDTO(entity);
				list.add(dto);
			}
		}
		return list;
	}
}
