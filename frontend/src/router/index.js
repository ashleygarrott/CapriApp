import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Profile from "../views/Profile.vue";
import Test from "../views/Test.vue";
import Menu from "../views/Menu.vue";
import Cart from "../views/Cart.vue"
import PostOrder from "../views/PostOrder.vue"
import Category from "../views/Category.vue"
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
    },
    {
      path: "/cart",
      name: "cart",
      component: Cart
    },
    {
      path: "/postOrder",
      name: "postOrder",
      component: PostOrder
    },
    {
      path: "/category:categoryName",
      name: "category",
      component: Category
    }
  ]
});

export default router;
