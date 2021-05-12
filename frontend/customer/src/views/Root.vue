<template>
    <div>
    </div>
</template>

<script>
export default {
    name: "Root",
    data() {
        return {

        }
    }, 
    created(){
        this.$router.push({name: "home"})
    }
}
</script>