<template>
    <div>
        <div class="centered">
            <div class="d-flex justify-content-center mb-2">
                <label style="font-size:20px;color:#49b3cd">Capri Cove Admin</label>
            </div>
            <div class="d-flex justify-content-center mb-2">
                <div class="my-auto">
                    <label class="my-2">Username: </label>
                    <label class="my-2">Password: </label>
                </div>
                <div>
                    <input type="username" class="form-control ml-2" id="exampleInputEmail1" aria-describedby="username" placeholder="username" v-model="username">
                    <input type="password" class="form-control ml-2" id="exampleInputEmail1" aria-describedby="password" placeholder="password" v-model="password">
                </div>
            </div>
            <div class="d-flex justify-content-center">
                <input class="btn btn-primary" type="button" value="Login" v-on:click="login()">
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Login",
    data(){
        return{
            username: "",
            password: ""
        }
    },
    created(){
        if (this.$parent.loggedIn){
            this.$router.push({name: "home"})
        }

        
    },
    methods: {
        login(){
            this.axios.post(this.$parent.api + 'authenticate/authenticate', {
                username: this.username,
                password: this.password

            })
            .then(res => {
                window.console.log(res.request.response)
                var response = JSON.parse(res.request.response)
                window.console.log(response.accessToken)
                this.$parent.accessToken = response.accessToken
                window.localStorage.setItem("accessToken", response.accessToken)
                this.$parent.refresherToken = response.refresherToken
                window.localStorage.setItem("refresherToken", response.refresherToken)
                this.$parent.updateConfig()
                // this.axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.$parent.token;
                // this.axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*'
                this.$router.push({name: "openOrders"})
            })
            .catch(function (error) {window.console.log("login failed")});
        }
    }
}
</script>

<style scoped>
.centered {
   width: 280px;
   height: 180px;
   position: absolute;
   top: 50%;
   left: 50%;
   margin-left: -140px;
   margin-top: -90px;
}

.bordered {
    border-style: solid;
    border-color: black;
}

</style>