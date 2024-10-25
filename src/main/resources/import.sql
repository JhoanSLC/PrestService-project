
INSERT INTO tipoPersona (nombre) VALUES ('Cliente');
INSERT INTO tipoPersona (nombre) VALUES ('Administrador');
INSERT INTO tipoPersona (nombre) VALUES ('Jefe de bodega');
INSERT INTO tipoPersona (nombre) VALUES ('Gerente');
INSERT INTO tipoPersona (nombre) VALUES ('Jefe de inventario');
INSERT INTO tipoPersona (nombre) VALUES ('Jefe de recursos humanos');
INSERT INTO tipoPersona (nombre) VALUES ('Profesional de servicios');



INSERT INTO tipoEmpresa (nombre) VALUES ('Pequeña');
INSERT INTO tipoEmpresa (nombre) VALUES ('Mediana');
INSERT INTO tipoEmpresa (nombre) VALUES ('Grande');
INSERT INTO tipoEmpresa (nombre) VALUES ('Multinacional');
INSERT INTO tipoEmpresa (nombre) VALUES ('Startup');
INSERT INTO tipoEmpresa (nombre) VALUES ('Cooperativa');
INSERT INTO tipoEmpresa (nombre) VALUES ('Franquicia');
INSERT INTO tipoEmpresa (nombre) VALUES ('Corporación');
INSERT INTO tipoEmpresa (nombre) VALUES ('Startup Tecnológica');
INSERT INTO tipoEmpresa (nombre) VALUES ('Empresa Familiar');


INSERT INTO tipoTelefono (nombre) VALUES ('Móvil');
INSERT INTO tipoTelefono (nombre) VALUES ('Fijo');
INSERT INTO tipoTelefono (nombre) VALUES ('Trabajo');
INSERT INTO tipoTelefono (nombre) VALUES ('Personal');
INSERT INTO tipoTelefono (nombre) VALUES ('Emergencia');
INSERT INTO tipoTelefono (nombre) VALUES ('Teléfono de emergencia');
INSERT INTO tipoTelefono (nombre) VALUES ('Teléfono de contacto');
INSERT INTO tipoTelefono (nombre) VALUES ('Teléfono de oficina');
INSERT INTO tipoTelefono (nombre) VALUES ('Teléfono de casa');
INSERT INTO tipoTelefono (nombre) VALUES ('Teléfono secundario');


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
INSERT INTO pais (nombre) VALUES ('Perú');
INSERT INTO pais (nombre) VALUES ('Venezuela');
INSERT INTO pais (nombre) VALUES ('Ecuador');
INSERT INTO pais (nombre) VALUES ('Uruguay');
INSERT INTO pais (nombre) VALUES ('Paraguay');


INSERT INTO region (nombre, paisId) VALUES ('Buenos Aires', 1);
INSERT INTO region (nombre, paisId) VALUES ('Sao Paulo', 2);
INSERT INTO region (nombre, paisId) VALUES ('Metropolitana', 3);
INSERT INTO region (nombre, paisId) VALUES ('Cundinamarca', 4);
INSERT INTO region (nombre, paisId) VALUES ('Nuevo León', 5);
INSERT INTO region (nombre, paisId) VALUES ('Lima', 6);
INSERT INTO region (nombre, paisId) VALUES ('Caracas', 7); 
INSERT INTO region (nombre, paisId) VALUES ('Quito', 8); 
INSERT INTO region (nombre, paisId) VALUES ('Montevideo', 9);  
INSERT INTO region (nombre, paisId) VALUES ('Asunción', 10);  


