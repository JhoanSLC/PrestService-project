
INSERT INTO tipoPersona (nombre) VALUES ('Cliente');
INSERT INTO tipoPersona (nombre) VALUES ('Administrador');
INSERT INTO tipoPersona (nombre) VALUES ('Jefe de bodega');
INSERT INTO tipoPersona (nombre) VALUES ('Gerente');
INSERT INTO tipoPersona (nombre) VALUES ('Jefe de inventario');
INSERT INTO tipoPersona (nombre) VALUES ('Jefe de recursos humanos');
INSERT INTO tipoPersona (nombre) VALUES ('Jefe de marketing');
INSERT INTO tipoPersona (nombre) VALUES ('Jefe de compras');
INSERT INTO tipoPersona (nombre) VALUES ('Profesional de servicios');

INSERT INTO tipoEmpresa (descripcion) VALUES ('Pequeña');
INSERT INTO tipoEmpresa (descripcion) VALUES ('Mediana');
INSERT INTO tipoEmpresa (descripcion) VALUES ('Grande');
INSERT INTO tipoEmpresa (descripcion) VALUES ('Multinacional');
INSERT INTO tipoEmpresa (descripcion) VALUES ('Startup');

INSERT INTO tipoTelefono (nombre) VALUES ('Móvil');
INSERT INTO tipoTelefono (nombre) VALUES ('Fijo');
INSERT INTO tipoTelefono (nombre) VALUES ('Trabajo');
INSERT INTO tipoTelefono (nombre) VALUES ('Personal');
INSERT INTO tipoTelefono (nombre) VALUES ('Emergencia');

INSERT INTO tipoEmail (nombre) VALUES ('Personal');
INSERT INTO tipoEmail (nombre) VALUES ('Trabajo');
INSERT INTO tipoEmail (nombre) VALUES ('Educacional');
INSERT INTO tipoEmail (nombre) VALUES ('Promocional');
INSERT INTO tipoEmail (nombre) VALUES ('Informativo');

INSERT INTO pais (nombre) VALUES ('Argentina');
INSERT INTO pais (nombre) VALUES ('Brasil');
INSERT INTO pais (nombre) VALUES ('Chile');
INSERT INTO pais (nombre) VALUES ('Colombia');
INSERT INTO pais (nombre) VALUES ('México');

INSERT INTO region (nombre, paisId) VALUES ('Buenos Aires', 1);
INSERT INTO region (nombre, paisId) VALUES ('Sao Paulo', 2);
INSERT INTO region (nombre, paisId) VALUES ('Metropolitana', 3);
INSERT INTO region (nombre, paisId) VALUES ('Cundinamarca', 4);
INSERT INTO region (nombre, paisId) VALUES ('Nuevo León', 5);

INSERT INTO ciudad (nombre, regionId) VALUES ('La Plata', 1);
INSERT INTO ciudad (nombre, regionId) VALUES ('Ribeirão Preto', 2);
INSERT INTO ciudad (nombre, regionId) VALUES ('Santiago', 3);
INSERT INTO ciudad (nombre, regionId) VALUES ('Bogotá', 4);
INSERT INTO ciudad (nombre, regionId) VALUES ('Monterrey', 5);

INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 1', 'Carrera 10', 'Cerca del parque', 'Centro', 1);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Avenida 5', 'Carrera 20', 'Zona comercial', 'Centro', 2);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 7', 'Carrera 30', 'Frente a la escuela', 'Norte', 3);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 8', 'Carrera 40', null, 'Sur', 4);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 9', 'Carrera 50', 'Cerca de la plaza', 'Oeste', 5);

INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (1, 'Empresa A', 1);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (2, 'Empresa B', 2);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (3, 'Empresa C', 3);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (4, 'Empresa D', 4);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (5, 'Empresa E', 5);

INSERT INTO sucursal (nombre, nit, direccionId, empresaId) VALUES ('Sucursal Centro', '123456789', 1, 1);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId) VALUES ('Sucursal Norte', '987654321', 2, 2);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId) VALUES ('Sucursal Sur', '111222333', 3, 3);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId) VALUES ('Sucursal Este', '444555666', 4, 4);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId) VALUES ('Sucursal Oeste', '777888999', 5, 5);

INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('1', 'Juan', 'Pérez', 'juanp', 'contraseña123', NOW(), NULL, 1);

INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('2', 'María', 'González', 'mariag', 'contraseña456', NOW(), 2, 2);

INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('3', 'Luis', 'Fernández', 'luisf', 'contraseña789', NOW(), NULL, 1);

INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('4', 'Ana', 'Martínez', 'anam', 'contraseña321', NOW(), 3, 2);

INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('5', 'Carlos', 'López', 'carlosl', 'contraseña654', NOW(), 2, 1);

INSERT INTO telPersona (numero, tipoTelefonoId, personaId) VALUES (1234567890, 1, '1');
INSERT INTO telPersona (numero, tipoTelefonoId, personaId) VALUES (9876543210, 2, '2');
INSERT INTO telPersona (numero, tipoTelefonoId, personaId) VALUES (5556667777, 1, '3');
INSERT INTO telPersona (numero, tipoTelefonoId, personaId) VALUES (4445556666, 3, '4');
INSERT INTO telPersona (numero, tipoTelefonoId, personaId) VALUES (2223334444, 2, '5');

INSERT INTO servicio (id, nombre, requiereInsumo, tiempoEjecucion) VALUES (1, 'Servicio A', true, '01:30:00');
INSERT INTO servicio (id, nombre, requiereInsumo, tiempoEjecucion) VALUES (2, 'Servicio B', false, '02:00:00');
INSERT INTO servicio (id, nombre, requiereInsumo, tiempoEjecucion) VALUES (3, 'Servicio C', true, '00:45:00');
INSERT INTO servicio (id, nombre, requiereInsumo, tiempoEjecucion) VALUES (4, 'Servicio D', false, '03:15:00');
INSERT INTO servicio (id, nombre, requiereInsumo, tiempoEjecucion) VALUES (5, 'Servicio E', true, '02:30:00');
