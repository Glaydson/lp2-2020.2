<template>
  <div class="card" style="width: 20rem">
    <div class="card-header">LISTA DE LIVROS</div>
    <ul class="list-group list-group-flush">
      <li v-for="livro in livros" :key="livro.id" 
        class="list-group-item list-group-item-action"
        :class="{ 'active': livroSelecionado === livro }">
        <a @click="livroSelecionado = livro">
          <span>{{ livro.titulo }}</span>
        </a>
      </li>
    </ul>
    <div class="notification" v-show="mensagem">{{mensagem}}</div>
    <div v-if="livroSelecionado">
        <div class="card-header">{{tituloDisponibilidade}}</div>
        <form>
        <div class="form-group">
            <label for="id">Id</label>
            <input
            type="text"
            class="form-control"
            id="id"
            disabled
            :value="livroSelecionado.id"
            />
        </div>
        <div class="form-group">
            <label for="titulo">Título</label>
            <input
            type="text"
            class="form-control"
            id="id"
            disabled
            :value="livroSelecionado.titulo"
            />
        </div>
        <div class="form-group">
            <label for="dataPublicacao">Data da Publicação</label>
            <input
            type="text"
            class="form-control"
            id="dataPublicacao"
            disabled
            :value="livroSelecionado.dataPublicacao"
            />
        </div>
        
        <div class="form-group form-check">
          <input type="checkbox" class="form-check-input" id="mostrar" v-model="mostrarMais" />
          <label for="mostrar" class="form-check-label">Mostrar Mais Campos</label>
        </div>

        <div class="form-group" v-show="mostrarMais">
          <label for="preco">Preço</label>
          <input type="number" class="form-control" id="preco" 
            v-model="livroSelecionado.preco" />
          <label>{{mensagemPreco}}</label>
        </div>

        <div class="form-group" v-show="mostrarMais">
            <label for="autores">Autor(es)</label>
            <input
            type="text"
            class="form-control"
            id="autores"
            disabled
            :value="livroSelecionado.autores"
            />
        </div>
        </form>
    </div>
  </div>
</template>
<script>
const nossosLivros = [
    {
        id: 20,
        titulo: "Java Como Programar",
        dataPublicacao: "2000-03-08",
        preco: 50,
        numeroPaginas: 300,
        autores: ["Autor 1", "Autor 2"],
        disponivel: true
    },
    {
        id: 21,
        titulo: "Vue.JS Framework",
        dataPublicacao: "2020-10-08",
        preco: 150,
        numeroPaginas: 300,
        autores: ["Autor 3", "Autor 4"],
        disponivel: false
    },
    {
        id: 22,
        titulo: "C Como Programar",
        dataPublicacao: "2018-11-08",
        preco: 100,
        numeroPaginas: 600,
        autores: ["Autor 1"],        
        disponivel: true
    }
]
export default {
    name: "ListaLivros",
    data() {
        return {
           livros: [],
           livroSelecionado: undefined,
           mostrarMais: false,
           mensagem: '',
           mensagemPreco: '',
        }
    },
    created () {
        this.carregarLivros();
    },
    methods: {
        async getLivros() {
            return new Promise(resolve => {
                setTimeout(() => resolve(nossosLivros), 2500);
            });
        },
        async carregarLivros() {
            this.livros = [];
            this.mensagem = 'Obtendo os livros. Por favor aguarde...';
            this.livros = await this.getLivros();
            this.mensagem = '';
        },   
        processaMudancaPreco(valorAntigo, valorNovo) {
            if (valorAntigo == undefined) {
                this.mensagemPreco = "";
        } else {
            if (valorAntigo > valorNovo) {
                this.mensagemPreco = "O preço caiu";
                } else this.mensagemPreco = "O preço subiu";
            }
        },
    },
    computed: {
        tituloDisponibilidade() {
            return `${this.livroSelecionado.titulo} - ${
                        this.livroSelecionado.disponivel ? "Disponível" : "Indisponível"
                }`;
        }
    },
    watch: {
      "livroSelecionado.preco": {
      immediate: false,
      handler(valorNovo, valorAntigo) {
        console.log(`Watcher avaliado. antigo=${valorAntigo}, novo=${valorNovo}`);
        this.processaMudancaPreco(valorAntigo, valorNovo);
      }
    }

    },
}
</script>
<style scoped>

</style>