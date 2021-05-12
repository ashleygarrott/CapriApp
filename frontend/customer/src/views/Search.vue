<template>
    <div>
        <div class="lightBackground fixed-top">
            <location-bar />
            <div class="d-flex justify-content-around my-2">
                <a href="#" @click.prevent="$router.go(-1)" style="color:white">
                    <i class="fas fa-chevron-left my-auto" style="color:white"></i>
                </a>
                <h5 style="color:white">{{$route.params.searchKey}}</h5>
                <router-link :to="{ name: 'search', params: { searchKey: '' }}" v-if="$parent.deliveryInfo != {}">
                    <i  class="fas fa-search my-auto" style="color:white"></i>
                </router-link>
                <a href="#" @click.prevent="requestLocation()" v-if="$parent.deliveryInfo == {}">
                    <i class="fas fa-map-marker-alt my-auto" style="color:white"></i>
                </a>
            </div>
        </div>
        <div class="container flex-grow-1 bodyArea mt-5">
            
            <div v-for="(menu, index) in menus" :key="index">
                <router-link :to="{ name: 'menu', params: { menuId: menu.id }}">
                    <div class="row">
                        <div class="col-5 col-m-3">
                            <img class="py-1" v-bind:src="'/img/menus/' + menu.src" style="width:100%;height:100%;object-fit:cover;">
                        </div>
                        <div class="col-7 col-m-9 ml-0 pl-0">
                            <p style="font-size:0.8rem;color:black" class="my-0"><b>{{menu.name}}</b></p>
                            <p style="font-size:0.8rem" class="my-0 lightColour"><b>฿{{menu.displayPrice}}</b></p>

                            <p class="text-muted" style="font-size:0.7rem"><b>{{menu.thaiDescription}}</b></p>
                            <p class="text-muted" style="font-size:0.7rem">{{menu.englishDescription}}</p>

                        </div>
                    </div>
                </router-link>
                <hr>
            </div>
        </div>
        <nav-bar />
    </div>
    
</template>


<script>

import SearchBar from "../components/SearchBar.vue"
import LocationBar from "../components/LocationBar.vue"
import NavBar from "../components/NavBar.vue"
export default {
    components: {
        SearchBar,
        LocationBar,
        NavBar
    },
    name: "Search",
    data() {
        return {
            menus: [],
            deliveryInfo: {
            deliveryFee: 0, 
            destination: "",
            distance: {
                humanReadable: "",
                inMeters: 0
            },
            duration: {
                humanReadable: "",
                inSeconds: 0
            },
            shortenedAddress: "sample destination"
            }
            
        }
    },
    created(){
        this.deliveryInfo=this.$parent.deliveryInfo
        this.axios.post(this.$parent.api + 'menu/get_search_results', {
            string: this.$route.params.searchKey
        })
        .then(res => {
            this.menus = res.data
            window.console.log("menus" + this.menus)
            window.console.log(this.$route.params.searchKey)
        })

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

.headerArea {
    background-color: #49b3cd;
}


</style>