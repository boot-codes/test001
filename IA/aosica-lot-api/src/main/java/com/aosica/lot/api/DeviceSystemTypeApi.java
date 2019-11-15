package com.aosica.lot.api;

import com.aosica.common.bean.RequestResult;
import com.aosica.lot.dto.DeviceSystemTypeQueryDTO;
import com.aosica.lot.entity.DeviceSystemType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @PackgeName com.aosica.lot.api
 * @ClassName DeviceSystemTypeApi.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/20 16:38
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/20$ 16:38$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@Api(tags = "物联设备系统类型管理 api")
@RequestMapping("/deviceSystemType")
public interface DeviceSystemTypeApi {


    /**
     *
     * @return
     */
    @ApiOperation(value = "添加物联设备系统类型")
    @ApiImplicitParam(value = "deviceSystemType",dataTypeClass = DeviceSystemType.class)
    @ApiResponse(code =200 ,message = "如果请求成功，返回一个RequestResult 对象",response = RequestResult.class)
    @PostMapping("/save")
    RequestResult saveSystemType(DeviceSystemType deviceSystemType) ;


    /**
     *  根据 DeviceSystemTypeQueryDTO 查询对象，查询对应的数据
     * @param
     * @return
     */
    @ApiOperation(value = "添加物联设备系统类型")
    @ApiResponse(code =200 ,message = "如果请求成功，返回RequestResult<DeviceSystemTypeQueryDTO> 对象",response = RequestResult.class)
    @PostMapping("/getByCondition")
    RequestResult<DeviceSystemTypeQueryDTO> getByCondition(DeviceSystemTypeQueryDTO dto) ;


    /**
     * 查询所有的系统类型
     * @return
     */
    @ApiOperation(value = "查询所有的系统类型")
    @ApiResponse(code =200 ,message = "如果请求成功，返回RequestResult<DeviceSystemTypeQueryDTO> 对象",response = RequestResult.class)
    @PostMapping("/list")
    RequestResult<DeviceSystemTypeQueryDTO> getAllList() ;


}
