<template>
	<div>
	  <myMenu></myMenu>
		<router-view></router-view>
	</div>
</template>

<script>
import myMenu from './menu.vue'
export default {
	data(){
		return{
			data:""
		}
	},
	components: {
		myMenu
	},
	methods:{
		logout(){
			window.localStorage.removeItem("token")
			window.localStorage.removeItem("user")
			this.$router.push('/login')
		}
	}
}
</script>

<style>

</style>