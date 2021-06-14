package com.asesoftware.turnos.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.dto.TurnoDTO;
import com.asesoftware.turnos.application.entity.TurnoEntity;
import com.asesoftware.turnos.application.mapper.ITurnoMapper;
import com.asesoftware.turnos.application.repositoy.ITurnoRepository;

@Service
public class TurnoService implements ITurnoService{

	
	@Autowired
	private ITurnoRepository turnoRepository;
	
	
	@Autowired
	private ITurnoMapper turnoMapper;
	
	@Override
	public ResponseDTO getTurnByServiceId(Integer serviceId) {
		List<TurnoEntity> lis = turnoRepository.findTurnsByService(serviceId);
		return lis.size() > 0 ? new ResponseDTO(turnoMapper.listEntityToDto(lis), true, "Ok", HttpStatus.OK) : new ResponseDTO(null, true, "No Ok", HttpStatus.OK);
	}


	@Override
	public ResponseDTO findTurnsByCommerceId(Integer commerceId) {
		List<TurnoEntity> lis = turnoRepository.findTurnsByService(commerceId);
		return lis.size() > 0 ? new ResponseDTO(turnoMapper.listEntityToDto(lis), true, "Ok", HttpStatus.OK) : new ResponseDTO(null, true, "No Ok", HttpStatus.OK);
	}


	@Override
	public ResponseDTO createTurn(TurnoDTO turno) {
		return new ResponseDTO(turnoMapper.entityToDto(turnoRepository.save(turnoMapper.dtoToEntity(turno))), true, "ok", HttpStatus.OK);
		
	}
}
