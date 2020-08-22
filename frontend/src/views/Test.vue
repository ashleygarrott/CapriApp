<template>
    <div>
    <p> added to tables </p>
    </div>
    
</template>

<script>
export default {
    name: "Test",
    mounted() {
        this.axios.get("https://capriapp-backend.herokuapp.com/test/add_menus")
    }
}
</script>