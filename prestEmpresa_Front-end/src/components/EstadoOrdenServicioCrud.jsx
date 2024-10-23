import { useEffect, useState } from 'react';
import { create, deleteEntity, list, update } from '../services/estadoOrdenServicioService';

export default EstadoOrdenServicio = () => {
    const [estado, setEstado] = useState([]);
    const [nuevoEstado, setNuevoEstado] = useState({
        nombre:''
    })
    const [editandoId, setEditandoId] = useState(null);
    const [paginaActual, setPaginaActual] = useState(1);
    const itemsPorPagina = 10;

    const fetchEstadoOrdenServicio = async () => {
        try {
            const response = await list();
            setEstado(response.data);
        } catch (error) {
            console.error('Error al cargar los estados de orden de servicio: ', error);
        }
    };

    useEffect(() => {
        fetchEstadoOrdenServicio();
    }, []);

    const handleInputChange = (e) => {
        const {name,value} = e.target;
        setNuevoEstado({ ...prev, [name]: value});
    }

    const handleAdd = async () => {
        try {
            if (editandoId) {
                await update(editandoId, nuevoEstado);
                setEditandoId(null);
            } else {
                await create(nuevoEstado);
            }
            fetchEstadoOrdenServicio();
            setNuevoEstado({
                nombre:''
            });
        } catch (error) {
            console.error('Error al guardar el estado de orden de servicio: ', error);
        }
    }

    const handleEdit = (estado) => {
        setNuevoEstado({
            nombre : estado.nombre
        })
        setEditandoId(estado.id)
    }

    const handleDelete = async () => {
        try {
            await deleteEntity(id);
            fetchEstadoOrdenServicio();
        } catch (error) {
            console.error('Error al eliminar el estado de orden de servicio: ', error);
        }
    }

    const totalPages = Math.ceil(estado.length / itemsPorPagina);
    const displayedItems = estado.slice(
        (paginaActual - 1) * itemsPorPagina,
        paginaActual * itemsPorPagina
    );
    const handlePageChange = (page) => {
        setPaginaActual(page);
    }

    return (
        <>
        </>
        // div[className="container mx-auto p-4"]>h1[className="text-2xl font-bold mb-4"]{Gestión de Estados de Órdenes de servicio}+div[className="mb-4 grid grid-cols-1 md:grid-cols-2 gap-4"]>div>label[className="block text-sm font-medium"]{Número de Estados}
    )

}