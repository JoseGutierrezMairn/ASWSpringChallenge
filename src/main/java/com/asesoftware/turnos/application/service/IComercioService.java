package com.asesoftware.turnos.application.service;

import java.util.List;

import com.asesoftware.turnos.application.dto.ComercioDTO;
import com.asesoftware.turnos.application.entity.ComercioEntity;


public interface IComercioService {
	public List<ComercioDTO> getAll();
	
	public ComercioDTO getCommerceById(Integer id);
	
	public ComercioDTO createCommerce(ComercioEntity comercioEntity);
	
	public ComercioDTO updateService(ComercioEntity comercioEntity);
	
	public void deleteCommerce(Integer id);
}
