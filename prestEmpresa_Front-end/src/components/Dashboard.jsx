import { Link } from 'react-router-dom';

export default function Dashboard({ user }) {
    if (!user) {
        return <div className="text-center text-lg text-red-600">Por favor, inicia sesión para ver el dashboard.</div>;
    }

    const renderAdminOptions = () => (
        <>
            <Link to="/inventory" className={dashboardButtonStyles}>Gestión de Inventario</Link>
            <Link to="/work-orders" className={dashboardButtonStyles}>Gestión de Órdenes de Trabajo</Link>
            <Link to="/clients" className={dashboardButtonStyles}>Gestión de Clientes</Link>
            <Link to="/suppliers" className={dashboardButtonStyles}>Gestión de Proveedores</Link>
            <Link to="/employees" className={dashboardButtonStyles}>Gestión de Empleados</Link>
            <Link to="/servicios" className={dashboardButtonStyles}>Gestión de Servicios</Link>
            <Link to="/sucursales" className={dashboardButtonStyles}>Gestión de Sucursales</Link>
            <Link to="/personas" className={dashboardButtonStyles}>Gestión de Personas</Link>
            <Link to="/insumos" className={dashboardButtonStyles}>Gestión de Insumos</Link>
            <Link to="/ordenServicio" className={dashboardButtonStyles}>Gestión de Órdenes de Servicio</Link>
            <Link to="/estadoOrdenServicio" className={dashboardButtonStyles}>Gestión de Estados de Servicio</Link>
            <Link to="/estadoOrdenTrabajo" className={dashboardButtonStyles}>Gestión de Estados de Trabajo</Link>
            <Link to="/aprobacionServicio" className={dashboardButtonStyles}>Proceso de Aprobación de Servicios</Link>




        </>
    );

    const renderWarehouseManagerOptions = () => (
        <>
            <Link to="/inventory" className={dashboardButtonStyles}>Gestión de Inventario</Link>
            <Link to="/suppliers" className={dashboardButtonStyles}>Ver Proveedores</Link>
        </>
    );

    const renderClientOptions = () => (
        <>
            <Link to="/services" className={dashboardButtonStyles}>Solicitar Servicios</Link>
            <Link to="/orders" className={dashboardButtonStyles}>Mis Pedidos</Link>
        </>
    );

    return (
        <div className="container mx-auto p-6">
            <h2 className="text-3xl font-bold mb-6 text-center">Dashboard</h2>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                {user.tipoPersona === 'Administrador' && renderAdminOptions()}
                {user.tipoPersona === 'warehouse_manager' && renderWarehouseManagerOptions()}
                {user.tipoPersona === 'cliente' && renderClientOptions()}
            </div>
        </div>
    );
}

export const dashboardButtonStyles = `
    block
    bg-blue-500
    text-white
    rounded-lg
    p-4
    text-center
    transition-colors
    duration-200
    hover:bg-blue-600
    shadow-md
`;
