<template>
    <div v-if="addOns">
        <p class="optionTitle"><b>Add ons</b></p>
        <div class="form-check mx-0 px-0" v-for="(option, index) in addOns" :key="index" v-on:click="clickAddOn(option.optionName);updateDisplayPrice()">
            <div class="mx-0 px-0 d-flex justify-content-between">
            <div class="checkboxContainer">
                <input v-model="selectedAddOns" :key="index" v-on:change="updateDisplayPrice()" class="form-check-input" type="checkbox" v-bind:value="option.optionName" v-bind:id="option.optionName">
                <span class="checkboxCheckmark my-auto"></span>
                <p v-if="selectedAddOns.includes(option.optionName)" class="mx-1 my-0 text-muted"><b>{{option.optionName}}</b></p>
                <p v-if="!selectedAddOns.includes(option.optionName)" class="mx-1 my-0 text-muted">{{option.optionName}}</p>
            </div>
            <div>
                <p v-if="selectedAddOns.includes(option.optionName)" class="mx-1 my-0 text-muted"><b>{{option.optionPrice}}</b></p>
                <p v-if="!selectedAddOns.includes(option.optionName)" class="mx-1 my-0 text-muted">{{option.optionPrice}}</p>           
            </div>
            </div>
            <hr>
        </div>
    </div>
</template>

<script>

export default {
   name: "MenuAddOn",
   props: ["addOns", "selectedAddOns"]
}
</script>


<style scoped>


  label {
    /* whatever other styling you have applied */
    width: 100%;
    display: inline-block;
  }
  .shadowed {
    box-shadow: 3px 4px 5px 4px lightgrey;

  }

  .whiteCard {
    background-color: white;
  }

  .optionTitle {
    font-size: 1.3rem;
  }

 

</style>