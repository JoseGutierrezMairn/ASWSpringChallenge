package com.asesoftware.turnos.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asesoftware.turnos.application.dto.TurnoDTO;
import com.asesoftware.turnos.application.mapper.ITurnoMapper;
import com.asesoftware.turnos.application.repositoy.ITurnoRepository;

@Service
public class TurnoService implements ITurnoService{

	
	@Autowired
	private ITurnoRepository turnoRepository;
	
	
	@Autowired
	private ITurnoMapper turnoMapper;
	
	@Override
	public List<TurnoDTO> getTurnByServiceId(Integer serviceId) {
		return turnoMapper.listEntityToDto(turnoRepository.findTurnsByService(serviceId));
	}


	@Override
	public List<TurnoDTO> findTurnsByCommerceId(Integer commerceId) {
		return turnoMapper.listEntityToDto(turnoRepository.findTurnsByCommerceId(commerceId));
	}
}
