<template>
    <div class="headerArea headerColour fixed-top" id="headerArea">
        <location-bar />
        <search-bar />
    </div>
</template>

<script>
import SearchBar from "../components/SearchBar"
import LocationBar from "../components/LocationBar"
export default {
    name: "HomeHeader",
    components: {
        SearchBar,
        LocationBar
    },
    data () {
        return {
            deliveryInfo: {
                deliveryFee: 0, 
                destination: "",
                distance: {
                    humanReadable: "",
                    inMeters: 0
                },
                duration: {
                    humanReadable: "",
                    inSeconds: 0
                },
                shortenedAddress: "sample destination"
                }
        }
    },
    created (){
        this.deliveryInfo = this.$parent.deliveryInfo
    }
}
</script>

<style scoped>
  .headerArea {
    box-shadow: 1px 1px 5px 1px lightgrey;

  }
</style>