import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:1402/api/estadoOrdenServicio';

export const list = () => axios.get(REST_API_BASE_URL);

export const create = (entidad) => axios.post(REST_API_BASE_URL, entidad);

export const get = (id) => axios.get(REST_API_BASE_URL + '/' + id);

export const update = (id, entidad) => axios.put(REST_API_BASE_URL + '/' + id, entidad);

export const deleteEntity = (id) => axios.delete(REST_API_BASE_URL + '/' + id);