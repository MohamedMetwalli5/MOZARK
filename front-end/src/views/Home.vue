<template>
  <div id="container">
    <TheNavBar />
    <SuggestedProducts/>
    <Footer/>
  </div>
</template>

<script>
import SuggestedProducts from '../components/SuggestedProducts.vue';
import TheNavBar from '../components/TheNavBar.vue';
import Footer from '../components/Footer.vue';

export default {
  components: { 
    "TheNavBar": TheNavBar, 
    "SuggestedProducts": SuggestedProducts,
    "Footer" : Footer,
  },
  name: "Home",
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
     
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

#container {
    background-image: linear-gradient(180deg, rgb(247, 235, 72), rgb(63, 243, 78));
    width: 100%;
    border: 1px solid rgb(250, 239, 84);
    position: absolute;
    background-size: 100%;
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
    background-color: #333;
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
