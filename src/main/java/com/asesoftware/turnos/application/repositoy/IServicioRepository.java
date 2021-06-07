package com.asesoftware.turnos.application.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.turnos.application.entity.ServicioEntity;

public interface IServicioRepository extends JpaRepository<ServicioEntity, Integer> {

}
