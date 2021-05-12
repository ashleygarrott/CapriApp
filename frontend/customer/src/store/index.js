import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
    state:{
        menus: [],
        categories: [],
        categoryNames: ["Pizza", "Pasta", "Thai", "Salad", "Bread", "Appetizer", "Drinks", "Specials"],
        orders: [],  //rename to basket
        productTotal: 0,
        deliveryInfo: {},
        currentLocation: {},
        shortAddress: "",
        gps: false,
        loaded: false,
        orderMode: "delivery",
        latitude: 0,
        longitude: 0,
        order: null

    },
    getters: {
        getAllTasks: state => {
            return state.tasks
        },
        getMenus: state => {
            return state.menus
        },
        getCategories: state => {
            return state.categories
        },
        getOrders: state => {
            return state.orders
        },
        getProductTotal: state => {
            return state.productTotal
        },
        getDeliveryInfo: state => {
            return state.deliveryInfo
        },
        getCurrentLocation: state => {
            return state.currentLocation
        },
        getShortAddress: state => {
            return state.shortAddress
        },
        hasGps: state => {
            return state.gps
        },
        isLoaded: state => {
            return state.loaded
        },
        getOrderMode: state => {
            return state.orderMode
        },
        getCategoryNames: state => {
            return state.categoryNames
        },
        getLatitude: state => {
            return state.latitude
        },
        getLongitude: state => {
            return state.longitude
        },
        getOrder: state => {
            return state.order
        }
    },
    mutations: {
        setMenus(state, payload){
            state.menus = payload
        },
        addCategory(state, payload){
            state.categories.push(payload)
        },
        addOrder(state, payload){
            state.orders.push(payload)
        },
        setProductTotal(state, payload){
            state.productTotal = payload
        },
        setDeliveryInfo(state, payload){
            state.deliveryInfo = payload
        },
        setCurrentLocation(state, payload){
            state.currentLocation = payload
        },
        setShortAddress(state, payload){
            state.shortAddress = payload
        },
        setGps(state, payload){
            state.gps = payload
        },
        setLoaded(state, payload){
            state.loaded = payload
        },
        setOrderMode(state, payload){
            state.orderMode = payload
        },
        setLatitude(state, payload){
            state.latitude = payload
        },
        setLongitude(state, payload){
            state.longitude = payload
        },
        setOrders(state, payload){
            state.orders = payload
        },
        updateItem(state, {payload, index}){
            state.orders[index] = payload
        },
        setOrder(state, payload){
            state.order = payload
        }

        
    
    },
    actions: {
        // addTask(context, payload){
        //     context.commit('addTask', payload)
        // }
    },
    modules: {}
});