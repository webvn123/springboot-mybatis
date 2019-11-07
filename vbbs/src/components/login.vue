<template>
  <div>
    <el-input></el-input>
    <el-button @click="login"></el-button>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
  methods: {
    login() {
      let user = {
        username: "123",
        password: "456"
      };
    window.localStorage.setItem("user",JSON.stringify(user));
    window.localStorage.setItem("token","12213123");
    this.$router.push({ path: "/" });
    }
  }
};
</script>

<style>
</style>