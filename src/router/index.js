import Vue from 'vue'
import VueRouter from 'vue-router'
import ChamadosView from '../views/ChamadosView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'chamados',
    component: ChamadosView
  },
  {
    path: '/produtos',
    name: 'produtos',
    component: () => import(/* webpackChunkName: "about" */ '../views/ProdutosView.vue')
  },
  {
    path: '/equipamentos',
    name: 'equipamentos',
    component: () => import(/* webpackChunkName: "about" */ '../views/EquipamentosView.vue')
  },
  {
    path: '/clientes',
    name: 'clientes',
    component: () => import(/* webpackChunkName: "about" */ '../views/ClientesView.vue')
  },
  {
    path: '/agendamentos',
    name: 'agendamentos',
    component: () => import(/* webpackChunkName: "about" */ '../views/AgendamentosView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/LoginView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
