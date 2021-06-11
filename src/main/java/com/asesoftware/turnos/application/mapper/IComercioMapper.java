package com.asesoftware.turnos.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.turnos.application.dto.ComercioDTO;
import com.asesoftware.turnos.application.entity.ComercioEntity;

@Mapper(componentModel = "spring")
public interface IComercioMapper {

	@Mappings({@Mapping(source = "id_comercio", target = "idComercio"), @Mapping(source = "nom_Comercio", target = "nomComercio"), @Mapping(source = "aforo_maximo", target = "aforoMax")})
	public List<ComercioDTO> listEntityToDto(List<ComercioEntity> listEntity);
	
	public ComercioDTO entityToDto(ComercioEntity entity);
	
	
	@Mappings({@Mapping(source = "idComercio", target = "id_comercio"), @Mapping(source = "nomComercio", target = "nom_Comercio"), @Mapping(source = "aforoMax", target = "aforo_maximo")})
	public List<ComercioEntity> listDtoToEntity(List<ComercioDTO> listDto);
	
	
	public ComercioEntity dtoToEntity(ComercioDTO dto);
}
