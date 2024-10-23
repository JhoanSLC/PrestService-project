import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:1402/api';

export const list = (entidadUrl) => axios.get(`${REST_API_BASE_URL}/${entidadUrl}`);

export const create = (entidadUrl, data) => axios.post(`${REST_API_BASE_URL}/${entidadUrl}`, data);

export const get = (entidadUrl, id) => axios.get(`${REST_API_BASE_URL}/${entidadUrl}/${id}`);

export const update = (entidadUrl,id, data) => axios.put(`${REST_API_BASE_URL}/${entidadUrl}/${id}`, data);

export const deleteEntity = (entidadUrl,id) => axios.delete(`${REST_API_BASE_URL}/${entidadUrl}/${id}`);