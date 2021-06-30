/*
Area(codigo_del_area, nombre, descripcion) DAO COMPLETO
Cama(numero_de_cama, descripcion, area, estado) DAO COMPLETO
Empleado(identificacion, nombre, cargo, salario, direccion, e_mail, telefono, area, identificacion_jefe)DAO COMPLETO
Medico(identificacion, especialidad, numero_licencia, universidad)
Enfermera(identificacion, anos_experiencia)DAO COMPLETO
Enfermera_habilidad(identificacion, habilidad)DAO COMPLETO
Paciente(numero_ss, nombre, direccion, telefono, fecha_nacimiento, actividad_economica)DAO COMPLETO
Cita_medica(fecha, hora, identificacion_medico, identificacion_paciente)DAO COMPLETO
Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente, historia_serial)DAO COMPLETO
Historia_clinica_especifica(historia_serial, fecha_consulta, identificacion_medico, precio, causas, descuento)DAO COMPLETO
Causas(codigo, nombre, descripcion) DAO COMPLETO
Formula_medica(id_medicamento, cantidad, identificacion_medico, identificacion_paciente)DAO COMPLETO
Medicamento(codigo, nombre, descripcion, costo)DAO COMPLETO
PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final)DAO COMPLETO
Campana_prevencion(codigo_campana, nombre, objetivo, fecha_realizacion, identificacion_medico)
Participante_campana(codigo_campana, identificacion_paciente)DAO COMPLETO

*/
DROP TABLE IF EXISTS Area CASCADE;
DROP TABLE IF EXISTS Cama CASCADE;
DROP TABLE IF EXISTS Empleado CASCADE;
DROP TABLE IF EXISTS Personas CASCADE;
DROP TABLE IF EXISTS Medico CASCADE;
DROP TABLE IF EXISTS Enfermera CASCADE;
DROP TABLE IF EXISTS Enfermera_habilidad CASCADE;
DROP TABLE IF EXISTS Paciente CASCADE;
DROP TABLE IF EXISTS Cita_medica CASCADE;
DROP TABLE IF EXISTS Historia_clinica CASCADE;
DROP TABLE IF EXISTS Historia_clinica_especifica CASCADE;
DROP TABLE IF EXISTS Causas CASCADE;
DROP TABLE IF EXISTS Formula_medica CASCADE;
DROP TABLE IF EXISTS Medicamento CASCADE;
DROP TABLE IF EXISTS PacienteCama CASCADE;
DROP TABLE IF EXISTS Campana_prevencion CASCADE;
DROP TABLE IF EXISTS Participante_campana CASCADE;
DROP TABLE IF EXISTS Formula_especifica CASCADE;
#ROl
CREATE TABLE Rol(
        id_rol VARCHAR(2) NOT NULL PRIMARY KEY,
        nombre VARCHAR(30) NOT NULL
);

