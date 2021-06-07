package com.asesoftware.turnos.application.service;

import java.util.List;

import com.asesoftware.turnos.application.dto.ServicioDTO;
import com.asesoftware.turnos.application.entity.ServicioEntity;

public interface IServicioService {
	public List<ServicioDTO> getAll();
	
	public ServicioDTO getServiceById(Integer id);
	
	public ServicioDTO createService(ServicioEntity servicioEntity);
		
	public ServicioDTO updateService(ServicioEntity servicioEntity);
	
	public void deleteService(Integer id);
}
