import React, { useEffect, useState } from 'react';
import moment from 'moment';
import { motion } from 'framer-motion';
import { create, deleteEntity, list, update } from '../services/serviceDinamico';
import { tableConfig } from '../services/tableConfig';
import Pagination from './Pagination';
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "./ui/Table";
import DynamicSelect from './DynamicSelect';
import { Plus, Edit2, Trash2, Save, X } from 'lucide-react';

export default function DynamicCrud({ tableName }) {
    const [items, setItems] = useState([]);
    const [formData, setFormData] = useState({});
    const [editingItemId, setEditingItemId] = useState(null);
    const [currentPage, setCurrentPage] = useState(1);
    const [errorMessage, setErrorMessage] = useState('');
    const [isFormVisible, setIsFormVisible] = useState(false);
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

    const handleInputChange = (name, value) => {
        setFormData((prev) => ({ ...prev, [name]: value }));
    };

    const handleAddOrUpdateItem = async (e) => {
        e.preventDefault();
        setErrorMessage('');
        try {
            const formattedData = {
                ...formData,
                horaAsignacion: formData.horaAsignacion ? moment(formData.horaAsignacion, 'HH:mm').format('HH:mm:ss') : undefined
            };

            if (editingItemId) {
                await update(tableName, editingItemId, formattedData);
                setEditingItemId(null);
            } else {
                await create(tableName, formattedData);
            }
            fetchItems();
            initializeFormData();
            setIsFormVisible(false);
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
        setEditingItemId(item.id);
        setIsFormVisible(true);
    };

    const handleDeleteItem = async (id) => {
        setErrorMessage('');
        try {
            await deleteEntity(tableName, id);
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

    const formVariants = {
        hidden: { opacity: 0, y: -20 },
        visible: { opacity: 1, y: 0 }
    };

    const tableVariants = {
        hidden: { opacity: 0 },
        visible: { opacity: 1, transition: { staggerChildren: 0.05 } }
    };

    const rowVariants = {
        hidden: { opacity: 0, x: -20 },
        visible: { opacity: 1, x: 0 }
    };

    return (
        <div className="container mx-auto p-4">
            <motion.h1 
                className="text-3xl font-bold mb-6 text-blue-600"
                initial={{ opacity: 0, y: -20 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ duration: 0.5 }}
            >
                Gestión de {tableName}
            </motion.h1>

            {errorMessage && (
                <motion.div 
                    className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mb-4" 
                    role="alert"
                    initial={{ opacity: 0, y: -20 }}
                    animate={{ opacity: 1, y: 0 }}
                    transition={{ duration: 0.5 }}
                >
                    {errorMessage}
                </motion.div>
            )}

            <motion.button
                className="mb-4 bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded flex items-center"
                onClick={() => setIsFormVisible(!isFormVisible)}
                whileHover={{ scale: 1.05 }}
                whileTap={{ scale: 0.95 }}
            >
                {isFormVisible ? <X className="mr-2" /> : <Plus className="mr-2" />}
                {isFormVisible ? 'Cerrar Formulario' : 'Agregar Nuevo'}
            </motion.button>

            {isFormVisible && (
                <motion.form 
                    onSubmit={handleAddOrUpdateItem} 
                    className="mb-8 bg-white p-6 rounded-lg shadow-lg"
                    variants={formVariants}
                    initial="hidden"
                    animate="visible"
                    exit="hidden"
                >
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                        {fields.map((field) => (
                            <div key={field.name} className="mb-4">
                                <label className="block text-sm font-medium text-gray-700 mb-1">
                                    {field.label}:
                                    {field.required && <span className="text-red-500 ml-1">*</span>}
                                </label>
                                {field.type === 'select' ? (
                                    <DynamicSelect 
                                        tableName={field.referencedTable}
                                        onChange={(value) => handleInputChange(field.name, value)}
                                        value={formData[field.name] || ''}
                                        className="w-full p-2 border border-gray-300 rounded-md focus:ring-blue-500 focus:border-blue-500"
                                    />
                                ) : (
                                    <input
                                        className="w-full p-2 border border-gray-300 rounded-md focus:ring-blue-500 focus:border-blue-500"
                                        type={field.type}
                                        name={field.name}
                                        value={formData[field.name] || ''}
                                        onChange={(e) => handleInputChange(field.name, e.target.value)}
                                        required={field.required}
                                    />
                                )}
                            </div>
                        ))}
                    </div>
                    <div className="flex justify-end mt-4">
                        <motion.button
                            type="submit"
                            className="bg-green-500 hover:bg-green-600 text-white font-semibold py-2 px-4 rounded flex items-center"
                            whileHover={{ scale: 1.05 }}
                            whileTap={{ scale: 0.95 }}
                        >
                            <Save className="mr-2" />
                            {editingItemId ? 'Actualizar' : 'Agregar'}
                        </motion.button>
                    </div>
                </motion.form>
            )}

            <motion.div 
                className="mt-6 overflow-x-auto border border-gray-300 rounded-lg shadow-lg"
                variants={tableVariants}
                initial="hidden"
                animate="visible"
            >
                <Table className="w-full text-left border-collapse">
                    <TableHeader>
                        <TableRow>
                            {tableFields.map((field) => (
                                <TableHead key={field.name} className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-3">
                                    {field.label}
                                </TableHead>
                            ))}
                            <TableHead className="bg-gray-100 text-gray-700 border-b-2 border-gray-300 p-3">Acciones</TableHead>
                        </TableRow>
                    </TableHeader>
                    <TableBody>
                        {displayedItems.map((item) => (
                            <motion.tr 
                                key={item.id} 
                                className="hover:bg-gray-50 transition"
                                variants={rowVariants}
                            >
                                {tableFields.map((field) => (
                                    <TableCell key={field.name} className="border-b border-gray-200 p-3">
                                        {field.dataType === 'date' ? moment(item[field.name]).format('YYYY-MM-DD') : 
                                         field.dataType === 'time' ? moment(item[field.name], 'HH:mm:ss').format('HH:mm') : 
                                         item[field.name]}
                                    </TableCell>
                                ))}
                                <TableCell className="border-b border-gray-200 p-3">
                                    <motion.button
                                        className="mr-2 bg-yellow-500 hover:bg-yellow-600 text-white font-semibold py-1 px-3 rounded flex items-center"
                                        onClick={() => handleEditItem(item)}
                                        whileHover={{ scale: 1.05 }}
                                        whileTap={{ scale: 0.95 }}
                                    >
                                        <Edit2 className="mr-1 h-4 w-4" />
                                        Editar
                                    </motion.button>
                                    <motion.button
                                        className="bg-red-500 hover:bg-red-600 text-white font-semibold py-1 px-3 rounded flex items-center"
                                        onClick={() => handleDeleteItem(item.id)}
                                        whileHover={{ scale: 1.05 }}
                                        whileTap={{ scale: 0.95 }}
                                    >
                                        <Trash2 className="mr-1 h-4 w-4" />
                                        Eliminar
                                    </motion.button>
                                </TableCell>
                            </motion.tr>
                        ))}
                    </TableBody>
                </Table>
            </motion.div>

            <Pagination
                currentPage={currentPage}
                totalPages={totalPages}
                onPageChange={handlePageChange}
            />
        </div>
    );
}