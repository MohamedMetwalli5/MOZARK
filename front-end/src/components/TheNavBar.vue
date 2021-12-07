<template>
  <div id="the-nav-bar-container">
    <h1 id="title" onclick="window.location.href='/Home';">MOZARK</h1>
    <ul class="horizontal">
    <li><a class="category-option" onclick="window.location.href='/Clothing';">Clothing </a></li>
    <li><a class="category-option" onclick="window.location.href='/Electronics';">Electronics</a></li>
    <li><a class="category-option" onclick="window.location.href='/Shoes';">Shoes</a></li>
    <li><a class="category-option" onclick="window.location.href='/Watches';">Watches</a></li>
    <li><a class="category-option" onclick="window.location.href='/Jewellery';">Jewellery</a></li>
    <li><a class="category-option" onclick="window.location.href='/Sports';">Sports</a></li> 
    <li id = "search-area"><input
        type="text"
        placeholder="Search"
        value=""
        ref="searchRef"
        id = "search-box"
        v-model="text"
      />
      <!-- <input id="search"
       type="button"
       value="Search"> -->
       </li> 
       <li><a class="category-option" id="setting-option"  @click="SettingsNavigator()">⚙️</a></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "TheNavBar",
  props: {
    IsAdmin: Boolean,
  },
  data() {
    return {
    };
  },
  methods: {
    SettingsNavigator(){
      if(this.IsAdmin === true){
        window.location.href='/AdminSettings';
      }else{
        window.location.href='/Settings';
      }
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

#settings-container {
    background-color: rgb(250, 239, 84);
    height: 100%;
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
ul.horizontal {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: rgb(0, 54, 136)
}
li {
    position: relative;
    display: inline-block;
    text-align: -webkit-match-parent;
    cursor: pointer;
}
ul.horizontal li a.category-option:hover{
    background-color: #04AA6D;
}
#setting-option:hover{
    background-color: #a939eb;
    cursor: pointer;
}
ul.horizontal li a {
    display: inline-block;
    color: white;
    text-align: center;
    font-size: 2vmax;
    padding: 14px 11px;
    text-decoration: none;
}

#search-box{
    padding: 1vw;
    width: 20vw;
    display: flex;
    height: 2vw;
    font-size: 2vw;
    margin: 2vw;
    margin-left: 10px;
    border-radius: 25px;
}
</style>
