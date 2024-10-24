export const tableConfig = {
    ordenTrabajo: {
        fields: [
            { name: 'numeroOrdentrabajo', label: 'Número de Orden', type: 'text', dataType: 'String' },
            { name: 'fechaAsignacion', label: 'Fecha de Asignación', type: 'date', dataType: 'date' },
            { name: 'horaAsignacion', label: 'Hora de Asignación', type: 'time', dataType: 'time' },
            { name: 'empleadoId', label: 'ID de Empleado', type: 'text', dataType: 'Long' },
            { name: 'ordenServicioId', label: 'ID de Orden de Servicio', type: 'text', dataType: 'Long' }
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
            { name: 'nombre', label: 'Nombre del estado', type: 'text', dataType: 'String' }
        ],
        tableFields: [
            { name: 'id', label: 'ID', dataType: 'Long' },
            { name: 'nombre', label: 'Nombre del estado' }
        ],
        isEmbeddedId: false
    },
    aprobacionServicio: {
        fields: [
            { name : 'ordenTrabajoId', label : 'ID del órden de trabajo', type : 'number', dataType: 'Long'},
            { name : 'clienteId', label : 'ID del cliente', type : 'text', dataType: 'String' },
            { name : 'servicioId', label : 'ID del servicio', type : 'number', dataType: 'Long' },
            { name : 'hallazgo', label : 'Hallazgo', type : 'text', dataType: 'String' },
            { name : 'solucion', label : 'Solucion', type : 'text', dataType: 'String' },
            { name : 'estadoAprobacionId', label : 'Estado de aprobacion', type : 'number', dataType: 'Long' }

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
            { name : 'nombre', label : 'Nombre de la ciudad', type : 'text', dataType: 'String' },
            { name : 'regionId', label : 'ID de la región', type : 'number', dataType: 'Long' }

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
            { name : 'valorServicio', label : 'Valor del servicio', type : 'number', dataType: 'Double' },
            { name : 'ordenServicioId', label : 'ID del Órden de Servicio', type : 'number', dataType: 'Long' },
            { name : 'servicioId', label : 'ID del servicio', type : 'number', dataType: 'Long' }


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
            { name : 'ordenTrabajoId', label : 'ID del Órden de Trabajo', type : 'number', dataType: 'Long' },
            { name : 'servicioAsignadoId', label : 'ID del servicio asignado', type : 'number', dataType: 'Long' },
            { name : 'fecha', label : 'Fecha', type : 'date', dataType: 'Date' },
            { name : 'estadoOrdenTrabajoId', label : 'Estado de orden de trabajo', type : 'number', dataType: 'Long' }
        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
            { name : 'servicioAsignadoId', label : 'ID del servicio asignado', type : 'number', dataType: 'Long' },
            { name : 'fecha', label : 'Fecha', type : 'date', dataType: 'Date' },
            { name : 'estadoOrdenTrabajoId', label : 'ID del estado de orden de trabajo', type : 'number', dataType: 'Long' }
        ],
        isEmbeddedId: false
    },
    direccion: {
        fields: [
            { name : 'calle', label : 'Calle', type : 'text', dataType: 'String' },
            { name : 'carrera', label : 'Carrera', type : 'text', dataType: 'String' },
            { name : 'descripcion', label : 'Descripcion', type : 'text', dataType: 'String' },
            { name : 'barrio', label : 'Barrio', type : 'text', dataType: 'String' },
            { name : 'ciudadId', label : 'ID de la ciudad', type : 'number', dataType: 'Long' },
            { name : 'sucursalId', label : 'ID de la sucursal', type : 'number', dataType: 'Long' }
        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
            { name : 'calle', label : 'Calle', type : 'text', dataType: 'String' },
            { name : 'carrera', label : 'Carrera', type : 'text', dataType: 'String' },
            { name : 'descripcion', label : 'Descripcion', type : 'text', dataType: 'String' },
            { name : 'barrio', label : 'Barrio', type : 'text', dataType: 'String' },
            { name : 'ciudadId', label : 'ID de la ciudad', type : 'number', dataType: 'Long' },
            { name : 'sucursalId', label : 'ID de la sucursal', type : 'number', dataType: 'Long' }
        ],
        isEmbeddedId: false
    },
    aprobacionServicio: {
        fields: [
            { name : 'email', label : 'Email', type : 'email', dataType: 'String' },
            { name : 'personaId', label : 'ID de la persona', type : 'text', dataType: 'String' },
            { name : 'tipoEmailId', label : 'Tipo de email', type : 'number', dataType: 'Long' }
        ],
        tableFields: [
            { name : '', label : ' ', type : '', dataType: '' },
            { name : 'email', label : 'Email', type : 'email', dataType: 'String' },
            { name : 'personaId', label : 'ID de la persona', type : 'text', dataType: 'String' },
            { name : 'tipoEmailId', label : 'ID tipo de email', type : 'number', dataType: 'Long' }
        ],
        isEmbeddedId: false
    },
    empresa: {
        fields: [
            { name : 'nombre', label : 'Nombre de empresa', type : 'text', dataType: 'String' },
            { name : 'tipoEmpresaId', label : 'Tipo de empresa', type : 'number', dataType: 'Long' },

        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
            { name : 'nombre', label : 'Nombre de empresa', type : 'text', dataType: 'String' },
            { name : 'tipoEmpresaId', label : 'Tipo de empresa', type : 'number', dataType: 'Long' }     
        ],
        isEmbeddedId: false
    },
    empresaServicio: {
        fields: [
            { name : '', label : ' ', type : '', dataType: '' },
        ],
        tableFields: [
            { name : 'id', label : 'ID', dataType: 'Long' },
        ],
        isEmbeddedId: true
    }
    

};


