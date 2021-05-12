<template>
        <div class="row searchBar lightBackground">
          <div class="col-2 d-flex justify-content-center my-auto">
            <a href="#" @click.prevent="$router.go(-1)" style="color:white">
              <i class="fas fa-chevron-left my-auto" style="color:white"></i>
            </a>
          </div>
          
          <div class="col-8 d-flex justify-content-center my-1">
            <div class="input-group col-md-4">
              <input class="form-control border-right-0 border" type="search" id="example-search-input" placeholder="Search" v-model="searchKey" >
              <span class="input-group-append">
                <button class="btn btn-outline-secondary border-left-0 border" type="button" style="background-color:white" v-on:click="search()">
                  <i class="fa fa-search lightColour" style="background-color:white"></i>
                </button>
              </span>
            </div>
          </div>

          <div class="col-2 d-flex justify-content-center my-auto">
            <div class="pr-5">
              <p class="my-auto" style="color:white" >Profile</p>
            </div>
          </div>
        </div>
</template>


<script>
export default {
    name: "SearchBar",
    methods: {
      login() {
        this.$auth.loginWithRedirect();
      },
      logout() {
        this.$auth.logout();
        this.$router.push({ path: "/" });
      },
      search(){
        this.$router.push({name: "search", params: {searchKey: this.searchKey}})
      }
    }
}
</script>

<style scoped>
  .clearfix {
    overflow: auto;
  }

  .headerArea {
    box-shadow: 1px 1px 5px 1px lightgrey;

  }

  .top-search-form {
    display: block;
  }

  .input-group-addon {
    position:absolute
  }

  .locationBar {
    background-color:white;
  }

  .searchBar {
    border-top-color: lightgrey;
    border-top-style: solid;
    border-width: 1px;
  }




 

</style>