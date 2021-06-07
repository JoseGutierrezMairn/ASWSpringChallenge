package com.asesoftware.turnos.application.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table(name = "servicios")
public class ServicioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servicio")
	private Integer idServicio;
	
	@Column(name = "id_comercio")
	private Integer idComercio;
	
	@Column(name = "nom_servicio")
	private String nomServicio;
	
	@Column(name = "hora_apertura")
	private String horaApertura;
	
	@Column(name = "hora_cierre")
	private String horaCierre;
	
	@Column(name = "duracion")
	private Float duracion;
}
