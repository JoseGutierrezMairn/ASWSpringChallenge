package com.asesoftware.turnos.application.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;


@Data
public class TurnoDTO {
	
	
	private Integer idTurno;
	

	private Integer idServicio;
	

	private Date fechaTurno;
	

	private Time horaInicio;
	

	private Time horaFin;
	
	
	private String estado;
}
