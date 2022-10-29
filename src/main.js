import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
// import axios from 'axios'
import vuetify from './plugins/vuetify'

// axios.defaults.baseURL = 'https://subiter.azurewebsites.net'

Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
