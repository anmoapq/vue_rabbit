import httpInstance from "@/utils/http"

export function getBannerAPI(params = {}) {
    //首页轮播图params参数为1，商品页为2
    const { distributionSite = '1' } = params
    return httpInstance(
        {
            url: '/home/banner',
            params: {
                distributionSite
            }
        }
    );
}

/**
 * @description: 获取新鲜好物
 * @param {*}
 * @return {*}
 */
export const findNewAPI = () => {
    return httpInstance({
        url: '/home/new'
    })
}

/**
 * @description: 获取人气推荐
 * @param {*}
 * @return {*}
 */
export const findHotAPI = () => {
    return httpInstance({
        url: '/home/hot'
    })
}

/**
 * @description: 获取全部商品
 * @param {*}
 * @return {*}
 */
export const getGoodsAPI = () => {
    return httpInstance({
        url: '/home/goods'
    })
}
