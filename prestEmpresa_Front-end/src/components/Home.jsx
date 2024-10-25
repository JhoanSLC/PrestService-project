import { Link } from 'react-router-dom';

export default function Home() {
    return (
        <div className="min-h-screen bg-gradient-to-br from-blue-50 to-white">
            <div className="max-w-6xl mx-auto text-center px-4 py-20">
                <h1 className="text-5xl md:text-6xl font-extrabold mb-6 text-gray-800 animate-fade-in-down">
                    Bienvenido a <span className="text-blue-600">PrestEmpresa</span>
                </h1>
                <p className="text-lg md:text-xl text-gray-700 mb-10 max-w-3xl mx-auto animate-fade-in-up">
                    Somos tu solución integral para la gestión empresarial. Ofrecemos servicios especializados y control de inventario para optimizar tus operaciones.
                </p>

                <div className="grid md:grid-cols-2 gap-12 mt-16">
                    {/* Card para Clientes */}
                    <div className="bg-white rounded-xl shadow-xl transform transition-all hover:-translate-y-2 hover:shadow-2xl hover:scale-105 duration-300">
                        <div className="p-8">
                            <h2 className="text-3xl font-bold mb-4 text-gray-800">
                                Para Clientes
                            </h2>
                            <p className="text-gray-600 mb-6">
                                Descubre nuestros servicios especializados y gestiona tus pedidos de manera eficiente.
                            </p>
                            <Link 
                                to="/register" 
                                className="inline-block bg-blue-600 text-white font-semibold px-6 py-3 rounded hover:bg-blue-700 transition-colors"
                            >
                                Regístrate ahora
                            </Link>
                        </div>
                    </div>

                    {/* Card para Empresas */}
                    <div className="bg-white rounded-xl shadow-xl transform transition-all hover:-translate-y-2 hover:shadow-2xl hover:scale-105 duration-300">
                        <div className="p-8">
                            <h2 className="text-3xl font-bold mb-4 text-gray-800">
                                Para Empresas
                            </h2>
                            <p className="text-gray-600 mb-6">
                                Optimiza tu gestión empresarial con nuestras soluciones adaptadas a tus necesidades.
                            </p>
                            <Link 
                                to="/services" 
                                className="inline-block bg-blue-600 text-white font-semibold px-6 py-3 rounded hover:bg-blue-700 transition-colors"
                            >
                                Conoce nuestros servicios
                            </Link>
                        </div>
                    </div>
                </div>
            </div>

            {/* Sección de valores o ventajas */}
            <div className="bg-blue-600 text-white py-16 mt-16">
                <div className="max-w-6xl mx-auto px-4 text-center">
                    <h2 className="text-4xl font-bold mb-8 animate-fade-in-down">
                        ¿Por qué elegir <span className="text-white">PrestEmpresa</span>?
                    </h2>
                    <div className="grid md:grid-cols-3 gap-8">
                        <div className="p-6 bg-white bg-opacity-10 rounded-lg shadow-lg animate-fade-in-up">
                            <h3 className="text-xl font-semibold mb-4">Experiencia Comprobada</h3>
                            <p>
                                Más de 10 años ayudando a empresas a optimizar sus procesos con soluciones tecnológicas de vanguardia.
                            </p>
                        </div>
                        <div className="p-6 bg-white bg-opacity-10 rounded-lg shadow-lg animate-fade-in-up">
                            <h3 className="text-xl font-semibold mb-4">Soluciones Personalizadas</h3>
                            <p>
                                Adaptamos nuestros servicios a las necesidades específicas de cada cliente, garantizando su satisfacción.
                            </p>
                        </div>
                        <div className="p-6 bg-white bg-opacity-10 rounded-lg shadow-lg animate-fade-in-up">
                            <h3 className="text-xl font-semibold mb-4">Atención al Cliente</h3>
                            <p>
                                Un equipo de soporte disponible 24/7 para ayudarte en cada paso del proceso, siempre cerca de ti.
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            {/* Sección de CTA */}
            <div className="bg-white py-16">
                <div className="max-w-4xl mx-auto text-center">
                    <h2 className="text-3xl md:text-4xl font-bold mb-6 text-gray-800">
                        Empieza a transformar tu negocio hoy mismo
                    </h2>
                    <p className="text-gray-600 mb-8">
                        Con nuestras soluciones, podrás llevar tu empresa al siguiente nivel. ¿Qué esperas para ser parte de la transformación?
                    </p>
                    <Link 
                        className="bg-blue-600 text-white font-semibold px-8 py-4 rounded hover:bg-blue-700 transition-colors"
                    >
                        Contáctanos
                    </Link>
                </div>
            </div>
        </div>
    );
}
