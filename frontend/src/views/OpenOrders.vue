<template>
    <div class="container flex-grow-1 bodyArea">
        Order page
                <div v-if="orders.length < 1">
                    There are currently no open orders
                </div>
                <div class="row" v-if="orders.length > 0" >
                    <div class="card" style="width:100%">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item" v-for="(order, index) in orders" :key="index">
                                <div class="row">
                                    <div class = "col-1 px-0">
                                        <p class="titleText">{{order.orderType}}</p>
                                    </div>
                                    <div class = "col 2 px-0">
                                        <p class="titleText">{{order.address}}</p>
                                    </div>
                                    <div class = "col-6 px-0">
                                        <div class="row" v-for="(item, index) in order.orders" :key="index">
                                            <div class="col-4">
                                                <p class="contentText">{{item.menuName}}</p>
                                            </div>
                                            <div class="col-4">
                                                <p class="contentText">{{item.optionString}}</p>
                                            </div>
                                            <div class="col-2">
                                                <p class="contentText">x{{item.quantity}}</p>
                                            </div>
                                            <div class="col-2">
                                                <p class="contentText">{{item.menuPrice}}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class = "col-1 px-0">
                                        <p class="titleText">{{order.orderPrice}}</p>
                                    </div>
                                        <div class="col-2">
                                            <div v-if="order.response==''" :key="order.orderId">
                                               <button v-on:click="acceptOrder(order)" type="button" class="btn btn-primary btn-block">Accept</button>
                                                <button v-on:click="declineOrder(order)" type="button" class="btn btn-danger btn-block">Decline</button> 
                                                {{order.response}}
                                            </div> 
                                            <div v-if="order.response=='Accepted'" :key="order.response">
                                               Accepted
                                            </div> 
                                            <div v-if="order.response=='Declined'" :key="order.response">
                                               Declined
                                            </div> 
                                        </div>
                                    </div>
                            </li>
                        </ul>
                    </div>
                </div>

        </div>
</template>
<script>
export default {
    name: "OpenOrders",
    data (){
        return {
            orders: [
                {
                    address: "",
                    latitude: 0.0,
                    locationNotes: "",
                    longitude: 0.0,
                    orderId: "",
                    orderPrice: 0,
                    orderTime: "",
                    orderType: "",
                    orders: [
                        {
                            menuId: 0,
                            menuName: "",
                            menuPrice: 0,
                            optionString: "",
                            options: [],
                            quantity: 0
                        }
                    ],
                    response: "",
                    userId: ""
                }
            ]

        }
    },
    created(){
        this.axios.get('https://capriapp-backend.herokuapp.com/order/view_open_orders')
        .then(res => {
            this.orders = res.data
            for (var i=0;i<this.orders.length;i++){
                this.orders[i].response = ""
            }
            window.console.log(this.orders)
        })
    },
    methods: {
        acceptOrder(order){
            this.axios.post("https://capriapp-backend.herokuapp.com/order/confirm_order",{
                orderId: order.orderId
            })
            .then(res =>{
                window.console.log(res.data)

               if (res.data == "success"){
                   order.response = 'Accepted'
                   this.$forceUpdate();
                   
               } 
            })
        },

        declineOrder(order){
            this.axios.post("https://capriapp-backend.herokuapp.com/order/decline_order",{
                orderId: order.orderId
            })
            .then(res =>{
               if (res.data == "success"){
                   order.response = 'Declined'
                   this.$forceUpdate();
               } 
            })
        }

    }
}
</script>

<style scoped>
        
    .titleText {
        font-size:0.7rem;
    }

    .contentText {
        font-size:0.7rem;
        color:green;
    }

    .buttons {
        font-size: 1rem;
    }
</style>