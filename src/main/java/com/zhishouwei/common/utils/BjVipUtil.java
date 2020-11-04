package com.zhishouwei.common.utils;

import cn.hutool.core.bean.BeanUtil;
import com.zhishouwei.common.exception.ServiceException;
import com.zhishouwei.common.model.BjCheckCompanyModel;
import com.zhishouwei.common.model.BjCheckEnum;
import com.zhishouwei.common.model.CompanyServiceUsageCheckModel;
import com.zhishouwei.common.model.entity.basicdata.CompanyServiceUsageEntity;
import com.zhishouwei.common.model.entity.basicdata.ServiceConfigEntity;
import com.zhishouwei.common.model.mapper.BjVipMapper;
import com.zhishouwei.common.redisson.RedisKeyCons;
import com.zhishouwei.common.redisson.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 对新云客户套餐限制一些代码<br>
 *
 * @className: BjVipUtil
 * @package: com.bjblackhole.common.utils
 * @author: javatom
 * @date: 2020/6/29 14:37
 */
@Component
@Slf4j
public class BjVipUtil {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private BjVipMapper bjVipMapper;

    /**
     * 解冻资源
     *
     * @param companyId            公司id
     * @param successResourcesSize 成功资源大小
     * @param errorResourcesSize   失败大小
     * @return boolean
     * @throws com.zhishouwei.common.exception.ServiceException q
     */
    public boolean thawResources(String companyId, Long successResourcesSize, Long errorResourcesSize)
            throws ServiceException {
        //根据公司id 查找其使用
        CompanyServiceUsageCheckModel companyServiceUsageEntity = selectCompanyServiceUsageCheckModel(companyId);
        if (null == successResourcesSize) {
            successResourcesSize = 0L;
        }
        if (null != errorResourcesSize) {
            //成功 ，那冻结需要减去的等于
            //成功的+失败的
            successResourcesSize = successResourcesSize + errorResourcesSize;
        } else {
            errorResourcesSize = 0L;

        }
        companyServiceUsageEntity.setCloudDiskSpaceFreeSize(companyServiceUsageEntity.getCloudDiskSpaceFreeSize()
                - successResourcesSize);
        companyServiceUsageEntity.setCloudDiskSpaceRsedSize(companyServiceUsageEntity.getCloudDiskSpaceRsedSize()
                - errorResourcesSize);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, companyId, companyServiceUsageEntity);
        bjVipMapper.thawResources(companyId, successResourcesSize, errorResourcesSize);
        return true;
    }

    /**
     * @param companyId            公司id
     * @param successResourcesSize 成功资源大小
     * @param errorResourcesSize   失败大小
     * @param usgeMode             usgeMode  资源更改字段
     * @return boolean
     * @throws ServiceException q
     */
    public boolean updateResources(String companyId, Long successResourcesSize, Long errorResourcesSize,
                                   CompanyServiceUsageCheckModel usgeMode)
            throws ServiceException {
        //根据公司id 查找其使用
        CompanyServiceUsageCheckModel companyServiceUsageEntity = selectCompanyServiceUsageCheckModel(companyId);
        if (null == successResourcesSize) {
            successResourcesSize = 0L;
        }
        if (null != errorResourcesSize) {
            //成功 ，那冻结需要减去的等于
            //成功的+失败的
            successResourcesSize = successResourcesSize + errorResourcesSize;
        } else {
            errorResourcesSize = 0L;

        }
        companyServiceUsageEntity.setCloudDiskSpaceFreeSize(companyServiceUsageEntity.getCloudDiskSpaceFreeSize()
                - successResourcesSize);
        companyServiceUsageEntity.setCloudDiskSpaceRsedSize(companyServiceUsageEntity.getCloudDiskSpaceRsedSize()
                - errorResourcesSize);
        updateResourcesCheck(usgeMode, companyServiceUsageEntity);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, companyId, companyServiceUsageEntity);
        saveCompanyUsageDb(companyServiceUsageEntity);
        return true;
    }

    /**
     * @param usgeMode                  usgeMode
     * @param companyServiceUsageEntity companyServiceUsageEntity
     */
    private void updateResourcesCheck(CompanyServiceUsageCheckModel usgeMode, CompanyServiceUsageCheckModel companyServiceUsageEntity) {
        //项目使用数量
        if (null != usgeMode.getProjectRsedNum() && usgeMode.getProjectRsedNum() > 0) {
            companyServiceUsageEntity.setProjectRsedNum(companyServiceUsageEntity.getProjectModelRsedNum()
                    + usgeMode.getProjectRsedNum());
        } else if (null != usgeMode.getProjectRsedNum() && usgeMode.getProjectRsedNum() < 0) {
            companyServiceUsageEntity.setProjectRsedNum(companyServiceUsageEntity.getProjectModelRsedNum()
                    - usgeMode.getProjectRsedNum());
        }

        //项目模型导入大小
        if (null != usgeMode.getProjectModelRsedSize() && usgeMode.getProjectModelRsedSize() > 0) {
            companyServiceUsageEntity.setProjectModelRsedSize(companyServiceUsageEntity.getProjectModelRsedSize()
                    + usgeMode.getProjectModelRsedSize());
        } else if (null != usgeMode.getProjectModelRsedSize() && usgeMode.getProjectModelRsedSize() < 0) {
            companyServiceUsageEntity.setProjectModelRsedSize(companyServiceUsageEntity.getProjectModelRsedSize()
                    - usgeMode.getProjectModelRsedSize());
        }

        //项目模型导入数量
        if (null != usgeMode.getProjectModelRsedNum() && usgeMode.getProjectModelRsedNum() > 0) {
            companyServiceUsageEntity.setProjectModelRsedNum(companyServiceUsageEntity.getProjectModelRsedNum()
                    + usgeMode.getProjectModelRsedNum());
        } else if (null != usgeMode.getProjectModelRsedNum() && usgeMode.getProjectModelRsedNum() < 0) {
            companyServiceUsageEntity.setProjectModelRsedNum(companyServiceUsageEntity.getProjectModelRsedNum()
                    - usgeMode.getProjectModelRsedNum());
        }

        //项目模型转换大小
        if (null != usgeMode.getProjectModelConvertRsedSize() && usgeMode.getProjectModelConvertRsedSize() > 0) {
            companyServiceUsageEntity.setProjectModelConvertRsedSize(companyServiceUsageEntity.getProjectModelConvertRsedSize()
                    + usgeMode.getProjectModelConvertRsedSize());
        }

        //项目模型转换数量
//        if (null != usgeMode.getProjectModelConvertRsedNum() && usgeMode.getProjectModelConvertRsedNum() > 0) {
//            companyServiceUsageEntity.setProjectModelConvertRsedNum(companyServiceUsageEntity.getProjectModelConvertRsedNum()
//                    + usgeMode.getProjectModelConvertRsedNum());
//        }
    }

    /**
     * 校验
     * 请注意校验一个属性时，可能需要校验其关联属性
     * 比如创建一个模型，模型本身是文件，有大小，所以不仅要校验其模型数限制还有校验文件限制
     *
     * @param bjCheckCompanyModel 校验参数
     * @return boolean
     * @throws ServiceException q
     */
    public boolean isCheck(BjCheckCompanyModel bjCheckCompanyModel) throws ServiceException {
        //根据公司id 查找其使用
        CompanyServiceUsageCheckModel companyServiceUsageEntity = selectCompanyServiceUsageCheckModel(
                bjCheckCompanyModel.getCompanyId());
        log.info("companyServiceUsageEntity:{}", companyServiceUsageEntity);
        //根据套餐id 拿到套餐
        ServiceConfigEntity serviceConfig = new ServiceConfigEntity();
        log.info("companyServiceUsageEntity.getServiceConfigId():{}", companyServiceUsageEntity.getServiceConfigId());

        Object hget = redisUtil.hget(RedisKeyCons.VIP_CONFIG_LIST, companyServiceUsageEntity.getServiceConfigId());
        log.info("hget:{}", hget);
        BeanUtil.copyProperties(hget, serviceConfig);
        log.info("serviceConfig:{}", serviceConfig);
        boolean res = false;
        switch (bjCheckCompanyModel.getCheckType()) {
            case "1":
                //判断空间是否够用
                res = checkResourceSize(companyServiceUsageEntity, serviceConfig, bjCheckCompanyModel);
                break;
            case "2":
                //判断员工数是否够用
                res = checkEmployeeCount(companyServiceUsageEntity, serviceConfig, bjCheckCompanyModel);
                break;
            case "3":
                //判断项目模型转换数量
                res = checkProjectModelConvertNum(companyServiceUsageEntity, serviceConfig, bjCheckCompanyModel);
                break;
            case "4":
                //判断项目模型数
                res = checkProjectModelNum(companyServiceUsageEntity, serviceConfig, bjCheckCompanyModel);
                break;
            default:

        }

        return res;
    }

    /**
     * 校验是否有足够的空间
     *
     * @param companyServiceUsageEntity companyServiceUsageEntity
     * @param serviceConfig             serviceConfig
     * @param bjCheckCompanyModel       bjCheckCompanyModel
     * @return boolean
     */
    private boolean checkResourceSize(CompanyServiceUsageCheckModel companyServiceUsageEntity,
                                      ServiceConfigEntity serviceConfig, BjCheckCompanyModel bjCheckCompanyModel) {
        Long c = companyServiceUsageEntity.getCloudDiskSpaceRsedSize() + bjCheckCompanyModel.getResourceSize();
        log.info("{}", serviceConfig.getCloudDiskSpaceSize());
        if (c.compareTo(serviceConfig.getCloudDiskSpaceSize()) < 0) {
            //还有资源可以用
            if (bjCheckCompanyModel.getOperatType().equals(BjCheckEnum.OPERAT_CHECK_DEDUCT.getCode())) {
                companyServiceUsageEntity.setCloudDiskSpaceRsedSize(c);
                redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, bjCheckCompanyModel.getCompanyId(),
                        companyServiceUsageEntity);
                saveCompanyUsageDb(companyServiceUsageEntity);
            } else if (bjCheckCompanyModel.getOperatType().equals(BjCheckEnum.OPERAT_CHECK_FREEZE.getCode())) {
                companyServiceUsageEntity.setCloudDiskSpaceRsedSize(c);
                companyServiceUsageEntity.setCloudDiskSpaceFreeSize(bjCheckCompanyModel.getResourceSize()
                        + companyServiceUsageEntity.getCloudDiskSpaceFreeSize());
                redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE,
                        bjCheckCompanyModel.getCompanyId(), companyServiceUsageEntity);
                saveCompanyUsageDb(companyServiceUsageEntity);
            }
            return true;
        } else {
            //没有资源可以用了
            return false;
        }
    }

    /**
     * 将数据同步到数据库总
     *
     * @param companyServiceUsageCheckModel companyServiceUsageCheckModel
     */
    @Async
    public void saveCompanyUsageDb(CompanyServiceUsageCheckModel companyServiceUsageCheckModel) {
        log.info("saveCompanyUsageDb {}", companyServiceUsageCheckModel);
        CompanyServiceUsageEntity companyServiceUsageEntity1 = new CompanyServiceUsageEntity();
        BeanUtil.copyProperties(companyServiceUsageCheckModel, companyServiceUsageEntity1);
        log.info("companyServiceUsageEntity1 {}", companyServiceUsageEntity1);
        bjVipMapper.updateById(companyServiceUsageEntity1);
    }

    /**
     * 判断员工数是否够用
     *
     * @param companyServiceUsageEntity companyServiceUsageEntity
     * @param serviceConfig             serviceConfig
     * @param bjCheckCompanyModel       bjCheckCompanyModel
     * @return boolean
     */
    private boolean checkEmployeeCount(CompanyServiceUsageCheckModel companyServiceUsageEntity,
                                       ServiceConfigEntity serviceConfig, BjCheckCompanyModel bjCheckCompanyModel) {
        Integer c = 0;
        if (bjCheckCompanyModel.getOperatType().equals(BjCheckEnum.OPERAT_CHECK_DEDUCT.getCode())) {
            c = companyServiceUsageEntity.getEmployeeRsedCount() + bjCheckCompanyModel.getEmployeeCount();
            log.info("{}", serviceConfig.getEmployeeCount());
            if (c > serviceConfig.getEmployeeCount()) {
                //没有资源可以用了
                return false;
            }
        }
        if (bjCheckCompanyModel.getOperatType().equals(BjCheckEnum.OPERAT_CHECK_RECOVER.getCode())) {
            c = companyServiceUsageEntity.getEmployeeRsedCount() - bjCheckCompanyModel.getEmployeeCount();
            log.info("{}", serviceConfig.getEmployeeCount());
            if (c < 0) {
                //没有资源可以用了
                return false;
            }
        }
        //还有资源可以用
        companyServiceUsageEntity.setEmployeeRsedCount(c);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, bjCheckCompanyModel.getCompanyId(),
                companyServiceUsageEntity);
        saveCompanyUsageDb(companyServiceUsageEntity);
        return true;
    }

    /**
     * 判断项目模型转换数量
     *
     * @param companyServiceUsageEntity companyServiceUsageEntity
     * @param serviceConfig             serviceConfig
     * @param bjCheckCompanyModel       bjCheckCompanyModel
     * @return boolean
     */
    private boolean checkProjectModelConvertNum(CompanyServiceUsageCheckModel companyServiceUsageEntity,
                                                ServiceConfigEntity serviceConfig, BjCheckCompanyModel bjCheckCompanyModel) {
        Integer c = 0;
        if (bjCheckCompanyModel.getOperatType().equals(BjCheckEnum.OPERAT_CHECK_DEDUCT.getCode())) {
            c = companyServiceUsageEntity.getProjectModelConvertRsedNum() + bjCheckCompanyModel.getProjectModelConvertNum();
            log.info("{}", serviceConfig.getProjectModelConvertNum());
            if (c > serviceConfig.getProjectModelConvertNum()) {
                //没有资源可以用了
                return false;
            }
        }
        if (bjCheckCompanyModel.getOperatType().equals(BjCheckEnum.OPERAT_CHECK_RECOVER.getCode())) {
            c = companyServiceUsageEntity.getProjectModelConvertRsedNum() - bjCheckCompanyModel.getProjectModelConvertNum();
            log.info("{}", serviceConfig.getProjectModelConvertNum());
            if (c < 0) {
                //没有资源可以用了
                return false;
            }
        }
        //还有资源可以用
        companyServiceUsageEntity.setProjectModelConvertRsedNum(c);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, bjCheckCompanyModel.getCompanyId(),
                companyServiceUsageEntity);
        saveCompanyUsageDb(companyServiceUsageEntity);
        return true;

