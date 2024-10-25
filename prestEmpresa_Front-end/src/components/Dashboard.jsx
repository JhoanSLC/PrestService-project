import React from 'react';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { 
  Briefcase, FileText, Phone, Users, Building, Mail, MapPin, 
  Package, Truck, Globe, Box, ClipboardList, CheckSquare, 
  Layers, User, Flag, Tool, FileSignature, AlertTriangle, 
  Bookmark, Home, Inbox, Map, CheckCircle, Grid
} from 'lucide-react';

export default function Dashboard({ user }) {
  if (!user) {
    return (
      <motion.div 
        initial={{ opacity: 0, y: 20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.5 }}
        className="text-center text-lg text-red-600 p-6 bg-red-100 rounded-lg shadow-md"
      >
        Por favor, inicia sesión para ver el dashboard.
      </motion.div>
    );
  }

  const renderDashboardButton = (to, text, icon) => (
    <motion.div
      whileHover={{ scale: 1.05 }}
      whileTap={{ scale: 0.95 }}
    >
      <Link to={to} className="block bg-white text-blue-600 rounded-lg p-4 text-center transition-all duration-200 hover:bg-blue-50 shadow-md">
        {icon}
        <span className="block mt-2">{text}</span>
      </Link>
    </motion.div>
  );

  const renderAdminOptions = () => (
    <>
      {renderDashboardButton("/ordenTrabajo", "Gestión de Órden de trabajo", <Briefcase className="mx-auto" />)}
      {renderDashboardButton("/estadoOrdenServicio", "Gestión de Estado de Órden Servicio", <FileText className="mx-auto" />)}
      {renderDashboardButton("/tipoTelefono", "Gestión de Tipos de Teléfono", <Phone className="mx-auto" />)}
      {renderDashboardButton("/tipoPersona", "Gestión de Tipos de Persona", <Users className="mx-auto" />)}
      {renderDashboardButton("/tipoEmpresa", "Gestión de Tipos de Empresa", <Building className="mx-auto" />)}
      {renderDashboardButton("/tipoEmail", "Gestión de Tipos de Email", <Mail className="mx-auto" />)}
      {renderDashboardButton("/telPersona", "Gestión de Teléfonos / Persona", <Phone className="mx-auto" />)}
      {renderDashboardButton("/sucursal", "Gestión de Sucursal", <MapPin className="mx-auto" />)}
      {renderDashboardButton("/servicioInsumo", "Gestión de Servicio / Insumo", <Package className="mx-auto" />)}
      {renderDashboardButton("/servicio", "Gestión de Servicio", <Truck className="mx-auto" />)}
      {renderDashboardButton("/region", "Gestión de Region", <Globe className="mx-auto" />)}
      {renderDashboardButton("/personaInsumo", "Gestión de Persona / Insumo", <Box className="mx-auto" />)}
      {renderDashboardButton("/persona", "Gestión de Persona", <User className="mx-auto" />)}
      {renderDashboardButton("/pais", "Gestión de País", <Flag className="mx-auto" />)}
      {renderDashboardButton("/insumo", "Gestión de Insumo", <Tool className="mx-auto" />)}
      {renderDashboardButton("/ordenServicio", "Gestión de Órden de Servicio", <ClipboardList className="mx-auto" />)}
      {renderDashboardButton("/estadoOrdenTrabajo", "Gestión de Estado de Órden Trabajo", <FileSignature className="mx-auto" />)}
      {renderDashboardButton("/estadoAprobacion", "Gestión de Estado de Aprobación", <CheckSquare className="mx-auto" />)}
      {renderDashboardButton("/empresaServicio", "Gestión de Empresa / Servicio", <Layers className="mx-auto" />)}
      {renderDashboardButton("/empresa", "Gestión de Empresa", <Building className="mx-auto" />)}
      {renderDashboardButton("/emailPersona", "Gestión de Email / Persona", <Mail className="mx-auto" />)}
      {renderDashboardButton("/direccion", "Gestión de Direccion", <MapPin className="mx-auto" />)}
      {renderDashboardButton("/detalleOrdenServicio", "Gestión de Detalle de Órden Servicio", <FileText className="mx-auto" />)}
      {renderDashboardButton("/detalleOrdenTrabajo", "Gestión de Detalle de Órden Trabajo", <Briefcase className="mx-auto" />)}
      {renderDashboardButton("/ciudad", "Gestión de Ciudad", <Home className="mx-auto" />)}
      {renderDashboardButton("/aprobacionServicio", "Gestión de Aprobación Servicio", <CheckCircle className="mx-auto" />)}
    </>
  );

  const renderProfesionalServicios = () => (
    <>
      {renderDashboardButton("/ordenServicio", "Gestión de Órden de Servicio", <ClipboardList className="mx-auto" />)}
      {renderDashboardButton("/estadoOrdenTrabajo", "Gestión de Estado de Órden Trabajo", <FileSignature className="mx-auto" />)}
      {renderDashboardButton("/detalleOrdenServicio", "Gestión de Detalle de Órden Servicio", <FileText className="mx-auto" />)}
      {renderDashboardButton("/detalleOrdenTrabajo", "Gestión de Detalle de Órden Trabajo", <Briefcase className="mx-auto" />)}
      {renderDashboardButton("/ordenTrabajo", "Gestión de Órden de trabajo", <Briefcase className="mx-auto" />)}
    </>
  );

  const renderRecursosHumanos = () => (
    <>
      {renderDashboardButton("/persona", "Gestión de Persona", <User className="mx-auto" />)}
      {renderDashboardButton("/tipoTelefono", "Gestión de Tipos de Teléfono", <Phone className="mx-auto" />)}
      {renderDashboardButton("/tipoPersona", "Gestión de Tipos de Persona", <Users className="mx-auto" />)}
      {renderDashboardButton("/tipoEmail", "Gestión de Tipos de Email", <Mail className="mx-auto" />)}
      {renderDashboardButton("/telPersona", "Gestión de Teléfonos / Persona", <Phone className="mx-auto" />)}
    </>
  );

  const renderJefeBodega = () => (
    <>
      {renderDashboardButton("/insumo", "Gestión de Insumo", <Tool className="mx-auto" />)}
      {renderDashboardButton("/servicioInsumo", "Gestión de Servicio / Insumo", <Package className="mx-auto" />)}
      {renderDashboardButton("/ordenServicio", "Gestión de Órden de Servicio", <ClipboardList className="mx-auto" />)}
      {renderDashboardButton("/estadoOrdenTrabajo", "Gestión de Estado de Órden Trabajo", <FileSignature className="mx-auto" />)}
      {renderDashboardButton("/personaInsumo", "Gestión de Persona / Insumo", <Box className="mx-auto" />)}
    </>
  );

  const renderCliente = () => (
    <>
      {renderDashboardButton("/servicio", "Gestión de Servicio", <Truck className="mx-auto" />)}
      {renderDashboardButton("/insumo", "Gestión de Insumo", <Tool className="mx-auto" />)}
      {renderDashboardButton("/ordenServicio", "Gestión de Órden de Servicio", <ClipboardList className="mx-auto" />)}
      {renderDashboardButton("/detalleOrdenServicio", "Gestión de Detalle de Órden Servicio", <FileText className="mx-auto" />)}
    </>
  );

  const containerVariants = {
    hidden: { opacity: 0 },
    visible: {
      opacity: 1,
      transition: {
        delayChildren: 0.3,
        staggerChildren: 0.2
      }
    }
  };

  const itemVariants = {
    hidden: { y: 20, opacity: 0 },
    visible: {
      y: 0,
      opacity: 1
    }
  };

  return (
    <div className="container mx-auto p-6">
      <motion.h2 
        className="text-3xl font-bold mb-6 text-center text-blue-600"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.5 }}
      >
        Dashboard de {user.tipoPersona}
      </motion.h2>
      <motion.div 
        className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6"
        variants={containerVariants}
        initial="hidden"
        animate="visible"
      >
        {user.tipoPersona === 'Administrador' && renderAdminOptions()}
        {user.tipoPersona === 'Jefe de bodega' && renderJefeBodega()}
        {user.tipoPersona === 'Cliente' && renderCliente()}
        {user.tipoPersona === 'Gerente' && renderAdminOptions()}
        {user.tipoPersona === 'Jefe de inventario' && renderJefeBodega()}
        {user.tipoPersona === 'Jefe de recursos humanos' && renderRecursosHumanos()}
        {user.tipoPersona === 'Profesional de servicios' && renderProfesionalServicios()}
      </motion.div>
    </div>
  );
}