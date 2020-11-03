<template>
  <div id="app">
    <BarraCabecalho />
    <div class="main-section columns">
      <main class="column">
        <FormLivro />
      </main>
    </div>
  </div>
</template>

<script>
import BarraCabecalho from "@/components/barra-cabecalho.vue";
import FormLivro from "@/components/form-livro.vue";

export default {
  name: "App",
  components: {
    BarraCabecalho, FormLivro
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
  margin-left: 20px;
  margin-right: 20px;
  margin-top: 30px;
}
</style>
