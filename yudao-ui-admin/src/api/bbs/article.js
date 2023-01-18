import request from '@/utils/request'

// 创建文章
export function createArticle(data) {
  return request({
    url: '/bbs/article/create',
    method: 'post',
    data: data
  })
}

// 更新文章
export function updateArticle(data) {
  return request({
    url: '/bbs/article/update',
    method: 'put',
    data: data
  })
}

// 删除文章
export function deleteArticle(id) {
  return request({
    url: '/bbs/article/delete?id=' + id,
    method: 'delete'
  })
}

// 获得文章
export function getArticle(id) {
  return request({
    url: '/bbs/article/get?id=' + id,
    method: 'get'
  })
}

// 获得文章分页
export function getArticlePage(query) {
  return request({
    url: '/bbs/article/page',
    method: 'get',
    params: query
  })
}

// 导出文章 Excel
export function exportArticleExcel(query) {
  return request({
    url: '/bbs/article/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
