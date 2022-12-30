package cn.iocoder.yudao.module.bbs.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * bbs 错误码枚举类
 *
 * bbs系统，使用  1-011-000-000 ~ 1-012-000-000 段
 */
public interface ErrorCodeConstants {

    ErrorCode TAG_NOT_EXISTS = new ErrorCode(1011000001, "标签不存在");



    ErrorCode CLASSIFY_NOT_EXISTS = new ErrorCode(1011000011 , "分类不存在");

}
