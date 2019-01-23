

create database DB_Ferruz;

use DB_Ferruz;

create table usuario(
	id int IDENTITY(1,1) primary key,
	nombre varchar(100),
	correo varchar(100), 
	clave varchar(100)
)
create table persona(
	id_persona int IDENTITY(1,1) primary key,
	tipo_persona varchar(100),
	a_paterno varchar(100),
	a_materno varchar(100),
	nombre varchar(100),
	fecha_nacimiento varchar(100),
	sexo varchar(100),
	curp varchar(100),
	rfc varchar(100),
	correo varchar(100),
	telefono1 varchar(100),
	telefono2 varchar(100)
);
create table direccion(
	id_direccion int IDENTITY(1,1) primary key,
	calle varchar(100),
	numero varchar(300),
	cp varchar(100),
	colonia varchar(100),
	municipio varchar(100),
	entidad_federativa varchar(100)
);
create table trabajador(
	id_trabajador int IDENTITY(1,1) primary key,
	id_persona int,
	id_direccion int,
	url_foto varchar(100),
	numero_licencia varchar(100),
	vigencia_licencia varchar(100),
	nss_trabajador varchar(100),
	fecha_ingreso varchar(100),
	sueldo int,
	sueldo_integrado int,
	puesto varchar(100),
	riesgo_trabajo varchar(100),
	tipo_contrato varchar(100),
	localidad_laboral varchar(100),
	sindicalizado bit,
	tipo_jornada varchar(100),
	periodicidad varchar(100),
	numero_empleado varchar(100)
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
	folio varchar(100),
	id_cliente int,
	fecha_solicitud varchar(100),
	fecha_realizacion varchar(100),
	tipo_camion varchar(100),
	placas_camion varchar(100),
	id_trabajador int,
	tipo_carga varchar(100),
	ciudad_origen varchar(100),
	ciudad_destino varchar(100),
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
	calculo_rendimiento varchar(100),
	diesel_cargado int,
	casetas int,
	comision int,
	viaticos int,
	refacciones int,
	otros int,
	foreign key(id_servicio) references servicio(id_servicio) 
);

