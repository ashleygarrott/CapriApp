<template>
    <v-navigation-drawer
        :value="drawer"
        @input="(newDrawer) => {drawer = newDrawer}"
        v-model="drawer"
        absolute
        temporary
        style="z-index:2"
        >
          <div class="darkBackground" style="height:20%;width:100%;position:relative">
            <p class="mx-3 text-white" style="position:absolute;bottom:0px;left:0px">Sign in</p>
          </div>
          <div class="my-3">
            <div class="d-flex ml-3 my-3" v-on:click="$router.push({name: 'cart'})">
              <i class="fas fa-shopping-cart my-auto mr-4 darkColour"></i>
              <p class="my-auto darkgreyText">Orders</p>
            </div>
            <div class="d-flex ml-3 my-3">
              <i class="fas fa-cog my-auto mr-4 darkColour"></i>
              <p class="my-auto darkgreyText">Settings</p>
            </div>
          </div>
      

      </v-navigation-drawer>
</template>

<script>
    export default {
        name: "Sidebar",
        props: ['value'],
        data(){
        return {
            drawer: false
        }
    }
    }
    
</script>
