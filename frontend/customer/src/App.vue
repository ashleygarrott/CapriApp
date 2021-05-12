<template>
  
  <div class="d-flex flex-column h-100">
    <!-- header area -->
  
    <!-- body area -->
    <!-- <div class="container flex-grow-1 bodyArea"> -->
      <error />
      <div class="">
        
          <router-view />
          
      </div>
    <!-- </div> -->
    <!-- footer area -->
    
  </div>
  
</template>

<script>
import NavBar from "./components/NavBar";
import Error from "./components/Error";
import SearchBar from "./components/SearchBar"
import CATEGORIES from "./constants/index.js"


export default {
  components: {
    NavBar,
    Error,
    SearchBar
  },
  data() {
      return {
        latitude: 0.0,
        longitude: 0.0,
        orderMode: "",
        orders:[],
        productTotal: 0,
        orderTotal: 0,
        loggedIn: false,
        username: "",
        password: "",
        accessToken: "",
        refresherToken: "",
        config: {},
        api: 'http://localhost:9090/',
        windowWidth: window.innerWidth,
        windowHeight: window.innerHeight,
        screenWidth: screen.width,
        screenHeight: screen.height,
        loaded: false,
        message: "",
        CATEGORIES: ["Pizza", "Pasta", "Thai", "Salad", "Bread", "Appetizers", "Drinks", "Specials"]
        //https://capriapp-backend.herokuapp.com/order/confirm_order
      }
    },
    created() {
      if(window.localStorage.getItem("orderMode") != null){
        this.orderMode = window.localStorage.getItem("orderMode")
      }
      if(window.localStorage.getItem("orders") != null){
        this.orders = JSON.parse(window.localStorage.getItem("orders"))
        window.console.log("orders: " + this.orders)
      }
      if(window.localStorage.getItem("deliveryInfo") != null){
        this.$store.commit("setDeliveryInfo", window.localStorage.getItem("deliveryInfo"))
      }
      if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(this.savePosition , 
            function showError() {
            switch(error.code) {
              case error.PERMISSION_DENIED:
                this.$router.push({name: "selectLocation"})
                break;
              case error.POSITION_UNAVAILABLE:
                this.message = "Turn on location to detect current location"
                break;
              case error.TIMEOUT:
                this.message = "We could not detect your location"
                break;
              case error.UNKNOWN_ERROR:
                this.message = "We could not detect your location"
                break;
            }
});
        } else {
            window.console.log("Geolocation is not supported by this browser.")
            this.message = "We could not detect your location"
        }

        this.accessToken = localStorage.getItem("accessToken")
        window.console.log(this.accessToken)
        this.refresherToken = localStorage.getItem("refresherToken")
        window.console.log(this.refresherToken)
        // if(this.token != null){
        //   this.axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.token;
        // }
        // this.axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*'

      this.updateConfig()
      setTimeout(() => this.loaded = true, 20000);

      //fetch all menus
      this.axios.get(this.api + 'menu/get_all_menus')
      .then(res => {
      this.menus = res.data
      this.$store.commit("setMenus", this.menus)

      

      //process them by categories
      for (var i=0;i<this.$store.getters.getCategoryNames.length;i++){
        this.$store.commit("addCategory", {
          name: this.$store.getters.getCategoryNames[i], 
          value: this.menus.filter(menu => menu.categories.includes(this.$store.getters.getCategoryNames[i]))

        })
      }

      
      }
      )
      .catch(function (error) {window.console.log(error)});

      

      
    },

    mounted() {

    },

  methods: {
    savePosition(position) {
      this.latitude = position.coords.latitude
      this.longitude = position.coords.longitude
      this.$store.commit("setLatitude", position.coords.latitude)
      this.$store.commit("setLongitude", position.coords.longitude)
      this.getDeliveryFee(this.latitude, this.longitude)
      this.getLocationData(this.latitude, this.longitude)


      
    },
    setCoordinates(lat,long){
      this.latitude = lat
      this.longitude = long
    },
    getDeliveryFee(lat, long){
      this.axios.post(this.api + 'processor/get_delivery_fee', {
        latitude: lat,
        longitude: long
      })
      .then(res => {
      window.console.log(res.data)
      this.$store.commit("setDeliveryInfo", res.data)
      this.$store.commit("setGps", true)


      }
      )
      .catch(function (error) {window.console.log(error)});
    },
    getLocationData(lat, long){
      this.axios.post(this.api + 'processor/get_location_data', {
        latitude: lat,
        longitude: long
      })
      .then(res => {
      window.console.log(typeof(res.data))

      var currentLocation = res.data
      this.$store.commit("setCurrentLocation", currentLocation)
      this.$store.commit("setShortAddress", currentLocation[0].shortName + " " + currentLocation[1].shortName)
      this.$store.commit("setGps", true)

      }
      )
      .catch(function (error) {window.console.log(error)});
    },
    acceptOrder(order){
            this.axios.post(this.api + 'order/confirm_order',{
                orderId: order.orderId
            })
            .then(res =>{
                window.console.log(res.data)

               if (res.data == "success"){
                   order.status = 'confirmed'
                   this.$forceUpdate();
               } 
            })
                   
        },

        declineOrder(order){
            this.axios.post(this.api + 'order/decline_order',{
                orderId: order.orderId
            })
            .then(res =>{
               if (res.data == "success"){
                   order.status = 'canceled'
                   this.$forceUpdate();
               } 
            })
        },
        getNewAccessToken(){
          window.console.log(this.refresherToken)
          this.axios.post(this.api + 'authenticate/token', {
              string: this.refresherToken

          })
          .then(res => {
            window.console.log(res.data)
            this.accessToken = res.data.accessToken
            window.localStorage.setItem("accessToken", res.data.accessToken)
          })
          .catch(function (error) {window.console.log("GetNewAccessToken failed")});
        },
        updateConfig(){
          this.config = {
            headers: { 
            'Authorization': "Bearer " + this.accessToken,
            'Access-Control-Allow-Origin': '*'

            }
          }
        },
        setLoaded(){
          this.loaded = true;
        }
  
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

<style>
  /* @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap'); */
  @import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');

*{
  font-family: 'Roboto', sans-serif;
}
  .shadowed {
    box-shadow: 0px 0px 10px 2px lightgrey;
    
  
}

  .capri-navbar {
    background-color: white;
    box-shadow: 3px 4px 5px 6px lightgrey;
    opacity:1;

  }

  .extralightColour {
    color: #d2dedb
  }

  .extralightBackground {
    background-color: #d2dedb;
  }

  .lightColour {
  /* color:#55d6d0; */
  /* color: lightgrey */
  color: #a3c7be;
  }

  .lightBackground {
  /* background-color: #55d6d0; */
  /* background-color: lightgrey */
  background-color: #a3c7be;
  }

   .lightBorder {
    border-style: solid;
    border-color: #a3c7be;
    border-width: 1px
  }

  .mediumColour {
    color: #639177;
  }

  .mediumBackground {
    background-color: #639177
  }

  
  .mediumBorder {
    border-style: solid;
    border-color: #639177;
    border-width: 1px

  }


  .redColour {
    color: #f54242
  }

  .redBackground {
    background-color: #f54242
  }
  .darkColour {
  /* color: #689489; */
  color: #195447;
  }

  .darkBackground {
  /* background-color: #49b3cd */
  /* background-color: darkgrey */
  background-color: #195447;
  }

   .darkBorder {
    border-style: solid;
    border-color: #195447;
    border-width: 1px
  }

  .whiteBackground {
    background-color: white
  }

  .lightgreyColour {
    color: lightgrey
  }

  .lightgreyBackground {
    background-color: lightgrey;
  }

  .greyButton {
    background-color: #5c5756
  }




  .rounded {
    border-radius: 10%;
  }

  .circled{
    border-radius:50%
  }

  .locationBar {
    background-color: white;
  }

  .greyBackground {
    background-color:lightgrey
  }

  .darkgreyColour {
    color: #363636
  }

  .darkgreyBackground {
    background-color: #363636
  }


 


 

  .greyBorder {
    border-style: solid;
    border-color: lightgrey;
    border-width: 1px

  }

  a { 
    color: inherit; 
  } 

  router-link {
    color: inherit; 
  }


  .buttonShadowed {
    box-shadow: 0px 0px 2px 1px lightgrey;

  }

   /* Create a custom radio button */
.radioContainer {
  display: block;
  position: relative;
  padding-left: 20px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 22px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default radio button */
.radioContainer input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

/* Create a custom radio button */
.radioCheckmark {
  position: absolute;
  top: 11px;
  left: 0;
  height: 16px;
  width: 16px;
  background-color: white;
  border-radius: 50%;
  border-style:solid;
  border-color:#689489;
  border-width: 2px
}

/* On mouse-over, add a grey background color */
.radioContainer:hover input ~ .radioCheckmark {
  background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.radioContainer input:checked ~ .radioCheckmark {
  background-color: #689489;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.radioCheckmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the indicator (dot/circle) when checked */
.radioContainer input:checked ~ .radioCheckmark:after {
  display: block;
}

/* Style the indicator (dot/circle) */
.radioContainer .radioCheckmark:after {
  top: 2px;
  left: 2px;
  width: 8px;
  height: 8px;
  border-radius: 50%;
  background: white;
}

/* Customize the label (the container) */
.checkboxContainer {
  display: block;
  position: relative;
  padding-left: 20px;
  margin-bottom: 12px;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default checkbox */
.checkboxContainer input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

/* Create a custom checkbox */
.checkboxCheckmark {
  position: absolute;
  top: 4px;
  left: 0;
  height: 16px;
  width: 16px;
  border-color: #195447;
  border-style: solid;
  border-width: 2px;
  background-color: white;
  border-radius: 5px
}

/* On mouse-over, add a grey background color */
.checkboxContainer:hover input ~ .checkboxCheckmark {
  background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.checkboxContainer input:checked ~ .checkboxCheckmark {
  background-color: #689489;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkboxCheckmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the checkmark when checked */
.checkboxContainer input:checked ~ .checkboxCheckmark:after {
  display: block;
}

/* Style the checkmark/indicator */
.checkboxContainer .checkboxCheckmark:after {
  left: 4px;
  top: 0px;
  width: 5px;
  height: 10px;
  border: solid white;
  border-width: 0 3px 3px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}

.navBar {
  background-color: white;
  border-top-color: lightgrey;
  border-top-style: solid;
  border-top-width: 1px;
  box-shadow: 0px 1px 12px 1px lightgrey;
}

.navbarText {
  font-size:10pt;
  margin-top: 0px
}

.navIcon {
  margin-bottom: 0px;
  margin-top: 0px;
}

.whiteCard {
  background-color: white;
}

 .scrollCard {
    display: inline-block;
    white-space: normal 
  }

html, body {min-height: 100%;}
body {background-size: cover;}

</style>