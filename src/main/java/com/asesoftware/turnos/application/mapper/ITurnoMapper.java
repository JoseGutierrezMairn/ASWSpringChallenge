package com.asesoftware.turnos.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.turnos.application.dto.TurnoDTO;
import com.asesoftware.turnos.application.entity.TurnoEntity;


@Mapper(componentModel = "spring")
public interface ITurnoMapper {
	
	public List<TurnoDTO> listEntityToDto (List<TurnoEntity> listEntity);
}
