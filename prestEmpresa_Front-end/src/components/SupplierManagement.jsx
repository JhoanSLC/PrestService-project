import React, { useState } from 'react'
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "./ui/Table"
import { Input } from './ui/Input'
import { Button } from './ui/Button'

export default function SupplierManagement() {
    const [suppliers, setSuppliers] = useState([
        { id: 1, name: "Proveedor A", contact: "Juan Pérez", email: "juan@proveedora.com", phone: "123-456-7890" },
        { id: 2, name: "Proveedor B", contact: "María García", email: "maria@proveedorb.com", phone: "098-765-4321" },
        { id: 3, name: "Proveedor C", contact: "Carlos Rodríguez", email: "carlos@proveedorc.com", phone: "555-555-5555" },
    ])

    const [newSupplier, setNewSupplier] = useState({ name: '', contact: '', email: '', phone: '' })

    const handleInputChange = (e) => {
        const { name, value } = e.target
        setNewSupplier(prev => ({ ...prev, [name]: value }))
    }

    const handleAddSupplier = () => {
        setSuppliers(prev => [...prev, { ...newSupplier, id: Date.now() }])
        setNewSupplier({ name: '', contact: '', email: '', phone: '' })
    }

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-2xl font-bold mb-4">Gestión de Proveedores</h1>

            <div className="mb-4 flex space-x-2">
                <Input
                    type="text"
                    name="name"
                    value={newSupplier.name}
                    onChange={handleInputChange}
                    placeholder="Nombre del proveedor"
                />
                <Input
                    type="text"
                    name="contact"
                    value={newSupplier.contact}
                    onChange={handleInputChange}
                    placeholder="Nombre de contacto"
                />
                <Input
                    type="email"
                    name="email"
                    value={newSupplier.email}
                    onChange={handleInputChange}
                    placeholder="Email"
                />
                <Input
                    type="tel"
                    name="phone"
                    value={newSupplier.phone}
                    onChange={handleInputChange}
                    placeholder="Teléfono"
                />
                <Button onClick={handleAddSupplier}>Agregar Proveedor</Button>
            </div>

            <Table>
                <TableHeader>
                    <TableRow>
                        <TableHead>ID</TableHead>
                        <TableHead>Nombre</TableHead>
                        <TableHead>Contacto</TableHead>
                        <TableHead>Email</TableHead>
                        <TableHead>Teléfono</TableHead>
                    </TableRow>
                </TableHeader>
                <TableBody>
                    {suppliers.map((supplier) => (
                        <TableRow key={supplier.id}>
                            <TableCell>{supplier.id}</TableCell>
                            <TableCell>{supplier.name}</TableCell>
                            <TableCell>{supplier.contact}</TableCell>
                            <TableCell>{supplier.email}</TableCell>
                            <TableCell>{supplier.phone}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </div>
    )
}