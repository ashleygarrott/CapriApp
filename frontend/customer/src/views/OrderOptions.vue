<template>
    <div class="imageBackground" v-bind:style="'height:' + $parent.screenHeight + 'px;width:' + $parent.screenWidth + 'px;max-height:' + $parent.screenHeight + 'px'">
        <!-- <div class="topBar fixed-top extralightBackground rounded">
            <div class="d-flex justify-content-around my-1"> 
                <img src="/img/logos/logo.png" height=38px class="my-0">
            </div>
        </div> -->
        <!-- <v-overlay :value="overlay"></v-overlay> -->
        <div class="d-flex justify-content-center mt-5">
            <img src="/img/logos/logo4.png" v-bind:style="'width:' + $parent.windowWidth * 0.8 + 'px'">
        </div>
        
        <div class="d-flex justify-content-center mediumBackground my-4 banner darkBackground">
            <p class=" my-2" style="font-size:20px;color:lightgrey;"><b>Where should we deliver?</b></p>

        </div>
        <div class="glassCard mx-3 mt-5">
            <div class="d-flex justify-content-center my-4" v-if="!$store.getters.hasGps && !$store.getters.isLoaded">
                <v-progress-circular
                    indeterminate
                    size="64"
                    color="#195447"
                ></v-progress-circular>
            </div>
            <div class="d-flex justify-content-center mt-2" v-if="!$store.getters.hasGps && $store.getters.isLoaded">
                <label class="my-4">We could not detect your location</label>
            </div>
            <div class="d-flex justify-content-center mt-2" v-if="$store.getters.hasGps">
                <div>
                    
                    <div class="d-flex justify-content-center">
                        <div style="width:95%">
                            <div class="d-flex justify-content-start">
                                <i class="fas fa-map-marker-alt my-auto mr-2 my-auto " style="align-items:baseline;font-size:13px;color:black"></i>
                                <label class="mb-1 mr-2 my-auto " style="align-items:baseline;font-size:13px;color:black"><b>{{this.$store.getters.getDeliveryInfo.distance.humanReadable}}</b></label>
                                <label class=" my-auto " style="font-size:13px;align-items:baseline;color:black"><b>from Capri cove</b></label>
                            </div>
                            <label class="mt-1 darkColour my-3" style="font-size:14px;">{{this.$store.getters.getDeliveryInfo.destination}}</label>
                        </div>
                    </div>

                    <div class="d-flex justify-content-center mb-3">
                        <div style="width:95%">
                            <div class="d-flex justify-content-start">
                                <i class="fas fa-truck my-auto  mr-2 my-auto darkColour" style="align-items:baseline;font-size:12px;color:#49915c"></i>
                                <p class="my-0 darkColour" style="font-size:12px;color:#49915c">฿</p>
                                <p class="my-0 darkColour" style="font-size:12px;color:#49915c">{{this.$store.getters.getDeliveryInfo.deliveryFee}}</p>
                            </div>
                            <div class="d-flex justify-content-start">
                                <i class="far fa-clock my-auto  mr-2 my-auto darkColour" style="align-items:baseline;font-size:12px;color:#49915c"></i>
                                <p class=" my-auto darkColour" style="font-size:12px;color:#49915c">{{this.$store.getters.getDeliveryInfo.duration.humanReadable}}</p>
                            </div>
                            
                        </div>
                    </div>

                    
                </div>

                
            </div>


            <div class="d-flex justify-content-center">
                <div style="width:80%">
                    <div class="darkBackground p-2 rounded my-2" v-if="$store.getters.hasGps" v-on:click="setMode('delivery');$router.push({name: 'home', params: {orderMode: mode}})">
                        <p class="text-center my-auto" style="color:white">Use current location</p>
                    </div>
                    <div class="p-2 rounded my-2 greyButton" style = "background-color:#5c5756" v-if="!$store.getters.hasGps">
                        <p class="text-center my-auto" style="color:white">Use current location</p>
                    </div>
                    <div class="p-2 rounded my-3 darkBorder" v-if="$store.getters.hasGps || !$store.getters.isLoaded" v-on:click="$router.push({name: 'selectLocation'})">
                        <p class="text-center my-auto darkColour" >Select another location</p>
                    </div>
                    <div class="darkBackground p-2 rounded my-3" v-if="!$store.getters.hasGps && $store.getters.isLoaded" v-on:click="$router.push({name: 'selectLocation'})">
                        <p class="text-center my-auto" style="color:white">Select another location</p>
                    </div>

                    
                </div>
            </div>
        </div>
        
     



       
       
                
        <div class="tertiaryButton p-2 fixed-bottom">
            <div class="d-flex justify-content-center">
            <i class="fas fa-store-alt my-auto" style="color:#2d302e"></i>
            <label class="my-auto mx-2" style="color:#2d302e;font-size:14px" v-on:click="setMode('takeaway');$router.push({name: 'home', params: {orderMode: mode}})">Pick up at Capri Cove</label>
            </div>
        </div>
    </div>

