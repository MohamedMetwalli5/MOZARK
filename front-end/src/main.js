import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './router'

import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faHeart } from '@fortawesome/free-regular-svg-icons'
import { faGithubSquare, faLinkedin, faHackerrank } from '@fortawesome/free-brands-svg-icons'
import { store } from './store/store';


library.add(faGithubSquare, faLinkedin, faHackerrank, faHeart)
Vue.component('fa-icon', FontAwesomeIcon)


Vue.use(VueRouter)
Vue.config.productionTip = false

new Vue({
  router,
  store: store,
  beforeCreate() { this.$store.commit('initialiseStore');},
  render: h => h(App)
}).$mount('#app')
