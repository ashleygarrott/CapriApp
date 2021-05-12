<template>
    <div class="fixed-bottom">
        <div class="d-flex justify-content-end">
          
            <div class="d-flex justify-content-center cartPopUp m-3"  style="" v-on:click="$router.push({name: 'cart'})">
                <i class="fas fa-shopping-bag my-auto" style="color:white;font-size:20px" ></i>
                <div class="darkBackground numberWrapper" style="border-radius:50%" v-if="$store.getters.getOrders.length > 0">
                <p class="text-white m-0 number"><b>{{$store.getters.getOrders.length}}</b></p>
                </div>
            </div>
          
        </div>
      </div>
</template>

<script>
export default {
    name: "CartPopUp"
}
</script>

<style scoped>
    
 .cartPopUp {
   border-radius: 15%;
   background-color: rgb(21,21,21,0.5);
   position:relative;
   box-shadow: 0px 0px 5px 1px grey;
   width:50px;
   height:50px

 }

 .numberWrapper {
     position:absolute;
     top: -5px;
     right:-5px;
     font-size: 12px;
     border-radius: 50%;
     width: 17px;
     height: 17px
 }

 .number {
     position:absolute;
     top:0px;
     right:5px
 }
</style>
