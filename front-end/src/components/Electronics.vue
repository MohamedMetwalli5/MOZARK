<template>
  <div id="Electronics-container">
    <TheNavBar />
  </div>
</template>

<script>
import TheNavBar from './TheNavBar.vue';
export default {
  components:{"TheNavBar" : TheNavBar},
  name: "Electronics",
  props: {
    msg: String,
  },
  data() {
    return {
    };
  },
  methods: {
  },
};
</script>

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
.setting-option{
  border: 2px solid;
}

</style>
