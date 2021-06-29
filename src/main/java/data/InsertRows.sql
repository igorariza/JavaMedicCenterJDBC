/*
Area(codigo_area, nombre, descripcion)
Cama(numero_de_cama, descripcion_cama, area_cama, estado_cama)
Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, email, telefono_empleado, area_empleado, identificacion_jefe)
Medico(identificacion_medico, especialidad, numero_licencia, universidad)
Enfermera(identificacion, identificacion_jefe, anos_experiencia)
Enfermera_habilidad(identificacion_enfermera_habilidad, habilidad)
Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica)
Cita_medica(fecha, hora, identificacion_medico, identificacion_paciente)
Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente, historia_serial)
Historia_clinica_especificahistoria_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento)
Causa(codigo_causas, nombre, descripcion)
Formula_medica(id_medicamento, cantidad, identificacion_medico, identificacion_paciente)
Medicamento(codigo_medicamento, nombre_medicamento, descripcion_medicamento, costo)
PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final)
Campana_prevencion(codigo_campana, nombre_campana, objetivo_campana, fecha_realizacion, identificacion_medico_campana)
Participante_campana(codigo_campana, identificacion_paciente)
*/

INSERT INTO Area (codigo_area, nombre_area, descripcion_area, estado) VALUES ('1001', 'Pediatria','Cuidado de menores',1);
INSERT INTO Area (codigo_area, nombre_area, descripcion_area,estado) VALUES ('1002', 'Urgencias','Triage',1);
INSERT INTO Area (codigo_area, nombre_area, descripcion_area, estado) VALUES ('1003', 'Medicina General','Consultas',1);


INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES('2001','Cama Basica','1001','Disponible');
INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES('2002','Cama Basica','1001','Disponible');
INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES('2003','Cama Basica','1001','Disponible');
INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES('2004','Cama Basica','1002','Disponible');
INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES('2005','Cama Basica','1002','Disponible');
INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES('2006','Cama Basica','1002','Disponible');
INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES('2007','Cama Basica','1003','Disponible');
INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES('2008','Cama Basica','1003','Disponible');
INSERT INTO Cama (numero_de_cama, descripcion_cama, area_cama, estado_cama) VALUES('2009','Cama Basica','1003','Disponible');


INSERT INTO Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, estado_empleado) VALUES('1234567896','Jefe 1','Jefe','3000000','Calle 2 # 30-30','emp7@gmail.com','3008009007','1001','1');
INSERT INTO Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, estado_empleado) VALUES('1234567897','Jefe 2','Jefe','3000000','Calle 2 # 30-31','emp8@gmail.com','3008009008','1001','1');
INSERT INTO Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, estado_empleado) VALUES('1234567898','Jefe 3','Jefe','3000000','Calle 2 # 30-32','emp9@gmail.com','3008009009','1001','1');
INSERT INTO Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, identificacion_jefe, estado_empleado) VALUES('1234567890','Enfermera 1','Enfermero','Calle 2 # 30-33','1000000','emp1@gmail.com','3008009001','1001','1234567896','1');
INSERT INTO Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, identificacion_jefe, estado_empleado) VALUES('1234567891','Enfermera 2','Enfermero','Calle 2 # 30-34','2000000','emp2@gmail.com','3008009002','1001','1234567897','1');
INSERT INTO Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, identificacion_jefe, estado_empleado) VALUES('1234567892','Enfermera 3','Enfermero','Calle 2 # 30-35','3000000','emp3@gmail.com','3008009003','1001','1234567898','1');
INSERT INTO Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, identificacion_jefe, estado_empleado) VALUES('1234567893','Medico 1', 'Medico','Calle 2 # 30-36','4000000','emp4@gmail.com','3008009004','1001','1234567896','1');
INSERT INTO Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, identificacion_jefe, estado_empleado) VALUES('1234567894','Medico 2', 'Medico','Calle 2 # 30-37','5000000','emp5@gmail.com','3008009005','1001','1234567897','1');
INSERT INTO Empleado(identificacion_empleado, nombre_empleado, cargo_empleado, salario, direccion_empleado, e_mail, telefono_empleado, area_empleado, identificacion_jefe, estado_empleado) VALUES('1234567895','Medico 3', 'Medico','Calle 2 # 30-38','6000000','emp6@gmail.com','3008009006','1001','1234567898','1');

INSERT INTO Usuario(usuario, id_usuario, password)VALUES('emp1@gmail.com', '1234567890', '11234567')

INSERT INTO Medico (identificacion_medico, especialidad, numero_licencia, universidad) VALUES ('1234567893','Neurocirugia','100900301','Univalle');
INSERT INTO Medico (identificacion_medico, especialidad, numero_licencia, universidad) VALUES ('1234567894','Pediatria','100900302','ICESI');
INSERT INTO Medico (identificacion_medico, especialidad, numero_licencia, universidad) VALUES ('1234567895','ADN','100900303','Javeriana');

INSERT INTO Enfermera (identificacion_enfermera, anos_experiencia) VALUES('1234567890','2');
INSERT INTO Enfermera (identificacion_enfermera, anos_experiencia) VALUES('1234567891','4');
INSERT INTO Enfermera (identificacion_enfermera, anos_experiencia) VALUES('1234567892','5');

