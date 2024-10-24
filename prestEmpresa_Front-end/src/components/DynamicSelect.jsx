import React, { useEffect, useState } from 'react';
import { list } from '../services/serviceDinamico';

const DynamicSelect = ({ field, tableConfig }) => {
    const [options, setOptions] = useState([]);
    const [selectedValue, setSelectedValue] = useState('');

    useEffect(() => {
        const fetchOptions = async () => {
            try {
                const response = await list(field.name); 
                setOptions(response.data);
            } catch (error) {
                console.error('Error fetching options:', error);
            }
        };

        fetchOptions();
    }, [field.name]);

    const handleChange = (e) => {
        setSelectedValue(e.target.value);
    };

    return (
        <select value={selectedValue} onChange={handleChange}>
            <option value="">Seleccione una opción</option>
            {options.map(option => (
                <option key={option.id} value={option.id}>
                    {option.nombre} {/* Muestra el nombre en el select */}
                </option>
            ))}
        </select>
    );
};

export default DynamicSelect;
