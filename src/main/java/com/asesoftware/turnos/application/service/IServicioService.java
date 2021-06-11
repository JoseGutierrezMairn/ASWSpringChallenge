package com.asesoftware.turnos.application.service;

import java.util.List;

import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.dto.ServicioDTO;


public interface IServicioService {
	public ResponseDTO getAll();
	
	public ResponseDTO getServiceById(Integer id);
	
	public ResponseDTO createService(ServicioDTO servicio);
		
	public ResponseDTO updateService(ServicioDTO servicio);
	
	public ResponseDTO deleteService(Integer id);
}
