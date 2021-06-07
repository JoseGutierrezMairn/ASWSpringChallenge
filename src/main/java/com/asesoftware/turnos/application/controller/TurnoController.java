package com.asesoftware.turnos.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.turnos.application.dto.TurnoDTO;
import com.asesoftware.turnos.application.service.ITurnoService;

@RestController
@RequestMapping(path = "/api/v1/turno")
public class TurnoController {
	
	
	@Autowired
	private ITurnoService turnoService;
	
	
	@GetMapping(path = "/byService")
	public List<TurnoDTO> getTurnByServiceId(@RequestParam Integer serviceId){
		return turnoService.getTurnByServiceId(serviceId);
	}
	
	
	@GetMapping(path = "/byCommerce")
	public List<TurnoDTO> findTurnsByCommerceId(@RequestParam Integer comercioId){
		return turnoService.findTurnsByCommerceId(comercioId);
		
	}

}
