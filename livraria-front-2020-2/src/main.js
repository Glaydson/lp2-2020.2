import Vue from 'vue'
import App from './App.vue'
import moment from 'moment'

import "@/assets/global.css"

Vue.config.productionTip = false

Vue.filter('dataLonga', function(value) {
  if (value) {
    moment.locale('pt-BR');
    const data = moment(value);
    return moment(data).format('LL')
  }
})


new Vue({
  render: h => h(App),
}).$mount('#app')
