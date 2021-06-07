package com.asesoftware.turnos.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.turnos.application.dto.ServicioDTO;
import com.asesoftware.turnos.application.entity.ServicioEntity;

import com.asesoftware.turnos.application.service.IServicioService;


@RestController
@RequestMapping(path = "/api/v1/servicio")
public class ServicioController {

	
	@Autowired
	private IServicioService servicioService;
	
	
	@GetMapping(path = "/all")
	public List<ServicioDTO> getAll(){
		return servicioService.getAll();
	}
	
	
	@GetMapping(path = "/consult")
	public ServicioDTO getServiceById(@RequestParam Integer id) {
		return servicioService.getServiceById(id);
	}
	
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ServicioDTO createService(@RequestBody ServicioEntity servicioEntity) {
		return servicioService.createService(servicioEntity);
	}
	
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public ServicioDTO updateService(@RequestBody ServicioEntity servicioEntity) {
		return servicioService.updateService(servicioEntity);
	}
	
	@DeleteMapping(path = "/delete")
	public void deleteService(@RequestParam Integer id) {
		servicioService.deleteService(id);
	}
}
