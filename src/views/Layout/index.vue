<script setup>
import LayoutNav from './components/LayoutNav.vue'
import LayoutHeader from './components/LayoutHeader.vue'
import LayoutFooter from './components/LayoutFooter.vue'
import LayoutFixed from './components/LayoutFixed.vue';
import { usecategoryStore } from '@/stores/categoryStore';
import { onMounted } from 'vue';
const categoryStore = usecategoryStore();
onMounted(() => categoryStore.getCategory())
</script>

<template>
    <LayoutFixed />
    <LayoutNav />
    <LayoutHeader />
    <!-- 添加key破坏复用机制，强制销毁重建 -->
    <!-- <RouterView :key="$route.fullPath" /> -->
    <RouterView />
    <LayoutFooter />
</template>
<style></style>