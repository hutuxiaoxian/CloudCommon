package com.zhishouwei.common.redisson;

/**
 * javatom
 * 整个项目中用到Redis key定义
 * 或者Key的前缀定义
 */
public class RedisKeyCons {
    /**
     * 默认Vip等级id
     */
    public static final String DEFAULT_VIP_LEVEL = "np:default:vip:level";
    /**
     * Vip服务配置信息
     */
    public static final String VIP_CONFIG_LIST = "np:vip:config:list";
    /**
     * 客户套餐使用情况
     */
    public static final String CUSTOMER_PACKAGE_USAGE = "np:customer:package:usage";
    /**
     * 查询的单个项目(id)
     */
    public static final String PROJECT_FIND_ID = "np:project:find:id:";
    /**
     * 查询企业下的单个项目(name)
     */
    public static final String PROJECT_FIND_NAME = "np:project:find:name:";
    /**
     * 项目访问
     */
    public static final String PROJECT_VISITED = "np:project:visited:";
    /**
     * 最近浏览项目
     */
    public static final String PROJECT_HISTORY = "np:project:history:";
    /**
     * 文件MD5校验
     */
    public static final String FILES_MD5 = "np:files:md5";
    /**
     * 文件fileId存储
     */
    public static final String FILES_FILEID = "np:files:fileId";
    /**
     * 查询的单个企业(id)
     */
    public static final String COMPANY_FIND_ID = "np:company:find:id:";
    /**
     * 查询的单个企业(name)
     */
    public static final String COMPANY_FIND_NAME = "np:company:find:name:";
    /**
     * 查询企业列表
     */
    public static final String COMPANY_LIST = "np:company:list";

    /**
     * 短信验证码
     */
    public static final String MOBILE_CHECK_CODE = "MOBILE:CODE:";


    /**
     * 邮箱验证码
     */
    public static final String EMAIL_CHECK_CODE = "EMAIL:CODE:";

    /**
     * 标签颜色
     */
    public static final String TAG_COLOR = "np:tag:color";

    /**
     * 评论数量
     */
    public static final String BBS_COUNT = "BBS:COUNT:";

    /**
     * 评论默认列表
     */
    public static final String BBS_DEFAULT_LIST = "BBS:LIST:";

    /**
     * 记录用户提交转换的模型数和模型大小
     */
    public static final String USER_COV_DATE = "USER:COV:DATE:";

    /**
     * 记录工程转换进度
     */
    public static final String PROJECT_CONVERTING_PROGRESS = "PROJECT:CONVERTING:PROGRESS:";

}
