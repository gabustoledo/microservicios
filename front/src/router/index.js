import { createRouter, createWebHistory } from 'vue-router'
import JustificativoView from '../views/JustificativoView.vue'
import HoraExtraView from '../views/HoraExtraView.vue'
import HorarioView from '../views/HorarioView.vue'
import SueldoView from '../views/SueldoView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/justificativo',
      name: 'justificativo',
      component: JustificativoView
    },
    {
      path: '/horaExtra',
      name: 'horaExtra',
      component: HoraExtraView
    },
    {
      path: '/horario',
      name: 'horario',
      component: HorarioView
    },
    {
      path: '/sueldo',
      name: 'sueldo',
      component: SueldoView
    }
  ]
})

export default router
