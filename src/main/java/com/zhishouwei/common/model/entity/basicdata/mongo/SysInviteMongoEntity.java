package com.zhishouwei.common.model.entity.basicdata.mongo;

import com.zhishouwei.common.model.entity.BaseMongoEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


/**
 * 系统分享表mongo实体bean<br>
 *
 * @className: SysInviteMongoEntity
 * @package: com.bjblackhole.common.entity.basicdata
 * @author: TR
 * @date: 2020/7/16 11:17
 */
@Data
@Document(collection = "np_sys_invite")
public class SysInviteMongoEntity  extends BaseMongoEntity implements Serializable {
    private static final long serialVersionUID = 8910221262770601821L;
    /*
        组合索引
        @CompoundIndexes({
            @CompoundIndex(name = "uq_userno_date", def = "{userNo:1, date:-1}", unique = true)
            })
            普通索引
          @Indexed
         */
    @Id
    private String id;


    //项目id
    @Field("project_id")
    @Indexed(name = "index_project_id")
    private String projectId;
    //项目名
    @Field("project_name")
    private String projectName;
    //有效期限
    @Field("expiration_date_num")
    private Integer expirationDateNum;
    //有效最后时间
    @Field("expiration_date_time")
    private String expirationDateTime;
    //审核方式 0:需要 1:不需要
    @Field("audit_type")
    private Integer auditType;
    //公司id
    @Field("company_id")
    private String companyId;
    //公司名
    @Field("company_name")
    private String companyName;
    //邀请指定人员
    @Field("invite_user")
    private String inviteUser;
    //邀请链接
    @Field("invite_link")
    private String inviteLink;
}
