<template>
    <div>
        <div class="fixed-top shadowed" style="background-color:white;">
            <div class="d-flex justify-content-between mx-3 my-2">
                <div>
                    <div class="d-flex justify-content-start ">
                        <i class="fas fa-arrow-left mr-4 my-auto mediumColour" style="font-size:20px" v-on:click="$router.go(-1)"></i>
                        <div>
                            <p class="my-auto" style="font-size:18px">{{categoryName}}</p>
                            <p class="mediumColour my-auto" style="font-size:12px"><b>{{$store.getters.getShortAddress}}</b></p>
                        </div>
                    </div>
                </div>
                <div class="d-flex">
                    <i class="fas fa-info-circle mediumColour my-auto"  style="font-size:20px"></i>
                </div>
            </div>
        </div>
        <br>
        <div>
        <v-tabs
            class="mt-5 fixed-tabs-bar"
            v-model="tab"
            background-color="transparent"
            color="#689489"
            show-arrows 
             
                     
            >
            <v-tab v-for="(category, index) in $store.getters.getCategories" :key="index">
                {{category.name}}
            </v-tab>
     
            <v-tabs-items v-model="tab">
                <v-tab-item
                    v-for="(category, index) in $store.getters.getCategories" :key="index"
                >
                    <div class="container flex-grow-1 bodyArea mt-3">
                        <div v-for="(menu, index) in category.value" :key="index">
                            <router-link :to="{ name: 'menu', params: { menuId: menu.id }}" v-if="menu.src">
                                <div class="row">
                                    <div class="col-5 col-m-3">
                                        <img class="py-1 roundedImage" v-bind:src="'/img/menus/' + menu.src" style="width:110px;height:110px;object-fit:cover;" @error="$event.target.src='/img/404.png'">
                                    </div>
                                    <div class="col-7 col-m-9 ml-0 pl-0">
                                        <p style="font-size:0.8rem;color:black" class="mt-1 mb-2"><b>{{menu.name}}</b></p>
                                        <p style="font-size:0.8rem" class="my-2 mediumColour"><b>{{menu.displayPrice}}</b></p>
                                        <p class="text-muted my-2 mb-0 darkgreyColour" style="font-size:0.7rem"><b>{{menu.thaiDescription}}</b></p>
                                    </div>
                                </div>
                            </router-link>
                        </div>
                        <div v-for="(menu, index) in category.value" :key="index+10000">
                            <router-link :to="{ name: 'menu', params: { menuId: menu.id }}" v-if="!menu.src">
                                <div class="row">
                                    <div class="col-5 col-m-3">
                                        <img class="py-1 roundedImage" v-bind:src="'/img/menus/' + menu.src" style="width:110px;height:110px;object-fit:cover;" @error="$event.target.src='/img/404.png'">
                                    </div>
                                    <div class="col-7 col-m-9 ml-0 pl-0">
                                        <p style="font-size:0.8rem;color:black" class="mt-1 mb-2"><b>{{menu.name}}</b></p>
                                        <p style="font-size:0.8rem" class="my-2 darkColour"><b>฿{{menu.displayPrice}}</b></p>
                                        <p class="text-muted my-2 mb-0 darkgreyColour" style="font-size:0.7rem"><b>{{menu.thaiDescription}}</b></p>
                                    </div>
                                </div>
                            </router-link>
                        </div>
                    </div>
                </v-tab-item>
            </v-tabs-items>
        </v-tabs>
        </div>
    
        
      <cart-pop-up />

    
        
    </div>
</template>


<script>


import CartPopUp from "../components/CartPopUp"
 
export default {
    components: {
        CartPopUp
    },
    name: "Category",
    data() {
        return {
            categories: [],
            tab: null,
            menus: [],
         
            
        }
    },
    created(){
        this.categoryName = this.$route.params.categoryName;

        //set tab
        window.console.log("CATEPGORIES")
        for (var i = 0;i<this.$store.getters.getCategoryNames.length;i++){
            if (this.$store.getters.getCategoryNames[i] == this.categoryName){
                this.tab = i
                window.console.log("SET TAB")
                break
            }
        }


        // for (var i=0;i<this.menus.length;i++){
        //     this.menus[i].src = "/img/menus/" + this.menus[i].src
        // }
    }

}
</script>

<style scoped>

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



.menuCard {
  border-radius: 25px;
  height: 12rem;
}

.roundedImage {
  border-radius: 10%;
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

.shadowed {
  box-shadow: 0px 0px 2px 1px lightgrey;

}

.fonted {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}

.sticky{
    position: -webkit-sticky; /* Safari */
    position: sticky;
    top: 0;
}

.fixed-tabs-bar .v-tabs__bar {
    
    position: -webkit-sticky;
    position: sticky;
    top: 0;
    z-index: 2;
}






</style>