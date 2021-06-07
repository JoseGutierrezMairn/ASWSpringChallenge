package com.asesoftware.turnos.application.service;

import java.util.List;

import com.asesoftware.turnos.application.dto.TurnoDTO;

public interface ITurnoService {
	
	public List<TurnoDTO> getTurnByServiceId(Integer serviceId);
	
	public List<TurnoDTO> findTurnsByCommerceId(Integer commerceId);
	
}