INSERT INTO Enfermera_habilidad(identificacion_enfermera_habilidad, habilidad) VALUES('1234567890','Inyectar');
INSERT INTO Enfermera_habilidad(identificacion_enfermera_habilidad, habilidad) VALUES('1234567891','Curaciones');
INSERT INTO Enfermera_habilidad(identificacion_enfermera_habilidad, habilidad) VALUES('1234567892','Cuidado Infantes');
INSERT INTO Enfermera_habilidad(identificacion_enfermera_habilidad, habilidad) VALUES('1234567892','Inyectar');
INSERT INTO Enfermera_habilidad(identificacion_enfermera_habilidad, habilidad) VALUES('1234567890','Curaciones');
INSERT INTO Enfermera_habilidad(identificacion_enfermera_habilidad, habilidad) VALUES('1234567891','Cuidado Infantes');


INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4001','Paciente 1','Carrera 1 # 10-01','3008007001','1997-01-01','Vendedor');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4002','Paciente 2','Carrera 1 # 10-02','3008007002','1997-01-02','Administrador');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4003','Paciente 3','Carrera 1 # 10-03','3008007003','1997-01-03','Ingeniero');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4004','Paciente 4','Carrera 1 # 10-04','3008007004','1997-01-04','Vendedor');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4005','Paciente 5','Carrera 1 # 10-05','3008007005','1997-01-05','Vendedor');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4006','Paciente 6','Carrera 1 # 10-06','3008007006','1997-01-06','Administrador');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4007','Paciente 7','Carrera 1 # 10-07','3008007007','1997-01-07','Administrador');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4008','Paciente 8','Carrera 1 # 10-08','3008007008','1997-01-08','Ingeniero');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4009','Paciente 9','Carrera 1 # 10-09','3008007009','1997-01-09','Ingeniero');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4010','Paciente 10','Carrera 1 # 10-10','3008007010','1997-01-10','Vendedor');
INSERT INTO Paciente(numero_ss, nombre_paciente, direccion_paciente, telefono_paciente, fecha_nacimiento, actividad_economica) VALUES('4011','Paciente 11','Carrera 1 # 10-11','3008007011','1997-01-11','Administrador');


INSERT INTO Medicamento(codigo_medicamento, nombre_medicamento, descripcion_medicamento, costo) VALUES('6001', 'Acetaminofem','Para el dolor', 2000.00);
INSERT INTO Medicamento(codigo_medicamento, nombre_medicamento, descripcion_medicamento, costo) VALUES('6002', 'Warfarina','Controla la densidad de la sangre', 3000.00);
INSERT INTO Medicamento(codigo_medicamento, nombre_medicamento, descripcion_medicamento, costo) VALUES('6003', 'Adderall','Para TDHA', 4000.00);
INSERT INTO Medicamento(codigo_medicamento, nombre_medicamento, descripcion_medicamento, costo) VALUES('6004', 'Dolex','Para dolor de cabeza', 5000.00);
INSERT INTO Medicamento(codigo_medicamento, nombre_medicamento, descripcion_medicamento, costo) VALUES('6005', 'Vitamina C','Para falta de vitamina c', 6000.00);



INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567893','4001','2017-04-03');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567894','4002','2017-04-04');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567895','4003','2017-04-05');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567895','4004','2017-04-06');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567894','4005','2017-04-07');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567893','4006','2017-04-08');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567893','4007','2017-04-09');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567894','4008','2017-04-10');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567895','4009','2017-04-11');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567895','4010','2017-04-12');
INSERT INTO Formula_medica(identificacion_medico_formula, identificacion_paciente_formula, fecha) VALUES('1234567894','4011','2017-04-13');

--Formula_especifica(id_formula_medica,codigo_medicamento,cantidad)
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (1,'6005',2);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (1,'6004',5);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (1,'6002',3);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (2,'6004',4);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (2,'6002',1);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (2,'6002',1);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (2,'6001',2);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (3,'6002',5);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (3,'6002',8);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (4,'6002',2);
INSERT INTO Formula_especifica (id_formula_medica,codigo_medicamento,cantidad) VALUES (4,'6005',1);


-------------
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-01','2017-12-01 14:00:00','1234567893','4001','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-01','2017-12-01 15:00:00','1234567894','4002','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-01','2017-12-01 16:00:00','1234567895','4003','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-02','2017-12-02 16:00:00','1234567895','4004','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-02','2017-12-02 15:00:00','1234567894','4005','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-02','2017-12-02 14:00:00','1234567893','4006','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-03','2017-12-03 14:00:00','1234567893','4007','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-03','2017-12-03 15:00:00','1234567894','4008','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-03','2017-12-03 16:00:00','1234567895','4009','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-04','2017-12-04 16:00:00','1234567895','4010','Programada');
INSERT INTO Cita_medica(fecha_cita, hora, identificacion_medico_cita, identificacion_paciente_cita, estado_cita) VALUES('2017-12-04','2017-12-04 15:00:00','1234567894','4011','Programada');


