import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

export default function Navbar({ user, setUser }) {
  const navigate = useNavigate();
  const handleLogout = () => {
    setUser(null);
    navigate('/');
  };

  return (
    <nav className="bg-blue-600 text-white p-4">
      <div className="container mx-auto flex justify-between items-center">
        <Link to="/" className="text-2xl font-bold">PrestEmpresa</Link>
        <div className="space-x-4">
          {user ? (
            <>
              <Link to="/dashboard">Dashboard</Link>
              <button onClick={handleLogout}>Cerrar sesión</button>
            </>
          ) : (
            <>
              <Link to="/login">Iniciar sesión</Link>
              <Link to="/register">Registrarse</Link>
            </>
          )}
        </div>
      </div>
    </nav>
  );
}