import moment from 'moment';
import React, { useEffect, useState } from 'react';
import { create, deleteEntity, list, update } from '../services/ordenTrabajoService';
import Pagination from './Pagination';
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "./ui/Table";

export default function WorkOrderManagement() {
    const [workOrders, setWorkOrders] = useState([]); 
    const [newOrder, setNewOrder] = useState({ 
        numeroOrdentrabajo: '', 
        fechaAsignacion: '', 
        horaAsignacion: '', 
        empleadoId: '', 
        ordenServicioId: 0 
    });
    const [editingOrderId, setEditingOrderId] = useState(null);
    const [currentPage, setCurrentPage] = useState(1);
    const itemsPerPage = 10;

    useEffect(() => {
        fetchWorkOrders();
    }, []);

    const fetchWorkOrders = async () => {
        try {
            const response = await list();
            setWorkOrders(response.data);
        } catch (error) {
            console.error('Error al cargar las órdenes:', error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewOrder(prev => ({ ...prev, [name]: value }));
    };

    const handleAddOrder = async () => {
        try {
            const formattedOrder = {
                ...newOrder,
                horaAsignacion: moment(newOrder.horaAsignacion, 'HH:mm').format('HH:mm:ss')
            };
    
            if (editingOrderId) {
                await update(editingOrderId, formattedOrder);
                setEditingOrderId(null);
            } else {
                await create(formattedOrder);
            }
            fetchWorkOrders();
            setNewOrder({ 
                numeroOrdentrabajo: '', 
                fechaAsignacion: '', 
                horaAsignacion: '', 
                empleadoId: '', 
                ordenServicioId: 0 
            });
        } catch (error) {
            console.error('Error al guardar la orden:', error);
        }
    };

    const handleEditOrder = (order) => {
        setNewOrder({
            numeroOrdentrabajo: order.numeroOrdentrabajo,
            fechaAsignacion: moment(order.fechaAsignacion).format('YYYY-MM-DD'),
            horaAsignacion: moment(order.horaAsignacion, 'HH:mm:ss').format('HH:mm'), 
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

    const totalPages = Math.ceil(workOrders.length / itemsPerPage);
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

            <div className="mb-4 grid grid-cols-1 md:grid-cols-2 gap-4">
                <div>
                    <label className="block text-sm font-medium">Número de Orden de Trabajo:</label>
                    <input
                        className="border rounded p-2 w-full"
                        type="text"
                        name="numeroOrdentrabajo"
                        value={newOrder.numeroOrdentrabajo}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div>
                    <label className="block text-sm font-medium">Fecha de Asignación:</label>
                    <input
                        className="border rounded p-2 w-full"
                        type="date"
                        name="fechaAsignacion"
                        value={newOrder.fechaAsignacion}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div>
                    <label className="block text-sm font-medium">Hora de Asignación:</label>
                    <input
                        className="border rounded p-2 w-full"
                        type="time"
                        name="horaAsignacion"
                        value={newOrder.horaAsignacion}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div>
                    <label className="block text-sm font-medium">Asignado a (ID de la persona):</label>
                    <input
                        className="border rounded p-2 w-full"
                        type="text"
                        name="empleadoId"
                        value={newOrder.empleadoId}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div>
                    <label className="block text-sm font-medium">ID de Orden de Servicio:</label>
                    <input
                        className="border rounded p-2 w-full"
                        type="text"
                        name="ordenServicioId"
                        value={newOrder.ordenServicioId}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div className="flex items-center md:col-span-2">
                    <button
                        onClick={handleAddOrder}
                        className="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded w-full"
                    >
                        {editingOrderId ? 'Actualizar Orden' : 'Agregar Orden'}
                    </button>
                </div>
            </div>

            <div className="mt-6 overflow-x-auto border border-gray-300 rounded-lg shadow-lg">
                <Table className="w-full text-left border-collapse">
                    <TableHeader>
                        <TableRow>
                            <TableHead className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-2">ID</TableHead>
                            <TableHead className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-2">Número de Orden</TableHead>
                            <TableHead className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-2">Fecha Asignación</TableHead>
                            <TableHead className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-2">Hora Asignación</TableHead>
                            <TableHead className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-2">Asignado a</TableHead>
                            <TableHead className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-2">Orden de servicio</TableHead>
                            <TableHead className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-2">Acciones</TableHead>
                        </TableRow>
                    </TableHeader>
                    <TableBody>
                        {displayedOrders.map((order) => (
                            <TableRow key={order.id} className="hover:bg-gray-50 transition">
                                <TableCell className="border-b border-gray-200 p-2">{order.id}</TableCell>
                                <TableCell className="border-b border-gray-200 p-2">{order.numeroOrdentrabajo}</TableCell>
                                <TableCell className="border-b border-gray-200 p-2">{moment(order.fechaAsignacion).format('YYYY-MM-DD')}</TableCell>
                                <TableCell className="border-b border-gray-200 p-2">{moment(order.horaAsignacion, 'HH:mm:ss').format('HH:mm:ss')}</TableCell>
                                <TableCell className="border-b border-gray-200 p-2">{order.empleadoId}</TableCell>
                                <TableCell className="border-b border-gray-200 p-2">{order.ordenServicioId}</TableCell>
                                <TableCell className="border-b border-gray-200 p-2">
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
            </div>

            <Pagination
                currentPage={currentPage}
                totalPages={totalPages}
                onPageChange={handlePageChange}
            />
        </div>
    );
}
