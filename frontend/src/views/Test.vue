<template>
    <div>
    <p> added to tables </p>
    </div>
    
</template>

<script>
export default {
    name: "Test",
    mounted() {
        this.axios.get("http://localhost:9090/test/add_menus")
    }
}
</script>