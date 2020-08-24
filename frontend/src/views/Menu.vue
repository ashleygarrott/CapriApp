<template>
  <div>
    <search-bar />
    <img src="https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg" style="width: 100%">
    <div class="container flex-grow-1 bodyArea">
      <div class="d-flex justify-content-center">
        <p class="lead mt-2" style="font-size: 2rem;">{{menu.name}}</p>
      </div>
      <p class="lightColour" style="font-size: 1.5rem;">฿{{this.displayPrice}}</p>

      <div class="optionsWrapper">
        <div class="optionCategory" v-if="optionCategory1!=null">
          <div class="form-group">
            <label for="optionCategory">{{optionCategory1.optionCategoryName}}</label>
            <select v-on:change="updateDisplayPrice()" class="form-control" v-model="option1Selected">
              <option v-for="(option, index) in optionCategory1.options" :key="index">
                {{option.optionName}}
              </option>
            </select>
          </div>
        </div>

        <div class="optionCategory" v-if="optionCategory2!=null">
          <div class="form-group">
            <label for="optionCategory">{{optionCategory2.optionCategoryName}}</label>
            <select v-on:change="updateDisplayPrice()" class="form-control" v-model="option2Selected">
              <option v-for="(option, index) in optionCategory2.options" :key="index">
                {{option.optionName}}
              </option>
            </select>
          </div>
        </div>

        <div class="optionCategory" v-if="optionCategory3!=null">
          <div class="form-group">
            <label for="optionCategory">{{optionCategory3.optionCategoryName}}</label>
            <select v-on:change="updateDisplayPrice()" class="form-control" v-model="option3Selected">
              <option v-for="(option, index) in optionCategory3.options" :key="index">
                {{option.optionName}}
              </option>
            </select>
          </div>
        </div>

        <div class="optionCategory" v-if="optionCategory4!=null">
          <div class="form-group">
            <label for="optionCategory">{{optionCategory4.optionCategoryName}}</label>
            <select v-on:change="updateDisplayPrice()" class="form-control" v-model="option4Selected">
              <option v-for="(option, index) in optionCategory4.options" :key="index">
                {{option.optionName}}
              </option>
            </select>
          </div>
        </div>

        <div class="optionCategory" v-if="optionCategory5!=null">
          <div class="form-group">
            <label for="optionCategory">{{optionCategory5.optionCategoryName}}</label>
            <select v-on:change="updateDisplayPrice()" class="form-control" v-model="option5Selected">
              <option v-for="(option, index) in optionCategory5.options" :key="index">
                {{option.optionName}}
              </option>
            </select>
          </div>
        </div>
        <!-- quantity -->
        <div class="optionCategory">
          <div class="form-group">
            <label for="quantity">Quantity</label>
            <select v-on:change="updateDisplayPrice()" class="form-control" v-model="quantity">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
              <option>6</option>

            </select>
          </div>
        </div>

        

        
      </div>
    
    <button v-on:click="addToCart()" type="button" class="btn" style="background-color:#55d6d0">Order</button>

    </div>
  </div>
    
</template>


<script>
  import SearchBar from "../components/SearchBar"
  export default {
    components: {
      SearchBar
    },
    name: "Menu",
    data() {
      return {
          menuId: 0,
          menu: {},
          selected: "",
          options: {},
          selectedOptionName: "",
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
          quantity: 0,
          invalidSubmission: false,
          displayPrice: ""
      }
    },
    created() {
        this.id = this.$route.params.menuId;
        this.axios.post('https://capriapp-backend.herokuapp.com/menu/get_menu_item', {
          id: this.id
        })
        .then(res => {
            this.menu = res.data
            this.displayPrice = this.menu.displayPrice
            this.optionCategory1 = this.menu.optionCategories.length > 0 ? this.menu.optionCategories[0]: null
            this.optionCategory2 = this.menu.optionCategories.length > 1 ? this.menu.optionCategories[1]: null
            this.optionCategory3 = this.menu.optionCategories.length > 2 ? this.menu.optionCategories[2]: null
            this.optionCategory4 = this.menu.optionCategories.length > 3 ? this.menu.optionCategories[3]: null
            this.optionCategory5 = this.menu.optionCategories.length > 4 ? this.menu.optionCategories[4]: null

        })
        .catch(function (error) {window.console.log(error)});

        


    },
    mounted() {
        



    },
    
    methods: {
      addToCart() {
        window.console.log(this.optionCategory1.options)
        var price = 0
        var selectedOptions = []

        if (this.optionCategory1 != null){
          selectedOptions.push(this.option1Selected)
          for (var i = 0; i < this.optionCategory1.options.length; i++){
            if (this.option1Selected == this.optionCategory1.options[i].optionName){
              price += this.optionCategory1.options[i].optionPrice
            }
          }
        }

        if (this.optionCategory2 != null){
          selectedOptions.push(this.option2Selected)
          for (i = 0; i < this.optionCategory2.options.length; i++){
            if (this.option2Selected == this.optionCategory2.options[i].optionName){
              price += this.optionCategory2.options[i].optionPrice
            }
          }
        }

        if (this.optionCategory3 != null){
          selectedOptions.push(this.option3Selected)
          for (i = 0; i < this.optionCategory3.options.length; i++){
            if (this.option3Selected == this.optionCategory3.options[i].optionName){
              price += this.optionCategory3.options[i].optionPrice
            }
          }
        }

        if (this.optionCategory4 != null){
          selectedOptions.push(this.option4Selected)
          for (i = 0; i < this.optionCategory4.options.length; i++){
            if (this.option4Selected == this.optionCategory4.options[i].optionName){
              price += this.optionCategory4.options[i].optionPrice
            }
          }
        }

        if (this.optionCategory5 != null){
          selectedOptions.push(this.option5Selected)
          for (i = 0; i < this.optionCategory5.options.length; i++){
            if (this.option5Selected == this.optionCategory5.options[i].optionName){
              price += this.optionCategory5.options[i].optionPrice
            }
          }
        }

        //check if all options are checked

        


        var item = {
          menuId: this.id,
          menuName: this.menu.name,
          menuOptions: selectedOptions,
          orderPrice: price * this.quantity,
          quantity: this.quantity
        }

        window.console.log(item)

        this.$parent.orders.push(item)

        this.$router.push({ name: 'cart'})


        


      },

      updateDisplayPrice(){
        if(this.verifySelected()){
          this.displayPrice = this.getPrice() * this.quantity
        }
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

        return price
      }
  }
}
</script>

<style scoped>

  .lightColour {
    color: #55d6d0;
  }

</style>