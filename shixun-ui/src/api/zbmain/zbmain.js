import request from '@/utils/request'

// 查询主要焊缝施焊记录主表列表
export function listZbmain(query) {
  return request({
    url: '/zbmain/zbmain/list',
    method: 'get',
    params: query
  })
}

// 查询主要焊缝施焊记录主表详细
export function getZbmain(id) {
  return request({
    url: '/zbmain/zbmain/' + id,
    method: 'get'
  })
}

// 新增主要焊缝施焊记录主表
export function addZbmain(data) {
  return request({
    url: '/zbmain/zbmain',
    method: 'post',
    data: data
  })
}

// 修改主要焊缝施焊记录主表
export function updateZbmain(data) {
  return request({
    url: '/zbmain/zbmain',
    method: 'put',
    data: data
  })
}

// 删除主要焊缝施焊记录主表
export function delZbmain(id) {
  return request({
    url: '/zbmain/zbmain/' + id,
    method: 'delete'
  })
}

export function exportEasyExcel(id) {
  return request({
    url: '/zbmain/zbmain/',
    method: 'get',
    params: {id: id}
  })
}
