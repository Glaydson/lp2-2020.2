import * as axios from 'axios';

const APIBASE = 'http://localhost:8081/apilivros/autores';

const getAutores = async function () {
    const resposta = await axios.get(`${APIBASE}/todos`);
    const autores = resposta.data;
    return autores;
}

export const dadosAutores = {
    getAutores
}
