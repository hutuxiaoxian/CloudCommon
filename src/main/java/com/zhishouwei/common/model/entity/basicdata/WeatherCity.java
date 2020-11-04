package com.zhishouwei.common.model.entity.basicdata;

import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/7/14 15:16
 */

@Data
//@Entity
@Table(name = "weather_city", indexes = {
        @Index(name = "index_bai_du_id", columnList = "bai_du_id")
})
public class WeatherCity extends BaseEntity implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", columnDefinition = "int Comment '主键id'")
//    private int id;

    @Column(name = "city_en", columnDefinition = "varchar(32) COMMENT '英文城市名'")
    private String cityEn;

    @Column(name = "city_zh", columnDefinition = "varchar(32) COMMENT '中文城市名'")
    private String cityZh;

    @Column(name = "weather_id", columnDefinition = "varchar(32) COMMENT '天气接口城市id'")
    private String weatherId;

    @Column(name = "bai_du_id", columnDefinition = "int(10) COMMENT '百度地图id'")
    private Integer baiDuId;
}
