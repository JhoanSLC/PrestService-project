import { useEffect, useState } from 'react';
import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:1402/api/servicio';

export default function Home() {
    const [services, setServices] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        // Función para obtener los servicios de la API
        const fetchServices = async () => {
            try {
                const response = await axios.get(REST_API_BASE_URL);
                setServices(response.data); // Suponiendo que 'data' es un array de servicios
                setLoading(false);
            } catch (err) {
                setError('Error al cargar los servicios');
                setLoading(false);
                console.error('Error al obtener los servicios:', err);
            }
        };

        fetchServices();
    }, []);

    if (loading) {
        return <div className="text-center py-20">Cargando servicios...</div>;
    }

    if (error) {
        return <div className="text-center py-20 text-red-600">{error}</div>;
    }

    return (
        <div className="bg-gray-100">
            {/* Sección Hero */}
            <div className="relative bg-gradient-to-r from-indigo-600 to-blue-500 text-white h-screen flex items-center justify-center">
                <div className="absolute inset-0 bg-[url('/path/to/your/image.jpg')] bg-cover bg-center opacity-30"></div>
                <div className="relative z-10 text-center">
                    <h1 className="text-6xl md:text-8xl font-bold mb-4 animate-bounce">
                        Bienvenido a <span className="text-yellow-400">PrestEmpresa</span>
                    </h1>
                    <p className="text-xl md:text-2xl mb-6">
                        Tu solución integral para la gestión empresarial.
                    </p>
                    <Link 
                        to="/register" 
                        className="bg-yellow-400 text-gray-800 font-semibold px-8 py-4 rounded-full shadow-lg hover:bg-yellow-300 transition-colors"
                    >
                        Comienza Ahora
                    </Link>
                </div>
            </div>

            {/* Sección de Servicios */}
            <div className="max-w-7xl mx-auto py-20 px-4">
                <h2 className="text-4xl font-bold text-center mb-12 text-gray-800">
                    Nuestros Servicios
                </h2>
                <div className="grid md:grid-cols-3 gap-8">
                    {services.map((service) => (
                        <div key={service.id} className="bg-white p-6 rounded-lg shadow-lg transition-transform hover:scale-105">
                            <h3 className="text-2xl font-bold mb-4 text-gray-800">{service.nombre}</h3>
                            <p className="text-gray-600 mb-4">
                                {service.requiereInsumo ? 'Requiere Insumos' : 'No requiere Insumos'}
                            </p>
                            <p className="text-gray-600 mb-4">
                                Tiempo de Ejecución: {service.tiempoEjecucion ? `${service.tiempoEjecucion.toString().split(' ')[0]} minutos` : 'No especificado'}
                            </p>
                            <button className="bg-blue-600 text-white font-semibold px-4 py-2 rounded hover:bg-blue-700 transition-colors">
                                Más Información
                            </button>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}
