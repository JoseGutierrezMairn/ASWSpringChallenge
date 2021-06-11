package com.asesoftware.turnos.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.turnos.application.dto.ServicioDTO;
import com.asesoftware.turnos.application.entity.ServicioEntity;

@Mapper(componentModel = "spring")
public interface IServicioMapper {
	
	@Mappings({@Mapping(source = "id_servicio", target = "idServicio"), @Mapping(source =  "id_comercio", target = "idComercio"), @Mapping(source =  "nom_servicio", target = "nomServicio"), @Mapping(source =  "hora_apertura", target = "horaApertura"), @Mapping(source =  "hora_cierre", target = "horaCierre"), @Mapping(source =  "duracion", target = "duracion")})
	public List<ServicioDTO> listEntityToDto(List<ServicioEntity> listEntity);
	public ServicioDTO entityToDto (ServicioEntity entity);
	
	
	
	@Mappings({@Mapping(source =  "idServicio", target = "idServicio"), @Mapping(source =  "idComercio", target = "idComercio"), @Mapping(source =  "nomServicio", target = "nomServicio"), @Mapping(source =  "horaApertura", target = "horaApertura"), @Mapping(source =  "horaCierre", target = "horaCierre"), @Mapping(source =  "duracion", target = "duracion")})
	public ServicioEntity dtoToEntity (ServicioDTO dto);
	
	public List<ServicioEntity> listDtoToEntity (List<ServicioDTO> dto);
}
