import Vue from 'vue'
import VueRouter from 'vue-router'
import ListaLivrosPai from '@/views/lista-livros-pai'
import EditarLivroForm from '@/views/editar-livro-form';
import PaginaNaoEncontrada from '@/views/pagina-nao-encontrada';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/listaLivros',
  },
  {
    path: '/listaLivros',
    name: 'listaLivros',
    component: ListaLivrosPai
  },
  {
    path: '/editaLivro/:id',
    name: 'editaLivro',
    component: EditarLivroForm,
    props: r => ({ id: parseInt(r.params.id)}),
  },
  {
    path: '*',
    component: PaginaNaoEncontrada,
  }, 
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
