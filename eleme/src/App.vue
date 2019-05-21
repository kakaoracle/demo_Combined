<template>
  <div id="app">
    <v-header></v-header>
    <!-- <div class="header"> //header被自定义的v-header取代

    </div> -->
    <div class="tab">
      <div class="tab-item">
        <router-link to="/goods">商品</router-link>
      </div>
      <div class="tab-item">
        <!-- <a v-link to="path:'/ratings'">评论</a> -->
        <router-link to="/ratings">评论</router-link>
      </div>
      <div class="tab-item">
        <router-link to="path:'/ratings'">商家</router-link>
      </div>
    </div>
    <div class="content">
      i am content
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
import header from "./components/header/header.vue";
  export default{
    components:{
      'v-header':header //一般自定义的标签名都是v-开头
    }
  };
</script>

<style lang="stylus" rel="stylesheet/stylus">
  #app
    .tab
     display:flex
     width:100%
     height : 45px
     line-height :40px
     .tab-item
      flex:1
      text-align:center
</style>
