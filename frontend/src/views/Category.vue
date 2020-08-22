<template>
    <div>
        <div>
            <search-bar />
        </div>
        <div class="container flex-grow-1 bodyArea">
            <div class="d-flex justify-content-center">
                <div class="row">
                    <p class="display-4 lightColour" style="font-size:2rem">{{categoryName}}</p>
                    <p style="color:white">a</p>
                    <p class="display-4" style="font-size:2rem">selection</p>
                </div>   
            </div>
            <div class="row">
                <div class="col-6 col-md-4 col-lg-3 my-4" v-for="(menu, index) in menus" :key="index">
                <router-link :to="{ name: 'menu', params: { menuId: menu.id }}">
                    <div class="card menuCard roundedCard shadowed">
                    <img class="card-img-top roundedImage" src="https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg" alt="Card image cap">
                    <div class="cardBody">
                        <p class="card-title text-center display-4 mt-2" style="font-size:1rem">{{menu.name}}</p>
                        <p class="card-subtitle mb-2 text-center" style="color:#55d6d0">฿{{menu.price}}</p>
                        <p class="card-text text-center text-muted">{{menu.description}}</p>
                    </div>
                    </div>
                </router-link>
                </div>

            </div>
        </div>
    </div>
    
</template>


<script>

import SearchBar from "../components/SearchBar.vue"
export default {
    components: {
        SearchBar
    },
    name: "Category",
    data() {
        return {
            menus: []
            
        }
    },
    created(){
        this.categoryName = this.$route.params.categoryName;

        this.axios.post("https://capriapp-backend.herokuapp.com/menu/get_menu_by_category", {
            string: this.$route.params.categoryName
        })
        .then(res => {
            this.menus = res.data
            window.console.log(this.menus)
        })
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
</style>