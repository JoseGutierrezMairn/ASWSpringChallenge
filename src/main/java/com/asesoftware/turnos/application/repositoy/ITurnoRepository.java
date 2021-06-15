package com.asesoftware.turnos.application.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asesoftware.turnos.application.entity.TurnoEntity;

public interface ITurnoRepository extends JpaRepository<TurnoEntity, Integer>{
	
	
	//Nativas
	@Query(nativeQuery = true, value = "select *  from turnos join servicios on servicios.id_servicio = turnos.id_servicio and servicios.id_servicio = :id_servicio")
	public List<TurnoEntity> findTurnsByService(@Param("id_servicio")Integer idServicio);
	
	@Query(nativeQuery = true, value = "select * from turnos join servicios on turnos.id_servicio = servicios.id_servicio and servicios.id_comercio = :id_comercio")
	public List<TurnoEntity> findTurnsByCommerceId(@Param("id_comercio")Integer idComercio);
	
	
	
	//Otra manera de buscar los turnos por servicio: public List<TurnoEntity> findByIdServicio(@Param("id_servicio") Integer idServicio);
}
