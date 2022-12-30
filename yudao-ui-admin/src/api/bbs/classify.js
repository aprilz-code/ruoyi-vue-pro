import request from '@/utils/request'

// 创建分类
export function createClassify(data) {
  return request({
    url: '/bbs/classify/create',
    method: 'post',
    data: data
  })
}

// 更新分类
export function updateClassify(data) {
  return request({
    url: '/bbs/classify/update',
    method: 'put',
    data: data
  })
}

// 置顶分类
export function topClassify(id) {
  return request({
    url: '/bbs/classify/topClassify?id=' + id,
    method: 'put'
  })
}

// 删除分类
export function deleteClassify(id) {
  return request({
    url: '/bbs/classify/delete?id=' + id,
    method: 'delete'
  })
}

// 获得分类
export function getClassify(id) {
  return request({
    url: '/bbs/classify/get?id=' + id,
    method: 'get'
  })
}

// 获得分类分页
export function getClassifyPage(query) {
  return request({
    url: '/bbs/classify/page',
    method: 'get',
    params: query
  })
}

// 导出分类 Excel
export function exportClassifyExcel(query) {
  return request({
    url: '/bbs/classify/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
