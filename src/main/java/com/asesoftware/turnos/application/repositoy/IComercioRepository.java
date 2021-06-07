package com.asesoftware.turnos.application.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.turnos.application.entity.ComercioEntity;

public interface IComercioRepository extends JpaRepository<ComercioEntity, Integer>{

}
