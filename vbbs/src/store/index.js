import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        user:window.localStorage.getItem("user") == null?{}:JSON.parse(window.localStorage.getItem("user")),
        token:window.localStorage.getItem("token") == null?null:JSON.parse(window.localStorage.getItem("token")),
    },
    mutations:{
        setUser(state,user){
            state.user = JSON.stringify(user);
        },
        removeUer(state){
            window.localStorage.removeItem("user")
            state.user = {}
        },
        setToken(state,token){
            state.token = token
        },
        removeToken(){
            window.localStorage.removeItem("token")
            state.token = null
        }
    },
    actions:{

    }
});