import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/product_category/list',
    method: 'get',
    params
  })
}

export function getCategoryOptions() {
  return request({
    url: '/product_category/options',
    method: 'get'
  })
}

export function getOptionsWithChildren() {
  return request({
    url: '/product_category/options_children',
    method: 'get'
  })
}

export function createCategory(data) {
  return request({
    url: '/product_category',
    method: 'put',
    data: data
  })
}

export function updateCategory(id, data) {
  return request({
    url: '/product_category/' + id,
    method: 'post',
    data: data
  })
}

export function deleteCategory(id) {
  return request({
    url: '/product_category' + id,
    method: 'delete'
  })
}
