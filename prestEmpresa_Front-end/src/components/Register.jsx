import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { create } from '../services/PersonaService'; // Asegúrate de importar el servicio
import { list as listTipoPersona } from '../services/tipoPersonaService'; // Asegúrate de importar el servicio para obtener tipos de persona

export default function Register() {
    const [formData, setFormData] = useState({
        id: '',
        name: '',
        apellido: '',
        usuario: '',
        contraseña: '',
        confirmarContraseña: '',
        tipoPersonaId: '', // Cambia 'rol' a 'tipoPersonaId'
    });
    const [tipoPersonas, setTipoPersonas] = useState([]); // Estado para almacenar los tipos de persona
    const [error, setError] = useState('');
    const [isLoading, setIsLoading] = useState(false);
    const navigate = useNavigate();

    // Fetch tipos de persona desde la base de datos
    useEffect(() => {
        const fetchTipoPersonas = async () => {
            try {
                const response = await listTipoPersona(); // Llama al servicio para obtener tipos de persona
                setTipoPersonas(response.data); // Asigna la lista de tipos de persona al estado
            } catch (error) {
                setError('Error al cargar los tipos de persona.');
            }
        };

        fetchTipoPersonas();
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        setIsLoading(true);

        // Basic form validation
        if (formData.contraseña !== formData.confirmarContraseña) {
            setError('Las contraseñas no coinciden');
            setIsLoading(false);
            return;
        }

        // Crear objeto de la persona
        const personaData = {
            id: formData.id,
            nombre: formData.name,
            apellido: formData.apellido,
            usuario: formData.usuario,
            contraseña: formData.contraseña,
            tipoPersonaId: formData.tipoPersonaId
        };

        try {
            const response = await create(personaData);

            if (response.status === 201) {
                alert('Registro exitoso. Por favor, inicia sesión.');
                navigate('/login');
            }
        } catch (error) {
            setError(error.response?.data?.message || 'Error en el registro. Por favor, inténtalo de nuevo.');
        } finally {
            setIsLoading(false);
        }
    };

    return (
        <div className="max-w-md mx-auto">
            <h2 className="text-2xl font-bold mb-4">Registro</h2>
            {error && <p className="text-red-500 mb-4">{error}</p>}
            <form onSubmit={handleSubmit} className="space-y-4">
                <div>
                    <label htmlFor="name" className="block mb-1">Nombre/s</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                        required
                        className="w-full px-3 py-2 border rounded"
                    />
                </div>
                <div>
                    <label htmlFor="apellido" className="block mb-1">Apellido/s</label>
                    <input
                        type="text"
                        id="apellido"
                        name="apellido"
                        value={formData.apellido}
                        onChange={handleChange}
                        required
                        className="w-full px-3 py-2 border rounded"
                    />
                </div>
                <div>
                    <label htmlFor="id" className="block mb-1">Identificación</label>
                    <input
                        type="text"
                        id="id"
                        name="id"
                        value={formData.id}
                        onChange={handleChange}
                        required
                        className="w-full px-3 py-2 border rounded"
                    />
                </div>
                <div>
                    <label htmlFor="usuario" className="block mb-1">Usuario</label>
                    <input
                        type="text"
                        id="usuario"
                        name="usuario"
                        value={formData.usuario}
                        onChange={handleChange}
                        required
                        className="w-full px-3 py-2 border rounded"
                    />
                </div>
                <div>
                    <label htmlFor="contraseña" className="block mb-1">Contraseña</label>
                    <input
                        type="password"
                        id="contraseña"
                        name="contraseña"
                        value={formData.contraseña}
                        onChange={handleChange}
                        required
                        className="w-full px-3 py-2 border rounded"
                    />
                </div>
                <div>
                    <label htmlFor="confirmarContraseña" className="block mb-1">Confirmar contraseña</label>
                    <input
                        type="password"
                        id="confirmarContraseña"
                        name="confirmarContraseña"
                        value={formData.confirmarContraseña}
                        onChange={handleChange}
                        required
                        className="w-full px-3 py-2 border rounded"
                    />
                </div>
                <div>
                    <label htmlFor="tipoPersonaId" className="block mb-1">Tipo de persona</label>
                    <select
                        id="tipoPersonaId"
                        name="tipoPersonaId" // Cambia 'rol' a 'tipoPersonaId'
                        value={formData.tipoPersonaId}
                        onChange={handleChange}
                        required
                        className="w-full px-3 py-2 border rounded"
                    >
                        <option value="">Seleccione un tipo de persona</option>
                        {tipoPersonas.map(tipo => (
                            <option key={tipo.id} value={tipo.id}>
                                {tipo.nombre}
                            </option>
                        ))}
                    </select>
                </div>
                <button
                    type="submit"
                    className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 disabled:opacity-50"
                    disabled={isLoading}
                >
                    {isLoading ? 'Registrando...' : 'Registrarse'}
                </button>
            </form>
        </div>
    );
}
