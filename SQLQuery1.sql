

create database DB_Ferruz;

use DB_Ferruz;

create table usuario(
	id int,
	nombre varchar,
	correo varchar, 
	clave varchar
);
create table persona(
	id_persona int IDENTITY(1,1) primary key,
	tipo_persona varchar,
	a_paterno varchar,
	a_materno varchar,
	nombre varchar,
	fecha_nacimiento varchar,
	sexo varchar,
	curp varchar,
	rfc varchar,
	correo varchar,
	telefono1 varchar,
	telefono2 varchar
);
create table direccion(
	id_direccion int IDENTITY(1,1) primary key,
	calle varchar,
	numero int,
	cp varchar,
	colonia varchar,
	municipio varchar,
	entidad_federativa varchar
);
create table trabajador(
	id_trabajador int IDENTITY(1,1) primary key,
	id_persona int,
	id_direccion int,
	url_foto varchar,
	numero_licencia varchar,
	vigencia_licencia varchar,
	nss_trabajador varchar,
	fecha_ingreso varchar,
	sueldo int,
	sueldo_integrado int,
	puesto varchar,
	riesgo_trabajo varchar,
	tipo_contrato varchar,
	localidad_laboral varchar,
	foreign key(id_persona) references persona(id_persona),
	foreign key(id_direccion) references direccion(id_direccion)
);
create table cliente(
	id_cliente int IDENTITY(1,1) primary key,
	id_persona int,
	id_direccion int,
	foreign key(id_persona) references persona(id_persona),
	foreign key(id_direccion) references direccion(id_direccion) 
);
create table servicio(
	id_servicio int IDENTITY(1,1) primary key,
	folio varchar,
	id_cliente int,
	fecha_solicitud datetime,
	fecha_realizacion datetime,
	tipo_camion varchar,
	placas_camion varchar,
	id_trabajador int,
	tipo_carga varchar,
	ciudad_origen varchar,
	ciudad_destino varchar,
	sub_total int,
	iva int,
	isr int,
	total_cobrado int,
	utilidad_neta int,
	foreign key(id_trabajador) references trabajador(id_trabajador),
	foreign key(id_cliente) references cliente(id_cliente)
);
create table costo_servicio(
	id_costo int IDENTITY(1,1) primary key,
	id_servicio int,
	kilometraje_inicial int,
	kilometraje_final int,
	litros_gastados int,
	calculo_rendimiento varchar,
	diesel_cargado int,
	casetas int,
	comision int,
	viaticos int,
	refacciones int,
	otros int,
	foreign key(id_servicio) references servicio(id_servicio) 
);

