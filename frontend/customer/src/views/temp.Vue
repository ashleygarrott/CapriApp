<template>
    
<div class="mx-3 whiteCard my-1" v-if="optionCategory1!=null">
      <div class="form-group  my-0">
        
        <div class="d-flex justify-content-between my-3">
          <p class="optionTitle my-0"><b>{{optionCategory1.optionCategoryName}}</b></p>
          <div class="rounded-pill lightBackground">
            <p class="darkColour m-1" style="font-size:12px"><b>1 Required</b></p>
          </div>
        </div>
        <div v-for="(option, index) in optionCategory1.options.slice(0,optionCategory1.options.length-1)" :key="index" v-on:click="option1Selected=option.optionName;updateDisplayPrice()">
          <div class="form-check my-0 p-0" >
              <div class="radioContainer">
                <label class="form-check-label" for="exampleRadios1">
                  <input class="form-check-input my-auto " type="radio" name="optionCategory1" v-on:change="updateDisplayPrice()" :value="option.optionName" v-model="option1Selected">
                  <span class="radioCheckmark my-auto"></span>
                  
                  <div class="d-flex justify-content-between">
                    <p v-if="option.optionName==option1Selected" class="mx-3 my-auto darkgreyColour radioText"><b>{{option.optionName}}</b></p>
                    <p v-if="option.optionName!=option1Selected" class="mx-3 my-auto text-muted radioText">{{option.optionName}}</p>
                    <p v-if="option.optionName==option1Selected" class="my-0 radioText darkgreyColour"><b>{{option.optionPrice}}</b></p>
                    <p v-if="option.optionName!=option1Selected" class="my-0 text-muted radioText">{{option.optionPrice}}</p>
                  </div>
                </label>
              </div>
          </div>         
        </div>
        <div v-on:click="option1Selected=optionCategory1.options[optionCategory1.options.length-1].optionName;updateDisplayPrice()">
          <div class="form-check my-0 p-0" >
              <div class="radioContainer">
                <label class="form-check-label" for="exampleRadios1"> 
                  <input class="form-check-input" type="radio" name="optionCategory1" v-on:change="updateDisplayPrice()" :value="optionCategory1.options[optionCategory1.options.length-1].optionName" v-model="option1Selected">
                  <span class="radioCheckmark my-auto"></span>
                  <div class="d-flex justify-content-between">
                    <p v-if="optionCategory1.options[optionCategory1.options.length-1].optionName==option1Selected" class="mx-3 my-0 text-muted radioText"><b>{{optionCategory1.options[optionCategory1.options.length-1].optionName}}</b></p>
                    <p v-if="optionCategory1.options[optionCategory1.options.length-1].optionName!=option1Selected" class="mx-3 my-0 text-muted radioText">{{optionCategory1.options[optionCategory1.options.length-1].optionName}}</p>
                    <p v-if="optionCategory1.options[optionCategory1.options.length-1].optionName==option1Selected" class="my-0 text-muted radioText"><b>{{optionCategory1.options[optionCategory1.options.length-1].optionPrice}}</b></p>
                    <p v-if="optionCategory1.options[optionCategory1.options.length-1].optionName!=option1Selected" class="my-0 text-muted radioText">{{optionCategory1.options[optionCategory1.options.length-1].optionPrice}}</p>       
                  </div>
                </label>
              </div>
            </div>        
        </div>
      </div>
    </div>
</template>
