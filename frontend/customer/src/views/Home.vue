<template>
<div>
    <div class="fixed-top shadowed" style="background-color:white;z-index:1">
      <div class="d-flex justify-content-between mx-3 my-2">
        <div>
          <div class="d-flex justify-content-start ">
            <i class="fas fa-bars mr-4 my-auto mediumColour" style="font-size:20px" v-on:click="drawer = !drawer;print()"></i>
            <div>
              <p class="my-0 mediumColour" style="font-size:14px"><b>{{$store.getters.getShortAddress}}</b></p>
              <p class="my-0 darkgreyColour" style="font-size:12px">Current Location</p>
            </div>
          </div>
        </div>
        <div class="d-flex">
          <i class="fas fa-info-circle mediumColour my-auto"  style="font-size:20px"></i>
        </div>
      </div>
    </div>
    <br>
    
    <div class="d-flex flex-column h-100 mt-5">
      <div class="whiteCard">
        <img src="/img/intro/intro2.jpg"  v-bind:height="windowWidth / 2.33 + 'px'" v-bind:width="windowWidth * 0.9 + 'px'"  class="roundedImage mt-1 mx-3">
      </div>

      <div class="container-fluid mx-0 my-2 mt-3">
          <div class="d-flex flex-row flex-nowrap scrolling-wrapper mx-0 h-100">
          <img class="roundedImage mr-2" src="/img/promotions/pesto.jpg" style="width:130px;height:130px;object-fit:cover">
          <img class="roundedImage mx-2" src="/img/promotions/matcha.jpg" style="width:130px;height:130px;object-fit:cover">
          <img class="roundedImage mx-2" src="/img/promotions/truffle.jpg"  style="width:130px;height:130px;object-fit:cover">


      </div>
      </div>

      
 
      <label class="mx-3 mt-3">Our menu</label>
       <div class="container-fluid mx-0 my-2">
          <div class="d-flex flex-row flex-nowrap scrolling-wrapper mx-0 h-100">
            <router-link :to="{ name: 'category', params: { categoryName: 'Pizza' }}">
              <div class="categoryContainer">
                <img class="roundedImage mr-2 mediumBackground" style="object-fit:cover" src="/img/categories/pizza.png" height="130px" width="115px">
                <p class="categoryText text-white"><b>Pizza</b></p>
              </div>
            </router-link>
            <router-link :to="{ name: 'category', params: { categoryName: 'Pasta' }}">
              <div class="categoryContainer">
                <img class="roundedImage mr-2 mediumBackground" style="object-fit:cover"  src="/img/categories/pasta.png" height="130px" width="115px">
                <p class="categoryText text-white"><b>Pasta</b></p>
              </div>
            </router-link>
            <router-link :to="{ name: 'category', params: { categoryName: 'Appetizer' }}">
              <div class="categoryContainer">
                <img class="roundedImage mr-2 mediumBackground" style="object-fit:cover"  src="/img/categories/appetizer.png" height="130px" width="115px">
                <p class="categoryText text-white"><b>Appetizer</b></p>
              </div>
            </router-link>
            <router-link :to="{ name: 'category', params: { categoryName: 'Thai' }}">
              <div class="categoryContainer">
                <img class="roundedImage mr-2 mediumBackground" style="object-fit:cover"  src="/img/categories/thai.png" height="130px" width="115px">
                <p class="categoryText text-white"><b>Thai</b></p>
              </div>
            </router-link>
            <router-link :to="{ name: 'category', params: { categoryName: 'Salad' }}">
              <div class="categoryContainer">
                <img class="roundedImage mr-2 mediumBackground" style="object-fit:cover"  src="/img/categories/salad.png" height="130px" width="115px">
                <p class="categoryText text-white"><b>Salad</b></p>
              </div>
            </router-link>
            <router-link :to="{ name: 'category', params: { categoryName: 'Drinks' }}">
              <div class="categoryContainer">
                <img class="roundedImage mr-2 mediumBackground" style="object-fit:cover"  src="/img/categories/drinks.png" height="130px" width="115px">
                <p class="categoryText text-white"><b>Drinks</b></p>
              </div>
            </router-link>
          </div>
        </div>
        

   
        <!-- Product Catagories-->

          
            <!-- <div class="lightBackground h-80 rounded">
              <p class="my-auto p-2" style="color:white">View all</p>
            </div> -->
        
        
        
        <!-- Top Products-->
        <div class="mx-3">     

          <p class=" mb-0 my-4" style="">Most popular</p>
          <div v-for="(menu, index) in $store.getters.getMenus.filter(menu => menu.categories.includes('Pasta'))" :key="index">
              <router-link :to="{ name: 'menu', params: { menuId: menu.id }}" v-if="menu.src">
                  <div class="row">
                      <div class="col-5 col-m-3">
                          <img class="py-1 roundedImage" v-bind:src="'/img/menus/' + menu.src" style="width:110px;height:110px;object-fit:cover;" @error="$event.target.src='/img/404.png'">
                      </div>
                      <div class="col-7 col-m-9 ml-0 pl-0">
                          <p style="font-size:0.8rem;color:black" class="mt-1 mb-2"><b>{{menu.name}}</b></p>
                          <p style="font-size:0.8rem" class="my-2 mediumColour"><b>{{menu.displayPrice}}</b></p>
                          <p class="text-muted my-2 mb-0" style="font-size:0.7rem"><b>{{menu.thaiDescription}}</b></p>
                      </div>
                  </div>
              </router-link>
              
          </div>
          
        </div>     
              
         
      </div>
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
      <cart-pop-up />
    </div>
    <!-- Internet Connection Status-->
    <!-- Footer Nav-->
    
