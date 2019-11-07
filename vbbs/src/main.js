// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import api from './api'

Vue.use(element)
Vue.prototype.$api = api
Vue.config.productionTip = false

router.beforeEach((to,from,next)=>{
  if(to.name == "login"){
    next()
    return
  }
  var token = window.localStorage.getItem("token")
  if(token == "" || token == null){
    next({path:'/login'})
    return
  } 
  next();
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
