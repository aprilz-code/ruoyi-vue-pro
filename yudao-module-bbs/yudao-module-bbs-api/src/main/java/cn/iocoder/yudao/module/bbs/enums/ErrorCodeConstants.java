package cn.iocoder.yudao.module.bbs.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * bbs 错误码枚举类
 * <p>
 * bbs系统，使用  1-011-000-000 ~ 1-012-000-000 段
 */
public interface ErrorCodeConstants {

    ErrorCode TAG_NOT_EXISTS = new ErrorCode(1011000001, "标签不存在");


    ErrorCode CLASSIFY_NOT_EXISTS = new ErrorCode(1011000011, "分类不存在");


    ErrorCode ARTICLE_NOT_EXISTS = new ErrorCode(1011000021, "文章不存在");


    ErrorCode MI_CARD_NOT_EXISTS = new ErrorCode(1011000031, "米卡密不存在");

    ErrorCode MI_DO_ERROR = new ErrorCode(1011000032, "当前账号：{}，打卡失败，请检查账号密码是否正确");

    ErrorCode MI_JOB_NOT_EXISTS = new ErrorCode(1011000041, "米job不存在");

    ErrorCode MI_LOG_NOT_EXISTS = new ErrorCode(1011000051, "米日志不存在");

}
