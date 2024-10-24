export const tableConfig = {
    ordenTrabajo: {
        fields: [
            { name: 'numeroOrdentrabajo', label: 'Número de Orden', type: 'text', dataType: 'String' , required : true },
            { name: 'fechaAsignacion', label: 'Fecha de Asignación', type: 'date', dataType: 'date', required : false },
            { name: 'horaAsignacion', label: 'Hora de Asignación', type: 'time', dataType: 'time', required : false },
            { name: 'empleadoId', label: 'ID de Empleado', type: 'text', dataType: 'Long' , required : true },
            { name: 'ordenServicioId', label: 'ID de Orden de Servicio', type: 'text', dataType: 'Long' , required : true }
        ],
        tableFields: [
            { name: 'id', label: 'ID', dataType: 'Long' },
            { name: 'numeroOrdentrabajo', label: 'Número de Orden' },
            { name: 'fechaAsignacion', label: 'Fecha de Asignación' },
            { name: 'horaAsignacion', label: 'Hora de Asignación' },
            { name: 'empleadoId', label: 'ID de Empleado' },
            { name: 'ordenServicioId', label: 'ID de Orden de Servicio' }
        ],
        isEmbeddedId: false
    },
    estadoOrdenServicio: {
        fields: [
            { name: 'nombre', label: 'Nombre del estado', type: 'text', dataType: 'String' , required : true }
        ],
        tableFields: [
            { name: 'id', label: 'ID', dataType: 'Long' },
            { name: 'nombre', label: 'Nombre del estado' }
        ],
        isEmbeddedId: false
    },
    aprobacionServicio: {
        fields: [
            { name : 'ordenTrabajoId', label : 'ID del órden de trabajo', type : 'number', dataType: 'Long' , required : true},
            { name : 'clienteId', label : 'ID del cliente', type : 'text', dataType: 'String' , required : true },
            { name : 'servicioId', label : 'ID del servicio', type : 'number', dataType: 'Long' , required : true },
            { name : 'hallazgo', label : 'Hallazgo', type : 'text', dataType: 'String', required : false },
            { name : 'solucion', label : 'Solucion', type : 'text', dataType: 'String', required : false },
            { name : 'estadoAprobacionId', label : 'Estado de aprobacion', type : 'select', dataType: 'Long' , required : true }

        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
            { name : 'clienteId', label : 'ID del cliente'},
            { name : 'servicioId', label : 'ID del servicio'},
            { name : 'hallazgo', label : 'Hallazgo'},
            { name : 'solucion', label : 'Solucion'},
            { name : 'estadoAprobacionId', label : 'ID del estado de aprobacion'}
        ],
        isEmbeddedId: false
    },
    ciudad: {
        fields: [
            { name : 'nombre', label : 'Nombre de la ciudad', type : 'text', dataType: 'String' , required : true },
            { name : 'regionId', label : 'ID de la región', type : 'select', dataType: 'Long' , required : true, referencedTable : 'region' }

        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
            { name : 'nombre', label : 'Nombre de la ciudad' },
            { name : 'regionId', label : 'ID de la región'}
        ],
        isEmbeddedId: false
    },
    detalleOrdenServicio: {
        fields: [
            { name : 'valorServicio', label : 'Valor del servicio', type : 'number', dataType: 'Double' , required : true },
            { name : 'ordenServicioId', label : 'ID del Órden de Servicio', type : 'number', dataType: 'Long' , required : true },
            { name : 'servicioId', label : 'ID del servicio', type : 'number', dataType: 'Long' , required : true }


        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
            { name : 'valorServicio', label : 'Valor del servicio' },
            { name : 'ordenServicioId', label : 'ID del Órden de Servicio' },
            { name : 'servicioId', label : 'ID del servicio'}
        ],
        isEmbeddedId: false
    },
    detalleOrdenTrabajo: {
        fields: [
            { name : 'ordenTrabajoId', label : 'ID del Órden de Trabajo', type : 'number', dataType: 'Long' , required : true },
            { name : 'servicioAsignadoId', label : 'ID del servicio asignado', type : 'number', dataType: 'Long' , required : true },
            { name : 'fecha', label : 'Fecha', type : 'date', dataType: 'Date', required : false },
            { name : 'estadoOrdenTrabajoId', label : 'Estado de orden de trabajo', type : 'select', dataType: 'Long', required : true }
        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
            { name : 'servicioAsignadoId', label : 'ID del servicio asignado', type : 'number', dataType: 'Long' },
            { name : 'fecha', label : 'Fecha', type : 'date', dataType: 'Date' },
            { name : 'estadoOrdenTrabajoId', label : 'ID del estado de orden de trabajo', type : 'select', dataType: 'Long' }
        ],
        isEmbeddedId: false
    },
    direccion: {
        fields: [
            { name : 'calle', label : 'Calle', type : 'text', dataType: 'String' , required : true },
            { name : 'carrera', label : 'Carrera', type : 'text', dataType: 'String' , required : true },
            { name : 'descripcion', label : 'Descripcion', type : 'text', dataType: 'String', required : false },
            { name : 'barrio', label : 'Barrio', type : 'text', dataType: 'String' , required : true },
            { name : 'ciudadId', label : 'Ciudad', type : 'select', dataType: 'Long' , required : true, referencedTable : 'ciudad' },
            { name : 'sucursalId', label : 'Sucursal', type : 'select', dataType: 'Long' , required : true, referencedTable : 'sucursal' }
        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
            { name : 'calle', label : 'Calle', type : 'text', dataType: 'String' },
            { name : 'carrera', label : 'Carrera', type : 'text', dataType: 'String' },
            { name : 'descripcion', label : 'Descripcion', type : 'text', dataType: 'String' },
            { name : 'barrio', label : 'Barrio', type : 'text', dataType: 'String' },
            { name : 'ciudadId', label : 'ID de la ciudad', type : 'select', dataType: 'Long' },
            { name : 'sucursalId', label : 'ID de la sucursal', type : 'select', dataType: 'Long' }
        ],
        isEmbeddedId: false
    },
    aprobacionServicio: {
        fields: [
            { name : 'email', label : 'Email', type : 'email', dataType: 'String' , required : true },
            { name : 'personaId', label : 'ID de la persona', type : 'text', dataType: 'String' , required : true },
            { name : 'tipoEmailId', label : 'Tipo de email', type : 'select', dataType: 'Long' , required : true }
        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType : 'Long'},
            { name : 'email', label : 'Email', type : 'email', dataType: 'String' },
            { name : 'personaId', label : 'ID de la persona', type : 'text', dataType: 'String' },
            { name : 'tipoEmailId', label : 'ID tipo de email', type : 'select', dataType: 'Long' }
        ],
        isEmbeddedId: false
    },
    empresa: {
        fields: [
            { name : 'nombre', label : 'Nombre de empresa', type : 'text', dataType: 'String' , required : true },
            { name : 'tipoEmpresaId', label : 'Tipo de empresa', type : 'select', dataType: 'Long' , required : true },

        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
            { name : 'nombre', label : 'Nombre de empresa', type : 'text', dataType: 'String' },
            { name : 'tipoEmpresaId', label : 'Tipo de empresa', type : 'select', dataType: 'Long' }     
        ],
        isEmbeddedId: false
    },
    empresaServicio: {
        fields: [
            { name: 'valorServicio', label: 'Valor del Servicio', type: 'number', dataType: 'Double' , required : true },
            { name: 'sucursalId', label: 'ID de Sucursal', type:'select', dataType: 'Long' , required : true },
            { name: 'servicioId', label: 'ID de Servicio', type: 'text', dataType: 'Long' , required : true }
        ],
        tableFields: [
            { name: 'valorServicio', label: 'Valor del Servicio' },
            { name: 'sucursalId', label: 'ID de Sucursal', dataType : 'Long' },
            { name: 'servicioId', label: 'ID de Servicio', dataType : 'Long' }
        ],
        isEmbeddedId: true
    },
    estadoAprobacion: {
        fields : [
            { name : 'nombre', label : 'Nombre del estado', type : 'text', dataType : 'String' , required : true}
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long'},
            { name : 'nombre', label : 'Nombre del estado'}
        ],
        isEmbeddedId: false
    },
    estadoOrdenTrabajo: {
        fields : [
            { name : 'nombre', label : 'Nombre del estado', type : 'text', dataType : 'String' , required : true},
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long'},
            { name : 'nombre', label : 'Nombre el estado'}

        ],
        isEmbeddedId: false
    },
    insumo: {
        fields : [
            { name : 'codigoInterno', label : 'Código interno', type : 'text', dataType : 'String' , required : true},
            { name : 'nombre', label : 'Nombre del insumo', type : 'text', dataType : 'String' , required : true},
            { name : 'precioUnitario', label : 'Precio unitario', type : 'number', dataType : 'Double' , required : true}
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long'},
            { name : 'codigoInterno', label : 'Código interno', type : 'text', dataType : 'String'},
            { name : 'nombre', label : 'Nombre del insumo', type : 'text', dataType : 'String'},
            { name : 'precioUnitario', label : 'Precio unitario', type : 'number', dataType : 'Double'}
        ],
        isEmbeddedId: false
    },
    ordenServicio: {
        fields : [
            { name : 'fechaOrden', label : 'Fecha de la órden', type : 'date', dataType : 'Date', required : false},
            { name : 'clienteId', label : 'ID del cliente', type : 'text', dataType : 'String', required : true},
            { name : 'empleadoId', label : 'ID del empleado', type : 'text', dataType : 'String', required : true},
            { name : 'estadoOrdenServicioId', label : 'ID del estado de la órden', type : 'select', dataType : 'Long' , required : true}
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long'},
            { name : 'fechaOrden', label : 'Fecha de la órden', type : 'date', dataType : 'Date'},
            { name : 'clienteId', label : 'ID del cliente', type : 'text', dataType : 'String'},
            { name : 'empleadoId', label : 'ID del empleado', type : 'text', dataType : 'String'},
            { name : 'estadoOrdenServicioId', label : 'ID del estado de la órden', type : 'select', dataType : 'Long' , required : true}
        ],
        isEmbeddedId: false
    },
    pais: {
        fields : [
            { name : 'nombre', label : 'Nombre del país', type : 'text', dataType : 'String' , required : true}
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long'},
            { name : 'nombre', label : 'Nombre del país', type : 'text', dataType : 'String'}
        ],
        isEmbeddedId: false
    },
    persona: {
        fields : [
            { name : 'nombre', label : 'Nombre/s', type : 'text', dataType : 'String' , required : true},
            { name : 'apellido', label : 'Apellido/s', type : 'text', dataType : 'String' , required : true},
            { name : 'usuario', label : 'Usuario', type : 'text', dataType : 'String' , required : true},
            { name : 'contraseña', label : 'Contraseña', type : 'text', dataType : 'String' , required : true},
            { name : 'fechaRegistro', label : 'Fecha de registro', type : 'date', dataType : 'Date', required : false},
            { name : 'sucursalId', label : 'Sucursal asignado (si aplica)', type : 'select', dataType : 'Long' , required : true},
            { name : 'tipoPersonaId', label : 'Tipo de persona', type : 'select', dataType : 'select' , required : true}
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long'},
            { name : 'nombre', label : 'Nombre/s', type : 'text', dataType : 'String'},
            { name : 'apellido', label : 'Apellido/s', type : 'text', dataType : 'String'},
            { name : 'usuario', label : 'Usuario', type : 'text', dataType : 'String'},
            { name : 'contraseña', label : 'Contraseña', type : 'text', dataType : 'String'},
            { name : 'fechaRegistro', label : 'Fecha de registro', type : 'date', dataType : 'Date'},
            { name : 'sucursalId', label : 'Sucursal asignado (si aplica)', type : 'number', dataType : 'Long'},
            { name : 'tipoPersonaId', label : 'Tipo de persona', type : 'text', dataType : 'String'}
        ],
        isEmbeddedId: false
    },
    personaInsumo : {
        fields : [
            { name : 'insumoId', label : 'ID del insumo', type : 'number', dataType : 'Long', required : true },
            { name : 'servicioId', label : 'ID del servicio', type : 'number', dataType : 'Long', required : true},
            { name : 'personaId', label : 'ID de la persona', type : 'number', dataType : 'Long', required : true }
        ],
        tableFields : [
            { name : 'insumoId', label : 'ID del insumo', dataType : 'Long'},
            { name : 'servicioId', label : 'ID del servicio'},
            { name : 'personaId', label : 'ID de la persona', dataType : 'Long'}
        ],
        isEmbeddedId: true
    },
    region : {
        fields : [
            { name : 'nombre', label : 'Nombre', type : 'text', dataType : 'String', required : true },
            { name : 'paisId', label : 'País', type : 'select', dataType : 'Long', required : true, referencedTable : 'pais'}
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long'},
            { name : 'nombre', label : 'Nombre'},
            { name : 'paisId', label : 'País'}
        ],
        isEmbeddedId: false
    },
    servicio : {
        fields : [
            { name : 'nombre', label : 'Nombre', type : 'text', dataType : 'String', required : true },
            { name : 'requiereInsumo', label : '¿Requiere insumo?', type : 'select', dataType : 'Boolean', required : true },
            { name : 'tiempoEjecucion', label : 'Tiempo de ejecucion', type : 'time', dataType : 'Time', required : false }
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long' },
            { name : 'nombre', label : 'Nombre'},
            { name : 'requiereInsumo', label : '¿Requiere insumo?' },
            { name : 'tiempoEjecucion', label : 'Tiempo de ejecucion' }
        ],
        isEmbeddedId : false
    },
    servicioInsumo : {
        fields : [
            { name : 'valorUnitario', label : 'Valor unitario', type : 'number', dataType : 'Double', required : true },
            { name : 'stock', label : 'Stock', type : 'number', dataType : 'Integer', required : false },
            { name : 'stockMin', label : 'Stock minimo', type : 'number', dataType : 'Integer', required : false },
            { name : 'stockMax', label : 'Stock máximo', type : 'number', dataType : 'Integer', required : false },
            { name : 'insumoId', label : 'ID del insumo', type : 'number', dataType : 'Long', required : true },
            { name : 'servicioId', label : 'ID del servicio', type : 'number', dataType : 'Long', required : true },


        ],
        tableFields : [
            { name : 'valorUnitario', label : 'Valor unitario' },
            { name : 'stock', label : 'Stock' },
            { name : 'stockMin', label : 'Stock minimo' },
            { name : 'stockMax', label : 'Stock máximo' },
            { name : 'insumoId', label : 'ID del insumo', dataType : 'Long' },
            { name : 'servicioId', label : 'ID del servicio', dataType : 'Long' },
        ],
        isEmbeddedId : true
    },
    sucursal : {
        fields : [
            { name : 'nombre', label : 'Nombre', type : 'text', dataType : 'String', required : true },
            { name : 'nit', label : 'NIT', type : 'text', dataType : 'String', required : true },
            { name : 'fechaCreacion', label : 'Fecha de creación', type : 'date', dataType : 'Date', required : false },
            { name : 'direccionId', label : 'ID de la direccion', type : 'number', dataType : 'Long', required : true },
            { name : 'empresaId', label : 'ID de la empresa', type : 'number', dataType : 'Long', required : true }
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long' },
            { name : 'nombre', label : 'Nombre' },
            { name : 'nit', label : 'NIT' },
            { name : 'fechaCreacion', label : 'Fecha de creación' },
            { name : 'direccionId', label : 'ID de la direccion'},
            { name : 'empresaId', label : 'ID de la empresa' }
        ],
        isEmbeddedId : false
    },
    telPersona : {
        fields : [
            { name : 'numero', label : 'Número de teléfono', type : 'number', dataType : 'Long', required : true },
            { name : 'tipoTelefonoId', label : 'Tipo de teléfono', type : 'select', dataType : 'Long', required : true, referencedTable : 'tipoTelefono' },
            { name : 'personaId', label : 'ID de la persona', type : 'text', dataType : 'String', required : true }
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long' },
            { name : 'numero', label : 'Número de teléfono' },
            { name : 'tipoTelefonoId', label : 'Tipo de teléfono' },
            { name : 'personaId', label : 'ID de la persona', dataType : 'String' }
        ],
        isEmbeddedId : false
    },
    tipoEmpresa : {
        fields : [
            { name : 'nombre', label : 'Nombre', type : 'text', dataType : 'String', required : true }
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long' },
            { name : 'nombre', label : 'Nombre' }

        ],
        isEmbeddedId : false
    },
    tipoEmail : {
        fields : [
            { name : 'nombre', label : 'Nombre', type : 'text', dataType : 'String', required : true }
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long' },
            { name : 'nombre', label : 'Nombre' }

        ],
        isEmbeddedId : false
    },
    tipoPersona : {
        fields : [
            { name : 'nombre', label : 'Nombre', type : 'text', dataType : 'String', required : true }
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : 'Long' },
            { name : 'nombre', label : 'Nombre' }

        ],
        isEmbeddedId : false
    },
    tipoTelefono : {
        fields : [
            { name : 'nombre', label : 'Nombre', type : 'text', dataType : 'String', required : true }
        ],
        tableFields : [
            { name : 'id', label : 'ID', dataType : "Long" },
            { name : 'nombre', label : 'Nombre' }
        ],
        isEmbeddedId : false
    }

};




