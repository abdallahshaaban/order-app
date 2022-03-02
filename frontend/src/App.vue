<template>
<!-- <TheNavBar /> -->

<div class="container">
  <div class="row">
    <div class="col-md-12">
      <div>
        <router-view> </router-view>
      </div>
    </div>
  </div>
  <FlashMessage position="left top" time="1000" />

</div>

</template>

<script>
export default {
  name: 'App',
  components: {
  },
  mounted(){
  }
}
</script>

<style>

</style>
