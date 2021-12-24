<template>
  <div id="container">
    <h1 id="title" onclick="window.location.href='/';">MOZARK</h1>
    <form id="signup-form">
      <input
        type="text"
        placeholder="First Name"
        value=""
        id = "first-name"
        ref="FName"
        v-model="user.firstName"
        required
        class="text-box"
      />
      <input
        type="text"
        placeholder="Last Name"
        value=""
        id = "last-name"
        ref="LName"
        v-model="user.lastName"
        required
        class="text-box"
      />
      <input
        type="email"
        placeholder="UserName@mozark.com"
        value=""
        ref="emailRef"
        id = "user-name"
        v-model="user.userName"
        required
        class="text-box"
      />
      <input
        type="password"
        placeholder="Password"
        value=""
        id="first-password"
        ref="passwordRef"
        v-model="user.password"
        required
        class="text-box"
      />
      <input
        type="password"
        placeholder="Confirm Password"
        value=""
        id="confirm-password"
        v-model="confirmPassword"
        required
        class="text-box"
      />
      <input
        type="text"
        placeholder="Phone Number"
        value=""
        id="phone-number"
        v-model="user.phone"
        required
        class="text-box"
      />
      <input
        type="text"
        placeholder="Address"
        value=""
        id="Address"
        v-model="user.Address"
        required
        class="text-box"
      />
      <input type="button" value="Sign up" id="submit" @click="SignUp" />
    </form>
    <h2>
      Already have an account?
      <a id ="SignInOption" style="color:red; text-decoration: underline;" @click.prevent="SignIn">Sign in</a>
    </h2>
  </div>
</template>

<script>
export default {
  name: "SignUp",
  data() {
    return {
      confirmPassword:'',
      user: {
          firstName:'',
          lastName:'',
          userName:'',
          password:'',
          phone:'',
          Address:'',
      },
    };
  },
  methods: {
      parseText: function (resp) {
          return resp.text();
      },
      checkStatus: function (resp) {
        console.log(resp);
          if (resp.status >= 200 && resp.status < 300) {
              console.log('good status');
              return resp;
          }
          console.log('bad status');
          return this.parseJSON(resp).then((resp) => {
            throw resp;
          });
      },
      CheckFullName(){
        let first_name = this.user.firstName;
        let last_name = this.user.lastName;
        return /^[a-zA-Z]+$/.test(first_name) && /^[a-zA-Z]+$/.test(last_name);
      },
      async CheckUserName(){
        try{
          const response = await fetch("http://localhost:8080/checkUsername/" + this.user.userName,{ 
              method: "get",
              headers: {'Content-Type': 'application/json'}
          }).then(this.checkStatus)
          .then(this.parseText);
          console.log("response of check userName: " + response);
          return response;
        }catch(error){
          return false;
        }
        
        
      },
      CheckPassword(){
        return this.user.password === this.confirmPassword;
    },
    CheckPhone(){
        return /^\d+$/.test(this.user.phone);
    },
    async SignUp(){
        if(this.CheckFullName() && await this.CheckUserName() && this.CheckPassword() && this.CheckPhone()){
          console.log("sending sign up request");
            const response = await fetch("http://localhost:8080/signup", {
                method: "post",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(this.user),
            }).then(this.parseText)

            if(response){
              alert("Signed up seccessfully");
              this.$router.push({ name: "SignIn" });
            }else{
              alert("Failed to SignUp");
            }
        }else{
            if(!this.CheckFullName()){
                alert("Invalid First Name or Last Name");
            }else if(!this.CheckPassword()){
                alert("Please, Enter a Valid Password with a length of 8");
            }else if(!this.CheckPhone()){
                alert("Please, Enter a Valid Phone Number");
            }
        }
    },
    SignIn(){
        this.$router.push({ name: "SignIn" });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#container {
    background-image: linear-gradient(180deg, rgb(247, 235, 72), rgb(63, 243, 78));
    height: 110%;
    background-size: cover;
    width: 100%;
    border: 1px solid rgb(250, 239, 84);
    position: absolute;
}
#title {
  min-width: 25vw;
  border-bottom: 0.7vw solid #ff5b5b;
  border-radius: 50px;
  padding-bottom: 15px;
  padding-left: 3.6vw;
  display: inline-block;
  font-size: 5vw;
  color: rgb(71, 103, 248);
  margin-left: 33%;
  margin-top: 10px;
  margin-bottom: 1vw;
  font-family: "Yanone Kaffeesatz", cursive;
  text-shadow: 0px 0px 0 rgb(236, 180, 180), 1px 0px 0 rgb(236, 180, 180),
    2px 0px 0 rgb(252, 129, 129), 3px 0px 0 rgb(187, 187, 187),
    4px 0px 0 rgb(255, 184, 184), 5px 0px 0 rgb(236, 180, 180),
    6px 0px 0 rgb(250, 171, 171), 7px 0px 6px rgba(0, 0, 0, 0.6),
    7px 0px 1px rgba(0, 0, 0, 0.5), 0px 0px 6px rgba(0, 0, 0, 0.2);
  z-index: 11;
  top: 0;
  cursor: pointer;
}
.text-box {
  padding: 0.5vw;
  width: 23vw;
  display: flex;
  height: 1.5vw;
  font-size: 2vw;
  margin: 2vw;
  margin-left: 36%;
  border-radius: 30px;
}
#submit {
  background-color: rgb(255, 0, 234);
  width: 8vw;
  height: 3vw;
  border-radius: 20px;
  font-size: 1.7vw;
  margin-left: 44%;
  cursor: pointer;
}
h2 {
  font-size: 1.5vw;
  margin-left: 36%;
}
#SignInOption {
  cursor: pointer;
}
</style>
