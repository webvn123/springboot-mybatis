<template>
  <div class="main">
    <div class="serach">
        <el-input placeholder="serach for you keys"> <el-button slot="append" icon="el-icon-search"></el-button></el-input>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.main {
  background-color: aliceblue;
  width: 100%;
  height: 100px;
}
.left {
  text-align: left;
}
.serach{
    text-align: left;
    padding: 10px
}
.serach .el-input{
    width: 200px;
}
</style>