import Vue from 'vue'
import Router from 'vue-router'
import goods from 'components/goods/goods.vue'
import header from 'components/header/header'
import ratings from 'components/ratings/ratings'
import seller from 'components/seller/seller'
import helloWorld from 'components/helloWorld'


Vue.use(Router);


export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'helloWorld',
      component: helloWorld
    },
    {
      path: '/goods',
      name: 'goods',
      component: goods
    },
    {
      path: '/header',
      name: 'header',
      component: header
    },
    {
      path: '/ratings',
      name: 'ratings',
      component: ratings
    },
    {
      path: '/seller',
      name: 'seller',
      component: seller
    },
  ]
})