INSERT INTO ciudad (nombre, regionId) VALUES ('La Plata', 1);
INSERT INTO ciudad (nombre, regionId) VALUES ('Ribeirão Preto', 2);
INSERT INTO ciudad (nombre, regionId) VALUES ('Santiago', 3);
INSERT INTO ciudad (nombre, regionId) VALUES ('Bogotá', 4);
INSERT INTO ciudad (nombre, regionId) VALUES ('Monterrey', 5);
INSERT INTO ciudad (nombre, regionId) VALUES ('Cusco', 6);  -- Lima
INSERT INTO ciudad (nombre, regionId) VALUES ('Maracaibo', 7);  -- Caracas
INSERT INTO ciudad (nombre, regionId) VALUES ('Guayaquil', 8);  -- Quito
INSERT INTO ciudad (nombre, regionId) VALUES ('Salto', 9);  -- Montevideo
INSERT INTO ciudad (nombre, regionId) VALUES ('Ciudad del Este', 10);  -- Asunción


INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 1', 'Carrera 10', 'Cerca del parque', 'Centro', 1);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Avenida 5', 'Carrera 20', 'Zona comercial', 'Centro', 2);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 7', 'Carrera 30', 'Frente a la escuela', 'Norte', 3);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 8', 'Carrera 40', null, 'Sur', 4);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 9', 'Carrera 50', 'Cerca de la plaza', 'Oeste', 5);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 10', 'Carrera 60', 'Cerca del supermercado', 'Centro', 1);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Avenida 15', 'Carrera 70', 'Zona residencial', 'Norte', 2);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 20', 'Carrera 80', 'Cerca de la universidad', 'Este', 3);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 25', 'Carrera 90', 'Zona comercial', 'Sur', 4);
INSERT INTO direccion (calle, carrera, descripcion, barrio, ciudadId) VALUES ('Calle 30', 'Carrera 100', 'Frente a la plaza', 'Oeste', 5);


INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (1, 'Empresa A', 1);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (2, 'Empresa B', 2);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (3, 'Empresa C', 3);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (4, 'Empresa D', 4);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (5, 'Empresa E', 5);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (6, 'Empresa F', 1);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (7, 'Empresa G', 2);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (8, 'Empresa H', 3);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (9, 'Empresa I', 4);
INSERT INTO empresa (id, nombre, tipoEmpresaId) VALUES (10, 'Empresa J', 5);


INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Centro', '123456789', 1, 1, CURRENT_DATE);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Norte', '987654321', 2, 2, CURRENT_DATE);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Sur', '111222333', 3, 3, CURRENT_DATE);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Este', '444555666', 4, 4, CURRENT_DATE);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Oeste', '777888999', 5, 5, CURRENT_DATE);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Centro Norte', '123456780', 6, 1, CURRENT_DATE);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Oeste Centro', '987654320', 7, 2, CURRENT_DATE);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Este Centro', '111222334', 8, 3, CURRENT_DATE);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Sur Centro', '444555667', 9, 4, CURRENT_DATE);
INSERT INTO sucursal (nombre, nit, direccionId, empresaId, fechaCreacion) VALUES ('Sucursal Norte Centro', '777888990', 10, 5, CURRENT_DATE);


INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('1', 'Juan', 'Pérez', 'juanp', 'contraseña123', NOW(), NULL, 1);

INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('2', 'María', 'González', 'mariag', 'contraseña456', NOW(), 2, 2);

INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('3', 'Luis', 'Fernández', 'luisf', 'contraseña789', NOW(), NULL, 1);

INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('4', 'Ana', 'Martínez', 'anam', 'contraseña321', NOW(), 3, 2);

INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES ('5', 'Carlos', 'López', 'carlosl', 'contraseña654', NOW(), 2, 1);
INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES (6, 'José', 'Ramírez', 'joser', 'contraseña987', NOW(), 1, 1);
INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES (7, 'Lucía', 'Torres', 'luciator', 'contraseña654', NOW(), 2, 2);
INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES (8, 'Fernando', 'Vázquez', 'ferva', 'contraseña321', NOW(), 3, 1);
INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES (9, 'Sofía', 'Cruz', 'sofic', 'contraseña159', NOW(), 1, 2);
INSERT INTO persona (id, nombre, apellido, usuario, contraseña, fechaRegistro, sucursalId, tipoPersonaId) VALUES (10, 'Diego', 'García', 'diegogar', 'contraseña753', NOW(), 2, 1);

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

INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS001', 'Papel A4', 0.10);
INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS002', 'Tinta Negra', 5.00);
INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS003', 'Resma de Papel', 15.00);
INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS004', 'Cartucho de Tinta Color', 8.00);
INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS005', 'Bolígrafo', 0.50);
INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS006', 'Grapadora', 12.00);
INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS007', 'Post-it', 2.00);
INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS008', 'Carpeta', 3.00);
INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS009', 'Pizarrón', 25.00);
INSERT INTO insumo (codigoInterno, nombre, precioUnitario) VALUES ('INS010', 'Marcador', 1.00);

INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (1, 1, 0.10, 100, 10, 50);
INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (2, 1, 5.00, 50, 5, 20);
INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (3, 2, 15.00, 30, 3, 15);
INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (4, 2, 8.00, 20, 2, 10);
INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (5, 3, 0.50, 200, 15, 100);
INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (6, 3, 12.00, 15, 2, 7);
INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (7, 4, 2.00, 80, 8, 40);
INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (8, 4, 3.00, 50, 5, 25);
INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (9, 5, 25.00, 10, 1, 5);
INSERT INTO servicioInsumo (insumoId, servicioId, valorUnitario, stock, stockMin, stockMax) VALUES (10, 5, 1.00, 300, 20, 150);

INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("1", 1, 1);
INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("1", 2, 1);
INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("2", 3, 2);
INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("2", 4, 2);
INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("3", 5, 3);
INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("3", 6, 3);
INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("4", 7, 4);
INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("4", 8, 4);
INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("5", 9, 5);
INSERT INTO personaInsumo (personaId, insumoId, servicioId) VALUES ("5", 10, 5);

INSERT INTO estadoOrdenServicio (nombre) VALUES ('Pendiente');
INSERT INTO estadoOrdenServicio (nombre) VALUES ('En Progreso');
INSERT INTO estadoOrdenServicio (nombre) VALUES ('Completado');
INSERT INTO estadoOrdenServicio (nombre) VALUES ('Cancelado');
INSERT INTO estadoOrdenServicio (nombre) VALUES ('Reprogramado');
INSERT INTO estadoOrdenServicio (nombre) VALUES ('En Espera');
INSERT INTO estadoOrdenServicio (nombre) VALUES ('Facturado');
INSERT INTO estadoOrdenServicio (nombre) VALUES ('Cerrado');
INSERT INTO estadoOrdenServicio (nombre) VALUES ('Asignado');
INSERT INTO estadoOrdenServicio (nombre) VALUES ('En Revisión');

INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "1", "2", 1);
INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "2", "3", 2);
INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "3", "1", 3);
INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "4", "2", 4);
INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "5", "3", 5);
INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "1", "1", 6);
INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "2", "2", 7);
INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "3", "1", 8);
INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "4", "3", 9);
INSERT INTO ordenServicio (fechaOrden, clienteId, empleadoId, estadoOrdenServicioId) VALUES (CURRENT_DATE, "5", "2", 10);

INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-001', "1", 1);
INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-002', "2", 2);
INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-003', "3", 3);
INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-004', "1", 4);
INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-005', "2", 5);
INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-006', "3", 6);
INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-007', "1", 7);
INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-008', "2", 8);
INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-009', "3", 9);
INSERT INTO ordenTrabajo (numeroOrdenTrabajo, empleadoId, ordenServicioId) VALUES ('OT-010', "1", 10);

INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('Pendiente');
INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('En Progreso');
INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('Completado');
INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('Cancelado');
INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('Reprogramado');
INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('En Espera');
INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('Aprobado');
INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('Rechazado');
INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('Facturado');
INSERT INTO estadoOrdenTrabajo (nombre) VALUES ('Cerrado');

