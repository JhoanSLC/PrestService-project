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
        ]
    },
    estadoOrdenServicio: {
        fields: [
            { name: 'nombre', label: 'Nombre del estado', type: 'text', dataType: 'String' }
        ],
        tableFields: [
            { name: 'id', label: 'ID', dataType: 'Long' },
            { name: 'nombre', label: 'Nombre del estado' }
        ]
    }
};
