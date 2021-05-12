<template>
    <div class="cartBackground">
         <div class="fixed-top shadowed" style="background-color:white;">
            <div class="d-flex justify-content-between mx-3 my-2">
                <div>
                    <div class="d-flex justify-content-start ">
                        <i class="fas fa-times  mr-4 my-auto mediumColour" style="font-size:20px" v-on:click="$router.go(-1)"></i>
                        <div>
                            <p class="my-auto" style="font-size:18px">Cart</p>
                            <p class="mediumColour my-auto" style="font-size:12px"><b>{{$store.getters.getDeliveryInfo.distance.humanReadable}}</b></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="mt-4">
            
        
               
                    <div class=" mt-5 mb-4" style="z-index:5;position:relative">
                        
                        
                        <div class="mx-3 my-3">
                            
                            <div class="mx-5 whiteCard mb-4" style="position:relative">
                                <i class="fas fa-pen  font13" style="position:absolute;right:5px;top:5px" v-on:click="deliveryTimeSheet = !deliveryTimeSheet;updateTimeLists()"></i>
                                <div class="d-flex justify-content-center">
                                    <p class=" my-0 mb-2 mt-3" style="font-size:13px;color:grey">Estimated delivery</p>
                                </div>
                                <div class="d-flex justify-content-center mb-2">
                                    <p v-if="tab == 0 || selectedDate == null || selectedInterval == null" class="my-0 mb-1" style="font-size:18px"><b>{{Math.ceil($store.getters.getDeliveryInfo.duration.inSeconds/60) + 20}} - {{Math.ceil($store.getters.getDeliveryInfo.duration.inSeconds/60) + 30}} minutes</b></p>
                                    <p v-if="tab == 1 && selectedDate != null && selectedInterval != null" class="my-0 mb-1" style="font-size:18px"><b>{{selectedDate.split(",")[0] + ", " + selectedInterval}}</b></p>
                                </div>
                            </div>
                            
                                
                        </div>
                        <div class="d-flex justify-content-between mx-3 my-3" v-on:click="$router.push({name: 'editLocation'})">
                            <div class="d-flex">
                                <i class="fas fa-map-marker-alt my-auto mr-2 my-auto mediumColour"></i>
                                <p class="my-auto font13">{{$store.getters.getShortAddress}}</p>
                            </div>
                            <p class="mediumColour my-auto" style="font-size:10px">Change</p>
                        </div>
                        <div class="d-flex justify-content-between mx-3 my-3" v-on:click="phoneSheet = !phoneSheet">
                            <div class="d-flex">
                                <i class="fas fa-phone my-auto mr-2 my-auto mediumColour"></i>
                                <p v-if="!phoneNumber" class="my-auto font13">Please enter your phone number</p>
                                <p v-if="phoneNumber.length > 0 && isValidPhoneNumber(phoneNumber)" class="my-auto font13">{{phoneNumber}}</p>
                                <p v-if="phoneNumber.length > 0 && !isValidPhoneNumber(phoneNumber)" class="my-auto font13 text-danger">{{this.phoneNumber}}</p>

                            </div>
                            <p class="mediumColour my-auto"  style="font-size:10px">Change</p>
                        </div>
                        
                    </div>

                <div style="border-bottom: 2px solid #242323"/>
                    
                <div class="cartBackground mb-1">
                    <div class=" ">
                        <div v-for="(item, index) in $store.getters.getOrders" :key="index" class="my-4" v-on:click="$router.push({name: 'menu', params: {menuId: item.menuId, updateIndex: index}})">
                            <div class="">
                                <div class="mx-3 d-flex justify-content-between">
                                    <div class="d-flex p-0" style="width:100%">
                                        <div class="d-flex justify-content-center mediumBackground quantityBox p-0 my-auto">
                                            <p class="mx-0 my-auto text-white font13"><b>{{item.quantity}}</b></p>
                                        </div> 
                                        <div class="my-auto ml-3" style="width:100%">
                                            <div class="d-flex justify-content-between" style="width:100%">
                                                <p class="darkGreyColour my-auto mx-3 font13">{{item.menuName}}</p>
                                                <p class="my-auto font13">{{item.orderPrice}}</p>
                                            </div>
                                            <p v-for="(option, j) in item.menuOptions" :key="j" class="font13 text-muted optionText mx-3 my-auto">{{option}}</p>
                                            <p v-for="(addOn, k) in item.selectedAddOns" :key="k" class="font13 text-muted optionText mx-3 my-auto">{{addOn}}</p>
                                            <p class="text-muted optionText mx-3 my-auto font13">{{item.menuNotes}}</p>
                                        </div>
                                    </div>       
                                </div>
                            </div>
                        </div>
                        <div class="mx-3">
                            <div class="d-flex justify-content-between">
                                <p class="font13">Subtotal</p>
                                <p class="font13">{{subtotal}}</p>
                            </div>
                            <div v-if="$store.getters.getOrderMode == 'delivery'" class="d-flex justify-content-between">
                                <p class="font13">Delivery fee</p>
                                <p class="font13">{{deliveryFee}}</p>
                            </div>
                            <hr class="mt-1" style="background-color:black">
                        <div class="d-flex justify-content-between my-3" v-on:click="paymentSheet = !paymentSheet">
                            <div class="d-flex" >
                                <i class="fas fa-money-check mr-2 my-auto mediumColour" ></i>
                                <p class="my-auto font13">Pay by cash</p>
                            </div>
                            <i class="fas fa-chevron-right my-auto" style="font-size:18px;color:grey"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <v-app>
        <v-bottom-sheet v-model="paymentSheet" data-app  style="position:relative;z-index:100">
            <v-sheet>
                <div class="p-3">
                    <v-select
                        v-model="selectedPaymentOption"
                        :items="['Pay by cash']"
                        dense
                        label="Payment method"
                        outlined
                        color="#639177"
                    ></v-select>
                               
                    <div class="d-flex justify-content-center mt-2 mx-3 mb-3">
                        <div class="rounded mediumBackground d-flex justify-content-center my-0" style="width:100%" v-on:click="paymentSheet = !paymentSheet">
                            <p class="my-2" style="color:white" >Update</p>
                        </div>
                    </div>
                </div>
            </v-sheet>
        </v-bottom-sheet>
        <v-bottom-sheet v-model="phoneSheet" data-app style="position:relative;z-index:100">
            <v-sheet
            style="position:relative;z-index:10"
                class="text-center"
            >
                <div class="pt-5 pb-4">
                <p>Phone number</p>
                <vue-fake-input
                    :length="10"
                    :fontSize="16"
                    inputColor="grey"
                    fontColor="#639177"
                    :allowPaste="true"
                    :onlynumber="true"
                    v-model="phoneNumber"
                    />
                </div>
                <br><br><br>
                <div class="d-flex justify-content-center mt-2 mx-3 mb-3">
                    <div class="rounded mediumBackground d-flex justify-content-center my-0" style="width:100%" v-on:click="phoneSheet = !phoneSheet;test()">
                        <p class="my-2" style="color:white" >Update</p>
                    </div>
                </div>

            </v-sheet>
        </v-bottom-sheet>
        <v-bottom-sheet v-model="deliveryTimeSheet" data-app style="position:relative;z-index:100">
            <v-sheet
            style="position:relative;z-index:10"
                class="text-center"
            >
                <div class="pt-5 pb-2">
                    <v-tabs
                        v-model="tab"
                        background-color=""
                        color="#639177"
                        grow
                        >
                        <v-tab>Now</v-tab>
                        <v-tab>Schedule</v-tab>
                    </v-tabs>
                    <v-tabs-items v-model="tab">
                        <v-tab-item>
                            
                        </v-tab-item>
                        <v-tab-item>
                            <div class="mx-3 my-5">
                                <v-select
                                    v-model="selectedDate"
                                    :items="dates"
                                    dense
                                    label="Delivery date"
                                    outlined
                                    color="#639177"
                                ></v-select>
                                <v-select
                                    v-model="selectedInterval"
                                    :items="intervals"
                                    dense
                                    label="Delivery time"
                                    outlined
                                    color="#639177"
                                ></v-select>
                                    
                            </div>
                        </v-tab-item>
                    </v-tabs-items>
                    <div class="d-flex justify-content-center mt-2 mx-3 mb-3">
                        <div class="rounded mediumBackground d-flex justify-content-center my-0" style="width:100%" v-on:click="deliveryTimeSheet = !deliveryTimeSheet;">
                            <p class="my-2" style="color:white" >Update</p>
                        </div>
                    </div>
                </div>

            </v-sheet>
        </v-bottom-sheet>
        </v-app>
        <div id = "footer" class = "fixed-bottom footerBar">
            <div class="d-flex justify-content-between mx-3 mt-2">
                <p class="my-auto"><b>Total</b></p>
                <p class="my-auto"><b>฿{{totalPrice}}</b></p>
            </div>
            <div class="d-flex justify-content-center mt-2 mx-3 mb-3">
                <div v-if="phoneNumber.length > 0" class="rounded mediumBackground d-flex justify-content-center my-0" style="width:100%" v-on:click="submitOrder()">
                    <p class="my-2" style="color:white">Place order</p>
                </div>
                <div v-if="phoneNumber.length < 1" class="rounded d-flex justify-content-center my-0" style="width:100%;background-color:grey">
                    <p class="my-2" style="color:white">Place order</p>
                </div>
            </div>
        </div> 
    </div>
    
