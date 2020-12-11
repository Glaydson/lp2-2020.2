<template>
  <div>
    <div class="card-header">{{tituloDisponibilidade}}</div>
    <form>
      <div class="form-group">
        <label for="id">Id</label>
        <input type="text" class="form-control" id="id" disabled :value="livroClonado.livroID" />
      </div>
      <div class="form-group">
        <label for="titulo">Título</label>
        <input type="text" class="form-control" id="idTitulo" v-model="livroClonado.titulo" />
      </div>
      <div class="form-group">
        <label for="dataPublicacao">Data da Publicação</label>
        <input
          type="date"
          class="form-control"
          id="dataPublicacao"
          v-model="livroClonado.dataPublicacao"
        />
      </div>
      <div class="form-group">
        <label for="preco">Preço</label>
        <input type="number" class="form-control" id="preco" v-model="livroClonado.preco" />
        <label>{{mensagemPreco}}</label>
      </div>
      <div class="form-group">
        <label for="autores">Autores</label>
        <select multiple class="form-control" id="autores" v-model="livroClonado.autores">
          <option
            v-for="autor in autores"
            :key="autor.autorID"
            :value="autor.autorID"
          >{{autor.nome}}</option>
        </select>
      </div>
      <div class="form-group">
        <label for="editora">Editora</label>
        <select
          class="form-control"
          :name="livroClonado.editora"
          id="editora"
          v-model="livroClonado.editora.editoraID"
        >
          <option
            v-for="editora in editoras"
            :key="editora.editoraID"
            :value="editora.editoraID"
          >{{editora.nome}}</option>
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
export default {
  name: "EditarLivroForm",
  props: {
    livro: {
      type: Object,
      default: () => {}
    },
    todosAutores: {
      type: Array,
      default: () => []
    },
    todasEditoras: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      mensagemPreco: "",
      livroClonado: { ...this.livro },
    };
  },
  created () {
    // transforma o array de autores em um array de IDs dos autores
      var autoresIDs = this.livroClonado.autores.map(function (autor) {
          return autor.autorID;
      })
      this.livroClonado.autores = autoresIDs; 
  },
  computed: {
    tituloDisponibilidade() {
      return `${this.livroClonado.titulo}`;
    },
    autores() {
      return this.todosAutores;
    },
    editoras() {
      return this.todasEditoras;
    }
  },
  methods: {
    atualizarLivro() {
      this.$emit("atualizar", this.livroClonado);
    },
    cancelarEdicao() {
      this.$emit("cancelar");
    },
    removerLivro() {
      this.$emit("remover", this.livroClonado);
    },
    processaMudancaPreco(valorAntigo, valorNovo) {
      if (valorAntigo == undefined) {
        this.mensagemPreco = "";
      } else {
        if (valorAntigo > valorNovo) {
          this.mensagemPreco = "O preço caiu";
        } else this.mensagemPreco = "O preço subiu";
      }
    }
  },
  watch: {
    "livroClonado.preco": {
      immediate: false,
      handler(valorNovo, valorAntigo) {
        console.log(
          `Watcher avaliado. antigo=${valorAntigo}, novo=${valorNovo}`
        );
        this.processaMudancaPreco(valorAntigo, valorNovo);
      }
    }
  },
};
</script>

<style lang="scss" scoped>
</style>