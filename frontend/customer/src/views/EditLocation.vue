<template>
   <div>
       <div class="fixed-top shadowed" style="background-color:white;">
            <div class="d-flex justify-content-between mx-3 my-2">
                <div>
                    <div class="d-flex justify-content-start ">
                        <i class="fas fa-chevron-left  mr-4 my-auto mediumColour" style="font-size:20px" v-on:click="$router.go(-1)"></i>
                        <p class="my-auto" style="font-size:20px">Cart</p>
                    </div>
                </div>
            </div>
        </div>
        <br>
       <div class="locationCard mx-3 mt-5">
            <div>
                <div class="d-flex justify-content-center mt-2" v-if="$store.getters.getDeliveryInfo.destination">
                    <div>
                        <div class="d-flex justify-content-center">
                            <div style="width:95%">
                                <div class="d-flex justify-content-start">
                                    <i class="fas fa-map-marker-alt my-auto mr-2 my-auto " style="align-items:baseline;font-size:13px;color:black"></i>
                                    <label class="mb-1 mr-2 my-auto " style="align-items:baseline;font-size:13px;color:black"><b>{{$store.getters.getDeliveryInfo.distance.humanReadable}}</b></label>
                                    <label class=" my-auto " style="font-size:13px;align-items:baseline;color:black"><b>from Capri cove</b></label>
                                </div>
                                <label class="mt-1 mediumColour my-3" style="font-size:14px;">{{$store.getters.getDeliveryInfo.destination}}</label>
                            </div>
                        </div>

                        <div class="d-flex justify-content-center mb-3">
                            <div style="width:95%">
                                <div class="d-flex justify-content-start">
                                    <i class="fas fa-truck my-auto  mr-2 my-auto text-muted" style="align-items:baseline;font-size:12px;color:#49915c"></i>
                                    <p class="my-0 text-muted" style="font-size:12px;">฿</p>
                                    <p class="my-0 text-muted" style="font-size:12px;">{{$store.getters.getDeliveryInfo.deliveryFee}}</p>
                                </div>
                                <div class="d-flex justify-content-start">
                                    <i class="far fa-clock my-auto  mr-2 my-auto text-muted" style="align-items:baseline;font-size:12px;"></i>
                                    <p class=" my-auto text-muted" style="font-size:12px;">{{$store.getters.getDeliveryInfo.duration.humanReadable}}</p>
                                </div>
                                
                            </div>
                        </div>

                        
                    </div>

                    
                </div>
                <div class="mt-4">
                    <p class="mb-0 ml-2"><b>Address</b></p>
                    <div class="d-flex justify-content-between m-1">
                        <vue-google-autocomplete
                            id="map"
                            classname="textField"
                            v-bind:placeholder="$store.getters.getDeliveryInfo.destination"
                            v-on:placechanged="getAddressData"
                            country="th"
                            ref="addressInput"
                        >
                        </vue-google-autocomplete>
                        <div>
                            <div class="d-flex my-auto locationButton" style="height:100%;" v-on:click="requestLocation()">
                                <i class="fas fa-map-marker-alt my-auto mx-2 darkColour" style="color:"></i>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="d-flex justify-content-center mt-5 mb-2">
                    <div style="width:80%">
                        <div class="mediumBackground p-2 rounded my-2" v-if="$store.getters.getDeliveryInfo.destination" v-on:click="setMode('delivery');$router.push({name: 'home', params: {orderMode: mode}})">
                            <p class="text-center my-auto" style="color:white">Use this location</p>
                        </div>
                        <div class="p-2 rounded my-2" v-if="!$store.getters.getDeliveryInfo.destination" style="background-color:#5c5756" v-on:click="setMode('delivery');$router.push({name: 'home', params: {orderMode: mode}})">
                            <p class="text-center my-auto" style="color:white">Use this location</p>
                        </div> 
                    </div>
                </div>
            </div>
       </div>
   </div>
</template>

<script>
import VueGoogleAutocomplete from 'vue-google-autocomplete'

