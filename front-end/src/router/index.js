import Vue from 'vue'
import VueRouter from 'vue-router'
import SignUp from '../views/SignUp.vue'
import SignIn from '../views/SignIn.vue'
import Home from '../views/Home.vue'
import Settings from '../views/Settings.vue'
import AdminSettings from '../views/AdminSettings.vue'
import Clothing from '../views/Clothing.vue'
import Electronics from '../views/Electronics.vue'
import Shoes from '../views/Shoes.vue'
import Watches from '../views/Watches.vue'
import Jewellery from '../views/Jewellery.vue'
import Sports from '../views/Sports.vue'
import ShoppingCart from '../views/ShoppingCart.vue'

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
  },{
    path: '/ShoppingCart',
    name: 'ShoppingCart',
    component: ShoppingCart
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
