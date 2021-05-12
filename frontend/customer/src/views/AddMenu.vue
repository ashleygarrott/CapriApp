<template>
    <div class="container">
        <div class="fixed-top darkBackground mt-0">
            <p class="text-center my-auto" style="color:white">Add menu</p>
        </div>
        <div class="form-group">
            <label>ID</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="id" placeholder="Enter menu ID" v-model="id">
        </div>
        <div class="form-group">
            <label>Name</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="name" placeholder="Enter menu name" v-model="name">
        </div>
        <div class="form-group">
            <label>Image name</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="src" placeholder="eg. pizza.jpg" v-model="src">
        </div>
        <div class="form-group">
            <label>Section</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="section" placeholder="Enter menu I" v-model="section">
        </div>
        <div class="form-group">
            <label>Categories</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="categories" placeholder="Categories, separated by commas" v-model="categories">
        </div>
        <div class="form-group">
            <label>Price</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="price" placeholder="Enter menu price (0 if menu has variable pricing)" v-model="price">
        </div>
        <div class="form-group">
            <label>Tags</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="tags" placeholder="Tags, separated by commas" v-model="tags">
        </div>
        <div class="form-group">
            <label>English description</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="englishDescription" placeholder="" v-model="englishDescription">
        </div>
        <div class="form-group">
            <label>Thai description</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="thaiDescription" placeholder="" v-model="thaiDescription">
        </div>
        <div class="form-group">
            <label>Options</label>
            <div v-for="(optionCategory, index) in options" :key="index">
                <div v-for="(option, index2) in optionCategory.options" :key="index2">
                    <div class="d-flex justify-content-between">
                        <label>{{optionCategory.optionCategoryName}}</label>
                        <label>{{option.optionName}}</label>
                        <label>{{option.optionPrice}}</label>
                    </div>
                </div>
            </div>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="thaiDescription" placeholder="Option category" v-model="optionCategory">
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="thaiDescription" placeholder="Option name" v-model="optionName">
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="thaiDescription" placeholder="Option price" v-model="optionPrice">
            <input class="btn btn-primary" type="button" value="Add option" v-on:click="addOption()">
        </div>
        <div class="form-group">
            <label>Add Ons</label>
            <div v-if="addOns.length > 0">
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="thaiDescription" placeholder="Add on selection limit" v-model="addOnLimit">
            </div>
            <div v-for="(addOn, index) in addOns" :key="index">
                <div class="d-flex justify-content-between">
                    <label>{{addOn.optionName}}</label>
                    <label>{{addOn.optionPrice}}</label>

                </div>
            </div>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="thaiDescription" placeholder="Add On Name" v-model="addOnName">
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="thaiDescription" placeholder="Add On price" v-model="addOnPrice">
            <input class="btn btn-primary" type="button" value="Add add on" v-on:click="addAddOn()">
        </div>


    </div>
</template>

<script>
export default {
    name: "AddMenu",
    data() {
        return {
            id: "",
            name: "",
            src: "",
            section: "",
            categories: "",
            price: "",
            tags: "",
            englishDescription: "",
            thaiDescription: "",
            addOnLimit: "",
            options: [],
            addOns: [],
            optionCategory: "",
            optionName: "",
            optionPrice: "",
            addOnName: "",
            addOnPrice: ""
        }
    },
    methods: {
        addOption(){
            var found = false;
            for (var i=0;i<this.options.length;i++){
                var option = this.options[i]
                if (option.optionCategoryName == this.optionName){
                  found = true;
                  option.options.push({
                      optionName: this.optionName,
                      optionPrice: this.optionPrice
                  })
                }

                
            }
            if(!found){
                this.options.push({
                    optionCategoryName: this.optionCategory,
                    options: [{
                        optionName: this.optionName,
                        optionPrice: this.optionPrice
                    }]
                })
            }

            this.optionCategory = ""
            this.optionName = ""
            this.optionPrice = ""

        },
        addAddOn(){
            this.addOns.push({
                optionName: this.addOnName,
                optionPrice: this.addOnPrice
            })
        },
        submitMenu(){

            this.axios.post(this.$parent.api + 'menu/get_menu_by_category', {
                id: this.id,
                name: this.name,
                src: this.src,
                section: this.section,
                categories: this.categories.split(","),
                price: parseInt(this.price),
                tags: this.tags.split(","),
                englishDescription: this.englishDescription,
                thaiDescription: this.thaiDescription,
                optionCategories: this.options,
                addOns: this.addOns,
                addOnLimit: parseInt(this.addOnLimit)

            })
            .then(res => {
                if (res == 1){
                    this.$alert("Menu has been added")
                }
                else{
                    this.$alert("Failed to add menu")
                }
            })
        }
    }
}
</script>