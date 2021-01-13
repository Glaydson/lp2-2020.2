<template>
    <div>
        <h1>Criar Nova Tarefa</h1>
        <div class="card-header">
            <form>
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text"
                    class="form-control"
                    id="nome"
                    v-model="tarefa.nome"/>
                </div>
                <div class="form-group">
                    <label for="dataConclusao">Data de Conclusão</label>
                    <input type="date"
                    class="form-control"
                    id="dataConclusao"
                    v-model="tarefa.dataConclusao"/>
                </div>
                <footer>
                    <div class="card-footer">
                        <button class="btn btn-primary botoes" @click="salvarTarefa">
                            <span>Salvar</span>
                        </button>
                        <button class="btn btn-secondary botoes" @click="cancelar">
                            <span>Cancelar</span>
                        </button>
                    </div>
                </footer>
            </form>
        </div>
    </div>
</template>
<script>
import { dadosTarefas } from '../servico/tarefas'
export default {
    name: 'CriarTarefaForm',
    data() {
        return {
            tarefa: {}
        }
    },
    methods: {
        salvarTarefa() {
            dadosTarefas.salvar(this.tarefa);
            alert("Tarefa Criada!")
            this.$router.push('/tarefas')
        },
        cancelar() {
            this.$router.push('/tarefas')
        }
    },
}
</script>
<style scoped>
.botoes {
    margin-right: 20px;
    width: 100px;
}
</style>