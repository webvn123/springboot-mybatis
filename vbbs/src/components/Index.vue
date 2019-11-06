<template>
  <div>
    <el-button v-on:click="getUser">获取</el-button>
    <el-button v-on:click="setUser">设置</el-button>
    <el-button v-on:click="send">发送</el-button>
  </div>
</template>

<script>
export default {
  data: function () {
    return {}
  },
  methods: {
    getUser: function () {
      let user = this.$store.state.user
      console.log(user)
    },
    setUser: function () {
      let user ={
        username:"123",
        password:"456"
      }
      this.$store.commit("setUser",user)
      this.$store.commit("setToken","token123")
    },
    send: function (){
      this.$api.get('base/test?year=1',"",function(res){


      })
    }
  }
}
</script>

<style scoped>
</style>
