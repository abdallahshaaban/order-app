<template>
<TheNavBar />

  <div class="home">
  <div class="product-cards-container">
      <ProductItems
      v-for="item in itemData"
      :key = "item.id"
      :product="item"
      v-on:add-product="addProduct($event)"
      />
  </div>
  </div>
</template>
<script>

// import items from '../mixins/items.js'
import ProductItems from '../components/ProductItems.vue';
import http from '../services/http'
import TheNavBar from '../components/TheNavBar.vue'

export default {
  name: "Home-page",
  components: { ProductItems ,TheNavBar},

//   mixins:[items],
  data() {
    return {
        itemData:[],
        product:null
    };
  },
  mounted() {
      console.log(this.itemData);
      let self = this;
       http.get("api/item/list",).then(function (res){
                console.log("success",res)
                self.itemData = res.data
                }) .catch(error => {
                 console.error('There was an error!', error);
                });
            
  },
  methods:{
      addProduct(product){
          this.product = product;
          console.log(this.product);
          let self = this;
             http.post("api/order/addToCart",{
                itemId:this.product.id,
                quantity:this.product.quantity
            }).then(function (res){
                self.$flashMessage.show({
                  type: 'success',
                  title: 'Item added successfully!',
                });
                console.log("success",res)

                }) .catch(error => {
                 console.error('There was an error!', error);
                });
            
      }
  }
};
</script>
<style scoped>
    .product-cards-container{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }
</style>