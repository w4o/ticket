import request from '@/utils/request'

export function createStorage(data) {
  return request({
    url: '/storage/create',
    method: 'put',
    data
  })
}

const uploadPath = process.env.VUE_APP_BASE_API + '/storage/create'
export { uploadPath }
