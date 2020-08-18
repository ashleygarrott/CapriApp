<template>
  
<div class="d-flex flex-column h-100">
  <header class="bg-dark text-center p-2 fixed-top">
    <div class="container">
      <div class="md-form mt-0">
        <input class="form-control" type="text" placeholder="Looking for a menu in particular?" aria-label="Search">
      </div>
    </div>
  </header>
  <br>
  <br>
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img class="d-block w-100" src="https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg" alt="First slide">
      </div>
      <div class="carousel-item">
        <img class="d-block w-100" src="https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg" alt="Second slide">
      </div>
      <div class="carousel-item">
        <img class="d-block w-100" src="https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg" alt="Third slide">
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>


</div>
</template>

<script>
export default {
  name: "NavBar",
  data() {
    return {
      temp: true,
      info: '',
      caption: '',
      src: '',
      cards: [],
    }
  },
  mounted() {

    this.axios.get('http://localhost:9090/menu/get_categories')
                .then(res => {
                  window.console.log(res.data)   
                  }
                  )
                .catch(function (error) {window.console.log(error)});

    this.axios.get('http://localhost:9090/menu/get_all_menus')
                .then(res => {
                  window.console.log(res.data)   
                  }
                  )
                .catch(function (error) {window.console.log(error)});

    
  },
  methods: {
    login() {
      this.$auth.loginWithRedirect();
    },
    logout() {
      this.$auth.logout();
      this.$router.push({ path: "/" });
    }
  }
};
</script>