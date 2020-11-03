package com.zhishouwei.common.utils;

import java.io.Serializable;

/**
 * 封装常量对象
 *
 * @author EDZ
 */

public class Constants implements Serializable {

    /**
     * 状态：正常
     */
    public static final Integer SUCCESS_CODE = 200;

    /**
     * 状态：该用户不存在
     */
    public static final Integer USER_INEXIST_CODE = 300;

    /**
     * 状态：获取token异常
     */
    public static final Integer GET_TOKEN_ERROR_CODE = 301;

    /**
     * 状态：用户首次验证码登陆 获取token异常
     */
    public static final Integer LOGIN_GET_TOKEN_ERROR_CODE = 302;

    /**
     * 状态：业务异常
     */
    public static final Integer BUSINESS_ERROR_CODE = 303;

    /**
     * 状态：请求错误
     */
    public static final Integer BAD_REQUEST = 400;

    /**
     * token异常
     */
    public static final Integer TOKEN_BAD = 401;

    /**
     * 状态：未找到
     */
    public static final Integer NOT_FIND_CODE = 404;

    /**
     * 禁止请求
     */
    public static final Integer METHOD_NOT_ALLOWED = 405;

    /**
     * 状态：未知错误
     */
    public static final Integer ERROR_CODE = 500;

    /**
     * 状态：服务宕机
     */
    public static final Integer SERVER_DOWN_CODE = 555;

    /**
     * 微信首次登录状态码 用户需绑定手机号
     */
    public static final Integer WX_LOGIN = 600;

    /**
     * 微信需要完善信息状态码 需要注册账号
     */
    public static final Integer WX_REGISTER = 601;

    /**
     * 微信用户刚打开微信二维码
     */
    public static final Integer WX_TICKET = 602;

    /**
     * 操作成功
     */
    public static final String SUCCESS = "操作成功";

    /**
     * 未找到数据
     */
    public static final String NOT_FIND = "未找到数据";

    /**
     * 操作失败
     */
    public static final String ERROR = "操作失败";

    /**
     * -1
     */
    public static final String PRODUCT = "Dysmsapi";

    /**
     * -1
     */
    public static final String DOMAIN = "dysmsapi.aliyuncs.com";

    /**
     * 参数校验异常
     */
    public static final String PARAM_ERROR = "参数异常";

    /**
     * ASC秘钥
     */
    public static final String ASC_PASSWORD = "oC86T4NeB5v6duLkmgcJ6Q==";

    /**
     * 逻辑删除标志:"0"未删除
     */
    public static final String IS_NOT_DELETE = "0";

    /**
     * 逻辑删除标志:"1"删除
     */
    public static final String IS_DELETE = "1";

    /**
     * 微信的登录appid
     */
    public static final String APPID = "wxb61d12ae0f18ee35";

    /**
     * 微信的登录secret秘钥
     */
    public static final String SECRET = "bf46216e3ec1fd604f2bdcc70bb8521c";

    /**
     * 生成随机数
     */
    public static final Integer CODE = 6;


    /**
     * 默认创建企业
     */
    public static final String DEFAULT_IMG = "group1/M00/00/03/wKgBCV8P87GAFHTOAAAtJspMltY458.png";

    /**
     * 保存标志 0 :不保存  1：保存
     */
    public static final String IS_SAVE = "1";

    /**
     * 保存标志 0 :不保存  1：保存
     */
    public static final String IS_NOT_SAVE = "0";

    /**
     * PDF
     */
    public static final String PDF = "pdf";

    /**
     * DWG
     */
    public static final String DWG = "dwg";

    /**
     * XLS
     */
    public static final String XLS = "xls";

    /**
     * XLSX
     */
    public static final String XLSX = "xlsx";

    /**
     * DOC
     */
    public static final String DOC = "doc";

    /**
     * DOCX
     */
    public static final String DOCX = "docx";

    /**
     * 保存资料文件
     */
    public static final String SAVE = "save";

    /**
     * 彻底删除资料文件
     */
    public static final String DELETE = "delete";

    /**
     * 三分钟3*60*1000
     */
    public static final Long THREE_MINUTS = 180000L;

    /**
     * 1天 1*24*60*60*1000
     */
    public static final Long ONE_DAY = 86400000L;
}
