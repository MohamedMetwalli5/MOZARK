<template>
  <div id="container">
    <h1 id="title" onclick="window.location.href='/';">MOZARK</h1>
    <form id="signin-form">

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
        id="password"
        ref="passwordRef"
        v-model="password"
        required
        class="text-box"
      />
      <input type="button" value="Sign In" id="submit" @click.prevent="SignIn" />
    </form>
  </div>
</template>

<script>
export default {
  name: "SignIn",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    parseJSON: function (resp) {
        return resp.JSON();
    },
    checkStatus: function (resp) {
        console.log('status');
        if (resp.status >= 200 && resp.status < 300) {
            console.log('good status');
            return resp;
        }
        console.log('bad status');
        return this.parseJSON(resp).then((resp) => {
            throw resp;
        });
    },
    async login(){
        try {
          console.log(this.email);
          console.log(this.password);
          const response = await fetch( "http://localhost:8080/signin/" , {
              method: "post",
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify({
                userName: this.email,
                password: this.password
              })
          }).then(this.checkStatus)
          .then(this.parseJSON);

          console.log(response.sessionID + "    " + response.role);

          this.$store.commit('saveUserData',{
              _id: response.sessionID,
              _name: this.form.userName
          });
          console.log("user name that stored in the Vuex" + this.$store.state.userID);
          return true;
        } catch (error) {
            return false;
        } 
      },
    async SignIn(){
      const valid = await this.login();
      if (valid) {
          this.$router.push({ name: "AdminSettings" });
      } else {
          alert("Please try agian, email or password is wrong :(");
      }
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#container {
    background-image: linear-gradient(180deg, rgb(247, 235, 72), rgb(63, 243, 78));
    height: 100%;
    background-size: cover;
    width: 100%;
    border: 1px solid rgb(250, 239, 84);
    position: absolute;
}
#title {
  min-width: 30vw;
  border-bottom: 10px solid #ff5b5b;
  border-radius: 50px;
  padding-bottom: 15px;
  display: inline-block;
  font-size: 7vw;
  color: rgb(71, 103, 248);
  margin-left: 33%;
  margin-top: 1%;
  margin-bottom: 2vw;
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
  height: 3vw;
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
  font-size: 2vw;
  margin-left: 44%;
  cursor: pointer;
}
h2 {
  font-size: 1.5vw;
  margin-left: 36%;
}
</style>
