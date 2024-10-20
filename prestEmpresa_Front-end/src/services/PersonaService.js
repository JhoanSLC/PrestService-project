import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:1402/api/persona';

export const list = () => axios.get(REST_API_BASE_URL);

export const create = (persona) => axios.post(REST_API_BASE_URL, persona);

export const get = (personaId) => axios.get(REST_API_BASE_URL + '/' + personaId);

export const update = (personaId, persona) => axios.put(REST_API_BASE_URL + '/' + personaId, persona);

export const deleteEntity = (personaId) => axios.delete(REST_API_BASE_URL + '/' + personaId);

