<template>
    <div class=" ">
        <div v-for="(item, index) in order.orders" :key="index" class="my-4" v-on:click="$router.push({name: 'menu', params: {menuId: item.menuId, updateIndex: index}})">
            <div class="">
                <div class="mx-3 d-flex justify-content-between">
                    <div class="d-flex p-0" style="width:100%">
                        <div class="d-flex justify-content-center mediumBackground quantityBox p-0 my-auto">
                            <p class="mx-0 my-auto text-white font14"><b>{{item.quantity}}</b></p>
                        </div> 
                        <div class="my-auto ml-2" style="width:100%">
                            <div class="d-flex justify-content-between" style="width:100%">
                                <p class="darkGreyColour my-auto mx-3 font14">{{item.menuName}}</p>
                                <p class="my-auto font14">{{item.menuPrice}}</p>
                            </div>
                            <p v-for="(option, j) in item.menuOptions" :key="j" class="font14 text-muted optionText mx-3 my-auto">{{option}}</p>
                            <p v-for="(addOn, k) in item.selectedAddOns" :key="k" class="font14 text-muted optionText mx-3 my-auto">{{addOn}}</p>
                            <p class="text-muted optionText mx-3 my-auto font14">{{item.menuNotes}}</p>
                        </div>
                    </div>       
                </div>
            </div>
        </div>
        <div class="mx-3">
            <div v-if="$store.getters.getOrderMode == 'delivery'" class="d-flex justify-content-between">
                <p class="font14 my-1">Subtotal</p>
                <p class="font14 my-1">{{subtotal}}</p>
            </div>
            <div v-if="$store.getters.getOrderMode == 'delivery'" class="d-flex justify-content-between">
                <p class="font14 my-1">Delivery fee</p>
                <p class="font14 my-1">{{deliveryFee}}</p>
            </div>
            <div class="d-flex justify-content-between">
                <p class="font14 my-1"><b>Total</b></p>
                <p class="font14 my-1"><b>{{totalPrice}}</b></p>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    name: "OrderSummaryComponent",
    props: ['order'],
    data(){
        return{
            totalPrice: 0,
            subtotal: 0,
            deliveryFee: 0
        }
    },
    created(){
        if (this.order.orderType == 'delivery'){
            this.deliveryFee = this.order.deliveryFee
        }

        for (var i=0;i<this.order.orders.length;i++){
            var item = this.order.orders[i]
            this.subtotal += item.menuPrice
        }

        this.totalPrice = this.subtotal + this.deliveryFee
       
    }
}
</script>


<style scoped>
    .quantityBox {
    width:25px;
    height:25px;
    border-radius: 5px
}

.ghostBox {
    width:30px;
    height:20px;
}

.optionText {
    font-size: 12px
}

.font14{
    font-size:13px
}
</style>