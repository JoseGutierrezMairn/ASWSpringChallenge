package com.asesoftware.turnos.application.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.turnos.application.dto.ComercioDTO;
import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.entity.ComercioEntity;
import com.asesoftware.turnos.application.mapper.IComercioMapper;
import com.asesoftware.turnos.application.repositoy.IComercioRepository;

@Service
public class ComercioService implements IComercioService {

	@Autowired
	private IComercioRepository comercioRepository;
	
	@Autowired
	private IComercioMapper comercioMapper;
	
	
	private Logger log = LoggerFactory.getLogger(ComercioService.class);
	
	
	@Override
	public ResponseDTO getAll() {
		List<ComercioEntity> answ = comercioRepository.findAll();
		ResponseDTO res = answ.size() > 0 ? getResponseDTOList(true, "Ok", answ) : getResponseDTOList(true, "Failed", answ);
		return res;
	}

	@Override
	public ResponseDTO getCommerceById(Integer id) {
		
		
		
		Optional<ComercioEntity> op = comercioRepository.findById(id);
		if(op.isPresent()) {
			return getResponseDTO(true, "Ok", op.get());
		}else {
			return getResponseDTO(false, "Usuario no encontrado", null);
		}
	}

	@Override
	public ResponseDTO createCommerce(ComercioDTO comercio) {
		try {
			ComercioEntity ce = comercioRepository.save(comercioMapper.dtoToEntity(comercio));
			return getResponseDTO(true, "Ok", ce);
		}catch (Exception e) {
			return getResponseDTO(false, "Invalid data", null);
		}
		
	}

	@Override
	public ResponseDTO updateService(ComercioDTO comercio) {
		try {
			Optional<ComercioEntity> op = comercioRepository.findById(comercio.getIdComercio());
			ResponseDTO answ = op.isPresent() ? getResponseDTO(true, "Ok",comercioRepository.save(comercioMapper.dtoToEntity(comercio))) : getResponseDTO(false, "Not found", null);
			return answ;
		}catch (Exception e) {
			return getResponseDTO(false, "Invalid data", null);
		}
	}

	@Override
	public ResponseDTO deleteCommerce(Integer id) {
		try {
			comercioRepository.deleteById(id);
			return getResponseDTO(true, "Deleted", null);
		}catch (Exception e) {
			return getResponseDTO(false, "Commerce Not Found", null);
		}
	}
	
	
	
	private ResponseDTO getResponseDTOList(boolean ok, String message, List<ComercioEntity> answ) {
		ResponseDTO response;
		log.info("En GetResponseDTOList");
		log.info("valor ok {}", ok);
		if(ok) {
			log.info("En condicional ok: true");
			response =  new ResponseDTO(comercioMapper.listEntityToDto(answ), true, message, HttpStatus.OK ); 
		}else {
			log.info("En condicional ok: false");
			response = new ResponseDTO(null, true, message, HttpStatus.OK);
		}
		return response;
	}
	
	
	private ResponseDTO getResponseDTO(boolean ok, String message, ComercioEntity answ) {
		ResponseDTO response;
		log.info("En GetResponseDTO");
		log.info("valor ok {}", ok);
		if(ok) {
			log.info("En condicional ok: true");
			response =  new ResponseDTO(comercioMapper.entityToDto(answ), true, message, HttpStatus.OK ); 
		}else {
			log.info("En condicional ok: false");
			response = new ResponseDTO(null, true, message, HttpStatus.OK);
		}
		return response;
	}
	

}
