export const tableConfig = {
    ordenTrabajo: {
        fields: [
            { name: 'numeroOrdentrabajo', label: 'Número de Orden', type: 'text', dataType: 'String' },
            { name: 'fechaAsignacion', label: 'Fecha de Asignación', type: 'date', dataType: 'Date' },
            { name: 'horaAsignacion', label: 'Hora de Asignación', type: 'time', dataType: 'Time' },
            { name: 'empleadoId', label: 'ID de Empleado', type: 'text', dataType: 'Long' },
            { name: 'ordenServicioId', label: 'ID de Orden de Servicio', type: 'text', dataType: 'Long' }
        ]
    }
};
