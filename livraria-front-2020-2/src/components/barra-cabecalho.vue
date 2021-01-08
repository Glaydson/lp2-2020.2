<template>
  <header>
    <nav class="navbar navbar-expand navbar-light bg-light">
      <a class="navbar-brand">
        <i class="fab js-logo fa-vuejs fa-3x" aria-hidden="true" />Livraria Front-End
      </a>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <router-link class="nav-link" href="#" to="/">
              Home
              <span class="sr-only">(current)</span>
            </router-link>
          </li>
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              id="navbarDropdown"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >Livros</a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <router-link class="dropdown-item" to="/listaLivros">Listar</router-link>
              <router-link class="dropdown-item" :to="{name: 'editaLivro', 
                params:{id: 0} }">Novo</router-link>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a
              class="nav-link disabled dropdown-toggle"
              href="#"
              role="button"
              id="navbarDropdown"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >Autores</a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <router-link class="dropdown-item" to="/listaAutores">Listar</router-link>
              <router-link class="dropdown-item" to="/novoAutor">Novo</router-link>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a
              class="nav-link disabled dropdown-toggle"
              href="#"
              role="button"
              id="navbarDropdown"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >Editoras</a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <router-link class="dropdown-item" to="/listaEditoras">Listar</router-link>
              <router-link class="dropdown-item" to="/novaEditora">Novo</router-link>
            </div>
          </li>
          <li class="nav-item">
            <router-link
              class="nav-link"
              href="#"
              tabindex="-1"
              aria-disabled="true"
              to="/about"
            >Sobre</router-link>
          </li>
        </ul>
      </div>
      <BarraCabecalhoLink/>
    </nav>
  </header>
</template>

<script>
import BarraCabecalhoLink from '@/components/barra-cabecalho-link.vue';
export default {
  name: "BarraCabecalho",
  components: {BarraCabecalhoLink}
};
</script>

<style scoped>
header {
  font-size: 20px;
  font-weight: bold;
  font-family: Arial;
}
.navbar-brand {
  padding-right: 20px;
}
</style>