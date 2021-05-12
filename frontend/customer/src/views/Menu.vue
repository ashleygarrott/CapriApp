<template>
  <div >
    <v-app>
      <div class="fixed-top">
        <v-app-bar
          color="transparent"
          hide-on-scroll
          flat
          
          >
          <div class="d-flex justify-content-between">
            <div class="d-flex justify-content-center quantityButton my-1" style="background-color:rgba(59, 59, 59, 0.7)">
                <i class="fas fa-arrow-left my-auto " style="font-size:20px;color:white" v-on:click="$router.go(-1)"></i>
            </div>
          </div>
        </v-app-bar>
      </div>
    
      <img class="mx-0" v-bind:src="'/img/menus/' + menu.src" style="width: 100%; border-radius: 0% 0% 5% 5%;object-fit:cover" v-bind:style="'height:' + ($parent.screenHeight * 0.25) + 'px'">
      <div class="whiteCard mx-2">
        <div class="d-flex justify-content-between mt-2">
          <p class="darkgreyColour mt-0 mb-0 mx-2" style="font-size: 20px;"><b>{{menu.name}}</b></p>
          <div style="min-width:70px d-flex justify-content-end">
          <p class=" mt-1 mb-0 mx-0" style="font-size: 16px;"><b>{{menu.displayPrice}}</b></p>
          </div>
        </div>
        <div class="mx-2">
          <p class="text-muted mt-2 mb-0" style="font-size:14px">{{menu.thaiDescription}}</p>
          <p class="text-muted mt-1 mb-0" style="font-size:12px">{{menu.englishDescription}}</p>
        </div>
      </div>
      <hr class="mx-3 my-2 mt-3">

      <!-- //Options area -->
    
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
                      <p v-if="option.optionName==option1Selected" class="mx-3 my-auto text-muted radioText"><b>{{option.optionName}}</b></p>
                      <p v-if="option.optionName!=option1Selected" class="mx-3 my-auto text-muted radioText">{{option.optionName}}</p>
                      <p v-if="option.optionName==option1Selected" class="my-0 radioText text-muted"><b>{{option.optionPrice}}</b></p>
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

      <div class="mx-3 whiteCard my-4" v-if="optionCategory2!=null">
        <div class="form-group  my-0">
          
          <div class="d-flex justify-content-between my-3">
            <p class="optionTitle my-0"><b>{{optionCategory2.optionCategoryName}}</b></p>
            <div class="rounded-pill lightBackground">
              <p class="darkColour m-1" style="font-size:12px"><b>1 Required</b></p>
            </div>
          </div>
          <div v-for="(option, index) in optionCategory2.options.slice(0,optionCategory2.options.length-1)" :key="index" v-on:click="option2Selected=option.optionName;updateDisplayPrice()">
            <div class="form-check my-0 p-0" >
                <div class="radioContainer">
                  <label class="form-check-label" for="exampleRadios1">
                    <input class="form-check-input my-auto " type="radio" name="optionCategory2" v-on:change="updateDisplayPrice()" :value="option.optionName" v-model="option2Selected">
                    <span class="radioCheckmark my-auto"></span>
                    
                    <div class="d-flex justify-content-between">
                      <p v-if="option.optionName==option2Selected" class="mx-3 my-auto text-muted radioText"><b>{{option.optionName}}</b></p>
                      <p v-if="option.optionName!=option2Selected" class="mx-3 my-auto text-muted radioText">{{option.optionName}}</p>
                      <p v-if="option.optionName==option2Selected" class="my-0 radioText text-muted"><b>{{option.optionPrice}}</b></p>
                      <p v-if="option.optionName!=option2Selected" class="my-0 text-muted radioText">{{option.optionPrice}}</p>
                    </div>
                  </label>
                </div>
            </div>         
          </div>
          <div v-on:click="option2Selected=optionCategory2.options[optionCategory2.options.length-1].optionName;updateDisplayPrice()">
            <div class="form-check my-0 p-0" >
                <div class="radioContainer">
                  <label class="form-check-label" for="exampleRadios1"> 
                    <input class="form-check-input" type="radio" name="optionCategory2" v-on:change="updateDisplayPrice()" :value="optionCategory2.options[optionCategory2.options.length-1].optionName" v-model="option2Selected">
                    <span class="radioCheckmark my-auto"></span>
                    <div class="d-flex justify-content-between">
                      <p v-if="optionCategory2.options[optionCategory2.options.length-1].optionName==option2Selected" class="mx-3 my-0 text-muted radioText"><b>{{optionCategory2.options[optionCategory2.options.length-1].optionName}}</b></p>
                      <p v-if="optionCategory2.options[optionCategory2.options.length-1].optionName!=option2Selected" class="mx-3 my-0 text-muted radioText">{{optionCategory2.options[optionCategory2.options.length-1].optionName}}</p>
                      <p v-if="optionCategory2.options[optionCategory2.options.length-1].optionName==option2Selected" class="my-0 text-muted radioText"><b>{{optionCategory2.options[optionCategory2.options.length-1].optionPrice}}</b></p>
                      <p v-if="optionCategory2.options[optionCategory2.options.length-1].optionName!=option2Selected" class="my-0 text-muted radioText">{{optionCategory2.options[optionCategory2.options.length-1].optionPrice}}</p>       
                    </div>
                  </label>
                </div>
              </div>        
          </div>
        </div>
      </div>

      <div class="mx-3 whiteCard my-1" v-if="optionCategory3!=null">
        <div class="form-group  my-0">
          
          <div class="d-flex justify-content-between my-3">
            <p class="optionTitle my-0"><b>{{optionCategory3.optionCategoryName}}</b></p>
            <div class="rounded-pill lightBackground">
              <p class="darkColour m-1" style="font-size:12px"><b>1 Required</b></p>
            </div>
          </div>
          <div v-for="(option, index) in optionCategory3.options.slice(0,optionCategory3.options.length-1)" :key="index" v-on:click="option3Selected=option.optionName;updateDisplayPrice()">
            <div class="form-check my-0 p-0" >
                <div class="radioContainer">
                  <label class="form-check-label" for="exampleRadios1">
                    <input class="form-check-input my-auto " type="radio" name="optionCategory3" v-on:change="updateDisplayPrice()" :value="option.optionName" v-model="option3Selected">
                    <span class="radioCheckmark my-auto"></span>
                    
                    <div class="d-flex justify-content-between">
                      <p v-if="option.optionName==option3Selected" class="mx-3 my-auto text-muted radioText"><b>{{option.optionName}}</b></p>
                      <p v-if="option.optionName!=option3Selected" class="mx-3 my-auto text-muted radioText">{{option.optionName}}</p>
                      <p v-if="option.optionName==option3Selected" class="my-0 radioText text-muted"><b>{{option.optionPrice}}</b></p>
                      <p v-if="option.optionName!=option3Selected" class="my-0 text-muted radioText">{{option.optionPrice}}</p>
                    </div>
                  </label>
                </div>
            </div>         
          </div>
          <div v-on:click="option3Selected=optionCategory3.options[optionCategory3.options.length-1].optionName;updateDisplayPrice()">
            <div class="form-check my-0 p-0" >
                <div class="radioContainer">
                  <label class="form-check-label" for="exampleRadios1"> 
                    <input class="form-check-input" type="radio" name="optionCategory3" v-on:change="updateDisplayPrice()" :value="optionCategory3.options[optionCategory3.options.length-1].optionName" v-model="option3Selected">
                    <span class="radioCheckmark my-auto"></span>
                    <div class="d-flex justify-content-between">
                      <p v-if="optionCategory3.options[optionCategory3.options.length-1].optionName==option3Selected" class="mx-3 my-0 text-muted radioText"><b>{{optionCategory3.options[optionCategory3.options.length-1].optionName}}</b></p>
                      <p v-if="optionCategory3.options[optionCategory3.options.length-1].optionName!=option3Selected" class="mx-3 my-0 text-muted radioText">{{optionCategory3.options[optionCategory3.options.length-1].optionName}}</p>
                      <p v-if="optionCategory3.options[optionCategory3.options.length-1].optionName==option3Selected" class="my-0 text-muted radioText"><b>{{optionCategory3.options[optionCategory3.options.length-1].optionPrice}}</b></p>
                      <p v-if="optionCategory3.options[optionCategory3.options.length-1].optionName!=option3Selected" class="my-0 text-muted radioText">{{optionCategory3.options[optionCategory3.options.length-1].optionPrice}}</p>       
                    </div>
                  </label>
                </div>
              </div>        
          </div>
        </div>
      </div>

      <div class="mx-3 whiteCard my-1" v-if="optionCategory4!=null">
        <div class="form-group  my-0">
          
          <div class="d-flex justify-content-between my-3">
            <p class="optionTitle my-0"><b>{{optionCategory4.optionCategoryName}}</b></p>
            <div class="rounded-pill lightBackground">
              <p class="darkColour m-1" style="font-size:12px"><b>1 Required</b></p>
            </div>
          </div>
          <div v-for="(option, index) in optionCategory4.options.slice(0,optionCategory4.options.length-1)" :key="index" v-on:click="option4Selected=option.optionName;updateDisplayPrice()">
            <div class="form-check my-0 p-0" >
                <div class="radioContainer">
                  <label class="form-check-label" for="exampleRadios1">
                    <input class="form-check-input my-auto " type="radio" name="optionCategory4" v-on:change="updateDisplayPrice()" :value="option.optionName" v-model="option4Selected">
                    <span class="radioCheckmark my-auto"></span>
                    
                    <div class="d-flex justify-content-between">
                      <p v-if="option.optionName==option4Selected" class="mx-3 my-auto text-muted radioText"><b>{{option.optionName}}</b></p>
                      <p v-if="option.optionName!=option4Selected" class="mx-3 my-auto text-muted radioText">{{option.optionName}}</p>
                      <p v-if="option.optionName==option4Selected" class="my-0 radioText text-muted"><b>{{option.optionPrice}}</b></p>
                      <p v-if="option.optionName!=option4Selected" class="my-0 text-muted radioText">{{option.optionPrice}}</p>
                    </div>
                  </label>
                </div>
            </div>         
          </div>
          <div v-on:click="option4Selected=optionCategory4.options[optionCategory4.options.length-1].optionName;updateDisplayPrice()">
            <div class="form-check my-0 p-0" >
                <div class="radioContainer">
                  <label class="form-check-label" for="exampleRadios1"> 
                    <input class="form-check-input" type="radio" name="optionCategory4" v-on:change="updateDisplayPrice()" :value="optionCategory4.options[optionCategory4.options.length-1].optionName" v-model="option4Selected">
                    <span class="radioCheckmark my-auto"></span>
                    <div class="d-flex justify-content-between">
                      <p v-if="optionCategory4.options[optionCategory4.options.length-1].optionName==option4Selected" class="mx-3 my-0 text-muted radioText"><b>{{optionCategory4.options[optionCategory4.options.length-1].optionName}}</b></p>
                      <p v-if="optionCategory4.options[optionCategory4.options.length-1].optionName!=option4Selected" class="mx-3 my-0 text-muted radioText">{{optionCategory4.options[optionCategory4.options.length-1].optionName}}</p>
                      <p v-if="optionCategory4.options[optionCategory4.options.length-1].optionName==option4Selected" class="my-0 text-muted radioText"><b>{{optionCategory4.options[optionCategory4.options.length-1].optionPrice}}</b></p>
                      <p v-if="optionCategory4.options[optionCategory4.options.length-1].optionName!=option4Selected" class="my-0 text-muted radioText">{{optionCategory4.options[optionCategory4.options.length-1].optionPrice}}</p>       
                    </div>
                  </label>
                </div>
              </div>        
          </div>
        </div>
      </div>

      <div class="mx-3 whiteCard my-1" v-if="optionCategory5!=null">
        <div class="form-group  my-0">
          
          <div class="d-flex justify-content-between my-3">
            <p class="optionTitle my-0"><b>{{optionCategory5.optionCategoryName}}</b></p>
              <p class="darkColour m-1" style="font-size:12px"><b>1 Required</b></p>
            <div class="rounded-pill lightBackground">
            </div>
          </div>
          <div v-for="(option, index) in optionCategory5.options.slice(0,optionCategory5.options.length-1)" :key="index" v-on:click="option5Selected=option.optionName;updateDisplayPrice()">
            <div class="form-check my-0 p-0" >
                <div class="radioContainer">
                  <label class="form-check-label" for="exampleRadios1">
                    <input class="form-check-input my-auto " type="radio" name="optionCategory5" v-on:change="updateDisplayPrice()" :value="option.optionName" v-model="option5Selected">
                    <span class="radioCheckmark my-auto"></span>
                    
                    <div class="d-flex justify-content-between">
                      <p v-if="option.optionName==option5Selected" class="mx-3 my-auto text-muted radioText"><b>{{option.optionName}}</b></p>
                      <p v-if="option.optionName!=option5Selected" class="mx-3 my-auto text-muted radioText">{{option.optionName}}</p>
                      <p v-if="option.optionName==option5Selected" class="my-0 radioText text-muted"><b>{{option.optionPrice}}</b></p>
                      <p v-if="option.optionName!=option5Selected" class="my-0 text-muted radioText">{{option.optionPrice}}</p>
                    </div>
                  </label>
                </div>
            </div>         
          </div>
          <div v-on:click="option5Selected=optionCategory5.options[optionCategory5.options.length-1].optionName;updateDisplayPrice()">
            <div class="form-check my-0 p-0" >
                <div class="radioContainer">
                  <label class="form-check-label" for="exampleRadios1"> 
                    <input class="form-check-input" type="radio" name="optionCategory5" v-on:change="updateDisplayPrice()" :value="optionCategory5.options[optionCategory5.options.length-1].optionName" v-model="option5Selected">
                    <span class="radioCheckmark my-auto"></span>
                    <div class="d-flex justify-content-between">
                      <p v-if="optionCategory5.options[optionCategory5.options.length-1].optionName==option5Selected" class="mx-3 my-0 text-muted radioText"><b>{{optionCategory5.options[optionCategory5.options.length-1].optionName}}</b></p>
                      <p v-if="optionCategory5.options[optionCategory5.options.length-1].optionName!=option5Selected" class="mx-3 my-0 text-muted radioText">{{optionCategory5.options[optionCategory5.options.length-1].optionName}}</p>
                      <p v-if="optionCategory5.options[optionCategory5.options.length-1].optionName==option5Selected" class="my-0 text-muted radioText"><b>{{optionCategory5.options[optionCategory5.options.length-1].optionPrice}}</b></p>
                      <p v-if="optionCategory5.options[optionCategory5.options.length-1].optionName!=option5Selected" class="my-0 text-muted radioText">{{optionCategory5.options[optionCategory5.options.length-1].optionPrice}}</p>       
                    </div>
                  </label>
                </div>
              </div>        
          </div>
        </div>
      </div>

      <div class="mx-3" v-if="menu.addOns.length > 0">
          <div class="d-flex justify-content-between my-3">
            <p class="optionTitle my-0"><b>Add Ons</b></p>
            <div class="rounded-pill lightBackground">
              <p class="darkColour m-1 mx-3" style="font-size:12px"><b>Max {{addOnsAllowed}}</b></p>
            </div>
          </div>
          <div v-for="(option, index) in menu.addOns" :key="index" v-on:click="clickAddOn(option.optionName);updateDisplayPrice()">
          <div class="form-check mx-0 px-0">
                <div class="checkboxContainer my-4">
                  <label class="form-check-label" for="exampleRadios1"> 
                    <input v-model="selectedAddOns" :key="index" v-on:change="updateDisplayPrice()" class="form-check-input my-auto" type="checkbox" v-bind:value="option.optionName" v-bind:id="option.optionName">
                    <span class="checkboxCheckmark my-auto"></span>
                    <div class="d-flex justify-content-between">
                      <p v-if="selectedAddOns.includes(option.optionName)" class="mx-3 my-0 text-muted radioText"><b>{{option.optionName}}</b></p>
                      <p v-if="!selectedAddOns.includes(option.optionName)" class="mx-3 my-0 text-muted radioText">{{option.optionName}}</p>
                      <p v-if="selectedAddOns.includes(option.optionName)" class="my-0 text-muted radioText"><b>{{option.optionPrice}}</b></p>
                      <p v-if="!selectedAddOns.includes(option.optionName)" class="my-0 text-muted radioText">{{option.optionPrice}}</p>           
                    </div>
                  </label>
                </div>
          </div>
          </div>
      </div>
      


      <!-- <div class="my-1">
        <menu-add-on v-bind:addons="menu.addOns" />
      </div> -->


      <!-- //Notes area -->
      <div class="whiteCard my-1 p-2">
        <div class="mx-2">
          <p class="optionTitle"><b>Special instructions</b></p>
          <div class="form-group">
            <input name="notes"  class="form-control" aria-describedby="smth" placeholder="Any allergies?" v-model="notes">
            <div class="row mx-2">
              <small class="form-text text-muted mt-4">You may specify additional dietary requirements here</small>
            </div>
          </div>
        </div>
      </div>

      <br><br><br><br>
      


      <div id = "footer" class = "fixed-bottom w-100 bar" style="background-color:white;">
        <div class="row m-2 mb-3" >
          <div class="col-4 p-0">
            <div class="d-flex justify-content-between mx-1">
              <div v-if="quantity > 1" class=" d-flex justify-content-center quantityButton mediumBackground my-1"  v-on:click="decrementQuantity()">
                <p class="my-auto" style="color:white">-</p>
              </div>
              <div  v-if="quantity <= 1" class=" d-flex justify-content-center quantityButton my-1" style="background-color:lightgrey">
                  <p class="my-auto" style="color:white">-</p>
              </div>
              <p class="my-auto mx-0">{{this.quantity}}</p>
              <div class=" d-flex justify-content-center quantityButton mediumBackground my-1"  v-on:click="incrementQuantity()">
                  <p class="my-auto" style="color:white">+</p>
              </div>
              
            </div>
          </div>
          <div class="col-8 p-0">
            <div class="d-flex mx-3">
              <div v-if="$route.params.updateIndex == null" class="rounded mediumBackground d-flex justify-content-center" style="width:100%" v-on:click="addToCart()">
                <p class="my-2  " style="color:white">Add to cart - {{finalPrice}}</p>
              </div>
              <div v-if="$route.params.updateIndex != null" class="rounded mediumBackground d-flex justify-content-center" style="width:100%;" v-on:click="updateCart()">
                <p class="my-2" style="color:white">Update cart - {{finalPrice}}</p>
              </div>
            </div>
          </div>
        </div>
      </div> 
    </v-app>
  </div> 
