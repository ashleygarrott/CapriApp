<template>
    <div>
        <vue-fake-input
  :length="10"
  :fontSize="40"
  inputColor="#31bce6"
  fontColor="#ffc107"
  :allowPaste="true"
  :onlynumber="true"
  v-model="phoneNumber"
/>
    </div>
</template>

<script>
import VueFakeInput from 'vue-fake-input';


export default ({
   name: "PhoneNumber",
   data(){
       return{
           phoneNumber: ""
       }
   },
   components: {
    VueFakeInput
  }

})
</script>


<style scoped>

</style>