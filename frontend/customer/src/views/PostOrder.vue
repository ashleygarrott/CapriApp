<template>
    <div>
        <div class="fixed-top shadowed" style="background-color:white;z-index:1">
            <div class="d-flex justify-content-between mx-3 my-2">
                <div>
                <div class="d-flex justify-content-start ">
                    <i class="fas fa-bars mr-4 my-auto mediumColour" style="font-size:20px" v-on:click="drawer = !drawer;print()"></i>
                    <div>
                    <p class="my-0 darkgreyColour" style="font-size:18px">Order status</p>
                    </div>
                </div>
                </div>
                
            </div>
        </div>
        <br><br>

        <div class=" mx-5 mt-3">
            <div class="d-flex justify-content-center mb-2">
            <p class="text-muted mt-2 my-0" style="font-size:14px">Estimated delivery</p>
            </div>
            <div class="d-flex justify-content-center mb-3">
            
            <p style="font-size:20px" class="my-0"><b>15 mins</b></p>
    
            </div>
        </div>
        
        <div class="d-flex justify-content-center">
            <div>
                
            <div class="d-flex justify-content-start mb-3">
                <div class="progressCircleOn d-flex justify-content-center ">
                    <i class="fas fa-cash-register my-auto mediumColour" style="font-size:14px"></i>
                </div>
                <div v-if ="$store.getters.getOrder.status == 'unconfirmed'" style="width: 60px" class="my-auto progressLine">
                    <div class="animatedProgressLine">
                    </div>
                </div>
                
                <div v-if ="$store.getters.getOrder.status != 'unconfirmed'" class="my-auto doneProgressLine"></div>
                <div v-if="$store.getters.getOrder.status != 'unconfirmed'" class="progressCircleOn  d-flex justify-content-center my-auto">
                    <i class="fas fa-vote-yea mediumColour my-auto"  style="font-size:14px"></i>
                </div>
                <div v-if="$store.getters.getOrder.status == 'unconfirmed'" class="progressCircleOff  d-flex justify-content-center my-auto">
                    <i class="fas fa-vote-yea my-auto"  style="color:grey;font-size:14px"></i>
                </div>
                <div v-if ="$store.getters.getOrder.status == 'confirmed'" style="width: 60px" class="my-auto progressLine">
                    <div class="animatedProgressLine">
                    </div>
                </div>
                <div v-if ="$store.getters.getOrder.status == 'unconfirmed'" class="my-auto progressLine"></div>
                <div v-if ="$store.getters.getOrder.status == 'delivering' || $store.getters.getOrder.status == 'delivered'" class="my-auto doneProgressLine"></div>
                <div v-if="$store.getters.getOrder.status == 'delivering' || $store.getters.getOrder.status == 'delivered'" class="progressCircleOn d-flex justify-content-center">
                    <i class="fas fa-truck my-auto mediumColour" style="font-size:13px;position:relative;left:1px"></i>
                </div>
                <div v-if="!($store.getters.getOrder.status == 'delivering' || $store.getters.getOrder.status == 'delivered')" class="progressCircleOff d-flex justify-content-center">
                    <i class="fas fa-truck my-auto " style="color:grey;font-size:13px;position:relative;left:1px"></i>
                </div>
                <div v-if ="$store.getters.getOrder.status == 'delivering'" style="width: 60px" class="my-auto progressLine">
                    <div class="animatedProgressLine">
                    </div>
                </div>
                <div v-if ="$store.getters.getOrder.status == 'delivered'" class="my-auto doneProgressLine"></div>

                <div v-if ="$store.getters.getOrder.status != 'delivering' && $store.getters.getOrder.status != 'delivered'" class="my-auto progressLine"></div>
                <div  v-if="$store.getters.getOrder.status == 'delivered'" class="progressCircleOn d-flex justify-content-center">
                    <i class="fas fa-home my-auto mediumColour" style="font-size:14px"></i>
                </div>
                <div  v-if="$store.getters.getOrder.status != 'delivered'" class="progressCircleOff d-flex justify-content-center">
                    <i class="fas fa-home my-auto" style="color:grey;font-size:14px"></i>
                </div>
            </div>
            <p v-if="$store.getters.getOrder.status =='unconfirmed'" class="statusText"><b>Waiting for confirmation from Capri Cove</b></p>
            <p v-if="$store.getters.getOrder.status =='confirmed'" class="statusText"><b>We're now preparing your food</b></p>
            <p v-if="$store.getters.getOrder.status =='delivering'" class="statusText"><b>We are on our way</b></p>
            <p v-if="$store.getters.getOrder.status =='delivered'" class="statusText"><b>Your food has arrived!</b></p>
            </div>
        </div>

        <!-- <hr style="background-color:grey"> -->
        <div class="mt-3 mx-3 p-2" style="box-shadow:0px 0px 3px 2px #f0f0f0;border-radius: 10px">
        <div class="d-flex justify-content-center">
            <img src="/img/logos/logo.png" style="width:50px;height:50px">
        </div>
        <div class="d-flex justify-content-center">
            <p class="my-0 mt-1">Capri Cove</p>
        </div>
        <div class=" mx-5 d-flex justify-content-center">
            <p class="text-muted my-0 mt-1" style="font-size:12px;text-align: center">ซอย บ้านตั้งสิน Salaya, Phutthamonthon District, Nakhon Pathom 73170</p>
        </div>
        <order-summary-component v-bind:order="$store.getters.getOrder"/>
        </div>
        <br><br><br>
               


        <div class="fixed-bottom" >
            <div class="d-flex justify-content-center mt-2 mx-3 mb-3">
                <div v-if="$store.getters.getOrder.status == 'unconfirmed'" class="rounded redBackground d-flex justify-content-center my-0" style="width:100%" v-on:click="$parent.declineOrder($store.getters.getOrder)">
                    <p class="my-2" style="color:white">Cancel order</p>
                </div>
                <div v-if="$store.getters.getOrder.status != 'unconfirmed'" class="rounded d-flex justify-content-center my-0 mediumBackground" style="width:100%">
                    <div class="d-flex">
                        <i class="fas fa-phone-alt my-auto mr-2" style="color:white"></i>
                        <a href="tel:0918042154">    
                        <p class="my-2" style="color:white">Call Capri Cove</p>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { io } from "socket.io-client";