</template>

<script>

  import NavBar from "../components/NavBar"
  import HomeHeader from "../components/HomeHeader"
  import { BButton, BModal, VBModal } from "bootstrap-vue";
  import CartPopUp from "../components/CartPopUp"
  import Sidebar from "../components/Sidebar"


  export default {
    components: {
      HomeHeader,
      NavBar,
      BModal,
      BButton,
      VBModal,
      CartPopUp,
      Sidebar
    },
    name: "Test",
    data() {
      return {
        test: "",
        drawer: false,
        hidden: false,
        windowWidth: window.innerWidth,
        searchKey: "",
        address: "",
        useGps: true,
        mode: "delivery",
        topProductCards: [],
        promotedMenus: [],
        shortenedAddress: "sample destination",
        twoColumnWidth: 0

      }
    },
    created(){
      this.twoColumnWidth = this.$parent.screenWidth * 0.85 / 2
      this.twoColumnHeight = this.$parent.screenWidth * 0.65 / 2



      
    },
    mounted() {

      

      this.axios.get(this.$parent.api + 'menu/get_promoted_menus')
      .then(res => {
      this.promotedMenus = res.data
      window.console.log(this.promotedMenus)
      }
      )
      .catch(function (error) {window.console.log(error)});

      window.console.log(this.$auth)
    },
    methods: {
      setMode(mode){
        this.mode = mode;
        this.$store.commit("setOrderMode", mode)
      },
      search(){
        this.$router.push({name: "search", params: {searchKey: this.searchKey}})
      },
      isValidOrderMode(orderMode){
        if (orderMode == "delivery"){
          return true
        }
        if (orderMode == "takeaway"){
          return true
        }
        if (orderMode == "dinein"){
          return true
        }
        return false
      },
      print(){
        window.console.log(this.drawer)
      }
    }
    }
  
</script>


<style scoped>



.topProductCard {
  border-radius: 10px;
  width:220px;
  height:370px;


}

.shadowed {
  box-shadow: 0px 0px 2px 1px lightgrey;

}

.menuCard {
  border-radius: 25px;
  height: 12rem;
}

.roundedImage {
  border-radius: 10px 10px 10px 10px;
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




.categoryImage img {
  width:80%;
  height:80%;
}

.scrolling-wrapper {
  overflow-x: scroll;
  overflow-y: hidden;
  -webkit-overflow-scrolling: touch;

  
}

 .scrollCard {
    display: inline-block;
    white-space: normal 
  }



  .rounded {
    border-radius: 10%;
  }

  .greyBackground {
    background-color: lightgrey;
  }

  .checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 22px;
  width: 22px;
  border-radius: 50%;
  border-color: lightgrey;
  border-style: solid;
  border-width: 3px;
}

/* On mouse-over, add a grey background color */
.radioContainer:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.radioContainer input:checked ~ .checkmark {
  background-color:#49b3cd;
  
}

/* Create the indicator (the dot/circle - hidden when not checked) */
  position: absolute;
.checkmark:after {
  content: "";
  display: none;
  background-color: white;
}

/* Hide the browser's default radio button */
.radioContainer input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
}

@keyframes moveUp {
  from {
    position: relative;
    bottom:20px
  }
  to {position:static}
}

.notificationCard {
  border-radius: 10%;
  box-shadow: 0px 0px 3px 1px lightgrey;

  
}

.slide-fade-enter-active {
  transition: all 2s ease;
}
.slide-fade-leave-active {
  transition: all 2s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-fade-enter, .slide-fade-leave-to
/* .slide-fade-leave-active below version 2.1.8 */ {
  transform: translateX(10px);
  opacity: 0;
}

 .roundButton {
   border-radius: 50%
 }

 .categoryContainer {
   position:relative
 }

 .categoryText {
   position:absolute;
   bottom: -10px;
   left: 10px;
   font-size: 16px;
 }





</style>