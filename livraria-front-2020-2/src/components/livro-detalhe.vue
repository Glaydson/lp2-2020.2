<template>
  <div>
        <div class="card-header">{{tituloDisponibilidade}}</div>
        <form>
          <div class="form-group">
            <label for="id">Id</label>
            <input type="text" class="form-control" id="id" disabled :value="livroClonado.id" />
          </div>
          <div class="form-group">
            <label for="titulo">Título</label>
            <input
              type="text"
              class="form-control"
              id="idTitulo"
              v-model="livroClonado.titulo"
            />
          </div>
          <div class="form-group">
            <label for="dataPublicacao">Data da Publicação</label>
            <input
              type="date"
              class="form-control"
              id="dataPublicacao"
              v-model="livroClonado.dataPublicacao"
            />
            <label>Data longa: {{ livroClonado.dataPublicacao | dataLonga}}</label>
          </div>
          <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="mostrar" v-model="mostrarMais" />
            <label for="mostrar" class="form-check-label">Mostrar Mais Campos</label>
          </div>
          <div class="form-group" v-show="mostrarMais">
            <label for="preco">Preço</label>
            <input type="number" class="form-control" id="preco" v-model="livroClonado.preco" />
            <label>{{mensagemPreco}}</label>
          </div>
          <div class="form-group" v-show="mostrarMais">
            <label for="autores">Autor(es)</label>
            <input
              type="text"
              class="form-control"
              id="autores"
              disabled
              :value="livroClonado.autores"
            />
          </div>
          <footer class="card-footer">
            <button class="btn btn-secondary botoes" @click="cancelarEdicao()">
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
</template>

<script>
export default {
  name: 'LivroDetalhe',
  data() {
    return {
      mostrarMais: false,
      mensagemPreco: "",
      livroClonado: { ...this.livro},
    }
  },
  props: {
    livro: {
      type: Object,
      default: () => {},
    },
  },
  computed: {
    tituloDisponibilidade() {
      return `${this.livroClonado.titulo} - ${
        this.livroClonado.disponivel ? "Disponível" : "Indisponível"
      }`;
    }
  },
  methods: {
    salvarLivro() {
        this.$emit('salvar', this.livroClonado);
    },
    cancelarEdicao() {
        this.$emit('cancelar');
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
  }
};
</script>

<style>
</style>