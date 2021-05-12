<template>
    <div>
        <div class="fixed-top lightBackground">
            <div class="d-flex justify-content-around my-2">
                <a href="#" @click.prevent="$router.go(-1)" style="color:white">
                    <i class="fas fa-chevron-left my-auto" style="color:white"></i>
                </a>
                <h5 style="color:white">Checkout</h5>
                <router-link :to="{ name: 'search', params: { searchKey: '' }}" v-if="$parent.deliveryInfo != {}">
                    <i  class="fas fa-search my-auto" style="color:white"></i>
                </router-link>
                <a href="#" @click.prevent="requestLocation()" v-if="$parent.deliveryInfo == {}">
                    <i class="fas fa-map-marker-alt my-auto" style="color:white"></i>
                </a>
            </div>
        </div>
        <br>
        <div class="container mt-5">
            <p class="title">Select payment method</p>
            <div class="form-check my-0" >
                <div class="d-flex justify-content-between" v-on:click="paymentMode='cash'">
                <div class="radioContainer">
                    <label class="form-check-label" >
                    <input class="form-check-input" type="radio" name="paymentMode" value="cash" v-model="paymentMode">
                    <span class="checkmark my-auto"></span>
                    <div v-if="paymentMode=='cash'">
                        <p class="mx-3 my-0 text-muted"><b>Cash on delivery</b></p>
                    </div>
                    <div v-if="paymentMode!='cash'">
                        <p class="mx-3 my-0 text-muted">Cash on delivery</p>
                    </div>
                    </label>
                </div>
                </div>
            </div>
            <hr>

            <p class="title">Enter your phone number</p>
            <form>
                <div class="form-group">
                    <input type="email" class="form-control" id="InputPhoneNumber" aria-describedby="phoneNumberHelp" placeholder="0123456789" v-model="phoneNumber">
                    <small id="emailHelp" class="form-text text-muted">We will call this number when delivering your food</small>
                </div>
            </form>
            
        </div>
        <div id = "footer" class = "fixed-bottom">
            <div class="d-flex justify-content-center my-1">
                <div v-if="$store.getOrders.length > 0" class="rounded mediumBackground d-flex justify-content-center my-0" style="width:80%" v-on:click="submitOrder()">
                    <p class="my-2" style="color:white">Confirm</p>
                </div>
                <div v-if="$store.getOrders.length < 1" class="rounded greyBackground d-flex justify-content-center my-0" style="width:80%">
                    <p class="my-2" style="color:white">Confirm</p>
                </div>
            </div>
        </div> 
    </div>
</template>

<script>
export default {
    name: "Checkout",
    data(){
        return {
            paymentMode: "cash",
            phoneNumber: ""
        }
    },
    methods: {
        submitOrder(){

            var finalOrders = []
            var totalPrice = 0


            for (var i=0;i<this.$store.getOrders.length;i++){
                

                
                var obj = {
                    menuId: this.$store.getOrders[i].menuId,
                    quantity: this.$store.getOrders[i].quantity,
                    menuName: this.$store.getOrders[i].menuName,
                    menuPrice: this.$store.getOrders[i].orderPrice,
                    options: this.$store.getOrders[i].menuOptions,
                    addOns: this.$store.getOrders[i].selectedAddOns,
                    menuNotes: this.$store.getOrders[i].menuNotes,
                }
                totalPrice += this.$store.getOrders[i].orderPrice
                finalOrders.push(obj)
            }

            var email = this.$auth.isAuthenticated ? this.$auth.user.email : "guest"

            var fee
            if(this.$parent.deliveryInfo.deliveryFee){
                fee = this.$parent.deliveryInfo.deliveryFee
            }
            else{
                fee = 0
            }

            var orderDTO
            if (this.$parent.deliveryInfo != {}){
                orderDTO = {
                userId: email,
                productTotal: this.$store.getters.getProductTotal,
                deliveryFee: fee,
                orderTotal: this.$store.getters.getProductTotal + fee,
                orderType: "delivery",
                orders: finalOrders,
                address: this.$parent.deliveryInfo.destination,
                latitude: this.$parent.latitude,
                longitude: this.$parent.longitude,
                phoneNumber: this.phoneNumber


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
            this.$store.getOrders = []
            window.localStorage.setItem("orders", JSON.stringify([]))
            window.localStorage.setItem("orderMode", "")
            this.$router.push({ name: 'postOrder'})
            }
            )
            .catch(function (error) {window.console.log(error)});

            
        }
    }
}
</script>


<style scoped>
  /* Create a custom radio button */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 22px;
  width: 22px;
  border-radius: 50%;
  border-color: lightgrey;
  border-style: solid;
  border-width: 3px;
}

/* On mouse-over, add a grey background color */
.radioContainer:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.radioContainer input:checked ~ .checkmark {
  background-color:#49b3cd;
  
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
  background-color: white;
}

/* Hide the browser's default radio button */
.radioContainer input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
}

.headerArea {
    background-color: #49b3cd;
}

.title {
    font-size: 1.3rem
}
</style>