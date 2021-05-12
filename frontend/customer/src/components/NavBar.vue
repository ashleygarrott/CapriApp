<template>
  <div id = "footer" class = "fixed-bottom">
    <div class="navBar">
      <div class="row my-auto" id="bottomNav" >
        <div class="col-3 text-center mt-1">
          <router-link :to="{ name: 'home'}" style="color:none">
            <i class="fas fa-home navIcon lightColour"></i>
            <p class = "navbarText mb-1 lightColour">Home</p>
          </router-link>
        </div>
        <div class="col-3 text-center mt-1">
          <router-link :to="{ name: 'cart'}" style="color:none">
            <i class="fas fa-shopping-cart navIcon lightColour"></i>
            <p class = "navbarText mb-1 lightColour">Cart</p>
          </router-link>
        </div>
        <div class="col-3 text-center mt-1">
          <router-link :to="{ name: 'support'}" style="color:none">
            <i class="fas fa-question navIcon lightColour"></i>
            <p class = "navbarText mb-1 lightColour">Support</p>
          </router-link>
        </div>
        <div class="col-3 text-center mt-1">
          <router-link :to="{ name: 'account'}" style="color:none">
            <i class="fas fa-user navIcon lightColour"></i>
            <p class = "navbarText mb-1 lightColour">Account</p>
          </router-link>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NavBar",
  methods: {
    login() {
      this.$auth.loginWithRedirect();
    },
    logout() {
      this.$auth.logout();
      this.$router.push({ path: "/" });
    }
  }
};
</script>

<style>
#mobileAuthNavBar {
  min-height: 125px;
  justify-content: space-between;
}




</style>
