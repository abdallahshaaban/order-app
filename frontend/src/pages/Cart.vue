<template>
<TheNavBar />

  <div>
      <h1>Your Cart</h1>
      <h5 class="price">total price : LE {{ totalCartPrice }}</h5>

        <CartItemCard
        v-for="item in itemData"
        :key = "item.id"
        :product="item"
        />
  </div>
</template>
<script>

import TheNavBar from '../components/TheNavBar.vue'
import http from '../services/http'
import CartItemCard from '../components/CartItemCard.vue';

export default {
  name: "Cart-page",
    components: { TheNavBar,CartItemCard},

  data() {
    return {
        itemData:[],
        totalCartPrice:0.0,


    };
  },
  mounted(){
      var self = this;
       http.get("api/order/list",).then(function (res){
                console.log("success",res)
                if(res.data.length>0){
                 self.itemData = res.data[0].orderItems
                 self.totalCartPrice = res.data[0].total_price.toFixed(2);
                }
             

                }) .catch(error => {
                 console.error('There was an error!', error);
                });
            
  }
};
</script>
