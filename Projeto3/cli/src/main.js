import Vue from 'vue'
import ElementUI from 'element-ui'
import lang from 'element-ui/lib/locale/lang/pt-br'
import locale from 'element-ui/lib/locale/'
import Resource from 'vue-resource'
import VueRouter from 'vue-router'
import Bars from 'vuebars'
import Vuebar from 'vuebar'
import vueEventCalendar from 'vue-event-calendar'
import VueFeatherIcon from 'vue-feather-icon'
import routes from './routes'
import store from './store'
import VueTyperPlugin from 'vue-typer'
import VueAnimateNumber from 'vue-animate-number'
import VueCharts from 'vue-chartjs'
import Tooltip from 'vue-directive-tooltip'
import Vuetify from 'vuetify'

locale.use(lang)
// Resource logic
Vue.use(Resource)
Vue.http.options.emulateJSON = true

Vue.use(VueRouter)
Vue.use(ElementUI)
Vue.use(Bars)
Vue.use(Vuebar)
Vue.use(VueFeatherIcon)
Vue.use(vueEventCalendar, {locale: 'en'})
Vue.use(VueTyperPlugin)
Vue.use(VueAnimateNumber)
Vue.use(VueCharts)
Vue.use(Tooltip)
Vue.use(Vuetify)

Vue.http.options.root = 'http://localhost:8080/projeto3/agencia'
// Vue.http.options.headers = {'Content-type': 'application/json'}

// Import top level component
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.css'
//  for element 1.9.9 below
// import 'element-ui/lib/theme-default/index.css'
import 'element-ui/lib/theme-chalk/index.css'
import 'material-design-icons/iconfont/material-icons.css'
import 'dripicons/webfont/webfont.css'
import 'vue-directive-tooltip/css/index.css'
import 'vuetify/dist/vuetify.min.css'

// Routing logic
var router = new VueRouter({
  routes: routes,
  mode: 'hash',
  linkActiveClass: 'open active',
  scrollBehavior: function (to, from, savedPosition) {
    return savedPosition || { x: 0, y: 0 }
  }
})

// Check local storage to handle refreshes
if (window.localStorage) {
  if (store.state.token !== window.localStorage.getItem('token')) {
    store.commit('SET_TOKEN', window.localStorage.getItem('token'))
  }
}

// Some middleware to help us ensure the user is authenticated.

// Start out app!
// eslint-disable-next-line no-new
new Vue({
  el: '#app',
  router: router,
  store: store,
  render: h => h(App)
})

require('bootstrap')
require('admin-lte')
require('../node_modules/admin-lte/dist/js/demo.js')
require('../node_modules/admin-lte/plugins/slimScroll/jquery.slimscroll.js')
