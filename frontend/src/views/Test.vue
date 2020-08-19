<template>
    <div>
    <p> hi </p>
    <router-link :to="{ name: 'Menu', params: { id: 1 }}">Navigate to Page2</router-link>
    </div>
    
</template>

<script>
export default {
    name: "Test"
}
</script>