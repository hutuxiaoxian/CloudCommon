package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * 微信用户表
 * @author:caowenjie
 * @datetime: 2020/6/11 16:51
 */
@Data
//@Entity
@Table(name = "np_we_chat")
@TableName(value = "np_we_chat")
//@org.hibernate.annotations.Table(appliesTo = "np_we_chat", comment = "微信用户实体类")
public class WeChatEntity extends BaseEntity{

    @Id
    @TableId(value = "open_id")
    @Column(name = "open_id", columnDefinition = "varchar(100) Comment '普通用户的标识，对当前开发者帐号唯一'")
    private String openId;

    @Column(name = "nick_name", columnDefinition = "varchar(255) Comment '普通用户昵称'")
    private String nickName;

    @Column(name = "sex", columnDefinition = "varchar(20) Comment '普通用户性别，1为男性，2为女性'")
    private String sex;

    @Column(name = "province", columnDefinition = "varchar(255) Comment '普通用户个人资料填写的省份'")
    private String province;

    @Column(name = "city", columnDefinition = "varchar(100) Comment '国家，如中国为CN'")
    private String city;

    @Column(name = "headimgurl", columnDefinition = "varchar(255) Comment '用户头像，最后一个数值代表正方形头像大小'")
    private String headimgurl;

    @Column(name = "privilege", columnDefinition = "varchar(100) Comment '用户特权信息，json数组，如微信沃卡用户为（chinaunicom）'")
    private String privilege;

    @Column(name = "union_id", columnDefinition = "varchar(100) Comment '用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的'")
    private String unionId;

}
