<template>
  <div>
    <el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      mode="horizontal"
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
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
      menuItems: [
        {
          title: "菜单一",
          path: "/",
          children: [
            {
              title: "子菜单一",
              path: "/login"
            },
            {
              title: "子菜单二",
              path: "/"
            }
          ]
        },
        {
          title: "菜单二",
          path: "/",
          children: [
            {
              title: "子菜单二",
              path: "/index"
            },
            {
              title: "子菜单二",
              path: "/"
            }
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
