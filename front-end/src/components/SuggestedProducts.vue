<template>
    <div id="products-container">
        <div class="product">hello1</div>
        <div class="product">hello2</div>
        <div class="product">hello3</div>
        <div class="product">hello4</div>
  </div>
</template>

<script>
export default {
    methods: {
        
    },
}
</script>


<style>

#products-container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(0, min(100%/1, max(64px, 100%/2))));
    width: 100%;
    height: 100%;
    margin-top: 30px;
    margin-right: 0px;
}

.product {
    width: 80%;
    height: 500px;
    outline: 2px solid;
    border-radius: 20px;
    margin-right: 15px;
    margin-left: 10px;
    margin-bottom: 30px;
    text-align: center;
    padding: 20px;
    font-size: 30px;
}
</style>