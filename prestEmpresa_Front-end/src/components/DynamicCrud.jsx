import moment from 'moment';
import React, { useEffect, useState } from 'react';
import { create, deleteEntity, deleteEntityEmbeddedId, list, update, updateEmbeddedId } from '../services/serviceDinamico';
import { tableConfig } from '../services/tableConfig';
import Pagination from './Pagination';
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "./ui/Table";

export default function DynamicCrud({ tableName }) {
    const [items, setItems] = useState([]);
    const [formData, setFormData] = useState({});
    const [editingItemId, setEditingItemId] = useState(null);
    const [currentPage, setCurrentPage] = useState(1);
    const [errorMessage, setErrorMessage] = useState('');
    const itemsPerPage = 5;

    useEffect(() => {
        fetchItems();
        initializeFormData();
    }, [tableName]);

    const fetchItems = async () => {
        try {
            const response = await list(tableName);
            setItems(response.data);
        } catch (error) {
            setErrorMessage('Error al cargar los ítems. Por favor, inténtelo de nuevo más tarde.');
            console.error('Error al cargar los ítems:', error);
        }
    };

    const initializeFormData = () => {
        const fields = tableConfig[tableName]?.fields || [];
        const initialData = {};
        fields.forEach(field => {
            initialData[field.name] = field.dataType === 'date' ? '' : field.dataType === 'time' ? '' : '';
        });
        setFormData(initialData);
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData((prev) => ({ ...prev, [name]: value }));
    };

    const handleAddOrUpdateItem = async (e) => {
        e.preventDefault();
        setErrorMessage('');
        const isEmbeddedId = tableConfig[tableName]?.isEmbeddedId;

        try {
            const formattedData = {
                ...formData,
                horaAsignacion: formData.horaAsignacion ? moment(formData.horaAsignacion, 'HH:mm').format('HH:mm:ss') : undefined,
            };

            if (editingItemId) {
                if (isEmbeddedId) {
                    const { mainId, embeddedId } = editingItemId;
                    await updateEmbeddedId(tableName, mainId, embeddedId, formattedData);
                } else {
                    await update(tableName, editingItemId, formattedData);
                }
                setEditingItemId(null);
            } else {
                await create(tableName, formattedData);
            }
            fetchItems();
            initializeFormData();
        } catch (error) {
            setErrorMessage('Error al guardar el ítem. Por favor, inténtelo de nuevo.');
            console.error('Error al guardar el ítem:', error);
        }
    };

    const handleEditItem = (item) => {
        const fields = tableConfig[tableName]?.fields || [];
        const updatedFormData = {};
        fields.forEach(field => {
            updatedFormData[field.name] = field.dataType === 'date' ? moment(item[field.name]).format('YYYY-MM-DD') : 
                                          field.dataType === 'time' ? moment(item[field.name], 'HH:mm:ss').format('HH:mm') : 
                                          item[field.name];
        });
        setFormData(updatedFormData);

        const isEmbeddedId = tableConfig[tableName]?.isEmbeddedId;
        if (isEmbeddedId) {
            setEditingItemId({ mainId: item.mainId, embeddedId: item.embeddedId });
        } else {
            setEditingItemId(item.id);
        }
    };

    const handleDeleteItem = async (id) => {
        setErrorMessage('');
        const isEmbeddedId = tableConfig[tableName]?.isEmbeddedId;

        try {
            if (isEmbeddedId) {
                const { mainId, embeddedId } = id;
                await deleteEntityEmbeddedId(tableName, mainId, embeddedId);
            } else {
                await deleteEntity(tableName, id);
            }
            fetchItems();
        } catch (error) {
            setErrorMessage('Error al eliminar el ítem. Por favor, inténtelo de nuevo.');
            console.error('Error al eliminar el ítem:', error);
        }
    };

    const totalPages = Math.ceil(items.length / itemsPerPage);
    const displayedItems = items.slice((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage);

    const handlePageChange = (page) => {
        setCurrentPage(page);
    };

    const fields = tableConfig[tableName]?.fields || [];
    const tableFields = tableConfig[tableName]?.tableFields || [];

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-2xl font-bold mb-4">Gestión de {tableName}</h1>

            {errorMessage && (
                <div className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mb-4" role="alert">
                    {errorMessage}
                </div>
            )}

            <form onSubmit={handleAddOrUpdateItem} className="mb-4">
                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                    {fields.map((field) => (
                        <div key={field.name} className="mb-4">
                            <label className="block text-sm font-medium">
                                {field.label}{field.required && <span className="text-red-500"> *</span>}:
                            </label>
                            <input
                                className="border rounded p-2 w-full"
                                type={field.type}
                                name={field.name}
                                value={formData[field.name] || ''}
                                onChange={handleInputChange}
                                required={field.required}
                            />
                        </div>
                    ))}
                    <div className="flex items-center md:col-span-2">
                        <button
                            type="submit"
                            className="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded w-full"
                        >
                            {editingItemId ? 'Actualizar' : 'Agregar'}
                        </button>
                    </div>
                </div>
            </form>

            <div className="mt-6 overflow-x-auto border border-gray-300 rounded-lg shadow-lg">
                <Table className="w-full text-left border-collapse">
                    <TableHeader>
                        <TableRow>
                            {tableFields.map((field) => (
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
                                {tableFields.map((field) => (
                                    <TableCell key={field.name} className="border-b border-gray-200 p-2">
                                        {field.dataType === 'date' ? moment(item[field.name]).format('YYYY-MM-DD') : 
                                         field.dataType === 'time' ? moment(item[field.name], 'HH:mm:ss').format('HH:mm') : 
                                         item[field.name]}
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
