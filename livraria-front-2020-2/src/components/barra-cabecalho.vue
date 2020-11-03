<template>
  <header>
    <nav class="navbar navbar-expand navbar-light bg-light">
      <a class="navbar-brand">
        <i class="fab js-logo fa-vuejs fa-3x" aria-hidden="true" />Livraria Front-End
      </a>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="#">
              Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Livros</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Autores</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Editoras</a>
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