package com.aosica.lot.service.impl;

import com.aosica.common.exception.AosicaServiceQueryException;
import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.lot.dto.DeviceSystemTypeQueryDTO;
import com.aosica.lot.entity.DeviceSystemType;
import com.aosica.lot.mapper.DeviceSystemTypeMapper;
import com.aosica.lot.service.DeviceSystemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  物联系统类型service
 * @PackgeName com.aosica.lot.service.impl
 * @ClassName DeviceSystemTypeServiceImpl.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/20 15:35
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/20$ 15:35$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@Service
public class DeviceSystemTypeServiceImpl implements DeviceSystemTypeService {


    @Autowired
    private DeviceSystemTypeMapper deviceSystemTypeMapper ;


    /**
     * 添加系统类型
     *
     * @param deviceSystemType
     */
    @Override
    public void save(DeviceSystemType deviceSystemType) throws AosicaServiceSaveException {
        this.deviceSystemTypeMapper.insert(deviceSystemType) ;
    }


    /**
     * 根据 DeviceSystemTypeQueryDTO 查询对象，查询对应的数据
     *
     * @param dto@return
     */
    @Override
    public DeviceSystemType getByCondition(DeviceSystemTypeQueryDTO dto) throws AosicaServiceQueryException {
        return this.deviceSystemTypeMapper.getByDtoCondition(dto);
    }



    /**
     * 查询所有的系统类型
     * @return
     */
    @Override
    public List<DeviceSystemType> getAllList() throws AosicaServiceQueryException  {
        return this.deviceSystemTypeMapper.getAllList();
    }


}
