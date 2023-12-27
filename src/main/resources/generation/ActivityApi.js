import request from '@/utils/request'

/**
* 根据 ID 查询
*/
export function getById(params) {
  return request({
    url: `${BASIC_PATH}/activity/getById`,
    method: 'get',
    params: params
  })
}

/**
* 插入一条记录
*/
export function save(params) {
  return request({
    url: '${BASIC_PATH}/activity/save',
    method: 'get',
    params: params
  })
}

/**
* 根据 ID 选择修改
*/
export function updateById(params) {
  return request({
    url: '${BASIC_PATH}/activity/updateById',
    method: 'get',
    params: params
  })
}

/**
* 根据 ID 删除
*/
export function removeById(params) {
  return request({
    url: '${BASIC_PATH}/activity/removeById',
    method: 'get',
    params: params
  })
}
