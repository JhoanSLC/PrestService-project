import { Link } from 'react-router-dom';

export default function Home() {
    return (
        <div className="max-w-4xl mx-auto text-center">
            <h1 className="text-4xl font-bold mb-6">Bienvenido a PrestEmpresa</h1>
            <p className="text-xl mb-8">
                Somos tu solución integral para la gestión empresarial. Ofrecemos servicios especializados y control de inventario para optimizar tus operaciones.
            </p>
            <div className="md:grid-cols-2 gap-6">
                <div className="bg-white p-6 rounded-lg shadow-md">
                    <h2 className="text-2xl font-semibold mb-4">Para Clientes</h2>
                    <p className="mb-4">Descubre nuestros servicios especializados y gestiona tus pedidos de manera eficiente.</p>
                    <Link to="/register" className="inline-block bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700 transition-colors">
                        Regístrate ahora
                    </Link>
                </div>
            </div>
        </div>
    );
}