INSERT INTO estadoAprobacion (nombre) VALUES ('Pendiente de Aprobación');
INSERT INTO estadoAprobacion (nombre) VALUES ('Aprobado');
INSERT INTO estadoAprobacion (nombre) VALUES ('Rechazado');
INSERT INTO estadoAprobacion (nombre) VALUES ('En Revisión');
INSERT INTO estadoAprobacion (nombre) VALUES ('Aprobación Parcial');
INSERT INTO estadoAprobacion (nombre) VALUES ('Cancelado');
INSERT INTO estadoAprobacion (nombre) VALUES ('En Espera');
INSERT INTO estadoAprobacion (nombre) VALUES ('Completado');
INSERT INTO estadoAprobacion (nombre) VALUES ('Reprogramado');
INSERT INTO estadoAprobacion (nombre) VALUES ('Cerrado');

INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (1, 1, 150.00);
INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (1, 2, 200.00);
INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (2, 1, 180.00);
INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (2, 3, 220.00);
INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (3, 2, 250.00);
INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (3, 4, 300.00);
INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (4, 1, 170.00);
INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (4, 5, 260.00);
INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (5, 3, 230.00);
INSERT INTO empresaServicio (sucursalId, servicioId, valorServicio) VALUES (5, 4, 280.00);

INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('juan.perez@example.com', 1, 1);
INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('maria.gonzalez@example.com', 2, 2);
INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('luis.fernandez@example.com', 3, 1);
INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('ana.martinez@example.com', 4, 2);
INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('carlos.lopez@example.com', 5, 1);
INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('jose.sanchez@example.com', 6, 2);
INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('laura.mora@example.com', 7, 1);
INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('pablo.rivera@example.com', 8, 2);
INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('sofia.diaz@example.com', 9, 1);
INSERT INTO emailPersona (email, personaId, tipoEmailId) VALUES ('marco.torres@example.com', 10, 2);

INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (1, 1, '2024-10-01', 1);
INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (1, 2, '2024-10-02', 2);
INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (2, 1, '2024-10-03', 1);
INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (2, 3, '2024-10-04', 2);
INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (3, 2, '2024-10-05', 1);
INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (3, 4, '2024-10-06', 2);
INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (4, 1, '2024-10-07', 1);
INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (4, 5, '2024-10-08', 2);
INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (5, 2, '2024-10-09', 1);
INSERT INTO detalleOrdenTrabajo (ordenTrabajoId, servicioAsignadoId, fecha, estadoOrdenTrabajoId) VALUES (5, 3, '2024-10-10', 2);

INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (150.0, 1, 1);
INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (200.0, 1, 2);
INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (300.0, 2, 1);
INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (250.0, 2, 3);
INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (175.0, 3, 2);
INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (220.0, 3, 4);
INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (130.0, 4, 1);
INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (310.0, 4, 5);
INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (190.0, 5, 2);
INSERT INTO detalleOrdenServicio (valorServicio, ordenServicioId, servicioId) VALUES (240.0, 5, 3);

INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (1, "1", 1, 'Fugas detectadas', 'Reparar las juntas', 1);
INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (1, "2", 2, 'Ruido anómalo', 'Revisar el motor', 2);
INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (2, "3", 1, 'Falta de mantenimiento', 'Realizar limpieza general', 1);
INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (2, "1", 3, 'Fugas en el sistema', 'Sustituir mangueras', 3);
INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (3, "2", 4, 'Bajo rendimiento', 'Ajustar configuraciones', 1);
INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (3, "4", 2, 'Componente dañado', 'Reemplazar pieza', 2);
INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (4, "3", 5, 'Problemas eléctricos', 'Verificar conexiones', 1);
INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (4, "2", 1, 'Vibraciones inusuales', 'Ajustar tornillería', 3);
INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (5, "5", 3, 'Fugas en el sistema', 'Reemplazar válvulas', 2);
INSERT INTO aprobacionServicio (ordenTrabajoId, clienteId, servicioId, hallazgo, solucion, estadoAprobacionId) VALUES (5, "4", 4, 'Fallo en el sistema', 'Sustituir el módulo de control', 1);
