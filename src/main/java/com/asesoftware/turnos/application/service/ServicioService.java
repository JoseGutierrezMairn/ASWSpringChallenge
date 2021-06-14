package com.asesoftware.turnos.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
	
	@Override
	public ResponseDTO getAll() {
		List<ServicioEntity> answ = servicioRepository.findAll();
		ResponseDTO res = answ.size() > 0 ? new ResponseDTO(servicioMapper.listEntityToDto(answ), true, "Ok", HttpStatus.OK ) : new ResponseDTO(null, false, "Failed", HttpStatus.OK);
		return res;
	}

	@Override
	public ResponseDTO getServiceById(Integer id) {
		Optional<ServicioEntity> op = servicioRepository.findById(id);
		if(op.isPresent()) {
			return new ResponseDTO(servicioMapper.entityToDto(op.get()), true, "Ok", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "Servicio no encontrado", HttpStatus.OK);
		}
	}
 
	@Override
	public ResponseDTO updateService(ServicioDTO servicio) {
		
		try {
			Optional<ServicioEntity> op = servicioRepository.findById(servicio.getIdServicio());
			ResponseDTO answ = op.isPresent() ?new ResponseDTO(servicioMapper.entityToDto(servicioRepository.save(servicioMapper.dtoToEntity(servicio))), true, "Ok", HttpStatus.OK): new ResponseDTO(null, true, "Not found", HttpStatus.OK);
			return answ;
		}catch (Exception e) {
			return new ResponseDTO(null, false, "Invalid data", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO deleteService(Integer id) {		
		try {
			servicioRepository.deleteById(id);
			return new ResponseDTO(null, true, "deleted", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseDTO(null, false, "Commerce Not Found", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO createService(ServicioDTO servicio) {
		servicio = isPossible(servicio);
		try {
			ServicioEntity ce = servicioRepository.save(servicioMapper.dtoToEntity(servicio));
			return new ResponseDTO(servicioMapper.entityToDto(ce), true, "Ok", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseDTO(null, true, "Invalid data", HttpStatus.OK);
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
	
}