INSERT INTO Causas(codigo_causas, nombre, descripcion) VALUES('7301','Inflamacion','Inflamacion en el cuerpo');
INSERT INTO Causas(codigo_causas, nombre, descripcion) VALUES('7302','Dolor','Dolor en el cuerpo');
INSERT INTO Causas(codigo_causas, nombre, descripcion) VALUES('7303','Hematoma','Hematoma en el cuerpo');
INSERT INTO Causas(codigo_causas, nombre, descripcion) VALUES('7304','Remitido','Remitido por otro medico');
INSERT INTO Causas(codigo_causas, nombre, descripcion) VALUES('7305','Accidente Transito','Remitido por un accidente');

INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('01','1997-05-08','4001');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('02','1997-05-08','4002');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('03','1997-05-08','4003');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('04','1997-05-08','4004');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('05','1997-05-08','4005');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('06','1997-05-08','4006');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('07','1997-05-08','4007');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('08','1997-05-08','4008');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('09','1997-05-08','4009');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('10','1997-05-08','4010');
INSERT INTO Historia_clinica(numero_historia, fecha_apertura, identificacion_paciente) VALUES('11','1997-05-08','4011');


--Historia_clinica_especifica( historia_especifica,historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento)
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (1,'2017-12-01','1234567893',10000.00,'7301',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (2,'2017-12-02','1234567894',20000.00,'7302',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (3,'2017-12-03','1234567895',30000.00,'7303',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (4,'2017-12-03','1234567895',40000.00,'7304',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (5,'2017-12-02','1234567894',50000.00,'7305',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (6,'2017-12-01','1234567893',60000.00,'7305',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (7,'2017-12-01','1234567893',70000.00,'7303',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (8,'2017-12-02','1234567894',80000.00,'7302',0);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (9,'2017-12-03','1234567895',90000.00,'7301',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (10,'2017-12-03','1234567895',10000.00,'7302',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (11,'2017-12-02','1234567894',20000.00,'7303',0.25);

INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (1,'2017-12-01','1234567893',10000.00,'7303',0);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (1,'2017-12-01','1234567893',20000.00,'7305',0);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (3,'2017-12-03','1234567895',30000.00,'7301',0.25);
INSERT INTO Historia_clinica_especifica(historia_serial_hce, fecha_consulta, identificacion_medico_hce, precio, causas_hce, descuento) VALUES (3,'2017-12-03','1234567895',40000.00,'7302',0.25);


INSERT INTO PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final) VALUES('4001','2001','2017-12-01','2017-12-02');
INSERT INTO PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final) VALUES('4002','2002','2017-12-04','2017-12-06');
INSERT INTO PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final) VALUES('4003','2003','2017-12-06','2017-12-07');
INSERT INTO PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial) VALUES('4004','2004','2017-12-02');
INSERT INTO PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final) VALUES('4005','2005','2017-12-03','2017-12-11');
INSERT INTO PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final) VALUES('4006','2006','2017-12-06','2017-12-10');
INSERT INTO PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial) VALUES('4007','2007','2017-12-10');
INSERT INTO PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial, fecha_final) VALUES('4008','2008','2017-12-01','2017-12-05');
INSERT INTO PacienteCama(identificacion_paciente, numero_de_cama, fecha_inicial) VALUES('4009','2009','2017-12-03');

INSERT INTO Campana_prevencion(codigo_de_campana, nombre_campana, objetivo_campana, fecha_realizacion, identificacion_medico_campana) VALUES('6701','Prevencion H1N1','Prevenir el H1N1','2017-02-15','1234567893');
INSERT INTO Campana_prevencion(codigo_de_campana, nombre_campana, objetivo_campana, fecha_realizacion, identificacion_medico_campana) VALUES('6702','Prevencion Embarazo no deseado','Prevenir embarazos','2017-03-10','1234567894');
INSERT INTO Campana_prevencion(codigo_de_campana, nombre_campana, objetivo_campana, fecha_realizacion, identificacion_medico_campana) VALUES('6703','Prevencion Cancer','Prevenir el Cancer','2017-01-01','1234567895');

INSERT INTO Participante_campana(codigo_de_campana, identificacion_paciente) VALUES('6701','4001');
INSERT INTO Participante_campana(codigo_de_campana, identificacion_paciente) VALUES('6701','4002');
INSERT INTO Participante_campana(codigo_de_campana, identificacion_paciente) VALUES('6701','4003');

INSERT INTO Participante_campana(codigo_de_campana, identificacion_paciente) VALUES('6702','4004');
INSERT INTO Participante_campana(codigo_de_campana, identificacion_paciente) VALUES('6702','4001');
INSERT INTO Participante_campana(codigo_de_campana, identificacion_paciente) VALUES('6702','4002');

INSERT INTO Participante_campana(codigo_de_campana, identificacion_paciente) VALUES('6703','4001');
INSERT INTO Participante_campana(codigo_de_campana, identificacion_paciente) VALUES('6703','4002');
INSERT INTO Participante_campana(codigo_de_campana, identificacion_paciente) VALUES('6703','4006');
