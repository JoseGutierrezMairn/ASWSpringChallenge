package com.asesoftware.turnos.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asesoftware.turnos.application.dto.ComercioDTO;
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
	public List<ComercioDTO> getAll() {
		List<ComercioEntity> answ = comercioRepository.findAll();
		return comercioMapper.listEntityToDto(answ);
	}

	@Override
	public ComercioDTO getCommerceById(Integer id) {
		Optional<ComercioEntity> op = comercioRepository.findById(id);
		if(op.isPresent()) {
			return comercioMapper.entityToDto(op.get());
		}else {
			return null;
		}
	}

	@Override
	public ComercioDTO createCommerce(ComercioEntity comercioEntity) {
		
		return comercioMapper.entityToDto(comercioRepository.save(comercioEntity));
	}

	@Override
	public ComercioDTO updateService(ComercioEntity comercioEntity) {
		Optional<ComercioEntity> op = comercioRepository.findById(comercioEntity.getIdComercio());
		ComercioEntity answ = op.isPresent() ?comercioRepository.save(comercioEntity): null;
		return comercioMapper.entityToDto(answ);
	}

	@Override
	public void deleteCommerce(Integer id) {
		
		comercioRepository.deleteById(id);
		
	}

}