#Usuarios (id_usuario, nombreapellido_usuario, username, psw, id_estado, id_rol)
CREATE TABLE Usuarios(
        id_usuario VARCHAR(30) NOT NULL PRIMARY KEY,
        nombreapellido_usuario VARCHAR(30) NOT NULL,
        username    VARCHAR(30) NOT NULL,
        psw         VARCHAR(40) NOT NULL,
        id_estado   VARCHAR(1) NOT NULL,
        id_rol      VARCHAR(2) NOT NULL
);
#Area(codigo_area, nombre_area, descripcion_area)
CREATE TABLE Area(
	codigo_area			VARCHAR(30)	NOT NULL 	PRIMARY KEY,
	nombre_area			VARCHAR(30)	NOT NULL,
	descripcion_area			VARCHAR(30)	NOT NULL,
        estado                          INTEGER NOT NULL
);
#Cama(numero_de_cama, descripcion_cama, area_cama, estado_cama)
CREATE TABLE Cama(
	numero_de_cama				VARCHAR(30)	NOT NULL	PRIMARY KEY,
	descripcion_cama			VARCHAR(30)	NOT NULL,
	area_cama				VARCHAR(30)	NOT NULL,
	estado_cama				VARCHAR(30)	NOT NULL
	#FOREIGN KEY (area_cama) REFERENCES AREA(codigo_area)
);
#Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, identificacion_jefe)
CREATE TABLE Empleado(
	identificacion_empleado			VARCHAR(30)	NOT NULL 	PRIMARY KEY,
	nombre_empleado				VARCHAR(30)	NOT NULL,
	cargo_empleado				VARCHAR(30)	NOT NULL,
	salario				VARCHAR(30)	NOT NULL,
	direccion_empleado			VARCHAR(30)	NOT NULL,
	e_mail				VARCHAR(30)	NOT NULL,
	telefono_empleado			VARCHAR(30)	NOT NULL,
	area_empleado				VARCHAR(30)	NOT NULL,
	identificacion_jefe		VARCHAR(30),
	estado_empleado			VARCHAR(30),
	FOREIGN KEY (identificacion_jefe) REFERENCES Empleado(identificacion_empleado)
);
#Usuario(id_usuario, usuario, password)
CREATE TABLE Usuario(
	usuario				VARCHAR(30)	NOT NULL PRIMARY KEY,
        id_usuario			VARCHAR(30)	NOT NULL,	
	password			VARCHAR(200)	NOT NULL
	
);
#Medico(identificacion_medico, especialidad, numero_licencia, universidad)
CREATE TABLE Medico(
	identificacion_medico			VARCHAR(30)	NOT NULL 	PRIMARY KEY,
	especialidad			VARCHAR(30)	NOT NULL,
	numero_licencia			VARCHAR(30)	NOT NULL,
	universidad			VARCHAR(100)	NOT NULL,
	FOREIGN KEY (identificacion_medico) REFERENCES Empleado(identificacion_empleado)
);
#Enfermera(identificacion_enfermera, anos_experiencia)
CREATE TABLE Enfermera(
	identificacion_enfermera			VARCHAR(30)	NOT NULL 	PRIMARY KEY,
	anos_experiencia		VARCHAR(30)	NOT NULL,
	FOREIGN KEY (identificacion_enfermera) REFERENCES Empleado(identificacion_empleado)
);
#Enfermera_habilidad(identificacion_enfermera_habilidad, habilidad)
CREATE TABLE Enfermera_Habilidad(
	identificacion_enfermera_habilidad			VARCHAR(30)	NOT NULL,
	habilidad			VARCHAR(30)	NOT NULL,
	PRIMARY KEY (identificacion_enfermera_habilidad, habilidad),
	FOREIGN KEY (identificacion_enfermera_habilidad) REFERENCES Enfermera(identificacion_enfermera)
);
#Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica)
CREATE TABLE Paciente(
	numero_ss			VARCHAR(30)	NOT NULL	PRIMARY KEY,
	nombre_paciente				VARCHAR(30)	NOT NULL,
	direccion_paciente			VARCHAR(30)	NOT NULL,
	telefono_paciente			VARCHAR(30)	NOT NULL,
	fecha_nacimiento		VARCHAR(30)		NOT NULL,
	actividad_economica		VARCHAR(30)	NOT NULL
);
#Medicamento(codigo_medicamento, nombre_medicamento, descripcion_medicamento, costo)
CREATE TABLE Medicamento (
	codigo_medicamento				VARCHAR(30)	NOT NULL	PRIMARY KEY,
	nombre_medicamento				VARCHAR(30)	NOT NULL,
	descripcion_medicamento			VARCHAR(100)	NOT NULL,
	costo				DOUBLE PRECISION NOT NULL
);
#Formula_medica(id_formula, identificacion_medico_formula, identificacion_paciente_formula, fecha)
CREATE TABLE Formula_medica(
	id_formula				SERIAL		NOT NULL 	PRIMARY KEY,
	identificacion_medico_formula		VARCHAR(30)	NOT NULL,
	identificacion_paciente_formula		VARCHAR(30)	NOT NULL,
	fecha					VARCHAR(30)		NOT NULL,
	FOREIGN KEY (identificacion_medico_formula) REFERENCES Medico   (identificacion_medico),
	FOREIGN KEY (identificacion_paciente_formula) REFERENCES Paciente(numero_ss)
);
#Formula_especifica(id_formula_especifica, id_formula_medica,codigo_medicamento,cantidad)
CREATE TABLE Formula_especifica(
	id_formula_especifica			SERIAL		NOT NULL  PRIMARY KEY,
	id_formula_medica			INTEGER		NOT NULL,
	codigo_medicamento                      VARCHAR(30)    NOT NULL,
	cantidad				INTEGER		NOT NULL
	
	#FOREIGN KEY (id_formula_medica) REFERENCES Formula_medica(id_formula),
	#FOREIGN KEY (codigo_medicamento) REFERENCES Medicamento(codigo_medicamento)
	#PRIMARY KEY(id_formula_especifica,id_formula_medica)
);
#Cita(id_cita, fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita, formula_medica_cita)
CREATE TABLE Cita_medica(
	id_cita				SERIAL		NOT NULL 	PRIMARY KEY,
	fecha_cita				VARCHAR(30)		NOT NULL,
	hora				TIMESTAMP	NOT NULL,
	identificacion_medico_cita		VARCHAR(30)	NOT NULL,	
	identificacion_paciente_cita		VARCHAR(30),
	
	estado_cita				VARCHAR(30),
	formula_medica_cita			INTEGER

	#FOREIGN KEY (identificacion_medico_cita) REFERENCES Medico(identificacion_medico),
	#FOREIGN KEY (identificacion_paciente_cita) REFERENCES Paciente(numero_ss),
	#FOREIGN KEY (formula_medica_cita) REFERENCES Formula_medica(id_formula)
);
#Causa(codigo_causas, nombre, descripcion)
CREATE TABLE Causas(
	codigo_causas				VARCHAR(30)	NOT NULL	PRIMARY KEY,
	nombre				VARCHAR(30)	NOT NULL,
	descripcion			VARCHAR(300)	NOT NULL
);
#Historia_clinica(historia_clinica_serial, numero_historia, fecha_apertura, identificacion_paciente)
CREATE TABLE Historia_clinica(
	historia_clinica_serial			SERIAL		NOT NULL PRIMARY KEY,
	numero_historia			VARCHAR(30)	NOT NULL,
	fecha_apertura			VARCHAR(30)		NOT NULL,
	identificacion_paciente		VARCHAR(30)	NOT NULL,
	
	FOREIGN KEY (identificacion_paciente) REFERENCES Paciente(numero_ss)
);
#Historia_clinica_especifica( historia_especifica,historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento)
CREATE TABLE Historia_Clinica_Especifica(
       historia_especifica                      Serial          NOT NULL PRIMARY KEY ,	
       historia_serial_hce			INTEGER		NOT NULL,
       fecha_consulta				VARCHAR(30)		NOT NULL,
       identificacion_medico_hce		VARCHAR(30)	NOT NULL,
	precio					DOUBLE PRECISION NOT NULL,
	causas_hce				VARCHAR(30)	NOT NULL,
	descuento				DOUBLE PRECISION
	#FOREIGN KEY (causas_hce) REFERENCES Causas(codigo_causas),
	#FOREIGN KEY (identificacion_medico_hce) REFERENCES Medico(identificacion_medico),
	#FOREIGN KEY (historia_serial_hce) REFERENCES Historia_clinica(historia_clinica_serial)
);
###---------------------------------------------------------------------------------

#PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final)
CREATE TABLE PacienteCama(
	identificacion_paciente		VARCHAR(30)	NOT NULL,
	numero_de_cama			VARCHAR(30)	NOT NULL,
	fecha_inicial			VARCHAR(30)		NOT NULL,
	fecha_final			VARCHAR(30),
	PRIMARY KEY (identificacion_paciente, numero_de_cama),
	FOREIGN KEY (identificacion_paciente) REFERENCES Paciente(numero_ss),
	FOREIGN KEY (numero_de_cama) REFERENCES Cama(numero_de_cama)
);

#Campana_prevencion(codigo_de_campana, nombre_campana, objetivo_campana, fecha_realizacion, identificacion_medico_campana)
CREATE TABLE Campana_prevencion(
	codigo_de_campana		VARCHAR(30)	NOT NULL	PRIMARY KEY,
	nombre_campana				VARCHAR(30)	NOT NULL,
	objetivo_campana			VARCHAR(150)	NOT NULL,
	fecha_realizacion		VARCHAR(30)		NOT NULL,
	identificacion_medico_campana		VARCHAR(30)	NOT NULL,
	FOREIGN KEY (identificacion_medico_campana) REFERENCES Medico(identificacion_medico)
);

#Campana_paciente(codigo_campana, identificacion_paciente)
CREATE TABLE Participante_campana(
	codigo_de_campana		VARCHAR(30)	NOT NULL,
	identificacion_paciente		VARCHAR(30)	NOT NULL,
	PRIMARY KEY(codigo_de_campana, identificacion_paciente),
	FOREIGN KEY(identificacion_paciente) REFERENCES Paciente(numero_ss)
);

