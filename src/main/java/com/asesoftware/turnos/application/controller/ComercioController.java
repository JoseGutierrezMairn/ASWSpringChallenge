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
import com.asesoftware.turnos.application.entity.ComercioEntity;
import com.asesoftware.turnos.application.service.IComercioService;

@RestController
@RequestMapping(path = "/api/v1/comercio")
public class ComercioController {
	@Autowired
	private IComercioService comercioService;
	
	
	
	@GetMapping(path = "/all")
	public List<ComercioDTO> getAll(){
		return comercioService.getAll();
	}
	

	@GetMapping(path = "/consult")
	public ComercioDTO getCommerceById(@RequestParam Integer id) {
		return comercioService.getCommerceById(id);
	}
	
	
	@PostMapping(path = "/create", consumes = "application/json",produces = "application/json")
	public ComercioDTO createCommerce(@RequestBody ComercioEntity comercioEntity) {
		return comercioService.createCommerce(comercioEntity);
	}
	
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public ComercioDTO updateCommerce(@RequestBody ComercioEntity comercioEntity) {
		return comercioService.updateService(comercioEntity);
	}
	
	
	@DeleteMapping(path = "/delete")
	public void deleteCommerce(@RequestParam Integer id) {
		comercioService.deleteCommerce(id);
	}
	
}
