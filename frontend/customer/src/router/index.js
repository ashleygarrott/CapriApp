import Vue from "vue";
import Router from "vue-router";
import Root from "../views/Root.vue"
import Home from "../views/Home.vue";
import Profile from "../views/Profile.vue";
import Test from "../views/Test.vue";
import Menu from "../views/Menu.vue";
import EditItem from "../views/EditItem.vue"
import Cart from "../views/Cart.vue"
import PostOrder from "../views/PostOrder.vue"
import Category from "../views/Category.vue"
import OpenOrders from "../views/OpenOrders.vue"
import Search from "../views/Search.vue"
import Checkout from "../views/Checkout.vue"
import OrderOptions from "../views/OrderOptions.vue"
import OrderDetails from "../views/OrderDetails.vue"
import EditLocation from "../views/EditLocation.vue"
import Login from "../views/Login.vue"
import PhoneNumber from "../views/PhoneNumber.vue"
import AddMenu from "../views/AddMenu.vue"
import SelectLocation from "../views/SelectLocation.vue"
import { authGuard } from "../auth";

Vue.use(Router);

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/home:orderMode?",
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
      path: "/menu:menuId/updateIndex?",
      name: "menu",
      component: Menu
    },
    {
      path: "/edititem:index/id",
      name: "editItem",
      component: EditItem
    },
    {
      path: "/cart",
      name: "cart",
      component: Cart
    },
    {
      path: "/postOrder:fetch?",
      name: "postOrder",
      component: PostOrder
    },
    {
      path: "/category:categoryName",
      name: "category",
      component: Category
    },
    {
      path: "/orders",
      name: "openOrders",
      component: OpenOrders
    },
    {
      path: "/search:searchKey",
      name: "search",
      component: Search
    },
    {
      path: "/checkout",
      name: "checkout",
      component: Checkout
    },
    {
      path: "/",
      name: "orderOptions",
      component: OrderOptions
    },
    {
      path: "/order:orderId",
      name: "orderDetails",
      component: OrderDetails
    },
    {
      path: "/addmenu",
      name: "AddMenu",
      component: AddMenu
    },
    {
      path: "/editlocation",
      name: "editLocation",
      component: EditLocation
    },
    {
      path: "/login",
      name: "login",
      component: Login
    },
    {
      path: "/selectLocation",
      name: "selectLocation",
      component: SelectLocation
    },
    {
      path: "/phoneNumber",
      name: "phoneNumber",
      component: PhoneNumber
    }
  ]
});

export default router;
