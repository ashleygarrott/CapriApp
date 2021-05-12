<template>
    <div>
        <div class="fixed-top darkBackground mt-0">
            <p class="text-center my-auto" style="color:white">Today's orders</p>
        </div>
        <br><br>
        <div class="container flex-grow-1 bodyArea">
            <div v-if="orders.length < 1">
                There are currently no open orders
            </div>
            <div class="row" v-if="orders.length > 0" >
                <div class="card" style="width:100%">
                    <ul class="list-group list-group-flush">
                        <div class="list-group-item" v-for="(order, index) in orders" :key="index">
                            <!-- <router-link :to="{ name: 'orderDetails', params: { orderId: order.orderId }}"> -->
                            <div class="row" v-on:click="selectOrder(order.orderId)">
                                <div class = "col-2 px-1">
                                    <p class="titleText text-dark">{{order.orderTime}}</p>
                                </div>
                                <div class = "col-2 px-1">
                                    <p class="titleText text-dark">{{order.orderType}}</p>
                                </div>
                                <div class = "col-5 px-1">
                                    <div class="row" v-for="(item, index) in order.orders" :key="index">
                                        <div class="col-8">
                                            <p class="text-secondary titleText text-center">{{item.menuName}}</p>
                                        </div>
                                        <div class="col-4">
                                            <p class="text-secondary titleText text-center">x{{item.quantity}}</p>
                                        </div>  
                                    </div>
                                </div>
                                <div class = "col-3 pl-1">
                                    <p v-if="order.status=='unconfirmed'" class="titleText text-warning text-center"><b>{{order.status}}</b></p>
                                    <p v-if="order.status=='confirmed'" class="titleText text-success"><b>{{order.status}}</b></p>
                                    <p v-if="order.status=='canceled'" class="titleText text-danger"><b>{{order.status}}</b></p>
                                </div>
                            </div>
                            <!-- </router-link> -->
                            <div v-if="order.status=='unconfirmed'" :key="order.status" class="row"> 
                                <div class="col-6">
                                    <button v-on:click="$parent.acceptOrder(order)" type="button" class="btn btn-success btn-block">Accept</button>
                                </div>
                                <div class="col-6">
                                    <button v-on:click="$parent.declineOrder(order)" type="button" class="btn btn-danger btn-block">Decline</button> 
                                </div>
                            </div>
                            <hr>
                        </div>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "OpenOrders",
    data (){
        return {
            config: {
                    headers: { 
                    'Authorization': "Bearer " + this.$parent.accessToken,
                    'Access-Control-Allow-Origin': '*'

                    }
            },
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
                    status: "",
                    phoneNumber: "",
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
                    userId: ""
                }
            ]

        }
    },
    created(){
        window.console.log("access token: " + this.$parent.accessToken)
        this.getOrders()
        this.$alert("Click OK");
        
        // this.axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.$parent.token;
        // this.axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*'

    },
    mounted(){
      
    },

    methods: {
        
        getOrders(){
            this.axios.get(this.$parent.api + 'order/get_daily_orders', this.$parent.config)
            .then(res => {
                this.orders = res.data
                for (var i=0;i<this.orders.length;i++){
                    this.orders[i].response = ""
                }
                this.refresh()
                window.console.log("token valid")
            })
            .catch(() => {
                this.refreshToken();

                });
            
        },
        updateConfig(){
            this.config = {
                    headers: { 
                    'Authorization': "Bearer " + this.$parent.accessToken,
                    'Access-Control-Allow-Origin': '*'

                    }
            }
        },
        redirectLogin(){
            window.console.log("redirecting to login")
            this.$router.push({name: "login"})
            window.clearInterval(this.loop)
        },
        refreshToken(){
            window.console.log(this.$parent.refresherToken)
            window.clearInterval(this.loop)
            this.axios.post(this.$parent.api + 'authenticate/token', {
                string: this.$parent.refresherToken

            })
            .then(res => {
                window.console.log(res.data)
                this.accessToken = res.data.accessToken
                window.localStorage.setItem("accessToken", res.data.accessToken)
                this.updateConfig()
                this.axios.get(this.$parent.api + 'order/get_daily_orders', this.$parent.config)
                .then(res => {
                    this.orders = res.data
                    for (var i=0;i<this.orders.length;i++){
                        this.orders[i].response = ""
                    }
                    this.refresh()
                    window.console.log("refresh successful")
                })
                .catch(() => {
                    this.redirectLogin();
                });
            })
            .catch(() => {
                window.console.log("GetNewAccessToken failed")
                this.$router.push({name: "login"})
                });


            
        },
        refresh: function(){
            this.loop = 
                window.setInterval(() => {
                    window.console.log(this.$parent.accessToken)
                    var length = this.orders.length
                    this.axios.get(this.$parent.api + 'order/get_daily_orders', this.$parent.config)
                    .then(res => {
                        this.orders = res.data
                        for (var i=0;i<this.orders.length;i++){
                            this.orders[i].response = ""
                        }
                        if (this.orders.length > length) {
                            window.console.log("new order")
                            var audioFile = new Audio('/sounds/notif.mp3');
                            audioFile.play();
                        }
                    })
                    .catch(() => {
                        window.console.log("calling refresh token")
                        this.refreshToken()
                    });
                
                
                }, 5000)
        },
        selectOrder(orderId){
            window.clearInterval(this.loop)
            this.$router.push({ name: 'orderDetails', params: { orderId: orderId }})

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