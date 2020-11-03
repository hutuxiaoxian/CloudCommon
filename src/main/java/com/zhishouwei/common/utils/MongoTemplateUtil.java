package com.zhishouwei.common.utils;

import com.zhishouwei.common.model.AuthUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author： zhus
 * @version: 1.0
 * @date: 2020/7/23 17:56
 */
@Component
public class MongoTemplateUtil {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * update
     *
     * @param updateTime 更新时间
     * @return update
     */
    public Update update(String updateTime) {
        Update update = new Update();
        if (StringUtils.isNotEmpty(updateTime)) {
            update.set("update_time", updateTime);
        }
        AuthUser userInfo = AuthUser.getInstance();
        if (null != userInfo) {
            update.set("update_user_name", userInfo.getUsername());
        }
        return update;
    }

    /**
     * update
     *
     * @param updateTime     更新时间
     * @param updateUserName 更新人
     * @return update
     */
    public Update update(String updateTime, String updateUserName) {
        Update update = new Update();
        if (StringUtils.isNotEmpty(updateTime)) {
            update.set("update_time", updateTime);
        }
        if (StringUtils.isNotEmpty(updateUserName)) {
            update.set("update_user_name", updateUserName);
        }
        return update;
    }

    /**
     * criteriaNotDelete
     *
     * @return Criteria
     */
    public Criteria criteriaNotDelete() {
        return Criteria.where("is_delete").is(Constants.IS_NOT_DELETE);
    }

    /**
     * criteriaIsDelete
     *
     * @return Criteria
     */
    public Criteria criteriaIsDelete() {
        return Criteria.where("is_delete").is(Constants.IS_DELETE);
    }

    /**
     * criteriaNotDeleteIsSave
     *
     * @return Criteria
     */
    public Criteria criteriaNotDeleteIsSave() {
        return Criteria.where("is_delete").is(Constants.IS_NOT_DELETE).and("is_save").is(Constants.IS_SAVE);
    }

    /**
     * criteriaIsDeleteIsSave
     *
     * @return Criteria
     */
    public Criteria criteriaIsDeleteIsSave() {
        return Criteria.where("is_delete").is(Constants.IS_DELETE).and("is_save").is(Constants.IS_SAVE);
    }

}
