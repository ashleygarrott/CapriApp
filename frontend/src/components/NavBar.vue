<template>
  <div id="blank">
  <div class="col-12">
  <div class="row" id="bottomNav">
    <div class="col-3 text-center">
      <a href="#" class = "text-light">
        <i class="fas fa-home navIcon"></i>
        <p class = "navbarText">Home</p>
      </a>
    </div>
    <div class="col-3 text-center">
      <a href="#" class = "text-light">
        <i class="fas fa-shopping-cart navIcon"></i>
        <p class = "navbarText">Cart</p>
      </a>
    </div>
    <div class="col-3 text-center">
      <a href="#" class = "text-light">
        <i class="fas fa-question navIcon"></i>
        <p class = "navbarText">Support</p>
      </a>
    </div>
    <div class="col-3 text-center">
      <a href="#" class = "text-light">
        <i class="fas fa-user navIcon"></i>
        <p class = "navbarText">Account</p>
      </a>
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

.navbarText {
  font-size:10pt;
  margin-top: 0px
}

.navIcon {
  margin-bottom: 0px;
  margin-top: 0px;
}
</style>
