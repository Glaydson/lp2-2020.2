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
      <!-- Edição de um livro -->
      <EditarLivroForm 
          v-if="livroSelecionado" 
          :livro="livroSelecionado"
          :todosAutores="autores"
          :todasEditoras="editoras"
          @atualizar="atualizarLivro"
          @cancelar="cancelarEdicao" />
    </div>
  </div>
</template>

<script>
import EditarLivroForm from "@/components/editar-livro-form.vue";
import { format } from "date-fns";
import { dadosLivros } from "../compartilhado/livroService";
import { dadosAutores } from "../compartilhado/autoresService";
import { dadosEditoras } from "../compartilhado/editorasService";

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
      livros: [],
      autores: [],
      editoras: [],
      mensagem: "",
  
    };
  },
  components: {
      EditarLivroForm
  },
  
  async created() {
    await this.carregarLivros();
    await this.carregarAutores();
    await this.carregarEditoras();
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
      this.livros = await dadosLivros.getLivros();
      this.mensagem = "";
    },
    async carregarAutores() {
      this.autores = await dadosAutores.getAutores();
    },
    async carregarEditoras() {
      this.editoras = await dadosEditoras.getEditoras();
    },
    salvarLivro(livro) {
      const index = this.livros.findIndex(l => l.id === livro.id);
      console.log(livro);
      setTimeout(5000);
      this.livros.splice(index, 1, this.livro);
      this.livros = [...this.livros];
      this.livroSelecionado = undefined;
    },
    cancelarEdicao() {
      this.livroSelecionado = undefined;
    },
    selecionarLivro(livro) {
      this.livroSelecionado = livro;
    },
  },
  
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