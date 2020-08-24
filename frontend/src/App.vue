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
      if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(this.savePosition , 
            function showError(error) {
            switch(error.code) {
              case error.PERMISSION_DENIED:
                this.deliveryInfo = {}
                break;
              case error.POSITION_UNAVAILABLE:
                this.deliveryInfo = {}
                break;
              case error.TIMEOUT:
                this.deliveryInfo = {}
                break;
              case error.UNKNOWN_ERROR:
                this.deliveryInfo = {}
                break;
            }
});
        } else {
            window.console.log("Geolocation is not supported by this browser.")
            this.deliveryInfo = {}
        }

      

      
    },

    mounted() {
      
      
    },

  methods: {
    savePosition(position) {
      this.latitude = position.coords.latitude
      this.longitude = position.coords.longitude
      window.console.log(this.latitude)

      this.axios.post('https://capriapp-backend.herokuapp.com/processor/get_delivery_fee', {
        latitude: this.latitude,
        longitude: this.longitude
      })
      .then(res => {
      window.console.log(res.data)
      this.deliveryInfo = res.data

      if (this.deliveryInfo.destination.length > 50){
        this.deliveryInfo.shortenedAddress = this.deliveryInfo.destination.substring(0, 50) + "..."
      }
      else (this.deliveryInfo.shortenedAddress = this.deliveryInfo.destination)

      }
      )
      .catch(function (error) {window.console.log(error)});
    }
  }


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