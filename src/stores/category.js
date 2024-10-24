import { ref } from 'vue'
import { defineStore } from 'pinia'
import { getCategoryAPI } from '@/apis/layout';
export const usecategoryStore = defineStore('category', () => {
    //导航列表逻辑
    //导航列表数据state
    const categoryList = ref([]);
    //导航列表数据get方法
    const getCategory = async () => {
        const res = await getCategoryAPI();
        categoryList.value = res.result;
    }

    return {
        categoryList,
        getCategory
    }
})
