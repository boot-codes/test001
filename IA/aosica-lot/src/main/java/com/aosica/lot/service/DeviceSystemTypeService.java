package com.aosica.lot.service;


import com.aosica.common.exception.AosicaServiceQueryException;
import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.dto.DeviceSystemTypeQueryDTO;
import com.aosica.lot.entity.DeviceSystemType;

import java.util.List;

/**
 * @PackgeName com.aosica.lot.service
 * @ClassName DeviceSystemTypeService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/20 15:33
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/20$ 15:33$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public interface DeviceSystemTypeService {


    /**
     * 添加系统类型
     * @param deviceSystemType
     */
    void save(DeviceSystemType deviceSystemType) throws AosicaServiceSaveException ;

    /**
     *  根据 DeviceSystemTypeQueryDTO 查询对象，查询对应的数据
     * @param
     * @return
     */
    DeviceSystemType getByCondition(DeviceSystemTypeQueryDTO dto) throws AosicaServiceQueryException ;


    /**
     *  查询所有的系统类型
     * @return
     */
    List<DeviceSystemType> getAllList() throws AosicaServiceQueryException  ;
}
