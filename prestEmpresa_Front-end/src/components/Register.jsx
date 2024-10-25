import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { motion } from 'framer-motion';
import { create } from '../services/PersonaService';
import { list as listTipoPersona } from '../services/tipoPersonaService';
import { Eye, EyeOff, User, Mail, Lock, IdCard, UserCircle } from 'lucide-react';

export default function Register() {
    const [formData, setFormData] = useState({
        id: '',
        name: '',
        apellido: '',
        usuario: '',
        contraseña: '',
        confirmarContraseña: '',
        tipoPersonaId: '',
    });
    const [tipoPersonas, setTipoPersonas] = useState([]);
    const [error, setError] = useState('');
    const [isLoading, setIsLoading] = useState(false);
    const [showPassword, setShowPassword] = useState(false);
    const [showConfirmPassword, setShowConfirmPassword] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchTipoPersonas = async () => {
            try {
                const response = await listTipoPersona();
                setTipoPersonas(response.data);
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

        if (formData.contraseña !== formData.confirmarContraseña) {
            setError('Las contraseñas no coinciden');
            setIsLoading(false);
            return;
        }

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

    const fadeIn = {
        hidden: { opacity: 0, y: 20 },
        visible: { opacity: 1, y: 0 }
    };

    return (
        <div className="min-h-screen bg-gradient-to-br from-blue-50 to-white flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
            <motion.div 
                className="max-w-md w-full space-y-8 bg-white p-10 rounded-xl shadow-2xl"
                initial="hidden"
                animate="visible"
                variants={fadeIn}
                transition={{ duration: 0.5 }}
            >
                <div>
                    <h2 className="mt-6 text-center text-3xl font-extrabold text-gray-900">
                        Crea tu cuenta
                    </h2>
                    <p className="mt-2 text-center text-sm text-gray-600">
                        O{' '}
                        <a href="/login" className="font-medium text-blue-600 hover:text-blue-500">
                            inicia sesión si ya tienes una cuenta
                        </a>
                    </p>
                </div>
                {error && (
                    <motion.div 
                        className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative" 
                        role="alert"
                        initial={{ opacity: 0, y: -50 }}
                        animate={{ opacity: 1, y: 0 }}
                        transition={{ duration: 0.5 }}
                    >
                        <span className="block sm:inline">{error}</span>
                    </motion.div>
                )}
                <form className="mt-8 space-y-6" onSubmit={handleSubmit}>
                    <div className="rounded-md shadow-sm -space-y-px">
                        <div className="flex">
                            <div className="w-1/2 pr-2">
                                <label htmlFor="name" className="sr-only">Nombre/s</label>
                                <div className="relative">
                                    <input
                                        id="name"
                                        name="name"
                                        type="text"
                                        required
                                        className="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm"
                                        placeholder="Nombre/s"
                                        value={formData.name}
                                        onChange={handleChange}
                                    />
                                    <User className="absolute right-3 top-2 h-5 w-5 text-gray-400" />
                                </div>
                            </div>
                            <div className="w-1/2 pl-2">
                                <label htmlFor="apellido" className="sr-only">Apellido/s</label>
                                <div className="relative">
                                    <input
                                        id="apellido"
                                        name="apellido"
                                        type="text"
                                        required
                                        className="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm"
                                        placeholder="Apellido/s"
                                        value={formData.apellido}
                                        onChange={handleChange}
                                    />
                                    <User className="absolute right-3 top-2 h-5 w-5 text-gray-400" />
                                </div>
                            </div>
                        </div>
                        <div className="relative">
                            <label htmlFor="id" className="sr-only">Identificación</label>
                            <input
                                id="id"
                                name="id"
                                type="text"
                                required
                                className="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm"
                                placeholder="Identificación"
                                value={formData.id}
                                onChange={handleChange}
                            />
                            <IdCard className="absolute right-3 top-2 h-5 w-5 text-gray-400" />
                        </div>
                        <div className="relative">
                            <label htmlFor="usuario" className="sr-only">Usuario</label>
                            <input
                                id="usuario"
                                name="usuario"
                                type="text"
                                required
                                className="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm"
                                placeholder="Usuario"
                                value={formData.usuario}
                                onChange={handleChange}
                            />
                            <Mail className="absolute right-3 top-2 h-5 w-5 text-gray-400" />
                        </div>
                        <div className="relative">
                            <label htmlFor="contraseña" className="sr-only">Contraseña</label>
                            <input
                                id="contraseña"
                                name="contraseña"
                                type={showPassword ? "text" : "password"}
                                required
                                className="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm"
                                placeholder="Contraseña"
                                value={formData.contraseña}
                                onChange={handleChange}
                            />
                            <button
                                type="button"
                                className="absolute inset-y-0 right-0 pr-3 flex items-center"
                                onClick={() => setShowPassword(!showPassword)}
                            >
                                {showPassword ? (
                                    <EyeOff className="h-5 w-5 text-gray-400" />
                                ) : (
                                    <Eye className="h-5 w-5 text-gray-400" />
                                )}
                            </button>
                        </div>
                        <div className="relative">
                            <label htmlFor="confirmarContraseña" className="sr-only">Confirmar contraseña</label>
                            <input
                                id="confirmarContraseña"
                                name="confirmarContraseña"
                                type={showConfirmPassword ? "text" : "password"}
                                required
                                className="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-b-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm"
                                placeholder="Confirmar contraseña"
                                value={formData.confirmarContraseña}
                                onChange={handleChange}
                            />
                            <button
                                type="button"
                                className="absolute inset-y-0 right-0 pr-3 flex items-center"
                                onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                            >
                                {showConfirmPassword ? (
                                    <EyeOff className="h-5 w-5 text-gray-400" />
                                ) : (
                                    <Eye className="h-5 w-5 text-gray-400" />
                                )}
                            </button>
                        </div>
                    </div>

                    <div>
                        <label htmlFor="tipoPersonaId" className="block text-sm font-medium text-gray-700">Tipo de persona</label>
                        <div className="mt-1 relative rounded-md shadow-sm">
                            <select
                                id="tipoPersonaId"
                                name="tipoPersonaId"
                                value={formData.tipoPersonaId}
                                onChange={handleChange}
                                required
                                className="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                            >
                                <option value="">Seleccione un tipo de persona</option>
                                {tipoPersonas.map(tipo => (
                                    <option key={tipo.id} value={tipo.id}>
                                        {tipo.nombre}
                                    </option>
                                ))}
                            </select>
                            <UserCircle className="absolute right-3 top-2 h-5 w-5 text-gray-400" />
                        </div>
                    </div>

                    <div>
                        <motion.button
                            type="submit"
                            className="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500"
                            disabled={isLoading}
                            whileHover={{ scale: 1.05 }}
                            whileTap={{ scale: 0.95 }}
                        >
                            <span className="absolute left-0 inset-y-0 flex items-center pl-3">
                                <Lock className="h-5 w-5 text-blue-500 group-hover:text-blue-400" aria-hidden="true" />
                            </span>
                            {isLoading ? 'Registrando...' : 'Registrarse'}
                        </motion.button>
                    </div>
                </form>
            </motion.div>
        </div>
    );
}