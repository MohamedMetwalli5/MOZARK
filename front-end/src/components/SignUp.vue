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
        v-model="text"
        required
        class="text-box"
      />
      <input
        type="text"
        placeholder="Last Name"
        value=""
        id = "last-name"
        ref="LName"
        v-model="text"
        required
        class="text-box"
      />
      <input
        type="email"
        placeholder="UserName@mozark.com"
        value=""
        ref="emailRef"
        id = "user-name"
        v-model="email"
        required
        class="text-box"
      />
      <input
        type="password"
        placeholder="Password"
        value=""
        id="first-password"
        ref="passwordRef"
        v-model="password"
        required
        class="text-box"
      />
      <input
        type="password"
        placeholder="Confirm Password"
        value=""
        id="confirm-password"
        required
        class="text-box"
      />
      <input
        type="text"
        placeholder="Phone Number"
        value=""
        id="phone-number"
        required
        class="text-box"
      />
      <input type="button" value="Sign up" id="submit" @click="SignUp()" />
    </form>
    <h2>
      Already have an account?
      <a id ="SignInOption" style="color:red; text-decoration: underline;" onclick="window.location.href='/SignIn';">Sign in</a>
    </h2>
  </div>
</template>

<script>
export default {
  name: "SignUp",
  props: {
    msg: String,
  },
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
      CheckFullName(){
        let first_name = document.getElementById("first-name").value;
        let last_name = document.getElementById("last-name").value;
        return /^[a-zA-Z]+$/.test(first_name) && /^[a-zA-Z]+$/.test(last_name);
      },
      CheckUserName(){
        // let user_name = document.getElementById("user-name").value; // it should be sent to the database
        let response = true;
        //// to-do 
        /// we should a request to the database to check whether this use name already exists or not, and we must return the response (true or fasle)
        ////

        return response;
      },
      CheckPassword(){
        let first_password = document.getElementById("first-password").value;
        let confirmation_password = document.getElementById("confirm-password").value;
        if(first_password !== confirmation_password || first_password.length < 8){
            return false;
        }
        return true;
    },
    CheckPhone(){
        return /^\d+$/.test(document.getElementById("phone-number").value);
    },
    SignUp(){
        if(this.CheckFullName() && this.CheckUserName() && this.CheckPassword() && this.CheckPhone()){
            alert("Success");
            //// to-do
            // send a request to the database to save the user information and rout to the main page for shopping
            ///
            ////
        }else{
            if(!this.CheckFullName()){
                alert("Invalid First Name or Last Name");
            }else if(!this.CheckUserName()){
                alert("User Name already exists");
            }else if(!this.CheckUserName()){
                alert("Please, Enter a Valid Password with a length of 8");
            }else if(!this.CheckPhone()){
                alert("Please, Enter a Valid Phone Number");
            }
        }
    },
    SignIn(){
        window.location.href='/SignIn';
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#container {
    background-image: linear-gradient(45deg, rgb(247, 235, 72), rgb(63, 243, 78));
    height: 100%;
    width: 100%;
    background-size: cover;
    border: 1px solid rgb(250, 239, 84);
    /* position: absolute; */
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
  height: 2vw;
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