</template>
<script>

import VueFakeInput from 'vue-fake-input';
import moment from 'moment'


export default {
    components: { 
        VueFakeInput
    },
    name: "Cart",
    data() {
        return {
            items: [],
            deliveryInfo: {},
            totalPrice: 0,
            deliveryFee: 0,
            phoneSheet: false,
            deliveryTimeSheet: false,
            phoneNumber: "",
            subtotal: 0,
            tab: "",
            dates: [moment().format("[Today], MMM D"), moment().add(1, 'd').format("[Tomorrow], MMM D"), moment().add(2, 'd').format("ddd, MMM D")],
            intervals: "",
            selectedDate: null,
            selectedInterval: null,
            paymentOption: "",
            paymentSheet: false,
            selectedPaymentOption: 'Pay by cash'
        }
    },
    created() {
        window.console.log(this.$store.getters.getOrders.length)
        if (this.$store.getters.getDeliveryInfo.deliveryFee){
            this.deliveryFee = this.$store.getters.getDeliveryInfo.deliveryFee
        }

        for (var i=0;i<this.$store.getters.getOrders.length;i++){
            var item = this.$store.getters.getOrders[i]
            this.subtotal += item.orderPrice
        }

        this.totalPrice = this.subtotal + this.deliveryFee
       

           
    

    },
    methods: {  
        setMode(mode){
            this.store.commit("setOrderMode", mode)
            window.localStorage.setItem("orderMode", mode)
            if (mode == 'delivery'){
                this.deliveryFee = this.$parent.deliveryInfo.deliveryFee
            }
            else{
                this.deliveryFee = 0
            }
        },
        proceed(){
            //if no phone no.

            if (true){
                // this.$router.push({name: "phoneNumber"})
                window.console.log(this.sheet)
                this.phoneSheet = !this.Sheet
            }
            else{
                this.submitOrder()
            }
        },
        submitOrder(){

            var finalOrders = []
            var totalPrice = 0


            for (var i=0;i<this.$store.getters.getOrders.length;i++){
                

                
                var obj = {
                    menuId: this.$store.getters.getOrders[i].menuId,
                    quantity: this.$store.getters.getOrders[i].quantity,
                    menuName: this.$store.getters.getOrders[i].menuName,
                    menuPrice: this.$store.getters.getOrders[i].orderPrice,
                    options: this.$store.getters.getOrders[i].menuOptions,
                    addOns: this.$store.getters.getOrders[i].selectedAddOns,
                    menuNotes: this.$store.getters.getOrders[i].menuNotes,
                }
                totalPrice += this.$store.getters.getOrders[i].orderPrice
                finalOrders.push(obj)
            }

            var email = this.$auth.isAuthenticated ? this.$auth.user.email : "guest"


            var orderDTO
            if (this.$store.getters.getOrderMode == 'delivery'){
                orderDTO = {
                userId: email,
                productTotal: this.$store.getters.getProductTotal,
                deliveryFee: this.deliveryFee,
                orderTotal: this.$store.getters.getProductTotal + this.deliveryFee,
                orderType: "delivery",
                orders: finalOrders,
                address: this.$store.getters.getDeliveryInfo.destination,
                latitude: this.$store.getters.getLatitude,
                longitude: this.$store.getters.getLongitude,
                phoneNumber: this.phoneNumber
                }
                if (this.tab == 1){
                    orderDTO.deliveryPreferredTime = this.date + this.interval
                }
            }
            else{
                orderDTO = {
                userId: email,
                orderPrice: totalPrice,
                orderType: "delivery",
                orders: finalOrders,
                locationNotes: ""
            }
            }

            

            this.axios.post(this.$parent.api + 'order/make_order', orderDTO)
            .then(res => {
            window.console.log(res.data)
            this.$store.commit("setOrder", res.data)
            window.localStorage.setItem("lastOrderId", res.data.orderId)
            this.$store.getOrders = []
            window.localStorage.setItem("orders", JSON.stringify([]))
            window.localStorage.setItem("orderMode", "")
            this.$router.push({ name: 'postOrder', params: {nofetch: true}})
            
            }
            )
            .catch(function (error) {window.console.log(error)});

            
        },
        isValidPhoneNumber(number){
            return true;
        },
        test(){
            window.console.log(this.phoneNumber)
        },
        updateTimeLists(){
           this.intervals = []
           if(moment().minute() % 15 != 0){
               
           }
           for (var i=1;i<=15;i++){
               this.intervals.push(moment().add((15*i + (15 - (moment().minute() % 15))), 'm').format("HH:mm"))
           }
        },
        hash(item){
            return item.menuId + item.menuOptions.toString() + item.selectedAddOns.toString() + item.menuNotes
        }
    }
}
</script>

