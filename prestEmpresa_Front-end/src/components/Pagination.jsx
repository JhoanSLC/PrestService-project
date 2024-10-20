import React from 'react';

export default function Pagination({ currentPage, totalPages, onPageChange }) {
    return (
        <div className="flex justify-center space-x-2 mt-4">
            <button
                className={`py-2 px-4 rounded ${currentPage === 1 ? 'bg-gray-300 cursor-not-allowed' : 'bg-blue-500 hover:bg-blue-600 text-white'}`}
                onClick={() => currentPage > 1 && onPageChange(currentPage - 1)}
                disabled={currentPage === 1}
            >
                Anterior
            </button>
            <span className="py-2 px-4">{currentPage} de {totalPages}</span>
            <button
                className={`py-2 px-4 rounded ${currentPage === totalPages ? 'bg-gray-300 cursor-not-allowed' : 'bg-blue-500 hover:bg-blue-600 text-white'}`}
                onClick={() => currentPage < totalPages && onPageChange(currentPage + 1)}
                disabled={currentPage === totalPages}
            >
                Siguiente
            </button>
        </div>
    );
}
