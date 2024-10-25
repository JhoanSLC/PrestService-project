import React, { useEffect, useState } from 'react';
import { list } from '../services/serviceDinamico'; 

export default function Services() {
    const [servicios, setServicios] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    
    const fetchServicios = async () => {
        try {
            const response = await list('servicio');
            setServicios(response.data);
            setLoading(false);
        } catch (err) {
            setError('Hubo un problema al cargar los servicios.');
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchServicios();
    }, []);

    if (loading) {
        return <p>Cargando servicios...</p>;
    }

    if (error) {
        return <p>{error}</p>;
    }

    return (
        <div className="max-w-5xl mx-auto py-8">
            <h2 className="text-3xl font-bold mb-6 text-center">Lista de Servicios</h2>
            <div className="overflow-x-auto">
                <table className="min-w-full bg-white border border-gray-200 rounded-lg shadow-md">
                    <thead>
                        <tr className="bg-blue-600 text-white">
                            <th className="px-4 py-2">ID</th>
                            <th className="px-4 py-2">Nombre</th>
                            <th className="px-4 py-2">Requiere Insumo</th>
                            <th className="px-4 py-2">Tiempo de Ejecución</th>
                        </tr>
                    </thead>
                    <tbody>
                        {servicios.map((servicio) => (
                            <tr key={servicio.id} className="border-b border-gray-200 hover:bg-gray-100">
                                <td className="px-4 py-2">{servicio.id}</td>
                                <td className="px-4 py-2">{servicio.nombre}</td>
                                <td className="px-4 py-2">
                                    {servicio.requiereInsumo ? 'Sí' : 'No'}
                                </td>
                                <td className="px-4 py-2">
                                    {servicio.tiempoEjecucion ? servicio.tiempoEjecucion : 'No especificado'}
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
