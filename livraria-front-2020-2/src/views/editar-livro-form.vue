<template>
  <div>
    <div class="card-header">{{ tituloPagina | upperCase }}</div>
    <form v-on:submit.prevent>
      <div class="form-group">
        <label for="id">Id</label>
        <input
          type="text"
          class="form-control"
          id="id"
          disabled
          :value="livro.livroID"
        />
      </div>
      <div class="form-group">
        <label for="titulo">Título</label>
        <input
          type="text"
          class="form-control"
          id="idTitulo"
          v-model="livro.titulo"
        />
      </div>
      <div class="form-group">
        <label for="dataPublicacao">Data da Publicação</label>
        <input
          type="date"
          class="form-control"
          id="dataPublicacao"
          v-model="livro.dataPublicacao"
        />
      </div>

      <div class="form-group">
        <label for="numeroPaginas">Número de Páginas</label>
        <input type="number"
          class="form-control" id="numeroPaginas" v-model="livro.numeroPaginas" />
      </div>

      <div class="form-group">
        <label for="preco">Preço</label>
        <input
          type="number"
          class="form-control"
          id="preco"
          v-model="livro.preco"
        />
      </div>
      <div class="form-group">
        <label for="autores">Autores</label>
        <select
          multiple
          class="form-control"
          id="autores"
          v-model="livro.autores"
        >
          <option
            v-for="autor in autores"
            :key="autor.autorID"
            :value="autor.autorID"
          >
            {{ autor.nome }}
          </option>
        </select>
      </div>
      <div class="form-group">
        <label for="editora">Editora</label>
        <select
          class="form-control"
          :name="livro.editora"
          id="editora"
          v-model="livro.editora.editoraID">
          <option
            v-for="editora in editoras"
            :key="editora.editoraID"
            :value="editora.editoraID">
            {{ editora.nome }}
          </option>
        </select>
      </div>
      <footer class="card-footer">
        <button class="btn btn-secondary botoes" @click="cancelarEdicao()">
          <i class="fas fa-undo"></i>
          <span>Cancelar</span>
        </button>
        <button class="btn btn-primary botoes" @click="atualizarLivro()">
          <i class="fas fa-save"></i>
          <span>Salvar</span>
        </button>
        <button class="btn btn-secondary botoes" @click="removerLivro()">
          <i class="fas fa-trash"></i>
          <span>Remover</span>
        </button>
      </footer>
    </form>
  </div>
</template>

<script>
import { dadosLivros } from "../compartilhado/livroService";
import { dadosAutores } from "../compartilhado/autoresService";
import { dadosEditoras } from "../compartilhado/editorasService";
// Cria um objeto autor para ser usado no momento de atualizar/salvar um livro
var Autor = function (autorID) {
  this.autorID = autorID;
};
export default {
  name: "EditarLivroForm",
  props: {
    id: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      livro: {},
      autores: [],
      editoras: [],
      mensagemSucesso: "",
    };
  },
  async created() {
    if (this.id != 0) {
      await this.obterLivro(this.id);
      //this.autores = await dadosAutores.getAutores();
      //this.editoras = await dadosEditoras.getEditoras();
      this.tituloPagina = this.livro.titulo;
    } else {  //id = 0
      this.inicializaLivro();
      this.tituloPagina = "NOVO LIVRO";
    }
    await this.obterAutores();
    await this.obterEditoras();
  },
  methods: {
    async obterLivro(id) {
      try {
        this.livro = await dadosLivros.getLivro(id);
        // transforma o array de autores em um array de IDs dos autores
        var autoresIDs = this.livro.autores.map(function (autor) {
          return autor.autorID;
        });
        this.livro.autores = autoresIDs;
      } catch (error) {
          this.mensagemErro = error.message;
          alert(this.mensagemErro);
          this.$router.push('/listaLivros');
      }
    },
    async obterAutores() {
      this.autores = await dadosAutores.getAutores();
    },
    async obterEditoras() {
      this.editoras = await dadosEditoras.getEditoras();
    },
    async atualizarLivro() {
      if (this.livro) {
        // transforma o array de ids em um array de objetos, cada um com o autorID
        const autoresLivro = [];
        this.livro.autores.forEach(autor => {
            autoresLivro.push(new Autor(autor));
        });
        this.livro.autores = autoresLivro;
        if (this.livro.livroID) {  // livro existente em atualização
          await dadosLivros.atualizarLivro(this.livro);
          this.mensagemSucesso = `${this.livro.titulo} Atualizado`; 
          } else {  // não tem ID, é livro novo
            await dadosLivros.salvarLivro(this.livro);
            this.mensagemSucesso = `${this.livro.titulo} Criado`; 
          }
          alert(this.mensagemSucesso);        
        }  
        this.$router.push('/listaLivros');
    },
    cancelarEdicao() {
      this.$router.push('/listaLivros');
    },
    async removerLivro() {
      if (confirm(`Deseja remover ${this.livro.titulo}?`)) {
        const resposta = await dadosLivros.removerLivro(this.livro);
        console.log(resposta);
        this.mensagemSucesso = `${this.livro.titulo} Removido`;
        alert(this.mensagemSucesso);
      }
      this.$router.push('/listaLivros');
    },
      inicializaLivro() {
        this.livro.titulo = "";
        this.livro.dataPublicacao = "";
        this.livro.preco = "";
        this.livro.numeroPaginas = "";
        this.livro.autores = [];
        this.livro.editora = {};
    },
  },
};
</script>

<style scoped>
.botoes {
  width: 120px;
  margin-right: 20px;
}
</style>