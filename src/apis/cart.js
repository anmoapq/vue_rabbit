//封装购物车相关的api接口
import request from '@/utils/http';
export const insertCartAPI = ({ skuId, count }) => {
    return request({
        url: '/member/cart',
        method: 'post',
        data: {
            skuId,
            count
        }
    })
}

// 获取购物车列表
export const findNewCartListAPI = () => {
    return request({
        url: '/member/cart'
    })
}