export default {
    components: {
        VueGoogleAutocomplete
    },
    name: "EditLocation",
    data () {
        return {
            useGps: true,
            addressData: {},
            address: ""
        }
    },
    created(){
        var orderMode = window.localStorage.getItem("orderMode")
        if (this.$route.params.redirect){
            if (this.isValidOrderMode(orderMode)){
                this.setMode(orderMode)
            }
        }
        
    },
    methods: {
        setMode(mode){
            this.$parent.orderMode = mode
            window.localStorage.setItem("orderMode", mode)
            this.$router.push({name: "home", params: {orderMode: mode}})
            
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
        getAddressData(addressData, placeResultData) {
            this.addressData = addressData;
            this.$parent.latitude = addressData.latitude
            this.$parent.longitude = addressData.longitude
            this.placeResultData = placeResultData
            this.address = placeResultData.formatted_address
            this.$parent.getDeliveryFee(addressData.latitude, addressData.longitude)
            window.console.log(addressData)
            window.console.log(placeResultData)
        },
        requestLocation(){
            this.$refs.addressInput.clear()
            if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(this.savePosition , 
            function showError(error) {
            switch(error.code) {
              case error.PERMISSION_DENIED:
                this.$parent.deliveryInfo = {}
                break;
              case error.POSITION_UNAVAILABLE:
                this.$parent.deliveryInfo = {}
                break;
              case error.TIMEOUT:
                this.$parent.deliveryInfo = {}
                break;
              case error.UNKNOWN_ERROR:
                this.$parent.deliveryInfo = {}
                break;
            }
});
        } else {
            window.console.log("Geolocation is not supported by this browser.")
            this.$parent.deliveryInfo = {}
        }
        },
        savePosition(position) {
            this.latitude = position.coords.latitude
            this.longitude = position.coords.longitude
            this.$store.commit("setLatitude", position.coords.latitude)
            this.$store.commit("setLongitude", position.coords.longitude)
            this.getDeliveryFee(this.latitude, this.longitude)
            this.getLocationData(this.latitude, this.longitude) 
        },
        getDeliveryFee(lat, long){
            this.axios.post(this.api + 'processor/get_delivery_fee', {
                latitude: lat,
                longitude: long
            })
            .then(res => {
            window.console.log(res.data)
            this.$store.commit("setDeliveryInfo", res.data)
            this.$store.commit("setGps", true)


            }
            )
            .catch(function (error) {window.console.log(error)});
        },
        getLocationData(lat, long){
            this.axios.post(this.api + 'processor/get_location_data', {
                latitude: lat,
                longitude: long
            })
            .then(res => {
            window.console.log(typeof(res.data))

            var currentLocation = res.data
            this.$store.commit("setCurrentLocation", currentLocation)
            this.$store.commit("setShortAddress", currentLocation[0].shortName + " " + currentLocation[1].shortName)
            this.$store.commit("setGps", true)

        }
        )
        .catch(function (error) {window.console.log(error)});
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
        background-color: lightgrey;
        background-size: cover;
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

    .glassCard {
        background: rgba( 255, 255, 255, 0.3 );
        box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
        backdrop-filter: blur( 15px );
        -webkit-backdrop-filter: blur( 15px );
        border-radius: 10px;
        border: 1px solid rgba( 255, 255, 255, 0.18 );
    }

    .vertical-center {
  margin: 0;
  position: absolute;
  top: 50%;
  -ms-transform: translateY(-50%);
  transform: translateY(-50%) translateY(-40px);
}

    .textField{
        
        border: 1px solid grey;
        width:100%;
        border-radius: 5px 0px 0px 5px;
        color:black;
        border-right: none;

    }

    .textField[type=text]:focus {
        outline-color: #639177


    }

    .locationButton {
        border: 1px solid grey;
        border-left: none;
        background-color:white;
        border-radius: 0px 5px 5px 0px;

    }

    .locationCard {
        background-color: white;
        border-top: rgb(211, 211, 211, 0.7) solid;
        border-left: lightgrey solid;
        border-bottom: lightgrey solid;
        border-right: lightgrey solid;
        border-radius: 3px;
        box-shadow: 0px 2px 10px 1px rgb(236, 236, 236);
        border-width:1px

    }




</style>