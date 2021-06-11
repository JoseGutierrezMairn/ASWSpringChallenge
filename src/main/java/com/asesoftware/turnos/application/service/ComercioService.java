package com.asesoftware.turnos.application.service;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public ResponseDTO getAll() {
		List<ComercioEntity> answ = comercioRepository.findAll();
		ResponseDTO res = answ.size() > 0 ? new ResponseDTO(comercioMapper.listEntityToDto(answ), true, "Ok", HttpStatus.OK ) : new ResponseDTO(null, false, "Failed", HttpStatus.OK);
		return res;
	}

	@Override
	public ResponseDTO getCommerceById(Integer id) {
		
		
		
		Optional<ComercioEntity> op = comercioRepository.findById(id);
		if(op.isPresent()) {
			return new ResponseDTO(comercioMapper.entityToDto(op.get()), true, "Ok", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "Usuario no encontrado", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO createCommerce(ComercioDTO comercio) {
		try {
			ComercioEntity ce = comercioRepository.save(comercioMapper.dtoToEntity(comercio));
			return new ResponseDTO(comercioMapper.entityToDto(ce), true, "Ok", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseDTO(null, true, "Invalid data", HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseDTO updateService(ComercioDTO comercio) {
		try {
			Optional<ComercioEntity> op = comercioRepository.findById(comercio.getIdComercio());
			ResponseDTO answ = op.isPresent() ?new ResponseDTO(comercioMapper.entityToDto(comercioRepository.save(comercioMapper.dtoToEntity(comercio))), true, "Ok", HttpStatus.OK): new ResponseDTO(null, true, "Not found", HttpStatus.OK);
			return answ;
		}catch (Exception e) {
			return new ResponseDTO(null, false, "Invalid data", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO deleteCommerce(Integer id) {
		try {
			comercioRepository.deleteById(id);
			return new ResponseDTO(null, true, "deleted", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseDTO(null, false, "Commerce Not Found", HttpStatus.OK);
		}
		
	}

}
