import React, { useEffect, useState } from 'react';
import { list } from '../services/serviceDinamico';

const DynamicSelect = ({ tableName, onChange }) => {
    const [options, setOptions] = useState([]);
    const [selectedValue, setSelectedValue] = useState('');

    useEffect(() => {
        const fetchOptions = async () => {
            try {
                const response = await list(tableName); 
                setOptions(response.data);
            } catch (error) {
                console.error('Error fetching options:', error);
            }
        };

        fetchOptions();
    }, [tableName]);

    const handleChange = (e) => {
        const value = e.target.value;
        setSelectedValue(value);
        onChange(value);
    };

    return (
        <select 
            value={selectedValue} 
            onChange={handleChange} 
            className="border border-gray-300 rounded-lg p-2 w-full bg-white text-gray-700 focus:outline-none focus:ring focus:ring-blue-300"
            required
        >
            <option value="">Seleccione una opción</option>
            {options.map(option => (
                <option key={option.id} value={option.id}>
                    {option.nombre}
                </option>
            ))}
        </select>
    );
};

export default DynamicSelect;
