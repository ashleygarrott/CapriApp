import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Profile from "../views/Profile.vue";
import Test from "../views/Test.vue";
import Menu from "../views/Menu.vue";
import { authGuard } from "../auth";

Vue.use(Router);

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/profile",
      name: "profile",
      component: Profile,
      beforeEnter: authGuard
    },
    {
      path: "/test",
      name: "test",
      component: Test
    },
    {
      path: "/menu:menuId",
      name: "menu",
      component: Menu
    }
  ]
});

export default router;
