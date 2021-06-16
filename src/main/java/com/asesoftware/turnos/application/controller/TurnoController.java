package com.asesoftware.turnos.application.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.service.ITurnoService;

@RestController
@RequestMapping(path = "/api/v1/turno")
public class TurnoController {
	
	
	@Autowired
	private ITurnoService turnoService;
	
	
	private Logger log = LoggerFactory.getLogger(TurnoController.class);
	
	
	@GetMapping(path = "/byService")
	public ResponseDTO getTurnByServiceId(@RequestParam Integer serviceId){
		log.info("Ingresó al método getTurnByServiceId");
		return turnoService.getTurnByServiceId(serviceId);
	}
	
	
	@GetMapping(path = "/byCommerce")
	public ResponseDTO findTurnsByCommerceId(@RequestParam Integer comercioId){
		log.info("Ingresó al método findTurnsByCommerceId");
		return turnoService.findTurnsByCommerceId(comercioId);
		
	}
	
	
	/*
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ResponseDTO createTurn(@RequestBody TurnoDTO turno) {
		return turnoService.createTurn(turno);
	}*/
	

}
