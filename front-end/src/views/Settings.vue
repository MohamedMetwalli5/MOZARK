<template>
  <div id="settings-container">
    <TheNavBar />
    <div class="setting-option">
      <h2>Upload a Profile Picture</h2>
      <form id="form" action="/action_page.php">
        <input type="file" id="ProfilePicture" name="filename">
        <input type="submit" class="save-button" style="background-color: orange">
      </form>
    </div>
    <div class="setting-option">
      <h2>Change Password</h2>
      <input
          type="password"
          placeholder="Old Password"
          value=""
          ref="PasswordRef"
          id = "user-old-password"
          v-model="password"
          class="text-box"
        />  
        <input
          type="password"
          placeholder="New Password"
          value=""
          ref="PasswordRef"
          id = "user-new-password"
          v-model="password"
          class="text-box"
        />  
        <input
          type="button"
          value="Save"
          class="save-button"
          id = "password-save"
          @click="Save('password-save')"
        />  
    </div>
    <div class="setting-option">
      <h2>Add Address</h2>
      <input
          type="text"
          placeholder="New Address"
          value=""
          ref="AddressRef"
          id = "user-address"
          v-model="text"
          class="text-box"
        />  
        <input
          type="button"
          value="Save"
          class="save-button"
          id = "address-save"
          @click="Save('address-save')"
        />  
    </div>
    <div class="setting-option">
      <h2>Change Phone Number</h2>
        <input
              type="text"
              placeholder="New Phone Number"
              value=""
              ref="PhoneNumberRef"
              id = "user-phone-number"
              v-model="text"
              class="text-box"
        />  
        <input
          type="button"
          value="Save"
          class="save-button"
          id = "phone-number-save"
          @click="Save('phone-number-save')"
        />  
    </div>
    <Footer/>
  </div>
</template>

<script>
import TheNavBar from '../components/TheNavBar.vue';
import Footer from '../components/Footer.vue';

export default {
  components:{
    "TheNavBar" : TheNavBar,
    "Footer" : Footer,
  },
  name: "Settings",
  props: {
    msg: String,
  },
  data() {
    return {
    };
  },
  methods: {
    CheckPassword(){
        let old_password = document.getElementById("user-old-password").value;
        let new_password = document.getElementById("user-new-password").value;
        if(old_password !== new_password && new_password.length >= 8){
           // to-do
           //// we must send a check the datebase to check if the old password is correct 
           // if the response is true -> then we must change the new password with the new one 
           alert("Saved Successfully!");
        }else{
          alert("Please, Enter a New Valid Password");
        }
    },
    CheckPhoneNumber(){
       return /^\d+$/.test(document.getElementById("user-phone-number").value);
    },
    Save(id){
      if(id === "password-save"){
        this.CheckPassword();
      }else if(id === "address-save"){
        if(document.getElementById("user-address").value.length > 6){
          // to-do we must save the new address in the datebase
          alert("Saved Successfully!");
        }else{
          alert("Please, Enter a Valid Address");
        }
        
      }else if(id === "phone-number-save"){
        let response = this.CheckPhoneNumber();
        if(response){
          // to-do we must save the new phone number in the datebase 
          alert("Saved Successfully!");
        }else{
          alert("Please, Enter a Valid Phone Number");
        }
      } 
    },
  },
};
</script>

<style scoped>
#settings-container {
    background-color: rgb(250, 239, 84);
    background-size: cover;
    width: 100%;
    border: 1px solid rgb(250, 239, 84);
    position: absolute;
}
#title {
  min-width: 10vw;
  border-bottom: 10px solid #ff5b5b;
  border-radius: 50px;
  padding-bottom: 15px;
  display: inline-block;
  font-size: 5vw;
  color: rgb(71, 103, 248);
  margin-left: 35%;
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
.setting-option{
  border: 2px solid;
}
h2{
 margin-left: 10px;
}
.text-box{
  border-radius: 20px;
  width: 350px;
  height: 30px;
  margin: 10px;
  padding: 5px;
  font-size: 20px;
}
.save-button{
  width: 80px;
  height: 50px;
  margin: 10px;
  margin-left: 30px;
  padding: 5px;
  font-size: 20px;
  border-radius: 30px;
  color: rgb(255, 255, 255);
  background: rgb(227, 70, 248);
  cursor: pointer;
}
#form{
  margin: 10px;
}
</style>
