<template>
    <div class="card">
        <h3>{{ product.item.name }}</h3>

        <h5 class="price">price : LE {{ product.item.price.toFixed(2) }}</h5>
        <h5 class="price">quantity :{{ product.quantity }}</h5>
        <h5 class="price">total price : LE {{ product.price.toFixed(2) }}</h5>

    </div>
</template>

<script>

export default{
    props :['product']

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