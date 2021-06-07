package com.asesoftware.turnos.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asesoftware.turnos.application.dto.ServicioDTO;
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
	public List<ServicioDTO> getAll() {

		return servicioMapper.listEntityToDto(servicioRepository.findAll());
	}

	@Override
	public ServicioDTO getServiceById(Integer id) {
		Optional<ServicioEntity> op = servicioRepository.findById(id);
		ServicioEntity answ = op.isPresent() ? op.get(): null;
		return servicioMapper.entityToDto(answ);
	}

	@Override
	public ServicioDTO updateService(ServicioEntity servicioEntity) {
		Optional<ServicioEntity> op = servicioRepository.findById(servicioEntity.getIdServicio());
		ServicioEntity answ = op.isPresent() ? servicioRepository.save(servicioEntity): null;
		return servicioMapper.entityToDto(answ);
	}

	@Override
	public void deleteService(Integer id) {
		servicioRepository.deleteById(id);
	}

	@Override
	public ServicioDTO createService(ServicioEntity servicioEntity) {
		return servicioMapper.entityToDto(servicioRepository.save(servicioEntity));
	}
	
}
