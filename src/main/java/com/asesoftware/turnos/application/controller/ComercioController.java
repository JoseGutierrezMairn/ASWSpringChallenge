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

import com.asesoftware.turnos.application.dto.ComercioDTO;
import com.asesoftware.turnos.application.dto.ResponseDTO;
import com.asesoftware.turnos.application.entity.ComercioEntity;
import com.asesoftware.turnos.application.service.IComercioService;

@RestController
@RequestMapping(path = "/api/v1/comercio")
public class ComercioController {
	@Autowired
	private IComercioService comercioService;
	
	
	
	@GetMapping(path = "/all")
	public ResponseDTO getAll(){
		return comercioService.getAll();
	}
	

	@GetMapping(path = "/consult")
	public ResponseDTO getCommerceById(@RequestParam Integer id) {
		return comercioService.getCommerceById(id);
	}
	
	
	@PostMapping(path = "/create", consumes = "application/json",produces = "application/json")
	public ResponseDTO createCommerce(@RequestBody ComercioDTO comercio) {
		return comercioService.createCommerce(comercio);
	}
	
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public ResponseDTO updateCommerce(@RequestBody ComercioDTO comercio) {
		return comercioService.updateService(comercio);
	}
	
	
	@DeleteMapping(path = "/delete")
	public ResponseDTO deleteCommerce(@RequestParam Integer id) {
		return comercioService.deleteCommerce(id);
	}
	
	
	
	
}
