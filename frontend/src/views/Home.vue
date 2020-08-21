<template>
<div>


    
    <div class="page-content-wrapper">
      <div>
        <search-bar />
      </div>

      <div class="row d-flex justify-content-center">
        <div v-if="$parent.deliveryInfo!={}">
          <div class="d-flex justify-content-center text-center px-4 mb-0">
            <p style="color:lightgrey;font-size:0.5rem">{{$parent.shortenedAddress}}</p>
            <p style="color:white">a</p>
            <p style="font-size:0.5rem;color:#55d6d0">({{$parent.deliveryInfo.distance.humanReadable}}/{{$parent.deliveryInfo.duration.humanReadable}}/฿{{$parent.deliveryInfo.deliveryFee}})</p>
          </div>
        </div>

        <div v-if="$parent.deliveryInfo=={}">
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
            <h6 class="ml-1">Our categories</h6>
            <a class="btn  btn-sm" href="shop-grid.html" style="color:white;background-color:#55d6d0">View All</a>
          </div>
        
          <div class="product-catagory-wrap">
            <div class="row">
              <!-- Single Catagory Card-->
              <div class="col-4 categoryCard">
                <router-link :to="{ name: 'category', params: { categoryName: 'pizza' }}">
                  <div class="roundedCard" style="background-image: url('https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg')"></div>
                  <div>
                    <p class = "categoryText  text-center"> Pizza </p>
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
            <div class="col-6 col-md-4 col-lg-3" v-for="(productCard, index) in topProductCards" :key="index">
              <router-link :to="{ name: 'menu', params: { menuId: 1 }}">
                <div class="card menuCard roundedCard">
                  <img class="card-img-top roundedImage" src="https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg" alt="Card image cap">
                  <div class="cardBody">
                    <p class="card-title text-center">{{productCard.name}}</p>
                    <p class="card-subtitle mb-2 text-muted text-center">฿{{productCard.price}}</p>
                    <p class="card-text text-center">{{productCard.description}}</p>
                  </div>
                </div>
              </router-link>
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
        topProductCards: []
      }
    },
    mounted() {

      this.axios.get('http://localhost:9090/menu/get_all_menu_cards')
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
  border: 2px solid #49b3cd;
  padding: 0px;
  width: 100%;
  height: 5rem;
  background-size: cover; /* or contain depending on what you want */
  background-position: center center;
  background-repeat: no-repeat;
}

.menuCard {
  border-radius: 25px;
  height: 100%;
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


</style>