</template>


<script>
  
  // import MenuAddOn from "../components/MenuAddOn.vue"
  export default {
    name: "Menu",
    data() {
      return {
          menuId: 0,
          menu: {},
          selected: "",
          options: {},
          selectedOptionName: "",
          selectedAddOns: [],
          selectedOptionCategory: "",
          optionCategory1: null,
          optionCategory2: null,
          optionCategory3: null,
          optionCategory4: null,  
          optionCategory5: null,
          option1Selected: "",
          option2Selected: "",
          option3Selected: "",
          option4Selected: "",
          option5Selected: "",
          quantity: 1,
          invalidSubmission: false,
          displayPrice: 0,
          finalPrice: 0,
          addedToCart: false,
          notes: "",
          collapseOnScroll: true,
          addOnsAllowed: 0
      }
    },
    created() {
        this.id = this.$route.params.menuId;
        try {
          for(var i=0;i<this.$store.getters.getMenus.length;i++){
            var menu = this.$store.getters.getMenus[i]
            if (this.$store.getters.getMenus[i].id == this.id){
              this.menu = this.$store.getters.getMenus[i]
            }
          }
          this.setup()
        }
        catch(err){
        this.axios.post(this.$parent.api + 'menu/get_menu_item', {
          id: this.id
        })
        .then(res => {
            this.menu = res.data
            this.setup()
        })
        .catch(function (error) {window.console.log(error)});
        }
        
    },
    mounted(){
        

    },
    
    methods: {
      clickAddOn(optionName){
        var found = false
          for(var i=0;i<this.selectedAddOns.length;i++){
            if (this.selectedAddOns[i] == optionName){
              this.selectedAddOns.pop(i)
              found = true
            }
          }

          if (!found){
            this.selectedAddOns.push(optionName)
          }

      },
      addToCart() {
        var selectedOptions = []

        if (this.optionCategory1 != null){
          selectedOptions.push(this.option1Selected)
        }

        if (this.optionCategory2 != null){
          selectedOptions.push(this.option2Selected)
        }

        if (this.optionCategory3 != null){
          selectedOptions.push(this.option3Selected)
        }

        if (this.optionCategory4 != null){
          selectedOptions.push(this.option4Selected)
        }

        if (this.optionCategory5 != null){
          selectedOptions.push(this.option5Selected)
        }

        //check if all options are checked

        window.console.log("displayPrice: " + this.displayPrice)


        var item = {
          menuId: this.id,
          menuName: this.menu.name,
          menuOptions: selectedOptions,
          selectedAddOns: this.selectedAddOns,
          orderPrice: this.getPrice() * this.quantity,
          finalPrice: this.finalPrice,
          quantity: this.quantity,
          menuNotes: this.notes,
          src: this.menu.src,
          promotionType: this.menu.promotionType,
          promotionAmount: this.menu.promotionAmount
        }
        this.$store.commit("addOrder", item)
        window.localStorage.setItem("orders", JSON.stringify(this.$store.getters.getOrders))
        this.addedToCart=true

        //  setTimeout(function(router) {
        //     router.go(-1)


        //   }, 500,this.$router);

        this.$router.go(-1)


        // this.$router.push({ name: 'cart'})


        


      },
      setup(){
        window.console.log(this.menu)
            this.displayPrice = this.menu.displayPrice
            this.optionCategory1 = this.menu.optionCategories.length > 0 ? this.menu.optionCategories[0]: null
            this.optionCategory2 = this.menu.optionCategories.length > 1 ? this.menu.optionCategories[1]: null
            this.optionCategory3 = this.menu.optionCategories.length > 2 ? this.menu.optionCategories[2]: null
            this.optionCategory4 = this.menu.optionCategories.length > 3 ? this.menu.optionCategories[3]: null
            this.optionCategory5 = this.menu.optionCategories.length > 4 ? this.menu.optionCategories[4]: null
            this.option1Selected = this.optionCategory1 != null ? this.optionCategory1.options[0].optionName: ""
            this.option2Selected = this.optionCategory2 != null ? this.optionCategory2.options[0].optionName: ""
            this.option3Selected = this.optionCategory3 != null ? this.optionCategory3.options[0].optionName: ""
            this.option4Selected = this.optionCategory4 != null ? this.optionCategory4.options[0].optionName: ""
            this.option5Selected = this.optionCategory5 != null ? this.optionCategory5.options[0].optionName: ""
            this.addOnsAllowed = this.menu.addOnLimit != 0 ? this.menu.addOnLimit: this.menu.addOns.length
            if (this.$route.params.updateIndex != null){
              this.initialiseOptions()
            }
            if (this.menu.price != 0){
              this.displayPrice = this.menu.price
              if (this.menu.promotionType == 'percent'){
                this.finalPrice = this.displayPrice * (100 - this.menu.promotionAmount) / 100
              }
              if (this.menu.promotionType == 'amount'){
                this.finalPrice = this.displayPrice - this.menu.promotionAmount
              }
            }
            else {
              this.updateDisplayPrice()
            }


        
      },

      updateCart() {
        var selectedOptions = []

        if (this.optionCategory1 != null){
          selectedOptions.push(this.option1Selected)
        }

        if (this.optionCategory2 != null){
          selectedOptions.push(this.option2Selected)
        }

        if (this.optionCategory3 != null){
          selectedOptions.push(this.option3Selected)
        }

        if (this.optionCategory4 != null){
          selectedOptions.push(this.option4Selected)
        }

        if (this.optionCategory5 != null){
          selectedOptions.push(this.option5Selected)
        }

        //check if all options are checked

        window.console.log("displayPrice: " + this.displayPrice)


        var item = {
          menuId: this.id,
          menuName: this.menu.name,
          menuOptions: selectedOptions,
          selectedAddOns: this.selectedAddOns,
          orderPrice: this.getPrice() * this.quantity,
          finalPrice: this.finalPrice,
          quantity: this.quantity,
          menuNotes: this.notes,
          src: this.menu.src,
          promotionType: this.menu.promotionType,
          promotionAmount: this.menu.promotionAmount
        }

        var cart = this.$store.getters.getOrders
        cart[this.$route.params.updateIndex] = item

        window.console.log(item)
        this.$store.commit("setOrders", cart)

        window.console.log(this.$store.getters.getOrders[this.$route.params.updateIndex])
        window.localStorage.setItem("orders", JSON.stringify(this.$store.getters.getOrders))

        this.addedToCart=true

        //  setTimeout(function(router) {
        //     router.go(-1)

        //   }, 500,this.$router);

        this.$router.go(-1)


        // this.$router.push({ name: 'cart'})


        


      },
      back(router){
        router.go(-1)
      },

      updateDisplayPrice(){
        if(this.menu.price == 0){
          this.displayPrice = this.getPrice() * this.quantity
        }
        window.console.log("displayPrice: " + this.displayPrice)
        this.finalPrice = this.displayPrice
        if (this.menu.promotionType == 'percent'){
          this.finalPrice = this.finalPrice * (100 - this.menu.promotionAmount) / 100
        }
        if (this.menu.promotionType == 'amount'){
          this.finalPrice = this.finalPrice - this.menu.promotionAmount
        }
        if (this.addedToCart == true){
          this.addedToCart = false
        }        
      },
      incrementQuantity(){
        this.quantity++
        this.updateDisplayPrice()

      },
      decrementQuantity(){
        if (this.quantity > 1){
          this.quantity--
        }
        this.updateDisplayPrice()
      },
      initialiseOptions(){
        var item = this.$store.getters.getOrders[this.$route.params.updateIndex]
        this.selectedAddOns = item.selectedAddOns
        this.notes = item.menuNotes
        this.option1Selected = this.optionCategory1 != null ? item.menuOptions[0]: ""
        this.option2Selected = this.optionCategory2 != null ? item.menuOptions[1]: ""
        this.option3Selected = this.optionCategory3 != null ? item.menuOptions[2]: ""
        this.option4Selected = this.optionCategory4 != null ? item.menuOptions[3]: ""
        this.option5Selected = this.optionCategory5 != null ? item.menuOptions[4]: ""
      },
      verifySelected(){
        var allSelected = true

        if (this.optionCategory1 != null && this.option1Selected == ""){
          allSelected = false
        }

        if (this.optionCategory2 != null && this.option2Selected == ""){
          allSelected = false
        }

        if (this.optionCategory3 != null && this.option3Selected == ""){
          allSelected = false
        }

        if (this.optionCategory4 != null && this.option4Selected == ""){
          allSelected = false
        }

        if (this.optionCategory5 != null && this.option5Selected == ""){
          allSelected = false
        }

        if (this.quantity == 0){
          allSelected = false
        }
        return allSelected
    },
      getPrice(){
                
        var price = 0
      

        if (this.menu.price != 0){
          price = this.menu.price
        }
        else{
          if (this.optionCategory1 != null){
            for (var i = 0; i < this.optionCategory1.options.length; i++){
              if (this.option1Selected == this.optionCategory1.options[i].optionName){
                price += this.optionCategory1.options[i].optionPrice
                window.console.log("adding price")
              }
            }
          }
        
          if (this.optionCategory2 != null){
            for (i = 0; i < this.optionCategory2.options.length; i++){
              if (this.option2Selected == this.optionCategory2.options[i].optionName){
                price += this.optionCategory2.options[i].optionPrice
              }
            }
          }

          if (this.optionCategory3 != null){
            for (i = 0; i < this.optionCategory3.options.length; i++){
              if (this.option3Selected == this.optionCategory3.options[i].optionName){
                price += this.optionCategory3.options[i].optionPrice
              }
            }
          }

          if (this.optionCategory4 != null){
            for (i = 0; i < this.optionCategory4.options.length; i++){
              if (this.option4Selected == this.optionCategory4.options[i].optionName){
                price += this.optionCategory4.options[i].optionPrice
              }
            }
          }

          if (this.optionCategory5 != null){
            for (i = 0; i < this.optionCategory5.options.length; i++){
              if (this.option5Selected == this.optionCategory5.options[i].optionName){
                price += this.optionCategory5.options[i].optionPrice
              }
            }
          }
        }

        // loop through selectedAddOns
        for (i=0;i<this.selectedAddOns.length;i++){
          var selectedAddOn = this.selectedAddOns[i]
          for(var j=0;j<this.menu.addOns.length;j++){
            var option = this.menu.addOns[j]
            if (selectedAddOn == option.optionName){
              price += option.optionPrice
            }
          }
        }

        
        

        return price
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
    font-size: 16px;
  }

  .radioText {
    font-size: 14px
    
  }

  .bar {
    
   
    border: solid 2px rgba(219, 219, 219, 0.4);
    border-bottom: none;
    border-left: none;
    border-right: none;
    /* box-shadow: 0px -1px 15px 1px lightgrey; */
  }

  .quantityButton {
    border-radius: 50%;
    height: 30px;
    width: 30px
  }

 

</style>