package com.zhishouwei.common.model.mapper;

import com.zhishouwei.common.model.CompanyServiceUsageCheckModel;
import com.zhishouwei.common.model.entity.basicdata.CompanyServiceUsageEntity;
import com.zhishouwei.common.model.entity.basicdata.ServiceConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 〈功能概述〉<br>
 *
 * @className: BjVipMapper
 * @package: com.bjblackhole.common
 * @author: TR
 * @date: 2020/6/29 17:16
 */
@Mapper
public interface BjVipMapper extends BaseMapper<CompanyServiceUsageEntity> {
    /**
     * 1
     *
     * @param companyId 1
     * @return 1
     */
    @Select("  SELECT\n"
            + "\tc.employee_rsed_count,\n"
            + "\tc.id,\n"
            + "\tc.project_rsed_num,\n"
            + "\tc.project_model_rsed_num,\n"
            + "\tc.cloud_disk_space_free_size,\n"
            + "\tc.project_model_rsed_size,\n"
            + "\tc.cloud_disk_space_rsed_size,\n"
            + "\tc.project_model_convert_rsed_num,\n"
            + "\tc.project_model_convert_rsed_size,\n"
            + "\tc.doc_size,\n"
            + "\tc.doc_dwg_num,\n"
            + "\tc.doc_pdf_num,\n"
            + "\tc.doc_word_num,\n"
            + "\tc.doc_excel_num,\n"
            + "\tc.company_id,\n"
            + "\tc.doc_other_num,\n"
            + "\tc.vip_effective_start_time,\n"
            + "\tc.vip_failure_time,\n"
            + "  r.service_config_id\n"
            + "FROM\n"
            + "\tnp_company r\n"
            + "\tLEFT JOIN np_company_service_usage c ON r.id = c.company_id\n"
            + "WHERE\n"
            + "\tr.is_delete =0 and r.id=#{companyId}")
    CompanyServiceUsageCheckModel selectCompanyServiceUsageCheck(@Param("companyId") String companyId);

    /**
     * 1
     *
     * @param companyId            1
     * @param successResourcesSize 1
     * @param errorResourcesSize   1
     * @return 1
     */
    @Update("UPDATE np_company_service_usage \n"
            + "SET cloud_disk_space_free_size = cloud_disk_space_free_size - #{successResourcesSize},\n"
            + "cloud_disk_space_rsed_size=cloud_disk_space_rsed_size - #{errorResourcesSize} \n"
            + "WHERE\n"
            + "\tcompany_id =#{companyId}")
    int thawResources(@Param("companyId") String companyId,
                      @Param("successResourcesSize") Long successResourcesSize,
                      @Param("errorResourcesSize") Long errorResourcesSize);

    /**
     * 恢复资源大小
     *
     * @param companyId     企业id
     * @param resourcesSize 资源大小
     * @return int
     */
    @Update("UPDATE np_company_service_usage \n"
            + "SET cloud_disk_space_rsed_size=cloud_disk_space_rsed_size - #{resourcesSize} \n"
            + "WHERE\n"
            + "\tcompany_id =#{companyId}")
    int recoverResources(@Param("companyId") String companyId,
                         @Param("resourcesSize") Long resourcesSize);

    /**
     * 恢复资源(资料文件)
     *
     * @param companyId                     企业id
     * @param companyServiceUsageCheckModel companyServiceUsageCheckModel
     * @return int
     */
    int recoverFileResources(@Param("companyId") String companyId,
                             @Param("model") CompanyServiceUsageCheckModel companyServiceUsageCheckModel);

    /**
     * 恢复资源大小
     *
     * @param companyId                     企业id
     * @param companyServiceUsageCheckModel companyServiceUsageCheckModel
     * @return int
     */
    int recoverModelResources(@Param("companyId") String companyId,
                              @Param("model") CompanyServiceUsageCheckModel companyServiceUsageCheckModel);

    /**
     * 根据id查找套餐服务
     *
     * @param serviceConfigId 套餐服务主键id
     * @return ServiceConfigEntity
     */
    @Select("SELECT * FROM np_service_config WHERE is_delete = 0 AND id = #{serviceConfigId};")
    ServiceConfigEntity selectServiceConfigById(@Param("serviceConfigId") String serviceConfigId);
}
