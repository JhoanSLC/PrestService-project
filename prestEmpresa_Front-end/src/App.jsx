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
            <Route path="/work-orders" element={<DynamicCrud tableName="ordenTrabajo"/>} />
            <Route path="/clients" element={<ClienteCrud />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}
