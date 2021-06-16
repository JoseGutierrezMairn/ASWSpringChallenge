package com.asesoftware.turnos.application.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.turnos.application.controller.TurnoController;
import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.dto.ServicioDTO;
import com.asesoftware.turnos.application.entity.ComercioEntity;
import com.asesoftware.turnos.application.entity.ServicioEntity;
import com.asesoftware.turnos.application.mapper.IServicioMapper;
import com.asesoftware.turnos.application.repositoy.IServicioRepository;

@Service
public class ServicioService implements IServicioService{
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	
	@Autowired
	private IServicioMapper servicioMapper;
	
	
	private Logger log = LoggerFactory.getLogger(ServicioService.class);
	
	@Override
	public ResponseDTO getAll() {
		List<ServicioEntity> answ = servicioRepository.findAll();
		ResponseDTO res = answ.size() > 0 ? getResponseDTOList(true, "Ok", answ): getResponseDTOList(true, "Ok", null);
		return res;
	}

	@Override
	public ResponseDTO getServiceById(Integer id) {
		Optional<ServicioEntity> op = servicioRepository.findById(id);
		if(op.isPresent()) {
			return getResponseDTO(true, "Ok", op.get());
		}else {
			return getResponseDTO(false, "Servicio no encontrado", null);
		}
	}
 
	@Override
	public ResponseDTO updateService(ServicioDTO servicio) {
		
		try {
			Optional<ServicioEntity> op = servicioRepository.findById(servicio.getIdServicio());
			ResponseDTO answ = op.isPresent() ?  getResponseDTO(true, "Ok", servicioRepository.save(servicioMapper.dtoToEntity(servicio))): getResponseDTO(false, "Not found", null);
			return answ;
		}catch (Exception e) {
			return getResponseDTO(false, "Invalid data", null);
		}
	}

	@Override
	public ResponseDTO deleteService(Integer id) {		
		try {
			servicioRepository.deleteById(id);
			return getResponseDTO(true, "Deleted", null);
		}catch (Exception e) {
			return getResponseDTO(false, "Servicio no encontrado", null);
		}
	}

	@Override
	public ResponseDTO createService(ServicioDTO servicio) {
		servicio = isPossible(servicio);
		try {
			ServicioEntity ce = servicioRepository.save(servicioMapper.dtoToEntity(servicio));
			return getResponseDTO(true, "Ok", ce);
		}catch (Exception e) {
			return getResponseDTO(false, "Invalid data", null);
		}
	}
	
	
	
	
	//Valida que el servicio Que se va a agregar es totalmente nuevo.
	private ServicioDTO isPossible(ServicioDTO servicio) {
		try{
			servicio = servicioRepository.findById(servicio.getIdServicio()).isPresent() ? null : servicio;
		}catch (Exception e) {
			return servicio;
		}
		
		return servicio;
	}
	
	
	private ResponseDTO getResponseDTOList(boolean ok, String message, List<ServicioEntity> answ) {
		ResponseDTO response;
		log.info("En GetResponseDTOList");
		log.info("valor ok {}", ok);
		if(ok) {
			log.info("En condicional ok: true");
			response =  new ResponseDTO(servicioMapper.listEntityToDto(answ), true, message, HttpStatus.OK ); 
		}else {
			log.info("En condicional ok: false");
			response = new ResponseDTO(null, true, message, HttpStatus.OK);
		}
		return response;
	}
	
	
	private ResponseDTO getResponseDTO(boolean ok, String message, ServicioEntity answ) {
		ResponseDTO response;
		log.info("En GetResponseDTO");
		log.info("valor ok {}", ok);
		if(ok) {
			log.info("En condicional ok: true");
			response =  new ResponseDTO(servicioMapper.entityToDto(answ), true, message, HttpStatus.OK ); 
		}else {
			log.info("En condicional ok: false");
			response = new ResponseDTO(null, true, message, HttpStatus.OK);
		}
		return response;
	}
	
}
