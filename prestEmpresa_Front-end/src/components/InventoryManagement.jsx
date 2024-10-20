import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "./ui/Table";
import { Input } from "./ui/Input";
import { Button } from "./ui/Button";

export default function InventoryManagement() {
    const [inventory, setInventory] = useState([
        { id: 1, name: "Producto A", quantity: 100, price: 10.99 },
        { id: 2, name: "Producto B", quantity: 50, price: 20.50 },
        { id: 3, name: "Producto C", quantity: 75, price: 15.75 },
    ]);

    const [newItem, setNewItem] = useState({ name: '', quantity: 0, price: 0 });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewItem(prev => ({ ...prev, [name]: name === 'name' ? value : Number(value) }));
    };

    const handleAddItem = () => {
        setInventory(prev => [...prev, { ...newItem, id: Date.now() }]);
        setNewItem({ name: '', quantity: 0, price: 0 });
    };

    return (
        <div className="container mx-auto p-6">
            <h1 className="text-3xl font-bold mb-6 text-center">Gestión de Inventario</h1>

            <div className="mb-6 flex flex-col md:flex-row md:space-x-4">
                <Input
                    type="text"
                    name="name"
                    value={newItem.name}
                    onChange={handleInputChange}
                    placeholder="Nombre del producto"
                    className="flex-1 p-2 border border-gray-300 rounded-md"
                />
                <Input
                    type="number"
                    name="quantity"
                    value={newItem.quantity}
                    onChange={handleInputChange}
                    placeholder="Cantidad"
                    className="flex-1 p-2 border border-gray-300 rounded-md"
                />
                <Input
                    type="number"
                    name="price"
                    value={newItem.price}
                    onChange={handleInputChange}
                    placeholder="Precio"
                    className="flex-1 p-2 border border-gray-300 rounded-md"
                />
                <Button onClick={handleAddItem} className="bg-blue-500 text-white p-2 rounded-md hover:bg-blue-600 transition-colors">
                    Agregar Producto
                </Button>
            </div>

            <Table className="min-w-full bg-white shadow-md rounded-lg overflow-hidden">
                <TableHeader>
                    <TableRow className="bg-gray-200">
                        <TableHead className="px-4 py-2 text-left">ID</TableHead>
                        <TableHead className="px-4 py-2 text-left">Nombre</TableHead>
                        <TableHead className="px-4 py-2 text-left">Cantidad</TableHead>
                        <TableHead className="px-4 py-2 text-left">Precio</TableHead>
                    </TableRow>
                </TableHeader>
                <TableBody>
                    {inventory.map((item) => (
                        <TableRow key={item.id} className="hover:bg-gray-100">
                            <TableCell className="px-4 py-2 border-b">{item.id}</TableCell>
                            <TableCell className="px-4 py-2 border-b">{item.name}</TableCell>
                            <TableCell className="px-4 py-2 border-b">{item.quantity}</TableCell>
                            <TableCell className="px-4 py-2 border-b">${item.price.toFixed(2)}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </div>
    );
}
