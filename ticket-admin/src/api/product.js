import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/product/list',
    method: 'get',
    params
  })
}

export function createProduct() {}
export function getProduct(id) {
  return request({
    url: '/product/' + id,
    method: 'get'
  })
}
export function updateProduct() {}
