<template>
  <div class="maindiv">
    <el-row :gutter="20">
      <el-col :span="8" :offset="8">
        <el-form :inline="true" :model="formData" class="demo-form-inline loginForm" :rules="rules" ref="form">
          <el-form-item label="用户名：" prop="username">
            <el-input v-model="formData.username"></el-input>
          </el-form-item>
          <el-form-item label="密码：" prop="password">
            <el-input v-model="formData.password"></el-input>
          </el-form-item>
          <div>
            <el-button type="primary" @click="submitForm()">提交</el-button>
            <a href="#" class="register">注册</a>
          </div>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      formData: {
        username: "",
        password: ""
      },
      rules:{
        username:{required:"true",trigger:"blur",message:"用户名不能为空"},
        password:{required:"true",trigger:"blur",message:"密码不能为空"}
      }
    };
  },
  methods: {
    login() {
      let user = {
        username: "123",
        password: "456"
      };
      window.localStorage.setItem("user", JSON.stringify(user));
      window.localStorage.setItem("token", "12213123");
      this.$router.push({ path: "/" });
    },
    submitForm () {
      var _this = this;
       this.$refs["form"].validate((valid) => {
         if(valid){
           _this.$api.post('login',_this.formData,function(data){
		   let data1 = data.data;
             if(data1 && data1.success){
				window.localStorage.setItem("user", JSON.stringify(data1.data));
				window.localStorage.setItem("token", data1.data.token);
				_this.$router.push("/")
             }else{
				_this.$message.error(data1.message)
			 }
           })
         }
       })
    }
  }
};
</script>

<style>
.maindiv{
  border:1px;
  margin-top: 300px
}
.loginForm{
  padding: 20px;
  background: aliceblue
}
.register{
  position: relative;
  right: -100px;
}
</style>
