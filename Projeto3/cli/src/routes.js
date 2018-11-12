import Dashboard from './components/Dashboard.vue'
import NotFound from './components/modules/dashboard/404.vue'
import Login from './components/Login.vue'
import Passagens from './components/modules/passagens/Passagens.vue'
import Hoteis from './components/modules/hoteis/Hoteis.vue'
import Pacotes from './components/modules/pacotes/Pacotes.vue'

// Routes
const routes = [
  {
    path: '/',
    component: Dashboard,
    meta: { requiresAuth: true },
    beforeEnter: (to, from, next) => {
      document.body.className += 'skin-black sidebar-mini'
      next()
    },
    activate: function () {
      this.$nextTick(function () {
        // => 'DOM loaded and ready'
        alert('test')
      })
    },
    children: [
      {
        path: '',
        name: 'login-default',
        component: Login
      }, {
        path: '/login',
        name: 'login',
        component: Login
      }, {
        path: '/passagens',
        name: 'passagens',
        component: Passagens
      }, {
        path: '/hoteis',
        name: 'hoteis',
        component: Hoteis
      }, {
        path: '/pacotes',
        name: 'pacotes',
        component: Pacotes
      }, {
        path: '*',
        name: '404',
        component: NotFound
      }
    ]
  }
]

export default routes
