<template>
  <el-row>
    <el-col :span="12" :offset="6">
      <el-form class="form">
        <el-row :gutter="20">
          <el-col :span="8" :offset="4">
            <el-form-item label="用户名：" label-width="100px">
              <el-input v-model="formData.username"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="密码：" label-width="100px">
              <el-input v-model="formData.password"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
           <el-row :gutter="20">
          <el-col :span="8" :offset="4">
            <el-form-item label="地区：" label-width="100px">
              <el-input v-model="formData.countrycode"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="手机号：" label-width="100px">
              <el-input v-model="formData.telphone"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
           <el-row :gutter="20">
          <el-col :span="8" :offset="4">
            <el-form-item label="邮箱：" label-width="100px">
              <el-input v-model="formData.email"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="昵称：" label-width="100px">
              <el-input v-model="formData.nickname"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-button type="primary" size="small" @click="register">注册</el-button>
          <el-button type="danger" size="small">重置</el-button>
        </el-row>
      </el-form>
    </el-col>
    <el-col></el-col>
  </el-row>
</template>

<script>
export default {
    data(){
        return{
            formData:{
                username:"",
                password:"",
                countrycode:"",
                telphone:"",
                email:"",
                nickname:""
            }
        }
    },
    methods:{
        register(){
            var _this = this;
            this.$api.post('register',this.formData,function(data){
                if(data && data.data && data.data.success){
                    _this.$router.push('login');
                }else{
                    _this.$message.error(data.data.message);
                }
            })
        }
    }
};
</script>

<style>
.form {
  text-align: center;
}
.form .el-row {
  text-align: center;
}
</style>