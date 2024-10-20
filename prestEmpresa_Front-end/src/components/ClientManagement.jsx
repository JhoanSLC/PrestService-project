import React, { useState } from 'react'
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "./ui/Table"
import { Input } from "./ui/Input"
import { Button } from "./ui/Button"

export default function ClientManagement() {
    const [clients, setClients] = useState([
        { id: 1, name: "Empresa A", email: "contacto@empresaa.com", phone: "123-456-7890" },
        { id: 2, name: "Empresa B", email: "info@empresab.com", phone: "098-765-4321" },
        { id: 3, name: "Empresa C", email: "ventas@empresac.com", phone: "555-555-5555" },
    ])

    const [newClient, setNewClient] = useState({ name: '', email: '', phone: '' })

    const handleInputChange = (e) => {
        const { name, value } = e.target
        setNewClient(prev => ({ ...prev, [name]: value }))
    }

    const handleAddClient = () => {
        setClients(prev => [...prev, { ...newClient, id: Date.now() }])
        setNewClient({ name: '', email: '', phone: '' })
    }

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-2xl font-bold mb-4">Gestión de Clientes</h1>

            <div className="mb-4 flex space-x-2">
                <Input
                    type="text"
                    name="name"
                    value={newClient.name}
                    onChange={handleInputChange}
                    placeholder="Nombre del cliente"
                />
                <Input
                    type="email"
                    name="email"
                    value={newClient.email}
                    onChange={handleInputChange}
                    placeholder="Email"
                />
                <Input
                    type="tel"
                    name="phone"
                    value={newClient.phone}
                    onChange={handleInputChange}
                    placeholder="Teléfono"
                />
                <Button onClick={handleAddClient}>Agregar Cliente</Button>
            </div>

            <Table>
                <TableHeader>
                    <TableRow>
                        <TableHead>ID</TableHead>
                        <TableHead>Nombre</TableHead>
                        <TableHead>Email</TableHead>
                        <TableHead>Teléfono</TableHead>
                    </TableRow>
                </TableHeader>
                <TableBody>
                    {clients.map((client) => (
                        <TableRow key={client.id}>
                            <TableCell>{client.id}</TableCell>
                            <TableCell>{client.name}</TableCell>
                            <TableCell>{client.email}</TableCell>
                            <TableCell>{client.phone}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </div>
    )
}