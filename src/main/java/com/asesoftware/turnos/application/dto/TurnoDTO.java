package com.asesoftware.turnos.application.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;


@Data
public class TurnoDTO {
	
	
	private Integer idTurno;
	

	private Integer idServicio;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fechaTurno;
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm", timezone = "America/New_York")
	private Date horaInicio;
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm", timezone = "America/New_York")
	private Date horaFin;
	
	
	private String estado;
}
