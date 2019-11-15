package com.aosica.lot.api;


import com.aosica.common.exception.AosicaServiceQueryException;
import com.aosica.common.exception.AosicaServiceSaveException;
import com.aosica.common.bean.RequestResult;
import com.aosica.lot.dto.DeviceSystemTypeQueryDTO;
import com.aosica.lot.entity.DeviceSystemType;
import com.aosica.lot.service.DeviceSystemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 *  设备系统类型 api
 * DeviceSystemTypeServiceApi
 * @PackgeName com.aosica.lot.api
 * @ClassName DeviceSystemTypeServiceApi.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/20 16:42
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/20$ 16:42$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RestController
public class DeviceSystemTypeServiceApi implements DeviceSystemTypeApi {

    @Autowired
   private DeviceSystemTypeService deviceSystemTypeService ;


    /** 添加设备系统类型
     * @return
     */
    @Override
    public RequestResult saveSystemType(DeviceSystemType deviceSystemType) {

        try {
            this.deviceSystemTypeService.save(deviceSystemType);
            return  RequestResult.buildOK() ;
        }
        catch (AosicaServiceSaveException e) {
            e.printStackTrace();
            return  RequestResult.buildFail() ;
        }
    }

    /**
     * 根据 DeviceSystemTypeQueryDTO 查询对象，查询对应的数据
     *
     * @param dto@return
     */
    @Override
    public RequestResult getByCondition(DeviceSystemTypeQueryDTO dto) {
        DeviceSystemType deviceSystemType = null;
        try {
            deviceSystemType = this.deviceSystemTypeService.getByCondition(dto);
            return  RequestResult.buildOkData(deviceSystemType) ;
        }
        catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return RequestResult.buildFail() ;
        }
    }


    /**
     * 根据 DeviceSystemTypeQueryDTO 查询对象，查询对应的数据
     *
     * @param @return
     */
    @Override
    public RequestResult<DeviceSystemTypeQueryDTO> getAllList() {

        List<DeviceSystemType> allList = null;
        try {
            allList = this.deviceSystemTypeService.getAllList();
            return  RequestResult.buildOkData(allList) ;
        }
        catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return RequestResult.buildFail() ;
        }
    }


}
