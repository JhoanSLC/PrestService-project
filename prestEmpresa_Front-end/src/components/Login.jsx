import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { authenticate } from '../services/autenticarLogin';

export default function Login({ setUser }) {
    const [usuario, setUsuario] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');

        try {
            const userData = await authenticate(usuario, password);

            setUser({ usuario: userData.usuario, tipoPersona: userData.tipoPersona });
            navigate('/dashboard');
        } catch (error) {
            setError(error.message);
        }
    };

    return (
        <div className="max-w-md mx-auto">
            <h2 className="text-2xl font-bold mb-4">Iniciar sesión</h2>
            {error && <p className="text-red-500 mb-4">{error}</p>}
            <form onSubmit={handleSubmit} className="space-y-4">
                <div>
                    <label htmlFor="usuario" className="block mb-1">Usuario</label>
                    <input
                        type="text"
                        id="usuario"
                        value={usuario}
                        onChange={(e) => setUsuario(e.target.value)}
                        required
                        className="w-full px-3 py-2 border rounded"
                    />
                </div>
                <div>
                    <label htmlFor="password" className="block mb-1">Contraseña</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                        className="w-full px-3 py-2 border rounded"
                    />
                </div>
                <button type="submit" className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700">
                    Iniciar sesión
                </button>
            </form>
        </div>
    );
}
