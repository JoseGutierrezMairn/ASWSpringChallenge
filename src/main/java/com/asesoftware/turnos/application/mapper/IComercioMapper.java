package com.asesoftware.turnos.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.turnos.application.dto.ComercioDTO;
import com.asesoftware.turnos.application.entity.ComercioEntity;

@Mapper(componentModel = "spring")
public interface IComercioMapper {

	
	public List<ComercioDTO> listEntityToDto(List<ComercioEntity> listEntity);
	
	public ComercioDTO entityToDto(ComercioEntity entity);
}
