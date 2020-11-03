<template>
<div class="content-container">
    <div class="section content-title-group">
      <h2 class="title">Livro</h2>
    </div>
    <div class="columns">
      <div class="column is-8">
        <div class="card edit-detail">
          <header class="card-header">
            <p class="card-header-title">{{ livro.titulo }}</p>
          </header>
          <div class="card-content">
            <div class="content">
              <div class="field">
                <label class="label" for="id">id</label>
                <label class="input" id="id" readonly>{{ livro.id }}</label>
              </div>
              <div class="field">
                <label class="label" for="firstName">Título</label>
                <input class="input" id="firstName" v-model="livro.titulo" />
              </div>
              <div class="field">
                <label class="label" for="lastName">Preço</label>
                <input class="input" id="lastName" v-model="livro.preco" />
              </div>
              <div class="field">
                <label class="label" for="lastName">Data de Publicação</label>
                <input class="date" id="lastName" v-model="livro.dataPublicacao" />
              </div>
              <div class="field">
                <label for="power">
                  super power
                  <div class="select is-primary">
                    <select
                      id="power"
                      v-model="livro.autor"
                      :class="{ invalid: !livro.autor }"
                      @keyup.esc="clearPower"
                    >
                      <option disabled value>Please select one</option>
                      <option>Speed</option>
                      <option>Flight</option>
                      <option>Strength</option>
                      <option>Invisibility</option>
                    </select>
                  </div>
                </label>
              </div>
              <div class="field">
                <label class="checkbox" for="active">
                  active
                  <input
                    type="checkbox"
                    class="is-primary"
                    id="active"
                    v-model="livro.ativo"
                  />
                </label>
              </div>
            </div>
          </div>
          <footer class="card-footer">
            <button
              class="link card-footer-item cancel-button"
              @click="cancelHero()"
            >
              <i class="fas fa-undo"></i>
              <span>Cancel</span>
            </button>
            <button class="link card-footer-item" @click="saveHero()">
              <i class="fas fa-save"></i>
              <span>Save</span>
            </button>
          </footer>
        </div>
        <div class="notification is-info">
          <pre>{{ message }}</pre>
        </div>
      </div>
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
        titulo: 'Madelyn',
        dataPublicacao: 'Papa',
        preco: 'the cat whisperer',
        numeroPaginas: '',
        autor: '',
        ativo: true,
      },
      message: '',
    };
  },
  methods: {
    cancelHero() {
      this.message = '';
    },
    clearPower() {
      this.hero.power = '';
    },
    saveHero() {
      // This only updates when you click the save button
      this.message = JSON.stringify(this.hero, null, '\n ');
    },
  },
};
</script>

<style scoped>
header {
  font-weight: bold;
  font-family: Arial;
}

.content-title-group {
  margin-bottom: 16px;
}

.content-title-group h2 {
    border-left: 16px solid #42b883;;
    border-bottom: 2px solid #42b883;;
    padding-left: 8px;
    padding-right: 16px;
    display: inline-block;
    text-transform: uppercase;
    color: #555;
    letter-spacing: 0px;
}

p.card-header-title {
  background-color: #42b883;
  text-transform: uppercase;
  letter-spacing: 4px;
  color: #fff;
  display: block;
  padding-left: 24px;
}

.card-footer button {
  font-size: 16px;
  color: #888;
}

.modal-card-foot button {
  display: inline-block;
  width: 80px;
}

.modal-card-head,
.modal-card-body {
  text-align: center;
}

div.card-content {
  background-color: #fafafa;
}

div.card-content .name {
  font-size: 28px;
  color: #000;
}

div.card-content .description {
  font-size: 20px;
  color: #999;
}

.card {
      margin-bottom: 2em;
}

label.label {
  font-weight: normal;
}

.edit-detail.input[read-only] {
  background-color: #fafafa;
}

.field {
  margin-bottom: 0.75rem;
}
</style>