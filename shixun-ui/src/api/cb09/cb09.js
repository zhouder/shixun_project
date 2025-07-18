import request from '@/utils/request'

// 查询硬化后水泥混凝土性能试验检测报告列表
export function listCb09(query) {
  return request({
    url: '/cb09/cb09/list',
    method: 'get',
    params: query
  })
}

// 查询硬化后水泥混凝土性能试验检测报告详细
export function getCb09(id) {
  return request({
    url: '/cb09/cb09/' + id,
    method: 'get'
  })
}

// 新增硬化后水泥混凝土性能试验检测报告
export function addCb09(data) {
  return request({
    url: '/cb09/cb09',
    method: 'post',
    data: data
  })
}

// 修改硬化后水泥混凝土性能试验检测报告
export function updateCb09(data) {
  return request({
    url: '/cb09/cb09',
    method: 'put',
    data: data
  })
}

// 删除硬化后水泥混凝土性能试验检测报告
export function delCb09(id) {
  return request({
    url: '/cb09/cb09/' + id,
    method: 'delete'
  })
}
