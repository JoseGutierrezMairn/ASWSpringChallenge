package com.asesoftware.turnos.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.turnos.application.dto.ServicioDTO;
import com.asesoftware.turnos.application.entity.ServicioEntity;

@Mapper(componentModel = "spring")
public interface IServicioMapper {
	
	public ServicioDTO entityToDto (ServicioEntity entity);
	
	public List<ServicioDTO> listEntityToDto(List<ServicioEntity> listEntity);
	
}
