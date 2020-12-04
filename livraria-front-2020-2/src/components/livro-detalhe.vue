<template>
  <div>Estou aqui {{livro.titulo}}</div>
</template>

<script>
export default {
  name: 'LivroDetalhe',
  props: {
    livro: {
      type: Object,
      default: () => {},
    },
  },
};
</script>

<style>
</style>