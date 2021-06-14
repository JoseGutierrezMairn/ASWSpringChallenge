package com.asesoftware.turnos.application.entity;

import java.util.Date;
import java.sql.Time;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "turnos")
public class TurnoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turno")
	private Integer idTurno;
	

	@Column(name = "id_servicio")
	private Integer idServicio;
	
	
	@Column(name = "fecha_turno")
	@Temporal(TemporalType.DATE)
	private Date fechaTurno;
	
	
	@Column(name = "hora_inicio")
	@Temporal(TemporalType.TIME)
	private Date horaInicio;
	
	@Column(name = "hora_fin")
	@Temporal(TemporalType.TIME)
	private Date horaFin;
	
	
	@Column(name = "estado")
	private String estado;
}
