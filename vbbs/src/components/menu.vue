<template>
  <div>
  <el-col>
  <div style="height:70px;background-color:rgb(84, 92, 100)">
    <div class="sys">
    {{userName}}
	  <el-button size="small" type="primary" class="lgout">退出</el-button></div>
    </div>
  </el-col>
  <el-col :span=3>
    <el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <template v-for="(item,index) in menuItems">
        <el-submenu :index="index+''" v-if="item.children && item.children.length" :key="index">
          <template slot="title">{{item.title}}</template>
          <el-menu-item
            v-for="child in item.children"
            :index="child.path"
            :key="child.path"
          >{{child.title}}</el-menu-item>
        </el-submenu>
        <el-menu-item v-if="!item.children" :index="item.path" :key="index">
          <i :class="item.icon"></i>
          {{item.title}}
        </el-menu-item>
      </template>
    </el-menu>
	</el-col>
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
      userName:JSON.parse(window.localStorage.getItem("user")).username,
      menuItems: [
        {
          title: "菜单一",
          path: "/",
          children: [
            {
              title: "登录",
              path: "/login"
            }
          ]
        },
        {
          title: "菜单二",
          path: "/",
          children: [
            {
              title: "首页",
              path: "/"
            },
          ]
        }
      ]
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      this.$router.push(key)
      console.log(key)
      console.log(keyPath);
    }
  }
};
</script>
<style scoped>
  .sys{
    float: right;
    text-align: center;
    padding: 10px;
    color: antiquewhite
  }
  .lgout{
    margin-left: 10px;
    padding: 10px;
  }
</style>
