<template>
  <div class="row">
    <div class="card col-md-8">
      <div v-if="!livroSelecionado">
        <div class="card-header">LISTA DE LIVROS</div>
        <ul class="list-group list-group-flush">
          <li
            v-for="livro in livros"
            :key="livro.id"
            class="list-group-item list-group-item-action"
            :class="{ 'active': livroSelecionado === livro }"
          >
            <a @click="selecionarLivro(livro)">
              <span>{{ livro.titulo }}</span>
            </a>
          </li>
        </ul>
        <div class="notification" v-show="mensagem">{{ mensagem }}</div>
      </div>
      <div v-if="livroSelecionado">
        <LivroDetalhe :livro="livroSelecionado"/>
        <div class="card-header">{{tituloDisponibilidade}}</div>
        <form>
          <div class="form-group">
            <label for="id">Id</label>
            <input type="text" class="form-control" id="id" disabled :value="livroSelecionado.id" />
          </div>
          <div class="form-group">
            <label for="titulo">Título</label>
            <input
              type="text"
              class="form-control"
              id="idTitulo"
              :value="livroSelecionado.titulo"
            />
          </div>
          <div class="form-group">
            <label for="dataPublicacao">Data da Publicação</label>
            <input
              type="date"
              class="form-control"
              id="dataPublicacao"
              v-model="livroSelecionado.dataPublicacao"
            />
            <label>Data longa: {{ livroSelecionado.dataPublicacao | formatDate}}</label>
          </div>
          <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="mostrar" v-model="mostrarMais" />
            <label for="mostrar" class="form-check-label">Mostrar Mais Campos</label>
          </div>
          <div class="form-group" v-show="mostrarMais">
            <label for="preco">Preço</label>
            <input type="number" class="form-control" id="preco" v-model="livroSelecionado.preco" />
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
          <footer class="card-footer">
            <button class="btn btn-secondary botoes" @click="cancelarLivro()">
              <i class="fas fa-undo"></i>
              <span>Cancelar</span>
            </button>
            <button class="btn btn-primary botoes" @click="salvarLivro()">
              <i class="fas fa-save"></i>
              <span>Salvar</span>
            </button>
          </footer>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import { LivroDetalhe } from '@/components/livro-detalhe.vue'
import { format } from "date-fns";

const inputDateFormat = "yyyy-MM-dd";
const nossosLivros = [
  {
    id: 19,
    titulo: "Spring Boot in Action",
    dataPublicacao: format(new Date(2020, 8, 1), inputDateFormat),
    preco: 500,
    numeroPaginas: 159,
    autores: ["Autor 3"],
    disponivel: true
  },
  {
    id: 20,
    titulo: "Java Como Programar",
    dataPublicacao: format(new Date(2000, 3, 8), inputDateFormat),
    preco: 50,
    numeroPaginas: 300,
    autores: ["Autor 1", "Autor 2"],
    disponivel: true
  },
  {
    id: 21,
    titulo: "C Como Programar",
    dataPublicacao: format(new Date(2000, 11, 8), inputDateFormat),
    preco: 50,
    numeroPaginas: 300,
    autores: ["Autor 4"],
    disponivel: false
  },
  {
    id: 22,
    titulo: "Vue JS Handbook",
    dataPublicacao: format(new Date(2020, 3, 8), inputDateFormat),
    preco: 500,
    numeroPaginas: 300,
    autores: ["Autor 5", "Autor 6"],
    disponivel: true
  }
];
export default {
  name: "ListaLivrosPai",
  data() {
    return {
      livroSelecionado: undefined,
      mostrarMais: false,
      livros: [],
      mensagem: "",
      mensagemPreco: ""
    };
  },
  components: {
      LivroDetalhe
  },
  computed: {
    tituloDisponibilidade() {
      return `${this.livroSelecionado.titulo} - ${
        this.livroSelecionado.disponivel ? "Disponível" : "Indisponível"
      }`;
    }
  },
  created() {
    this.carregarLivros();
  },
  methods: {
    async getLivros() {
      return new Promise(resolve => {
        setTimeout(() => resolve(nossosLivros), 1500);
      });
    },
    async carregarLivros() {
      this.livros = [];
      this.mensagem = "Obtendo os livros. Por favor aguarde...";
      this.livros = await this.getLivros();
      this.mensagem = "";
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
    salvarLivro() {
      const index = this.livros.findIndex(l => l.id === this.livroSelecionado.id);
      this.livros.splice(index, 1, this.livroSelecionado);
      this.livros = [...this.livros];
      this.livroSelecionado = undefined;
    },
    cancelarLivro() {
      this.livroSelecionado = undefined;
    },
    selecionarLivro(livro) {
      this.livroSelecionado = livro;
    },
  },
  watch: {
    "livroSelecionado.preco": {
      immediate: false,
      handler(valorNovo, valorAntigo) {
        console.log(
          `Watcher avaliado. antigo=${valorAntigo}, novo=${valorNovo}`
        );
        this.processaMudancaPreco(valorAntigo, valorNovo);
      }
    }
  }
};
</script>

<style scoped>
li a {
  cursor: pointer;
}
.card-header {
  text-transform: uppercase;
  font-weight: bold;
}
.notification {
  background-color: blue;
  color: white;
  font-size: 16px;
  line-height: 30px;
}
.botoes {
  width: 120px;
  margin-right: 20px;
}
</style>