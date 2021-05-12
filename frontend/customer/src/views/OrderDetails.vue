<template>
    <div class="container">
        <div class="d-flex">
            <p><b>Status: </b></p>
            <p style="color:white">a</p>
            <p v-if="order.status=='confirmed'" class="text-success"><b>{{order.status}}</b></p>
            <p v-if="order.status=='canceled'" class="text-danger"><b>{{order.status}}</b></p>
            <p v-if="order.status=='unconfirmed'" class="text-warning"><b>{{order.status}}</b></p>

        </div>
        

        <p><b>Time:</b> {{order.orderTime}}</p>
        <p><b>Order Type:</b> {{order.orderType}}</p>

        <div v-if="order.orderType=='delivery'">
            <div class="d-flex">
                <p class="titleText"><b>Address:</b></p>
                <p class="invisText">a</p>
                <p class="titleText text-muted">{{order.address}}</p>
            </div>
            <a  v-bind:href="'http://mapy.google.pl?q=' + order.latitude+ ',' + order.longitude">    
                <button type="button" class="btn btn-info btn-block">Maps</button>
            </a>
        </div>

        <div v-if="order.orderType=='delivery' || order.orderType=='takeaway'">
            <p class="mt-4"><b>Phone number:</b> {{order.phoneNumber}}</p>
            <a v-bind:href="'tel:' + order.phoneNumber">    
                <button type="button" class="btn btn-info btn-block">Call</button>
            </a>
        </div>

        <div class="my-3">
            <p><b>Items</b></p>
            <hr>
            <div v-for="(item, index) in order.orders" :key="index">
                <div class="row">
                    <div class="col-4">
                        <p class="contentText">{{item.menuName}}</p>
                    </div>
                    <div class="col-4">
                        <p class="contentText text-center">{{item.optionString}}</p>
                    </div>
                    <div class="col-2">
                        <p class="contentText">x{{item.quantity}}</p>
                    </div>
                    <div class="col-2">
                        <p class="contentText">{{item.menuPrice}}</p>
                    </div>                    
                </div>
                <hr>
            </div>
        </div>
        <div v-if="order.status=='unconfirmed'" :key="order.status" class="row"> 
            <div class="col-6">
                <button v-on:click="$parent.acceptOrder(order)" type="button" class="btn btn-success btn-block">Accept</button>
            </div>
            <div class="col-6">
                <button v-on:click="$parent.declineOrder(order)" type="button" class="btn btn-danger btn-block">Decline</button> 
            </div>
        </div>


    </div>
    
</template>

<script>
export default {
    name: "OrderDetails",
    data(){
        return {
            order: {
                orderType: ''
            }
        }
    },
    created(){
        this.axios.post(this.$parent.api + 'order/get_order', {string: this.$route.params.orderId}, this.$parent.config)
        .then(res => {
        this.order = res.data
        window.console.log(this.order)
        })
    },
    methods: {
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
                this.$parent.updateConfig()
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


            
        }
    }
}
</script>

<style scoped>
    .invisText{
        color:white;
    }

</style>
