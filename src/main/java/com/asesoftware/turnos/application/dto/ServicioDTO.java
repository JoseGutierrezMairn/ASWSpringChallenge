package com.asesoftware.turnos.application.dto;

import lombok.Data;

@Data
public class ServicioDTO {
	
	private Integer idServicio;
	
	
	private Integer idComercio;
	

	private String nomServicio;
	

	private String horaApertura;
	

	private String horaCierre;
	
	
	private Float duracion;
}
