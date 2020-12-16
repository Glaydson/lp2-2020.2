import * as axios from 'axios';

import { format } from "date-fns";
import moment from 'moment';
const inputDateFormat = "yyyy-MM-dd";
const APIBASE = 'http://localhost:8081/apilivros/livros';

const getLivros = async function () {
    const resposta = await axios.get(`${APIBASE}/todos`);
    const livros = resposta.data.map(l => {
        moment.locale('pt-BR');
        // Inicializa a data corretamente usando moment
        const data = moment(l.dataPublicacao, "DD-MM-YYYY");
        // Formata a data para exibição no campo, usando date-fns
        l.dataPublicacao = format(new Date(data), inputDateFormat);
        return l;
    });
    return livros;
}

const atualizarLivro = async function (livro) {
    const uri = `${APIBASE}/atualiza/${livro.livroID}`;
    const resposta = await axios.put(uri, JSON.stringify(livro), {
              headers: {
                  'Content-type': 'application/json'
              }
    });
    console.log(resposta);
}

const removerLivro = async function(livro) {
    
    const uri = `${APIBASE}/delete/${livro.livroID}`;
    console.log(JSON.stringify(livro))
    alert(uri)
    
    const resposta = await axios.delete(uri, {
        headers: {
            'Content-type': 'application/json'
        }
    });
   
    
    console.log(resposta);
}


export const dadosLivros = {
    getLivros, atualizarLivro, removerLivro
}

  