</template>

<script>
import VueGoogleAutocomplete from 'vue-google-autocomplete'

export default {
    components: {
        VueGoogleAutocomplete,
    },
    name: "OrderOptions",
    data () {
        return {
            useGps: true,
            addressData: {},
            address: "",
            gps: false,
            loaded: false
        }
    },
    watch: {
      overlay (val) {
        val && setTimeout(() => {
          this.loaded = true
        }, 3000)
      },
    },
    created(){
    },
    methods: {
        setMode(mode){
            this.$store.commit("setOrderMode", mode)
            window.localStorage.setItem("orderMode", mode)
            
        },
        isValidOrderMode(orderMode){
            if (orderMode == "delivery"){
            return true
            }
            if (orderMode == "takeaway"){
            return true
            }
            if (orderMode == "dinein"){
            return true
            }
            return false
        },
        requestLocation(){
            this.$refs.addressInput.clear()
            if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(this.savePosition , 
            function showError(error) {
            switch(error.code) {
              case error.PERMISSION_DENIED:
                this.$router.push({name: "selectLocation"})
                break;
              case error.POSITION_UNAVAILABLE:
                this.message = "Turn on location to detect current location"
                break;
              case error.TIMEOUT:
                this.message = "Turn on location to detect current location"
                break;
              case error.UNKNOWN_ERROR:
                this.message = "Turn on location to detect current location"
                break;
            }
});
        } else {
            this.message = "Turn on location to detect current location"
        }
        },
        savePosition(position) {
            this.$store.commit("setLatitude", position.coords.latitude)
            this.$store.commit("setLongitude", position.coords.longitude)

            //do other stuff

            this.axios.post(this.$parent.api + 'processor/get_delivery_fee', {
            latitude: position.coords.latitude,
            longitude: position.coords.longitude
            })
            .then(res => {
            window.console.log("SKjnsjlkd")
            window.console.log("gps" + this.gps)
            this.$store.commit("setDeliveryInfo", res.data)
            window.localStorage.setItem("deliveryInfo", JSON.stringify(this.$store.getters.getDeliveryInfo))

            this.address = this.$store.getters.getDeliveryInfo.destination

            }
            )
            .catch(function (error) {
                this.message = "Sorry, we could not retrieve your location"
                window.console.log(error)
                });

        }
    }
}
</script>

<style scoped>


    .blueBox {
        background-color: #55d6d0;
    }

    .blueBox p {
        color:white
    }


    .background  {
        background-size: cover;
        background-color: lightgrey;
    }

    .topBar {
        box-shadow: 0px -1px 10px 2px #859096;
        border-color: lightgrey;
        border-style: solid;
        border-width: 1px
    }
    .imageBackground {
        background: url('/img/backgrounds/background.jpg');
        background-size: cover;
        overflow: hidden;
    }

    img.bg {

	
  /* Set up positioning */
  position: fixed;
  top: 0;
  left: 0;



}



    .glassCard {
        background: rgba( 255, 255, 255, 0.3 );
        box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
        backdrop-filter: blur( 15px );
        -webkit-backdrop-filter: blur( 15px );
        border-radius: 10px;
        border: 1px solid rgba( 255, 255, 255, 0.18 );
    }

    .banner {
        box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
        border: 1px solid rgba( 255, 255, 255, 0.18 );
    }

    .glassButton {
        background: rgba( 255, 255, 255, 0.6 );
        box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
        backdrop-filter: blur( 15px );
        -webkit-backdrop-filter: blur( 15px );
        border-radius: 5px;
        border: 1px solid rgba( 255, 255, 255, 0.18 );
    }

.centered {
    position: fixed;
    left: 50%;
    transform: translate(-50%, 0);
}


div.transbox {

  opacity: 0.6;
}
div.transbox p {
  color: #000000;
}

.tertiaryButton{
    background: rgba(134, 160, 157, 0.7);
    box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
    border: 1px solid rgba(19, 17, 17, 0.4);
    border-style: solid;
    border-radius: 5px 5px 0px 0px;
    border-width: 2px;
    backdrop-filter: blur( 5px );
    -webkit-backdrop-filter: blur( 5px );
    border-bottom: none;
    border-left:none;
    border-right:none;


}





</style>