import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/scenic/list',
    method: 'get',
    params
  })
}

export function createScenic(data) {
  return request({
    url: '/scenic',
    method: 'put',
    data: data
  })
}
export function getScenic(id) {
  return request({
    url: '/scenic/' + id,
    method: 'get'
  })
}
export function updateScenic(id, data) {
  return request({
    url: '/scenic/' + id,
    method: 'post',
    data: data
  })
}
