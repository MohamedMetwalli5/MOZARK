<template>
  <div id="admin-settings-container">
    <TheNavBar />
    <div class="setting-option">
      <h1>Change Password</h1>
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
        <h1>Add Product</h1>
        <div class="dropdown">
            <button class="dropbtn">{{CategoryNameForAdding}}</button>
            <div class="dropdown-content">
                <a @click="SetCategory('Clothing','1')">Clothing</a>
                <a @click="SetCategory('Electronics','1')">Electronics</a>
                <a @click="SetCategory('Shoes','1')">Shoes</a>
                <a @click="SetCategory('Watches','1')">Watches</a>
                <a @click="SetCategory('Jewellery','1')">Jewellery</a>
                <a @click="SetCategory('Sports','1')">Sports</a>
            </div>
        </div>
        <input
          type="text"
          placeholder="Product Name"
          value=""
          ref="ProductRef"
          id = "product-name(add)"
          v-model="text"
          class="text-box"
        />
        <input
          type="text"
          placeholder="Product Price in $"
          value=""
          ref="ProductPriceRef"
          id = "product-price(add)"
          v-model="text"
          class="text-box"
          style="width : 170px"
        />
        <input
          type="text"
          placeholder="Quantity"
          value=""
          ref="QuantityRef"
          id = "quantity(add)"
          v-model="text"
          class="text-box"
          style="width : 100px"
        />
        <textarea type="text"  
            class="text-box" 
            v-model="text" 
            value=""
            ref="DescriptionRef"
            id = "description(add)"
            style="width : 400px; height:80px; padding:10px; margin-bottom:0px" 
            placeholder="Description">
        </textarea>
        <div style="margin-left:10px;">
            <form id="form" action="/action_page.php">
                <input type="file" class="product-picture" name="filename">
                <!-- <input type="submit" class="save-button" style="background-color: orange"> -->
            </form>
        </div>
        <input
          type="button"
          value="Add"
          class="save-button"
          id = "add-product-save"
          @click="Save('add-product-save')"
        />   
    </div>
    <div class="setting-option">
        <h1>Remove Product</h1>
        <div class="dropdown">
            <button class="dropbtn">{{CategoryNameForRemoving}}</button>
            <div class="dropdown-content">
                <a @click="SetCategory('Clothing','2')">Clothing</a>
                <a @click="SetCategory('Electronics','2')">Electronics</a>
                <a @click="SetCategory('Shoes','2')">Shoes</a>
                <a @click="SetCategory('Watches','2')">Watches</a>
                <a @click="SetCategory('Jewellery','2')">Jewellery</a>
                <a @click="SetCategory('Sports','2')">Sports</a>
            </div>
        </div>
        <input
          type="text"
          placeholder="Product Name"
          value=""
          ref="ProductRef"
          id = "product-name(remove)"
          v-model="text"
          class="text-box"
        />
        <input
          type="button"
          value="Remove"
          class="save-button"
          id = "add-product-save"
          @click="Save('remove-product-save')"
        />   
    </div>
    <div class="setting-option">
        <h1>Change Product</h1>
        <div class="dropdown">
            <button class="dropbtn">{{CategoryNameForChanging}}</button>
            <div class="dropdown-content">
                <a @click="SetCategory('Clothing','3')">Clothing</a>
                <a @click="SetCategory('Electronics','3')">Electronics</a>
                <a @click="SetCategory('Shoes','3')">Shoes</a>
                <a @click="SetCategory('Watches','3')">Watches</a>
                <a @click="SetCategory('Jewellery','3')">Jewellery</a>
                <a @click="SetCategory('Sports','3')">Sports</a>
            </div>
        </div>
        <input
          type="text"
          placeholder="New Product Name"
          value=""
          ref="ProductRef"
          id = "product-name(change)"
          v-model="text"
          class="text-box"
          style="width : 180px"
        />
        <input
          type="text"
          placeholder="New Product Price in $"
          value=""
          ref="ProductPriceRef"
          id = "product-price(change)"
          v-model="text"
          class="text-box"
          style="width : 210px"
        />
        <input
          type="text"
          placeholder="New Quantity"
          value=""
          ref="QuantityRef"
          id = "quantity(change)"
          v-model="text"
          class="text-box"
          style="width : 140px"
        />
        <textarea type="text"  
            class="text-box" 
            v-model="text" 
            value=""
            ref="DescriptionRef"
            id = "description(change)"
            style="width : 400px; height:80px; padding:10px; margin-bottom:0px" 
            placeholder="New Description">
        </textarea>
        <div style="margin-left:10px;">
            <form id="form" action="/action_page.php">
                <input type="file" class="product-picture" name="filename">
                <!-- <input type="submit" class="save-button" style="background-color: orange"> -->
            </form>
        </div>
        <input
          type="button"
          value="Change"
          class="save-button"
          id = "add-product-save"
          @click="Save('change-product-save')"
        />   
    </div>
    <Footer/>
  </div>
