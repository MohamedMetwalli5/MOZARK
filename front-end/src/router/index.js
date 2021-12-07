import Vue from 'vue'
import VueRouter from 'vue-router'
import SignUp from '../components/SignUp.vue'
import SignIn from '../components/SignIn.vue'
import Home from '../components/Home.vue'
import Settings from '../components/Settings.vue'
import AdminSettings from '../components/AdminSettings.vue'
import Clothing from '../components/Clothing.vue'
import Electronics from '../components/Electronics.vue'
import Shoes from '../components/Shoes.vue'
import Watches from '../components/Watches.vue'
import Jewellery from '../components/Jewellery.vue'
import Sports from '../components/Sports.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/SignIn',
    name: 'SignIn',
    component: SignIn
  },{
    path: '/Home',
    name: 'Home',
    component: Home
  },{
    path: '/Settings',
    name: 'Settings',
    component: Settings
  },{
    path: '/Clothing',
    name: 'Clothing',
    component: Clothing
  },{
    path: '/Electronics',
    name: 'Electronics',
    component: Electronics
  },{
    path: '/Shoes',
    name: 'Shoes',
    component: Shoes
  },{
    path: '/Watches',
    name: 'Watches',
    component: Watches
  },{
    path: '/Jewellery',
    name: 'Jewellery',
    component: Jewellery
  },{
    path: '/Sports',
    name: 'Sports',
    component: Sports
  },{
    path: '/AdminSettings',
    name: 'AdminSettings',
    component: AdminSettings
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
