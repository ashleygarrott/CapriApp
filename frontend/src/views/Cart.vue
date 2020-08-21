<template>
    <div>
        <div>
            <search-bar />
        </div>
        <div class="container-fluid">
            <div v-if="$parent.orders.length < 1">
                You current have no orders in your basket
            </div>
            <div class="row" v-if="$parent.orders.length > 0">
                <div class="card ordersCard">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item" v-for="(order, index) in $parent.orders" :key="index">
                            <div class="row">
                                <div class = "col-2 px-0">
                                    <i class="fas fa-times-circle"></i>
                                </div>
                                <div class = "col-6 px-0">
                                    <p>{{order.menuName}}</p>
                                </div>
                                <div class = "col-2 px-0">
                                    <p style="font-size:0.7rem;">{{order.orderPrice}}</p>
                                </div>
                                <div class = "col-2 px-0">
                                <p style="font-size:0.7rem;">{{order.quantity}}</p>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="row" v-if="$parent.orders.length > 0" >
                    <button v-on:click="submitOrder()" type="button" class="btn btn-primary">Order</button>
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
    name: "Cart",
    data() {
        return {
        }
    },
    created() {
        window.console.log(this.$parent.orders.length)
    },
    methods: {
        submitOrder(){

            var finalOrders = []
            var totalPrice = 0


            for (var i=0;i<this.$parent.orders.length;i++){
                var obj = {
                    menuId: this.$parent.orders[i].menuId,
                    quantity: this.$parent.orders[i].quantity
                }
                totalPrice += this.$parent.orders[i].orderPrice
                finalOrders.push(obj)
            }

            var email = this.$auth.isAuthenticated ? this.$auth.user.email : "guest"

            var orderDTO = {
                userId: email,
                orderPrice: totalPrice,
                orderType: "delivery",
                orders: finalOrders
            }

            this.axios.post('http://localhost:9090/order/make_order', orderDTO)
            .then(res => {
            window.console.log(res.data)
            this.$parent.orders = []
            this.$router.push({ name: 'postOrder'})
            }
            )
            .catch(function (error) {window.console.log(error)});

            
        }
    }
}
</script>

<style scoped>

    .ordersCard {
        width: 100%;
    }


</style>