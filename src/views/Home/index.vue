<script setup>
import HomeCategory from './components/HomeCategory.vue'
import HomeBanner from './components/HomeBanner.vue'
import HomeNew from './components/HomeNew.vue'
import HomeHot from './components/HomeHot.vue'
import homeProduct from './components/HomeProduct.vue'
import Homepanel from './components/Homepanel.vue'

</script>

<template>
    <div class="container">
        <HomeCategory />
        <HomeBanner />
    </div>
    <HomeNew />
    <HomeHot />
    <homeProduct />
    <!-- 测试面板组件 -->
    <Homepanel title="新鲜好物" sub-title="新鲜好物好多商品">
        <div>我是信息好物插槽</div>
    </Homepanel>
    <Homepanel title="人气推荐" sub-title="人气推荐好多商品">
        <div>我是信息好物插槽</div>
    </Homepanel>
</template>