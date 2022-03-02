<template>
  <div class="row">
    <div class="col-md-6 offset-md-3">
      <div>
        <div>
          <h3>Login</h3>
          <hr />
        </div>
        <form>
          <div class="form-group">
            <label>Email</label>
            <input type="text" class="form-control" v-model="username"/>
          </div>

          <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" v-model="password" />
          </div>
          <div class="my-">
            <button type="submit" class="btn btn-primary" @click.prevent="login">Login</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>

import http from '../services/http'
import router from '../router'

export default {
  name: "Login-page",
  data() {
    return {
       username:'',
      password:''
    };
  },
  methods:{
    login:function(){
      localStorage.removeItem('token')
      let self = this;
       http.post("user",{
                name:this.username,
                password:this.password
            }).then(function (res){
                localStorage.setItem( 'token', JSON.stringify(res.data.token) );

                console.log("success",res)
                self.$flashMessage.show({
                  type: 'success',
                  title: 'you have successfully signed in!',
                });
                    router.push("home")

                }) .catch(error => {
                   self.$flashMessage.show({
                  type: 'error',
                  title: 'invalid username and password',
                });
                 console.error('There was an error!', error);
                });
            
  }
  }
};
</script>