</template>

<script>
import Footer from './Footer.vue';
import TheNavBar from './TheNavBar.vue';
export default {
  components:{
    "TheNavBar" : TheNavBar, 
    "Footer":Footer,
  },
  name: "AdminSettings",
  props: {
    msg: String,
  },
  data() {
    return {
        CategoryNameForAdding : "Choose Category",
        CategoryNameForRemoving : "Choose Category",
        CategoryNameForChanging : "Choose Category",
    };
  },
  methods: {
    SetCategory(ChoosenCategoryName, OptionNumber){
        if(OptionNumber === '1'){
            this.CategoryNameForAdding = ChoosenCategoryName;
        }else if(OptionNumber === '2'){
            this.CategoryNameForRemoving = ChoosenCategoryName;
        }else if(OptionNumber === '3'){
            this.CategoryNameForChanging = ChoosenCategoryName;
        }
    },
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
    Save(id){
      if(id === "password-save"){
        this.CheckPassword();
      }else if(id === "add-product-save"){
        let product_name = document.getElementById("product-name(add)").value;
        let product_price = document.getElementById("product-price(add)").value;
        let product_quantity = document.getElementById("quantity(add)").value;
        let product_description = document.getElementById("description(add)").value;

        if(this.CategoryName !== "Choose Category" && product_name.length > 0 && product_price.length > 0 && product_quantity.length > 0 && product_description.length > 0){
            // to-do
            ///// add the new product details to the database and this is in case if there is no product have this name in the database in the chosen category
            ///
        }else{
            alert("Please, Enter Valid Information");
        } 
      }else if(id === "remove-product-save"){
        let product_name = document.getElementById("product-name(remove)").value;

        if(product_name.length > 0){
            // to-do
            ///// remove the new product details from the database and this is in case if there is a product has this name in the database in the chosen category
            ///
        }else{
            alert("Please, Enter an Existing Product Name");
        } 
      }else if(id === "change-product-save"){
        let product_name = document.getElementById("product-name(change)").value;
        let product_price = document.getElementById("product-price(change)").value;
        let product_quantity = document.getElementById("quantity(change)").value;
        let product_description = document.getElementById("description(change)").value;

        if(this.CategoryName !== "Choose Category" && product_name.length > 0 && (product_price.length > 0 || product_quantity.length > 0 || product_description.length > 0)){
            // to-do
            ///// change the product details to the database and this is in case if there is a product have this name in the database in the chosen category, else notify the admin using an alert and ask him to Enter Valid Information
            ///
        }else{
            alert("Please, Enter Valid Information");
        } 
      }
    },
  },
};
</script>

<style scoped>
#admin-settings-container {
    background-color: rgb(145, 250, 84);
    background-size: cover;
    width: 100%;
    border: 1px solid rgb(145, 250, 84);
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
  width: 340px;
  height: 30px;
  margin: 10px;
  padding: 5px;
  font-size: 20px;
}
.save-button{
  width: 93px;
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
/* /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// */

.dropbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
  margin: 20px;
  cursor: pointer;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #ffffff;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}

</style>
