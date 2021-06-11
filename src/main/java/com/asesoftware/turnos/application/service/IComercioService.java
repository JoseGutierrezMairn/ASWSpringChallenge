package com.asesoftware.turnos.application.service;

import java.util.List;

import com.asesoftware.turnos.application.dto.ComercioDTO;
import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.entity.ComercioEntity;


public interface IComercioService {
	public ResponseDTO getAll();
	
	public ResponseDTO getCommerceById(Integer id);
	
	public ResponseDTO createCommerce(ComercioDTO comercio);
	
	public ResponseDTO updateService(ComercioDTO comercioEntity);
	
	public ResponseDTO deleteCommerce(Integer id);
}