//        Integer c = companyServiceUsageEntity.getProjectModelConvertRsedNum() + bjCheckCompanyModel.getProjectModelConvertNum();
//        log.info("{}", serviceConfig.getProjectModelConvertNum());
//        if (c.compareTo(serviceConfig.getProjectModelConvertNum()) < 0) {
//            //还有资源可以用
//            if (bjCheckCompanyModel.getOperatType().equals(BjCheckEnum.OPERAT_CHECK_DEDUCT.getCode())) {
//                companyServiceUsageEntity.setProjectModelConvertRsedNum(c);
//                redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, bjCheckCompanyModel.getCompanyId(),
//                        companyServiceUsageEntity);
//                saveCompanyUsageDb(companyServiceUsageEntity);
//            }
//            return true;
//        } else {
//            //没有资源可以用了
//            return false;
//        }
    }

    /**
     * 判断项目模型数
     *
     * @param companyServiceUsageEntity companyServiceUsageEntity
     * @param serviceConfig             serviceConfig
     * @param bjCheckCompanyModel       bjCheckCompanyModel
     * @return boolean
     */
    private boolean checkProjectModelNum(CompanyServiceUsageCheckModel companyServiceUsageEntity,
                                         ServiceConfigEntity serviceConfig, BjCheckCompanyModel bjCheckCompanyModel) {
        Integer c = 0;
        if (bjCheckCompanyModel.getOperatType().equals(BjCheckEnum.OPERAT_CHECK_DEDUCT.getCode())) {
            c = companyServiceUsageEntity.getProjectModelRsedNum() + bjCheckCompanyModel.getProjectModelNum();
            log.info("{}", serviceConfig.getProjectModelNum());
            if (c > serviceConfig.getProjectModelNum()) {
                //没有资源可以用了
                return false;
            }
        }
        if (bjCheckCompanyModel.getOperatType().equals(BjCheckEnum.OPERAT_CHECK_RECOVER.getCode())) {
            c = companyServiceUsageEntity.getProjectModelRsedNum() - bjCheckCompanyModel.getProjectModelNum();
            log.info("{}", serviceConfig.getProjectModelNum());
            if (c < 0) {
                //没有资源可以用了
                return false;
            }
        }
        //还有资源可以用
        companyServiceUsageEntity.setProjectModelRsedNum(c);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, bjCheckCompanyModel.getCompanyId(),
                companyServiceUsageEntity);
        saveCompanyUsageDb(companyServiceUsageEntity);
        return true;
    }

    /**
     * 根据公司id 查找其使用情况
     *
     * @param companyId 公司id
     * @return CompanyServiceUsageCheckModel
     * @throws ServiceException 1
     */
    public CompanyServiceUsageCheckModel selectCompanyServiceUsageCheckModel(String companyId)
            throws ServiceException {
        CompanyServiceUsageCheckModel model = new CompanyServiceUsageCheckModel();
        Object hget = redisUtil.hget(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, companyId);
        if (null == hget) {
            //如果在redis中查询不到，则在数据库中查找相关数据，在同步到数据库中，确保下次可以查到
            model = bjVipMapper.selectCompanyServiceUsageCheck(companyId);
            //同步到redis上
            if (null == model) {
                throw new ServiceException("公司不存在或此公司已经禁用");
            }
            redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, companyId, model);
        } else {
            BeanUtil.copyProperties(hget, model);
//            model = (CompanyServiceUsageCheckModel) hget;
        }
        return model;
    }

    /**
     * 根据套餐id 查找
     *
     * @param serviceConfigId 套餐id
     * @return ServiceConfigEntity
     * @throws ServiceException 1
     */
    public ServiceConfigEntity selectServiceConfigEntity(String serviceConfigId)
            throws ServiceException {
        ServiceConfigEntity model = new ServiceConfigEntity();
        Object hget = redisUtil.hget(RedisKeyCons.VIP_CONFIG_LIST, serviceConfigId);
        if (null == hget) {
            //如果在redis中查询不到，则在数据库中查找相关数据，在同步到数据库中，确保下次可以查到
            model = bjVipMapper.selectServiceConfigById(serviceConfigId);
            //同步到redis上
            if (null == model) {
                throw new ServiceException("公司不存在或此公司已经禁用");
            }
            redisUtil.hset(RedisKeyCons.VIP_CONFIG_LIST, serviceConfigId, model);
        } else {
            BeanUtil.copyProperties(hget, model);
        }
        return model;
    }

    /**
     * 恢复资源
     *
     * @param companyId     公司id
     * @param resourcesSize 资源大小
     * @return boolean
     * @throws ServiceException q
     */
    public boolean recoverResources(String companyId, Long resourcesSize) throws ServiceException {
        //根据公司id 查找其使用
        CompanyServiceUsageCheckModel companyServiceUsageEntity = selectCompanyServiceUsageCheckModel(companyId);
        if (null == resourcesSize) {
            resourcesSize = 0L;
        }
        companyServiceUsageEntity.setCloudDiskSpaceRsedSize(companyServiceUsageEntity.getCloudDiskSpaceRsedSize()
                - resourcesSize);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, companyId, companyServiceUsageEntity);
        return bjVipMapper.recoverResources(companyId, resourcesSize) > 0 ? true : false;
    }

    /**
     * 恢复资源
     *
     * @param companyId     公司id
     * @param resourcesSize 资源大小
     * @param modelSize     删除模型数
     * @return boolean
     * @throws ServiceException q
     */
    public boolean recoverResources(String companyId, Long resourcesSize, int modelSize) throws ServiceException {
        //根据公司id 查找其使用
        CompanyServiceUsageCheckModel companyServiceUsageEntity = selectCompanyServiceUsageCheckModel(companyId);
        if (null == resourcesSize) {
            resourcesSize = 0L;
        }
        companyServiceUsageEntity.setCloudDiskSpaceRsedSize(companyServiceUsageEntity.getCloudDiskSpaceRsedSize()
                - resourcesSize);
        companyServiceUsageEntity.setProjectModelRsedNum(companyServiceUsageEntity.getProjectModelRsedNum() - modelSize);
        companyServiceUsageEntity.setProjectModelRsedSize(companyServiceUsageEntity.getProjectModelRsedSize() - resourcesSize);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, companyId, companyServiceUsageEntity);
        return bjVipMapper.recoverResources(companyId, resourcesSize) > 0 ? true : false;
    }

    /**
     * 恢复项目数量单个
     *
     * @param companyId 企业id
     * @return boolean
     * @throws ServiceException 异常
     */
    public boolean recoverProjectNum(String companyId) throws ServiceException {
        CompanyServiceUsageCheckModel companyServiceUsageCheckModel = selectCompanyServiceUsageCheckModel(companyId);
        companyServiceUsageCheckModel.setProjectRsedNum(companyServiceUsageCheckModel.getProjectRsedNum() - 1);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, companyId, companyServiceUsageCheckModel);
        saveCompanyUsageDb(companyServiceUsageCheckModel);
        return true;
    }

    /**
     * 恢复资源(资料文件)
     *
     * @param companyId 公司id
     * @param model     资源模型
     * @return boolean
     * @throws ServiceException q
     */
    public boolean recoverFileResources(String companyId, CompanyServiceUsageCheckModel model) throws ServiceException {
        //根据公司id 查找其使用
        CompanyServiceUsageCheckModel companyServiceUsageCheckModel = selectCompanyServiceUsageCheckModel(companyId);
        Long cloudDiskSpaceRsedSize = companyServiceUsageCheckModel.getCloudDiskSpaceRsedSize() - model.getDocSize();
        Long docSize = companyServiceUsageCheckModel.getDocSize() - model.getDocSize();
        Integer docPdfNum = companyServiceUsageCheckModel.getDocPdfNum() - model.getDocPdfNum();
        Integer docDwgNum = companyServiceUsageCheckModel.getDocDwgNum() - model.getDocDwgNum();
        Integer docExcelNum = companyServiceUsageCheckModel.getDocExcelNum() - model.getDocExcelNum();
        Integer docWordNum = companyServiceUsageCheckModel.getDocWordNum() - model.getDocWordNum();
        Integer docOtherNum = companyServiceUsageCheckModel.getDocOtherNum() - model.getDocOtherNum();
        companyServiceUsageCheckModel.setCloudDiskSpaceRsedSize(cloudDiskSpaceRsedSize);
        companyServiceUsageCheckModel.setDocSize(docSize);
        companyServiceUsageCheckModel.setDocPdfNum(docPdfNum);
        companyServiceUsageCheckModel.setDocDwgNum(docDwgNum);
        companyServiceUsageCheckModel.setDocExcelNum(docExcelNum);
        companyServiceUsageCheckModel.setDocWordNum(docWordNum);
        companyServiceUsageCheckModel.setDocOtherNum(docOtherNum);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, companyId, companyServiceUsageCheckModel);

        return bjVipMapper.recoverFileResources(companyId, companyServiceUsageCheckModel) > 0 ? true : false;
    }

    /**
     * 恢复资源(模型,空间使用大小,模型使用大小,数量)
     *
     * @param companyId 公司id
     * @param model     资源模型
     * @return boolean
     * @throws ServiceException q
     */
    public boolean recoverModelResources(String companyId, CompanyServiceUsageCheckModel model) throws ServiceException {
        //根据公司id 查找其使用
        CompanyServiceUsageCheckModel companyServiceUsageCheckModel = selectCompanyServiceUsageCheckModel(companyId);
        Long cloudDiskSpaceRsedSize = companyServiceUsageCheckModel.getCloudDiskSpaceRsedSize() - model.getProjectModelRsedSize();
        Long projectModelRsedSize = companyServiceUsageCheckModel.getProjectModelRsedSize() - model.getProjectModelRsedSize();
        Integer projectModelRsedNum = companyServiceUsageCheckModel.getProjectModelRsedNum() - model.getProjectModelRsedNum();

        companyServiceUsageCheckModel.setCloudDiskSpaceRsedSize(cloudDiskSpaceRsedSize);
        companyServiceUsageCheckModel.setProjectModelRsedSize(projectModelRsedSize);
        companyServiceUsageCheckModel.setProjectModelRsedNum(projectModelRsedNum);
        redisUtil.hset(RedisKeyCons.CUSTOMER_PACKAGE_USAGE, companyId, companyServiceUsageCheckModel);

        return bjVipMapper.recoverModelResources(companyId, companyServiceUsageCheckModel) > 0 ? true : false;
    }
}
