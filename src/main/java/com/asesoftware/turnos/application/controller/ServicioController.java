package com.asesoftware.turnos.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.dto.ServicioDTO;

import com.asesoftware.turnos.application.service.IServicioService;


@RestController
@RequestMapping(path = "/api/v1/servicio")
public class ServicioController {
	
	
	@Autowired
	private IServicioService servicioService;
	
	
	private static final Logger log = LoggerFactory.getLogger(ServicioController.class);
	
	@GetMapping(path = "/all")
	public ResponseDTO getAll(){
		log.info("Ingresó al método getAll en controlador servicio");
		return servicioService.getAll();
	}
	
	
	@GetMapping(path = "/consult")
	public ResponseDTO getServiceById(@RequestParam Integer id) {
		log.info("Ingresó al método getServiceById");
		return servicioService.getServiceById(id);
	}
	
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ResponseDTO createService(@RequestBody ServicioDTO servicio) {
		log.info("Ingresó al método createService");
		return servicioService.createService(servicio);
	}
	
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public ResponseDTO updateService(@RequestBody ServicioDTO servicio) {
		log.info("Ingresó al método updateService");
		return servicioService.updateService(servicio);
	}
	
	@DeleteMapping(path = "/delete")
	public ResponseDTO deleteService(@RequestParam Integer id) {
		log.info("Ingresó al método deleteService");
		return servicioService.deleteService(id);
	}
}
