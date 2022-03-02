<template>
    <div class="card">
        <h3>{{ product.name }}</h3>

        <h5 class="price">price : LE {{ product.price.toFixed(2) }}</h5>
            <span class="db">
              <div class="flex flex-row items-center justify-end">
                <button class="bg-none white f4 pointer grow dim ph2" :disabled="product.quantity == 1" @click="() => updateQuantity(product.quantity - 1)">-</button>
                <span class="ttl">{{(product.quantity)?product.quantity:this.$props.product.quantity=1}}</span>
                <button class="bg-none white f5 pointer grow dim ph2" @click="() => updateQuantity(product.quantity + 1)">+</button>
              </div>
            </span>
        <button class="add-product-button" @click="$emit('add-product',product)">Add to Cart</button>
    </div>
</template>

<script>

export default{
    props :['product'],
    methods:{
        updateQuantity(quantity){
            this.$props.product.quantity = (quantity)?quantity:2
        }
    }

}
</script>
<style scoped>
.card{
    width:80%;
    margin: 1%;
    padding: 10px;
    border-radius: 5px;
    background: white;
    box-shadow: 0 0 5px gray;
}
h5.price{
    color: gray;
}
button.add-product-button{
    padding: 10px;
    background-color:green ;
    border: none;
    color: white;
    font-weight: bold;
    font-size: 1.15rem;
    border-radius: 5px ;
    cursor: pointer;
}
</style>