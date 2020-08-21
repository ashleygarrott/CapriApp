<template>
    <div>
        <div>
            <search-bar />
        </div>
        <div class="row">
            <div class="col-6 col-md-4 col-lg-3" v-for="(menu, index) in menus" :key="index">
              <router-link :to="{ name: 'menu', params: { menuId: menu.id }}">
                <div class="card menuCard roundedCard">
                  <img class="card-img-top roundedImage" src="https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg" alt="Card image cap">
                  <div class="cardBody">
                    <p class="card-title text-center">{{menu.name}}</p>
                    <p class="card-subtitle mb-2 text-muted text-center">฿{{menu.price}}</p>
                    <p class="card-text text-center">{{menu.description}}</p>
                  </div>
                </div>
              </router-link>
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

        this.axios.post("http://localhost:9090/menu/get_menu_by_category", {
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
    border: 2px solid #49b3cd;
    padding: 0px;
    width: 100%;
    height: 5rem;
    background-size: cover; /* or contain depending on what you want */
    background-position: center center;
    background-repeat: no-repeat;
    }

    .roundedImage {
    border-radius: 25px 25px 0px 0px;
    }
    
    .menuCard {
    border-radius: 25px;
    height: 100%;
    }
</style>