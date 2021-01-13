var tarefas = [
    {
        id: 1,
        nome: 'Dormir',
        dataConclusao: '2021-01-13',
        concluida: false
    },
    {
        id: 2,
        nome: 'Comer',
        dataConclusao: '2021-01-12',
        concluida: true
    },
]

const getTarefas = function() {
    return tarefas;
}

const salvar = function(tarefa) {
    tarefas.push(tarefa);
}

export const dadosTarefas = {
    getTarefas, salvar
}