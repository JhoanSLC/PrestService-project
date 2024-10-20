import axios from "axios";

const REST_API_PERSONA_URL = 'http://localhost:1402/api/persona';


export const authenticate = async (usuario, contraseña) => {
    const response = await axios.get(`${REST_API_PERSONA_URL}`);
    const personas = response.data;


    const user = personas.find(persona => persona.usuario === usuario && persona.contraseña === contraseña);

    if (!user) {
        throw new Error('Usuario o contraseña incorrectos');
    }

    const tipoPersonaResponse = await axios.get(`http://localhost:1402/api/tipoPersona/${user.tipoPersonaId}`);
    const tipoPersona = tipoPersonaResponse.data;

    return {
        ...user,
        tipoPersona: tipoPersona.nombre
    };
};
