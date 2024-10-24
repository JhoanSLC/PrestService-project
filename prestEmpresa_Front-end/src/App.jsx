import { useState } from 'react';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import ClienteCrud from './components/ClienteCrud';
import Dashboard from './components/Dashboard';
import DynamicCrud from './components/DynamicCrud';
import Home from './components/Home';
import Login from './components/Login';
import Navbar from './components/NavBar';
import Register from './components/Register';

export default function App() {
  const [user, setUser] = useState(null);

  return (
    <Router>
      <div className="min-h-screen bg-gray-100">
        <Navbar user={user} setUser={setUser} />
        <main className="container mx-auto px-4 py-8">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login setUser={setUser} />} />
            <Route path="/register" element={<Register />} />
            <Route path="/dashboard" element={<Dashboard user={user} />} />
            <Route path="/ordenTrabajo" element={<DynamicCrud tableName="ordenTrabajo"/>} />
            <Route path="/estadoOrdenServicio" element={<DynamicCrud tableName="estadoOrdenServicio" />} />
            <Route path="/tipoTelefono" element={<DynamicCrud tableName="tipoTelefono" />} />
            <Route path="/tipoPersona" element={<DynamicCrud tableName="tipoPersona" />} />
            <Route path="/tipoEmpresa" element={<DynamicCrud tableName="tipoEmpresa" />} />
            <Route path="/tipoEmail" element={<DynamicCrud tableName="tipoEmail" />} />
            <Route path="/telPersona" element={<DynamicCrud tableName="telPersona" />} />
            <Route path="/sucursal" element={<DynamicCrud tableName="sucursal" />} />
            <Route path="/servicioInsumo" element={<DynamicCrud tableName="servicioInsumo" />} />
            <Route path="/servicio" element={<DynamicCrud tableName="servicio" />} />
            <Route path="/region" element={<DynamicCrud tableName="region" />} />
            <Route path="/personaInsumo" element={<DynamicCrud tableName="personaInsumo" />} />
            <Route path="/persona" element={<DynamicCrud tableName="persona" />} />
            <Route path="/pais" element={<DynamicCrud tableName="pais" />} />
            <Route path="/insumo" element={<DynamicCrud tableName="insumo" />} />
            <Route path="/ordenServicio" element={<DynamicCrud tableName="ordenServicio" />} />
            <Route path="/estadoOrdenTrabajo" element={<DynamicCrud tableName="estadoOrdenTrabajo" />} />
            <Route path="/estadoAprobacion" element={<DynamicCrud tableName="estadoAprobacion" />} />
            <Route path="/empresaServicio" element={<DynamicCrud tableName="empresaServicio" />} />
            <Route path="/empresa" element={<DynamicCrud tableName="empresa" />} />
            <Route path="/emailPersona" element={<DynamicCrud tableName="emailPersona" />} />
            <Route path="/direccion" element={<DynamicCrud tableName="direccion" />} />
            <Route path="/detalleOrdenServicio" element={<DynamicCrud tableName="detalleOrdenServicio" />} />
            <Route path="/detalleOrdenTrabajo" element={<DynamicCrud tableName="detalleOrdenTrabajo" />} />
            <Route path="/ciudad" element={<DynamicCrud tableName="ciudad" />} />
            <Route path="/aprobacionServicio" element={<DynamicCrud tableName="aprobacionServicio" />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}
