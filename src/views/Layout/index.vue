<script setup>
import LayoutNav from './components/LayoutNav.vue'
import LayoutHeader from './components/LayoutHeader.vue'
import LayoutFooter from './components/LayoutFooter.vue'
import LayoutFixed from './components/LayoutFixed.vue';
import { usecategoryStore } from '@/stores/category';
import { onMounted } from 'vue';
const categoryStore = usecategoryStore();
onMounted(() => categoryStore.getCategory())
</script>

<template>
    <LayoutFixed />
    <LayoutNav />
    <LayoutHeader />
    <RouterView />
    <LayoutFooter />
    <div class="test">测试</div>
</template>
<style>
.test {
    color: red;
    height: 1500px;
    background-color: blue;
}
</style>