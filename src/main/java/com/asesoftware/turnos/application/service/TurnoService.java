package com.asesoftware.turnos.application.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.turnos.application.controller.TurnoController;
import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.dto.TurnoDTO;
import com.asesoftware.turnos.application.entity.ServicioEntity;
import com.asesoftware.turnos.application.entity.TurnoEntity;
import com.asesoftware.turnos.application.mapper.ITurnoMapper;
import com.asesoftware.turnos.application.repositoy.ITurnoRepository;

@Service
public class TurnoService implements ITurnoService{

	
	@Autowired
	private ITurnoRepository turnoRepository;
	
	
	@Autowired
	private ITurnoMapper turnoMapper;
	
	
	private Logger log = LoggerFactory.getLogger(TurnoService.class);
	
	@Override
	public ResponseDTO getTurnByServiceId(Integer serviceId) {
		List<TurnoEntity> lis = turnoRepository.findTurnsByService(serviceId);
		return lis.size() > 0 ? getResponseDTOList(true, "Ok", lis) : getResponseDTOList(false, "No Ok", null);
	}


	@Override
	public ResponseDTO findTurnsByCommerceId(Integer commerceId) {
		List<TurnoEntity> lis = turnoRepository.findTurnsByService(commerceId);
		return lis.size() > 0 ? getResponseDTOList(true, "Ok", lis) : getResponseDTOList(false, "No Ok", null);
	}
	
	
	private ResponseDTO getResponseDTOList(boolean ok, String message, List<TurnoEntity> answ) {
		ResponseDTO response;
		log.info("En GetResponseDTOList");
		log.info("valor ok {}", ok);
		if(ok) {
			log.info("En condicional ok: true");
			response =  new ResponseDTO(turnoMapper.listEntityToDto(answ), true, message, HttpStatus.OK ); 
		}else {
			log.info("En condicional ok: false");
			response = new ResponseDTO(null, true, message, HttpStatus.OK);
		}
		return response;
	}
	
	
	/*
	@Override
	public ResponseDTO createTurn(TurnoDTO turno) {
		return new ResponseDTO(turnoMapper.entityToDto(turnoRepository.save(turnoMapper.dtoToEntity(turno))), true, "ok", HttpStatus.OK);
		
	}*/
}