import OrderSummaryComponent from '../components/OrderSummaryComponent.vue';

export default {
    name: "postOrder",
    components: {
        OrderSummaryComponent
    },
    data(){
        return {
            showColon: true
        }
    },
    created() {

        if (!this.$route.params.nofetch){
            this.updateOrder(window.localStorage.getItem("lastOrderId"))
        }
        else{
            this.updateOrder(this.$store.getters.getOrder.orderId)
        }    
        
        const socket = io("https://35.247.141.30:9091");
        socket.on("status", (orderId) => {    
            if (this.$store.getters.getOrder.orderId == orderId) {
                this.updateOrder(orderId)
            }
        });

        socket.on("connect", () => {
                window.console.log("connected!")
                window.console.log(socket.id)
            });



        this.oscilateColon()

    },
    methods: {
        updateOrder(id){
        this.axios.post(this.$parent.api + 'order/get_order', {
        string: id
        })
        .then(res => {
            this.$store.commit("setOrder", res.data)
        })
        .catch(function (error) {window.console.log(error)});
        },

        oscilateColon: function () {
            setInterval(() => {
                this.showColon = !this.showColon
                window.console.log(this.showColon)
            }, 700);
        }
        
            
    }
}
</script>

<style scoped>
    .ETAcard{
        border-style:solid;
        border-color:rgb(207, 207, 207);
        border-radius: 10px;
        border-width: 1px;
        box-shadow: 0px 1px 8px 1px lightgrey
    }

    .description{
        font-size: 14px
    }

    .animate {
        width: 100px;
        height: 20px;
        background-color: red;
        animation-name: example;
        animation-duration: 1s;
        animation-iteration-count: infinite;
    }

    @keyframes example {
        0%   {width: 0px}
        /* 25%  {background-color:yellow; left:200px; top:0px;}
        50%  {background-color:blue; left:200px; top:200px;}
        75%  {background-color:green; left:0px; top:200px;} */
        100% {width: 100px}

        }
    .progressLine {
        width:60px;
        height: 0px; 
        border-bottom: 3px solid lightgrey;
        position: relative;
        top: 1px
    }

    .animatedProgressLine {
        width:60px;
        height: 0px; 
        border-bottom: 3px solid #639177;
        animation-name: load;
        animation-duration: 2s;
        animation-iteration-count: infinite;
    }

    .doneProgressLine {
        width:60px;
        height: 0px; 
        border-bottom: 3px solid #639177;
        position: relative;
        top: 1px
    }

    @keyframes load {
        0%   {width: 0%}
        50%  {width: 100%}
        
        /* 25%  {background-color:yellow; left:200px; top:0px;}
        50%  {background-color:blue; left:200px; top:200px;}
        75%  {background-color:green; left:0px; top:200px;} */

        }

    .progressCircleOff {
        border-radius:50%;
        width:30px;
        height:30px;
        border-style: solid;
        border-color: grey;
        border-width: 3px;
    }

     .progressCircleOn {
        border-radius:50%;
        width:30px;
        height:30px;
        border-style: solid;
        border-color: #639177;
        border-width: 3px;
    }

    .statusText {
        margin-left: 3px;
        margin-top: 10px;
        font-size: 14px;
    }

    .centerOverflow{

        text-align: center;
    }
    
</style>