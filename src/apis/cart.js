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

//删除购物车列表

export const delCartAPI = (ids) => {
    return request({
        url: '/member/cart',
        method: 'DELETE',
        data: {
            ids
        }
    })
}

//合并本地和接口购物车

export const mergeCartAPI = (data) => {
    return request({
        url: '/member/cart/merge',
        method: 'POST',
        data

    })
}