<style scoped>


  
  /* border: 1px groove lightgrey ; */
.roundedCard {
  padding: 0px;
  width: 100%;
  height: 5rem;
  background-size: cover; /* or contain depending on what you want */
  background-position: center center;
  background-repeat: no-repeat;
  border-radius: 25px;
}

.shadowed {
  box-shadow: 0px 0px 2px 1px lightgrey;

}

.menuCard {
  border-radius: 25px;
  height: 12rem;
}


.cardBody {
  padding: 0px;
  margin: 0px;
  padding-left: 0.5rem;
}

.card-title {
  font-size: 1rem !important;
  color: black;
}

.card-subtitle {
  font-size: 0.8rem !important;
}

.card-text {
  font-size: 0.7rem !important;
  color:black
}

.fonted {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}

.whiteCard {
background-color: white;


border-color: black;
border-style: solid;
border-width: 2px;
border-radius: 3px;
box-shadow: 0px 0px 0px 1px #f0f0f0;
}

.quantityBox {
    width:30px;
    height:30px;
    border-radius: 5px
}

.ghostBox {
    width:30px;
    height:20px;
}

.optionText {
    font-size: 12px
}

.ETAbox {
    border-style: solid;
    border-color: lightgrey;
    border-width: 2px;
    background-color: white;
    border-radius: 10px;


}

.cartBackground {
    background-color: white
}

.footerBar {
    background-color:white;
    box-shadow: 0px 0px 5px 3px rgb(236, 236, 236);
    z-index:1

}

.font13{
    font-size:13px
}




</style>