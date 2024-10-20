import React, { useState, useEffect } from 'react';
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "./ui/Table";
import Pagination from './Pagination';
import { list, create, update, deleteEntity } from '../services/ordenTrabajoService';
import { list as listEstados } from '../services/estadoOrdenTrabajoService';

export default function WorkOrderManagement() {
    const [workOrders, setWorkOrders] = useState([]);
    const [newOrder, setNewOrder] = useState({ descripcion: '', empleadoId: '', ordenServicioId: 0 });
    const [editingOrderId, setEditingOrderId] = useState(null);
    const [estados, setEstados] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const itemsPerPage = 10;

    useEffect(() => {
        fetchWorkOrders();
        fetchEstados();
    }, []);

    const fetchWorkOrders = async () => {
        try {
            const response = await list();
            setWorkOrders(response.data);
        } catch (error) {
            console.error('Error al cargar las órdenes:', error);
        }
    };

    const fetchEstados = async () => {
        try {
            const response = await listEstados();
            setEstados(response.data);
        } catch (error) {
            console.error('Error al cargar los estados:', error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewOrder(prev => ({ ...prev, [name]: value }));
    };

    const handleEstadoChange = (e) => {
        setNewOrder(prev => ({ ...prev, ordenServicioId: e.target.value }));
    };

    const handleAddOrder = async () => {
        try {
            if (editingOrderId) {
                await update(editingOrderId, newOrder);
                setEditingOrderId(null);
            } else {
                await create(newOrder);
            }
            fetchWorkOrders();
            setNewOrder({ descripcion: '', empleadoId: '', ordenServicioId: 0 });
        } catch (error) {
            console.error('Error al guardar la orden:', error);
        }
    };

    const handleEditOrder = (order) => {
        setNewOrder({
            descripcion: order.descripcion,
            empleadoId: order.empleadoId,
            ordenServicioId: order.ordenServicioId
        });
        setEditingOrderId(order.id);
    };

    const handleDeleteOrder = async (id) => {
        try {
            await deleteEntity(id);
            fetchWorkOrders();
        } catch (error) {
            console.error('Error al eliminar la orden:', error);
        }
    };

    const totalPages = Math.max(Math.ceil(workOrders.length / itemsPerPage), 1);
    const displayedOrders = workOrders.slice(
        (currentPage - 1) * itemsPerPage,
        currentPage * itemsPerPage
    );

    const handlePageChange = (page) => {
        setCurrentPage(page);
    };

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-2xl font-bold mb-4">Gestión de Órdenes de Trabajo</h1>

            <div className="mb-4 flex space-x-2">
                <input
                    className="border rounded p-1 w-1/4"
                    type="text"
                    name="descripcion"
                    value={newOrder.descripcion}
                    onChange={handleInputChange}
                    placeholder="Descripción"
                />
                <input
                    className="border rounded p-1 w-1/4"
                    type="text"
                    name="empleadoId"
                    value={newOrder.empleadoId}
                    onChange={handleInputChange}
                    placeholder="Asignado a: (ID de la persona)"
                />
                <select
                    className="border rounded p-1 w-1/4"
                    name="ordenServicioId"
                    value={newOrder.ordenServicioId}
                    onChange={handleEstadoChange}
                >
                    <option value="">Selecciona un estado</option>
                    {estados.map((estado) => (
                        <option key={estado.id} value={estado.id}>
                            {estado.nombre}
                        </option>
                    ))}
                </select>
                <button
                    onClick={handleAddOrder}
                    className="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-1 px-3 rounded"
                >
                    {editingOrderId ? 'Actualizar Orden' : 'Agregar Orden'}
                </button>
            </div>

            <Table>
                <TableHeader>
                    <TableRow>
                        <TableHead>ID</TableHead>
                        <TableHead>Descripción</TableHead>
                        <TableHead>Asignado a</TableHead>
                        <TableHead>Estado</TableHead>
                        <TableHead>Acciones</TableHead>
                    </TableRow>
                </TableHeader>
                <TableBody>
                    {displayedOrders.map((order) => (
                        <TableRow key={order.id}>
                            <TableCell>{order.id}</TableCell>
                            <TableCell>{order.descripcion}</TableCell>
                            <TableCell>{order.empleadoId}</TableCell>
                            <TableCell>{estados.find(e => e.id === order.ordenServicioId)?.nombre || 'Desconocido'}</TableCell>
                            <TableCell>
                                <button
                                    className="mr-2 bg-yellow-500 hover:bg-yellow-600 text-white font-semibold py-1 px-3 rounded"
                                    onClick={() => handleEditOrder(order)}
                                >
                                    Editar
                                </button>
                                <button
                                    className="bg-red-500 hover:bg-red-600 text-white font-semibold py-1 px-3 rounded"
                                    onClick={() => handleDeleteOrder(order.id)}
                                >
                                    Eliminar
                                </button>
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>

            <Pagination
                currentPage={currentPage}
                totalPages={totalPages}
                onPageChange={handlePageChange}
            />
        </div>
    );
}
