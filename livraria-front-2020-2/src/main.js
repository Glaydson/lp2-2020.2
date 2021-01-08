import Vue from 'vue'
import App from './App.vue'
import moment from 'moment'

import "@/assets/global.css"
import router from './router'

Vue.config.productionTip = false

Vue.filter('dataLonga', function(value) {
  if (value) {
    moment.locale('pt-BR');
    const data = moment(value);
    return moment(data).format('LL')
  }
})

Vue.filter('upperCase', function(value) {
  if (value) {
    return value.toUpperCase();
  }
})

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
