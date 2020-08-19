<template>
  <div>
    <img src="https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg" style="width: 100%">
    <p style="font-size: 2rem;">{{menu.name}}</p>
    <p style="font-size: 1.5rem;">฿{{menu.price}}</p>

    <div class="optionsWrapper">
      <div class="optionCategory" v-for="[optionCategory, options] in Object.entries(menu.options)" :key="optionCategory">
        <div class="form-group">
          <label for="optionCategory">{{optionCategory}}</label>
          <select class="form-control" v-model="selected">
            <option onchange="update(this.optionCategory, optionName)" v-for="[optionName, optionPrice] in Object.entries(menu.options[optionCategory])" :key="optionName">
              {{optionName}}
            </option>
          </select>
        </div>
      </div>
    </div>
    <p>{{selected}}</p>
    <button v-on:click="addToCart()" type="button" class="btn btn-primary">Order</button>


  </div>
    
</template>


<script>
  export default {
    name: "Menu",
    data() {
      return {
          menuId: 0,
          menu: {},
          selected: "",
          options: {},
          selectedOptionName: "",
          selectedOptionCategory: ""
      }
    },
    created() {
        this.id = this.$route.params.menuId;
        this.axios.post('http://localhost:9090/menu/get_menu_item', {
          id: this.id
        })
        .then(res => {
            this.menu = res.data
            window.console.log(this.menu.options)
        })
        .catch(function (error) {window.console.log(error)});

        for (var optionCategory in this.menu.options){
          this.options[optionCategory] = ""
        }

    },
    mounted() {
        



    },
    
    methods: {
      addToCart() {
        window.console.log(this.options)
        


      },
      update(optionCategory, optionName) {
        this.options[optionCategory] = optionName
      }
    }
  }
</script>

<style scoped>

</style>