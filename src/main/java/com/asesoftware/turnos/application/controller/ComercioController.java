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

import com.asesoftware.turnos.application.dto.ComercioDTO;
import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.service.IComercioService;

@RestController
@RequestMapping(path = "/api/v1/comercio")
public class ComercioController {
	@Autowired
	private IComercioService comercioService;
	
	private static final Logger log = LoggerFactory.getLogger(ComercioController.class);
	
	@GetMapping(path = "/all")
	public ResponseDTO getAll(){
		log.info("Ingresó al método getAll");
		return comercioService.getAll();
	}
	

	@GetMapping(path = "/consult")
	public ResponseDTO getCommerceById(@RequestParam Integer id) {
		log.info("Ingresó al método getCommerceById");
		return comercioService.getCommerceById(id);
	}
	
	
	@PostMapping(path = "/create", consumes = "application/json",produces = "application/json")
	public ResponseDTO createCommerce(@RequestBody ComercioDTO comercio) {
		log.info("Ingresó al método createCommerce");
		return comercioService.createCommerce(comercio);
	}
	
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public ResponseDTO updateCommerce(@RequestBody ComercioDTO comercio) {
		log.info("Ingresó al método updateCommerce");
		return comercioService.updateService(comercio);
	}
	
	
	@DeleteMapping(path = "/delete")
	public ResponseDTO deleteCommerce(@RequestParam Integer id) {
		log.info("Ingresó al método deleteCommerce");
		return comercioService.deleteCommerce(id);
	}
	
	
	
	
}
