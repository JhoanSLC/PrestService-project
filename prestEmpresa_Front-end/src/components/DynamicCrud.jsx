import moment from 'moment';
import React, { useEffect, useState } from 'react';
import { create, deleteEntity, list, update } from '../services/serviceDinamico';
import { tableConfig } from '../services/tableConfig';
import Pagination from './Pagination';
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "./ui/Table";

export default function DynamicCrud({ tableName }) {
    const [items, setItems] = useState([]);
    const [formData, setFormData] = useState({});
    const [editingItemId, setEditingItemId] = useState(null);
    const [currentPage, setCurrentPage] = useState(1);
    const itemsPerPage = 10;

    useEffect(() => {
        fetchItems();
    }, []);

    const fetchItems = async () => {
        try {
            const response = await list(tableName);
            setItems(response.data);
        } catch (error) {
            console.error('Error al cargar los ítems:', error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData((prev) => ({ ...prev, [name]: value }));
    };

    const formatTime = (time) => {
        return moment(time, 'HH:mm').format('HH:mm:ss');
    };

    const formatDate = (date) => {
        return moment(date).format('YYYY-MM-DD');
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const formattedData = { ...formData };

            for (const field of tableConfig[tableName].fields) {
                if (field.type === 'Date') {
                    formattedData[field.name] = formatDate(formattedData[field.name]);
                }
                if (field.type === 'Time') {
                    formattedData[field.name] = formatTime(formattedData[field.name]);
                }
            }

            if (editingItemId) {
                await update(tableName, editingItemId, formattedData);
                setEditingItemId(null);
            } else {
                await create(tableName, formattedData);
            }
            fetchItems();
            setFormData({});
        } catch (error) {
            console.error('Error al guardar el ítem:', error);
        }
    };

    const handleEditItem = (item) => {
        setFormData(item);
        setEditingItemId(item.id);
    };

    const handleDeleteItem = async (id) => {
        try {
            await deleteEntity(tableName, id);
            fetchItems();
        } catch (error) {
            console.error('Error al eliminar el ítem:', error);
        }
    };

    const totalPages = Math.ceil(items.length / itemsPerPage);
    const displayedItems = items.slice((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage);

    const handlePageChange = (page) => {
        setCurrentPage(page);
    };

    const fields = tableConfig[tableName]?.fields || [];

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-2xl font-bold mb-4">Gestión de {tableName}</h1>

            <form onSubmit={handleSubmit} className="mb-4">
                {fields.map((field) => (
                    <div key={field.name} className="mb-4">
                        <label className="block text-sm font-medium">{field.label}:</label>
                        <input
                            className="border rounded p-2 w-full"
                            type={field.type === 'Date' ? 'date' : field.type === 'Time' ? 'time' : 'text'}
                            name={field.name}
                            value={formData[field.name] || ''}
                            onChange={handleInputChange}
                            required
                        />
                    </div>
                ))}
                <button
                    type="submit"
                    className="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded"
                >
                    {editingItemId ? 'Actualizar' : 'Agregar'}
                </button>
            </form>

            <div className="mt-6 overflow-x-auto border border-gray-300 rounded-lg shadow-lg">
                <Table className="w-full text-left border-collapse">
                    <TableHeader>
                        <TableRow>
                            {fields.map((field) => (
                                <TableHead key={field.name} className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-2">
                                    {field.label}
                                </TableHead>
                            ))}
                            <TableHead className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-2">Acciones</TableHead>
                        </TableRow>
                    </TableHeader>
                    <TableBody>
                        {displayedItems.map((item) => (
                            <TableRow key={item.id} className="hover:bg-gray-50 transition">
                                {fields.map((field) => (
                                    <TableCell key={field.name} className="border-b border-gray-200 p-2">
                                        {item[field.name]}
                                    </TableCell>
                                ))}
                                <TableCell className="border-b border-gray-200 p-2">
                                    <button
                                        className="mr-2 bg-yellow-500 hover:bg-yellow-600 text-white font-semibold py-1 px-3 rounded"
                                        onClick={() => handleEditItem(item)}
                                    >
                                        Editar
                                    </button>
                                    <button
                                        className="bg-red-500 hover:bg-red-600 text-white font-semibold py-1 px-3 rounded"
                                        onClick={() => handleDeleteItem(item.id)}
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
