<template>
    <div class="p-3 whiteCard my-1" v-if="optionCategory1!=null">
      <div class="form-group  my-0">
        <p class="optionTitle"><b>{{optionCategory1.optionCategory1Name}}</b></p>
        <div v-for="(option, index) in optionCategory1.options.slice(0,optionCategory1.options.length-1)" :key="index" v-on:click="option1Selected=option.optionName;updateDisplayPrice()">
          <div class="form-check my-0" >
            <div class="d-flex justify-content-between">
              <div class="radioContainer">
                <label class="form-check-label" for="exampleRadios1">
                  <input class="form-check-input" type="radio" name="optionCategory1" v-on:change="updateDisplayPrice()" :value="option.optionName" v-model="option1Selected">
                  <span class="checkmark my-auto"></span>
                  <p v-if="option.optionName==option1Selected" class="mx-3 my-0 text-muted"><b>{{option.optionName}}</b></p>
                  <p v-if="option.optionName!=option1Selected" class="mx-3 my-0 text-muted">{{option.optionName}}</p>
                </label>
              </div>
              <div>
                <p v-if="option.optionName==option1Selected" class="my-0 text-muted"><b>{{option.optionPrice}}</b></p>
                <p v-if="option.optionName!=option1Selected" class="my-0 text-muted">{{option.optionPrice}}</p>
              </div>
            </div>
          </div>
          <hr>          
        </div>
        <div v-on:click="option1Selected=optionCategory1.options[optionCategory1.options.length-1].optionName;updateDisplayPrice()">
          <div class="form-check my-0" >
            <div class="d-flex justify-content-between">
              <div class="radioContainer">
                <label class="form-check-label" for="exampleRadios1"> 
                  <input class="form-check-input" type="radio" name="optionCategory1" v-on:change="updateDisplayPrice()" :value="optionCategory1.options[optionCategory1.options.length-1].optionName" v-model="option1Selected">
                  <span class="checkmark my-auto"></span>
                  <p v-if="optionCategory1.options[optionCategory1.options.length-1].optionName==option1Selected" class="mx-3 my-0 text-muted"><b>{{optionCategory1.options[optionCategory1.options.length-1].optionName}}</b></p>
                  <p v-if="optionCategory1.options[optionCategory1.options.length-1].optionName!=option1Selected" class="mx-3 my-0 text-muted">{{optionCategory1.options[optionCategory1.options.length-1].optionName}}</p>
     
                </label>
              </div>
              <div>
                <p v-if="optionCategory1.options[optionCategory1.options.length-1].optionName==option1Selected" class="my-0 text-muted"><b>{{optionCategory1.options[optionCategory1.options.length-1].optionPrice}}</b></p>
                <p v-if="optionCategory1.options[optionCategory1.options.length-1].optionName!=option1Selected" class="my-0 text-muted">{{optionCategory1.options[optionCategory1.options.length-1].optionPrice}}</p>              
              </div>
            </div>
          </div>        
        </div>
      </div>
    </div>
</template>

<script>
export default {
    name: "MenuOptions",
    props: ["optionCategory1", "option1Selected"],
    data() {
        return {

        }
    }
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