<template>
<div class="card">
    <div class="card-header">
      {{livro.titulo}}
    </div>
  
    <div class="card-body">
      <form novalidate>
  
        <div class="form-group row mb-2">
          <label class="col-md-2 col-form-label"
                 for="idTitulo">Título</label>
          <div class="col-md-8">
            <input class="form-control"
                   id="idTitulo"
                   type="text"
                   placeholder="Título (obrigatório)"
                   v-model="livro.titulo" />
          </div>
        </div>
  
        <div class="form-group row mb-2">
          <label class="col-md-2 col-form-label"
                 for="idData">Data de Publicação</label>
          <div class="col-md-8">
            <input class="form-control"
                   id="idData"
                   type="date"
                   placeholder="Data de Publicação"
                   v-model="livro.dataPublicacao"/>
          </div>
        </div>
  
        <div class="form-group row mb-2">
          <label class="col-md-2 col-form-label"
                 for="idPreco">Preço</label>
  
          <div class="col-md-8">
            <input class="form-control"
                   id="idPreco"
                   type="number"
                   placeholder="Preço"
                   v-model="livro.preco"/>
          </div>
        </div>

        <div class="form-group row mb-2">
          <label class="col-md-2 col-form-label"
                 for="idNumeroPaginas">Número de Páginas</label>
  
          <div class="col-md-8">
            <input class="form-control"
                   id="idNumeroPaginas"
                   type="number"
                   placeholder=""
                   v-model="livro.numeroPaginas"/>
          </div>
        </div>

        <div class="form-group row mb-2">
            <label class="col-md-2 col-form-label" 
                for="autores">Autores</label>
            <div class="col-md-8">
                <select multiple class="form-control" 
                    id="autores" v-model="livro.autores">
                    <option>Autor 1</option>
                    <option>Autor 2</option>
                    <option>Autor 3</option>
                    <option>Autor 4</option>
                    <option>Autor 5</option>
                </select>
            </div>
        </div>
  
        <div class="form-group row mb-2">
          <div class="offset-md-2 col-md-4">
            <button class="btn btn-primary mr-3"
                    style="width:100px;"
                    type="submit"
                    @click="salvarLivro()">
              Salvar
            </button>
            <button class="btn btn-outline-secondary mr-3"
                    style="width:100px;"
                    type="button"
                    title="Cancelar suas edições"
                    @click="cancelarEdicao()">
              Cancelar
            </button>
          </div>
        </div>
      </form>
    </div>
    <div> 
        <p>{{message}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'FormLivro',
  data() {
    return {
      livro: {
        id: 20,
        titulo: 'Java Como Programar',
        dataPublicacao: "2000-03-08",
        preco: 50,
        numeroPaginas: 300,
        autores: ['Autor 1', 'Autor 2'],
        ativo: true,
      },
      message: '',
    };
  },
  methods: {
    cancelarLivro() {
      this.message = '';
    },
    salvarLivro() {
      // This only updates when you click the save button
      this.message = JSON.stringify(this.livro, null, '\n ');
      console.log(this.message)
    },
  },
};
</script>

<style scoped>
header {
  font-weight: bold;
  font-family: Arial;
}
.card-header {
    font-weight: bold;
    text-transform: uppercase;
}
</style>