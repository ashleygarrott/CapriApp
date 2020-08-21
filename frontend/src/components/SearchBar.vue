<template>
    <div class="headerArea fixed-top row headerColour" id="headerArea">
        <!-- Search Form-->
          <div class="col-2 d-flex justify-content-center my-auto">
            <a href="#" @click.prevent="$router.go(-1)" style="color:white">
              <i class="fas fa-undo pl-5" style="color:#42ccc9"/>
            </a>
          </div>
          
          <div class="col-8 d-flex justify-content-center">
            <div class="input-group col-md-4">
            <input class="form-control py-2 border-right-0 border" type="search" value="search" id="example-search-input" style="color:#42ccc9">
            <span class="input-group-append">
              <button class="btn btn-outline-secondary border-left-0 border" type="button" style="background-color:white">
                <i class="fa fa-search" style="background-color:white;color:#42ccc9"></i>
              </button>
            </span>
        </div>
          </div>

          <div class="col-2 d-flex justify-content-center my-auto" v-if="!$auth.isAuthenticated">
            <div class="pr-5">
              <a href="#" @click.prevent="login()" style="color:white">Login</a>
            </div>
          </div>
          <div class="col-2 d-flex justify-content-center my-auto" v-if="$auth.isAuthenticated">
            <p style="color:white">{{$auth.user.name}}</p>
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
      }
    }
}
</script>

<style scoped>
  .clearfix {
    overflow: auto;
  }

  .headerArea {
    background-color: white;
    background-color: #49b3cd;
    box-shadow: 1px 1px 1px 1px lightgrey;

  }

  .top-search-form {
    display: block;
  }

  .input-group-addon {
    position:absolute
  }



 

</style>