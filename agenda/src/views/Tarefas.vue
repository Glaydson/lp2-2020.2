<template>
    <div>
        <H1>{{titulo}}</H1>
        <div id="lista">
            <ul v-if="tarefas">
                <li v-for="tarefa in tarefas" :key="tarefa.id">
                    {{tarefa.nome}} - 
                    <span v-if="tarefa.concluida">Concluída</span>
                    <span v-else>A Concluir</span>
                </li>
            </ul>
            <div v-else><p>Não há tarefas</p></div>
        </div>
        <button type="button" @click="criarTarefa">Criar Tarefa</button>
    </div>
</template>
<script>
import { dadosTarefas } from '../servico/tarefas';
export default {
    name: 'Tarefas',
    data() {
        return {
            titulo: 'Lista de Tarefas',
            tarefas: [],
        }
    },
    created() {
        this.obterTarefas();
    },
    methods: {
        criarTarefa() {
            this.$router.push('/criarTarefa')
        },
        obterTarefas() {
            this.tarefas = dadosTarefas.getTarefas();
        },
    },
}
</script>
<style scoped>
H1 {
    text-align: left;
}
#lista {
    text-align: left;
}
</style>