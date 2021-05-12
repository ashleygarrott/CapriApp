<template>
    <div>
    <p> added to tables </p>
    </div>
    
</template>

<script>
export default {
    name: "Test",
    mounted() {
        this.axios.get(this.$parent.api + 'test/add_menus')
    }
}
</script>