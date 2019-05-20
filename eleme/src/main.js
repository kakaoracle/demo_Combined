// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import App from './App';
import VueRouter from "vue-router";
import goods from './components/goods/goods.vue';

Vue.use(VueRouter);

let app = Vue.extend(App);
let router = new VueRouter();
router.map({
  '/goods':{
    component:goods
  }
})

router.start(app,'#app');

