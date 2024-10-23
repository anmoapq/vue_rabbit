<script setup>
import { RouterView } from 'vue-router';


</script>

<template>
  <!-- 一级路由出口 -->
  <div class="test">
    test scss
  </div>
  <RouterView />
</template>

<style scoped lang="scss">
.test {
  color: $priceColor;
}
</style>
