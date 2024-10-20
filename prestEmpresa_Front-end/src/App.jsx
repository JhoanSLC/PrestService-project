import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { useState } from 'react';
import Navbar from './components/NavBar';
import Home from './components/Home';
import Login from './components/Login';
import Register from './components/Register';
import Dashboard from './components/Dashboard';
import InventoryManagement from './components/InventoryManagement';
import WorkOrderManagement from './components/WorkOrderManagement';
import ClientManagement from './components/ClientManagement';
import SupplierManagement from './components/SupplierManagement';

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
            <Route path="/inventory" element={<InventoryManagement />} />
            <Route path="/work-orders" element={<WorkOrderManagement />} />
            <Route path="/clients" element={<ClientManagement />} />
            <Route path="/suppliers" element={<SupplierManagement />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}
