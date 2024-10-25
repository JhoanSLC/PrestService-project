import { Link } from 'react-router-dom';

export default function Dashboard({ user }) {
    if (!user) {
        return <div className="text-center text-lg text-red-600">Por favor, inicia sesión para ver el dashboard.</div>;
    }

    const renderAdminOptions = () => (
        <>
            <Link to="/ordenTrabajo" className={dashboardButtonStyles}>Gestión de Órden de trabajo</Link>
            <Link to="/estadoOrdenServicio" className={dashboardButtonStyles}>Gestión de Estado de Órden Servicio</Link>
            <Link to="/tipoTelefono" className={dashboardButtonStyles}>Gestión de Tipos de Teléfono</Link>
            <Link to="/tipoPersona" className={dashboardButtonStyles}>Gestión de Tipos de Persona</Link>
            <Link to="/tipoEmpresa" className={dashboardButtonStyles}>Gestión de Tipos de Empresa</Link>
            <Link to="/tipoEmail" className={dashboardButtonStyles}>Gestión de Tipos de Email</Link>
            <Link to="/telPersona" className={dashboardButtonStyles}>Gestión de Teléfonos / Persona</Link>
            <Link to="/sucursal" className={dashboardButtonStyles}>Gestión de Sucursal</Link>
            <Link to="/servicioInsumo" className={dashboardButtonStyles}>Gestión de Servicio / Insumo</Link>
            <Link to="/servicio" className={dashboardButtonStyles}>Gestión de Servicio</Link>
            <Link to="/region" className={dashboardButtonStyles}>Gestión de Region</Link>
            <Link to="/personaInsumo" className={dashboardButtonStyles}>Gestión de Persona / Insumo</Link>
            <Link to="/persona" className={dashboardButtonStyles}>Gestión de Persona</Link>
            <Link to="/pais" className={dashboardButtonStyles}>Gestión de País</Link>
            <Link to="/insumo" className={dashboardButtonStyles}>Gestión de Insumo</Link>
            <Link to="/ordenServicio" className={dashboardButtonStyles}>Gestión de Órden de Servicio</Link>
            <Link to="/estadoOrdenTrabajo" className={dashboardButtonStyles}>Gestión de Estado de Órden Trabajo</Link>
            <Link to="/estadoAprobacion" className={dashboardButtonStyles}>Gestión de Estado de Aprobación</Link>
            <Link to="/empresaServicio" className={dashboardButtonStyles}>Gestión de Empresa / Servicio</Link>
            <Link to="/empresa" className={dashboardButtonStyles}>Gestión de Empresa</Link>
            <Link to="/emailPersona" className={dashboardButtonStyles}>Gestión de Email / Persona</Link>
            <Link to="/direccion" className={dashboardButtonStyles}>Gestión de Direccion</Link>
            <Link to="/detalleOrdenServicio" className={dashboardButtonStyles}>Gestión de Detalle de Órden Servicio</Link>
            <Link to="/detalleOrdenTrabajo" className={dashboardButtonStyles}>Gestión de Detalle de Órden Trabajo</Link>
            <Link to="/ciudad" className={dashboardButtonStyles}>Gestión de Ciudad</Link>
            <Link to="/aprobacionServicio" className={dashboardButtonStyles}>Gestión de Aprobación Servicio</Link>
            




        </>
    );

    
    const renderProfesionalServicios = () => (
        <>
            <Link to="/ordenServicio" className={dashboardButtonStyles}>Gestión de Órden de Servicio</Link>
            <Link to="/estadoOrdenTrabajo" className={dashboardButtonStyles}>Gestión de Estado de Órden Trabajo</Link>
            <Link to="/detalleOrdenServicio" className={dashboardButtonStyles}>Gestión de Detalle de Órden Servicio</Link>
            <Link to="/detalleOrdenTrabajo" className={dashboardButtonStyles}>Gestión de Detalle de Órden Trabajo</Link>
            <Link to="/ordenTrabajo" className={dashboardButtonStyles}>Gestión de Órden de trabajo</Link>
        
        </>
    );

    const renderRecursosHumanos = () => (
        <>
            <Link to="/persona" className={dashboardButtonStyles}>Gestión de Persona</Link>
            <Link to="/tipoTelefono" className={dashboardButtonStyles}>Gestión de Tipos de Teléfono</Link>
            <Link to="/tipoPersona" className={dashboardButtonStyles}>Gestión de Tipos de Persona</Link>
            <Link to="/tipoEmail" className={dashboardButtonStyles}>Gestión de Tipos de Email</Link>
            <Link to="/telPersona" className={dashboardButtonStyles}>Gestión de Teléfonos / Persona</Link>
            <Link to="/persona" className={dashboardButtonStyles}>Gestión de Persona</Link>
         
        </>
    );

    const renderJefeBodega = () => (
        <>
            <Link to="/insumo" className={dashboardButtonStyles}>Gestión de Insumo</Link>
            <Link to="/servicioInsumo" className={dashboardButtonStyles}>Gestión de Servicio / Insumo</Link>
            <Link to="/ordenServicio" className={dashboardButtonStyles}>Gestión de Órden de Servicio</Link>
            <Link to="/estadoOrdenTrabajo" className={dashboardButtonStyles}>Gestión de Estado de Órden Trabajo</Link>
            <Link to="/personaInsumo" className={dashboardButtonStyles}>Gestión de Persona / Insumo</Link>
            
        </>
    );


    const renderCliente = () => (
        <>
            <Link to="/servicio" className={dashboardButtonStyles}>Gestión de Servicio</Link>
            <Link to="/insumo" className={dashboardButtonStyles}>Gestión de Insumo</Link>
            <Link to="/ordenServicio" className={dashboardButtonStyles}>Gestión de Órden de Servicio</Link>
            <Link to="/detalleOrdenServicio" className={dashboardButtonStyles}>Gestión de Detalle de Órden Servicio</Link>
            
        </>
    );

   

    return (
        <div className="container mx-auto p-6">
            <h2 className="text-3xl font-bold mb-6 text-center">Dashboard</h2>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                {user.tipoPersona === 'Administrador' && renderAdminOptions()}
                {user.tipoPersona === 'Jefe de bodega' && renderJefeBodega()}
                {user.tipoPersona === 'Cliente' && renderCliente()}
                {user.tipoPersona === 'Gerente' && renderAdminOptions()}
                {user.tipoPersona === 'Jefe de inventario' && renderJefeBodega()}
                {user.tipoPersona === 'Jefe de recursos humanos' && renderRecursosHumanos()}
                {user.tipoPersona === 'Profesional de servicios' && renderProfesionalServicios()}

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
