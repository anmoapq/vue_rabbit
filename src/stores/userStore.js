import { defineStore } from 'pinia'
import { ref } from 'vue'
import { loginAPI } from '@/apis/user'
import { useCartStore } from './cartStore'



export const useUserStore = defineStore('user', () => {
    const cartStore = useCartStore()
    // 定义用户数据的state
    const userInfo = ref({})
    //定义获取接口数据的action函数
    const getUserInfo = async ({ account, password }) => {
        const res = await loginAPI({ account, password })
        userInfo.value = res.result
    }
    //返回state和action函数

    //退出清除用户信息
    const clearUserInfo = () => {
        userInfo.value = {}
        //退出时清除购物车
        cartStore.clearCart()
    }
    return {
        userInfo,
        getUserInfo,
        clearUserInfo
    }
},
    {
        persist: true,
    }
)