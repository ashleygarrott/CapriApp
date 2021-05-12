<template>
    <div class="locationBar" v-if="deliveryInfo!={}">
        <div class="d-flex justify-content-center text-center p-0">
            <p class="my-1 p-0" style="color:grey;font-size:0.7rem"><b>{{deliveryInfo.shortenedAddress}}</b></p>
            <!-- <p class="my-1 p-0" style="color:white">a</p>
            <p class="my-1 p-0" style="font-size:0.7rem;color:grey"><b>{{deliveryInfo.distance.humanReadable}}/{{deliveryInfo.duration.humanReadable}}/฿{{deliveryInfo.deliveryFee}}</b></p> -->
        </div>
        <div v-if="deliveryInfo=={}">
            <p style="color:grey;font-size:0.7rem"><b>We can not yet determine your location</b></p>
        </div>

    </div>
</template>

<script>
export default {
    name: "LocationBar",
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
            shortenedAddress: "no address currently"
            }
        }
    },
    created() {
        window.console.log(this.$parent)
        this.deliveryInfo = this.$parent.deliveryInfo
    }
}
</script>

<style scoped>

    .locationBar {
        background-color:white;
    }
</style>