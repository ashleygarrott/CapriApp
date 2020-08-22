<template>
  <div id="app" class="d-flex flex-column h-100">
    <!-- header area -->
  
    <!-- body area -->
    <!-- <div class="container flex-grow-1 bodyArea"> -->
      <error />
      <div class="mt-5">
        <router-view />
        <div class="pageBottom"></div>
      </div>
    <!-- </div> -->
    <!-- footer area -->
    <div id = "footer" class = "fixed-bottom">
      <nav-bar />
    </div>
  </div>
</template>

<script>
import NavBar from "./components/NavBar";
import Error from "./components/Error";
import SearchBar from "./components/SearchBar"

export default {
  components: {
    NavBar,
    Error,
    SearchBar
  },
  data() {
      return {
        orders:[],
        deliveryInfo: {}
      }
    },
    created() {
      

      

      
    },

    mounted() {
      
      
    },

  methods: {
    
  },


};
</script>


<style scoped>
  #footer {
  height: 50px;
  background-color: white;
  box-shadow: 3px 4px 5px 6px lightgrey;
  opacity:1;
}

.bodyArea {
  background-color: white;
}

.headerArea {
  background-color: #42ccc9;
  height: 2.5rem;
  box-shadow: 3px 4px 5px 6px lightgrey;

}

.pageBottom {
  height: 3.5rem;
}



</style>