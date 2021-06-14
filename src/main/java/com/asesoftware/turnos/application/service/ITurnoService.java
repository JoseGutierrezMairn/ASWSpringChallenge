package com.asesoftware.turnos.application.service;

import java.util.List;

import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.dto.TurnoDTO;

public interface ITurnoService {
	
	public ResponseDTO getTurnByServiceId(Integer serviceId);
	
	public ResponseDTO findTurnsByCommerceId(Integer commerceId);
	
	
	public ResponseDTO createTurn(TurnoDTO turno);
	
	
}
