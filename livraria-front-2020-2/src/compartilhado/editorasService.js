import * as axios from 'axios';

const APIBASE = 'http://localhost:8081/apilivros/editoras';

const getEditoras = async function () {
    const resposta = await axios.get(`${APIBASE}/todos`);
    const editoras = resposta.data;
    return editoras;
}

export const dadosEditoras = {
    getEditoras
}
