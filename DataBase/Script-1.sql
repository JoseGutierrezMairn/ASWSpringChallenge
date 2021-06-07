use sistema;

create table comercios(
id_comercio int auto_increment primary key,
nom_comercio varchar(100) not null,
aforo_maximo int not null);



create table servicios(
id_servicio int auto_increment primary key,
id_comercio int not null,
nom_servicio varchar(100) not null,
hora_apertura time not null,
hora_cierre time not null,
duracion numeric(6,2) not null);


create table turnos(
	id_turno int auto_increment primary key,
	id_servicio int not null, 
	fecha_turno date not null,
	hora_inicio time not null,
	hora_fin time not null,
	estado varchar(100) not null);
	

ALTER TABLE servicios
ADD constraint fk_servicios_comercios FOREIGN KEY (id_comercio) 
REFERENCES comercios (id_comercio);



ALTER TABLE turnos
ADD CONSTRAINT fk_turnos_servicios FOREIGN KEY (id_servicio) 
REFERENCES servicios (id_servicio);

 
