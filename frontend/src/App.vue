<template>
  <div id="app" class="d-flex flex-column h-100">
    <!-- header area -->
    <div class="headerArea fixed-top d-flex justify-content-center" id="headerArea">
        <!-- Search Form-->
        <div class="top-search-form ">
          <form action="" method="">
            <button type="submit"><i class="fa fa-search"></i></button>
            <input class="form-group" type="search" placeholder="Enter your keyword">
          </form>
        </div>

    </div>
    <!-- body area -->
    <div class="container flex-grow-1 bodyArea">
      <error />
      <div class="mt-5">
        <router-view />
        <div class="pageBottom"></div>
      </div>
    </div>
    <!-- footer area -->
    <div id = "footer" class = "fixed-bottom">
      <nav-bar />
    </div>
  </div>
</template>

<script>
import NavBar from "./components/NavBar";
import Error from "./components/Error";

export default {
  components: {
    NavBar,
    Error
  },
  data() {
      return {
        orders: []
      }
    },
    mounted() {
      
    }
};
</script>


<style scoped>
  #footer {
  height: 50px;
  background-color: #4f86d8;
  opacity:1;
}

.bodyArea {
  background-color: lightblue;
}

.headerArea {
  background-color: whitesmoke;
  height: 2.5rem;
}

.pageBottom {
  height: 3.5rem;
}



</style>