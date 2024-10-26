// 购物车模块
import { defineStore } from "pinia";
import { ref } from "vue";
import { computed } from "vue";
export const useCartStore = defineStore('cart', () => {
    // 定义state - cartList
    const cartList = ref([])

    // 定义action - addCart
    const addCart = (goods) => {
        // 添加购物车操作
        // 已添加过 - count + 1
        // 没有添加过 - 直接push
        // 思路：通过匹配传递过来的商品对象中的skuId能不能在cartList中找到，找到了就是添加过
        const item = cartList.value.find((item) => goods.skuId === item.skuId)
        if (item) {
            // 找到了
            item.count++
        } else {
            // 没找到
            cartList.value.push(goods)
        }
    }

    //删除购物车
    const delCart = (skuId) => {
        const idx = cartList.value.findIndex((item) => item.skuId === skuId)
        cartList.value.splice(idx, 1)
    }

    //购物车计算
    //总数量
    const allCount = computed(() => cartList.value.reduce((acc, cur) => acc + cur.count, 0))
    //总价
    const allPrice = computed(() => cartList.value.reduce((acc, cur) => acc + cur.price * cur.count, 0))
    return {
        cartList,
        addCart,
        delCart,
        allCount,
        allPrice
    }
}, {
    persist: true,
})