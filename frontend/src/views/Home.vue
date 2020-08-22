<template>
<div>


    
    <div class="page-content-wrapper">
      <div>
        <search-bar />
      </div>
      <div class="container flex-grow-1 bodyArea">
        <div class="row d-flex justify-content-center">
          <div v-if="deliveryInfo!={}">
            <div class="d-flex justify-content-center text-center px-4 mb-0">
              <p style="color:lightgrey;font-size:0.5rem">{{deliveryInfo.shortenedAddress}}</p>
              <!-- <p style="color:white">a</p>
              <p style="font-size:0.7rem;color:#55d6d0"><b>({{deliveryInfo.distance.humanReadable}}/{{deliveryInfo.duration.humanReadable}}/฿{{deliveryInfo.deliveryFee}})</b></p> -->
            </div>
            <div class="d-flex justify-content-center text-center px-4 mb-0">
              <p style="font-size:0.7rem;color:#55d6d0"><b>({{deliveryInfo.distance.humanReadable}}/{{deliveryInfo.duration.humanReadable}}/฿{{deliveryInfo.deliveryFee}})</b></p>
            </div>
          </div>

          

          <div v-if="deliveryInfo=={}">
            <p style="color:lightgrey;font-size:0.5rem">We can not yet determine your location</p>
          </div>

        </div>
        <!-- Hero Slides-->
        <div class="hero-slides owl-carousel">
          <carousel ref="carousel" :perPage="1">
            <slide>
              <img src="https://1112.minorcdn.com/1112/public/images/products/promotion/NOV2018/Promotion-Banner-Set_KHOOM-KROB-KREUNG-269-th.jpg" style="width: 100%; height: 10rem">
            </slide>
            <slide>
              <img src="https://previews.123rf.com/images/revelstockart/revelstockart1802/revelstockart180200130/96393376-retro-futuristic-promotion-banner-scroll-price-tag-vector-illustration.jpg" style="width: 100%; height: 10rem">
            </slide>
          </carousel>
        </div>
        <!-- Product Catagories-->
        <div class="product-catagories-wrapper py-3">
          <div class="container">
            <div class="section-heading d-flex align-items-center justify-content-between">
              <div class="row">
                <h6 class="ml-1 lead" style="color:#55d6d0;font-size:1.6rem">Our</h6>
                <h6 class="ml-1 lead" style="font-size:1.6rem">categories</h6>
              </div>
              <a class="btn  btn-sm" href="shop-grid.html" style="color:white;background-color:#55d6d0">View All</a>
            </div>
          
            <div class="product-catagory-wrap">
              <div class="row">
                <!-- Single Catagory Card-->
                <div class="col-4 categoryCard">
                  <router-link :to="{ name: 'category', params: { categoryName: 'pizza' }}">
                    <div class="roundedCard" style="background-image: url('https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg')"></div>
                    <div>
                      <p class = "categoryText text-center fonted"> Pizza </p>
                    </div>
                  </router-link>
                </div>
                <!-- Single Catagory Card-->
                <div class="col-4 categoryCard">
                  <router-link :to="{ name: 'category', params: { categoryName: 'pasta' }}">
                    <div class="roundedCard" style="background-image: url('https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg')"></div>
                    <div>
                      <p class = "categoryText  text-center"> Pasta </p>
                    </div>
                  </router-link>
                </div>
                <!-- Single Catagory Card-->
                <div class="col-4 categoryCard">
                  <router-link :to="{ name: 'category', params: { categoryName: 'thai food' }}">
                    <div class="roundedCard" style="background-image: url('https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg')"></div>
                    <div>
                      <p class = "categoryText  text-center"> Thai Food </p>
                    </div>
                  </router-link>
                </div>
                <!-- Single Catagory Card-->
                <div class="col-4 categoryCard">
                  <router-link :to="{ name: 'category', params: { categoryName: 'salad' }}">
                    <div class="roundedCard" style="background-image: url('https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg')"></div>
                    <div>
                      <p class = "categoryText  text-center"> Salad </p>
                    </div>
                  </router-link>
                </div>
                <!-- Single Catagory Card-->
                <div class="col-4 categoryCard">
                  <router-link :to="{ name: 'category', params: { categoryName: 'grilled bread' }}">
                    <div class="roundedCard" style="background-image: url('https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg')"></div>
                    <div>
                      <p class = "categoryText  text-center"> Grilled Bread </p>
                    </div>
                  </router-link>
                </div>
                <!-- Single Catagory Card-->
                <div class="col-4 categoryCard">
                  <router-link :to="{ name: 'category', params: { categoryName: 'appetizer' }}">
                    <div class="roundedCard" style="background-image: url('https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg')"></div>
                    <div>
                      <p class = "categoryText  text-center"> Appetizer </p>
                    </div>
                  </router-link>
                </div>
              </div>
            </div>
          </div>
        </div>

        
        
        <!-- Top Products-->
        <div class="top-products-area clearfix py-3">
          <div class="container">
            <div class="section-heading d-flex align-items-center justify-content-between">
              <h6 class="ml-1">Top Products</h6>
            </div>
            <div class="row">
              <!-- Single Top Product Card-->
              <div class="col-6 col-md-4 col-lg-3 my-4" v-for="(productCard, index) in topProductCards" :key="index">
                <router-link :to="{ name: 'menu', params: { menuId: 1 }}">
                  <div class="card menuCard roundedCard shadowed">
                    <img class="card-img-top roundedImage" src="https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg" alt="Card image cap">
                    <div class="cardBody">
                      <p class="card-title text-center display-4 mt-2" style="font-size:1rem">{{productCard.name}}</p>
                      <p class="card-subtitle mb-2 text-center" style="color:#55d6d0">฿{{productCard.displayPrice}}</p>
                      <p class="card-text text-center text-muted">{{productCard.description}}</p>
                    </div>
                  </div>
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    </div>
    <!-- Internet Connection Status-->
    <!-- Footer Nav-->
    
</template>

<script>

  import SearchBar from "../components/SearchBar"

  export default {
    components: {
      SearchBar
    },
    name: "Test",
    data() {
      return {
        topProductCards: [],
        deliveryInfo: {}
      }
    },
    created(){
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

      this.axios.get('https://capriapp-backend.herokuapp.com/menu/get_all_menus')
          .then(res => {
          this.topProductCards = res.data
          window.console.log(this.topProductCards)

          }
          )
        .catch(function (error) {window.console.log(error)});
      
    },
    methods: {
      submit() {


      },
      destroyCard() {

       
      },
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
  }
</script>


<style scoped>

  .categoryText {
    font-size: 1rem;
    color: black;
    margin-top: 0.33rem;
  }

  .categoryCard {
   padding: 0.7rem !important;
   margin: 0 !important;
}

.roundedCard {
  border-radius: 25px;
  /* border: 1px groove lightgrey ; */
  padding: 0px;
  width: 100%;
  height: 5rem;
  background-size: cover; /* or contain depending on what you want */
  background-position: center center;
  background-repeat: no-repeat;
}

.shadowed {
  box-shadow: 3px 4px 5px 4px lightgrey;

}

.menuCard {
  border-radius: 25px;
  height: 12rem;
}

.roundedImage {
  border-radius: 25px 25px 0px 0px;
}

.cardBody {
  padding: 0px;
  margin: 0px;
  padding-left: 0.5rem;
}

.card-title {
  font-size: 1rem !important;
  color: black;
}

.card-subtitle {
  font-size: 0.8rem !important;
}

.card-text {
  font-size: 0.7rem !important;
  color:black
}

.fonted {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}

.lightColour {
  color:#55d6d0;
}


</style>