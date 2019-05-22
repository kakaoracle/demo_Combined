// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import App from './App';
import Vue from 'vue';
import './common/stylus/index.styl';
import VueResource from 'vue-resource'
import router from './router/index'

Vue.use(VueResource);



new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

