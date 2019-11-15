package com.aoscia.base.api;

import com.aoscia.base.dto.BuildingDto;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 楼栋管理  Service
 *
 * @PackgeName com.aoscia.base.api
 * @ClassName BuildService.java
 * @Description: TODO
 * @Author: ylp
 * @Date: 2019/8/25 9:41
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/25$ 9:41$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
@RequestMapping("/build")
public interface BuildingServiceApi {

    /**
     * @description 获取建筑物列表
     * @param buildingDto
     */
    @ApiOperation(value = "获取建筑物列表",notes = "")
    @ApiImplicitParam(dataTypeClass = BuildingDto.class)
    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    RequestResultPage<Page<BuildingDto>> selectList(@RequestBody  BuildingDto buildingDto);

    /**
     * @desc 新增建筑物
     * @param buildingDto
     */
    @ApiOperation(value = "新增建筑物",notes = "")
    @ApiImplicitParam(dataTypeClass = BuildingDto.class)
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    RequestResult insert(@RequestBody BuildingDto buildingDto);

    /**
     * @desc 更新建筑物
     * @param buildingDto
     */
    @ApiOperation(value = "更新建筑物",notes = "")
    @ApiImplicitParam(dataTypeClass = BuildingDto.class)
    @RequestMapping(value = "update", method = RequestMethod.POST)
    RequestResult update(@RequestBody BuildingDto buildingDto);

    /**
     * @desc 查看建筑物详情信息
     * @param id
     * @return
     */
    @ApiOperation(value = "查看建筑物详情信息",notes = "")
    @ApiImplicitParam(name = "id",value = "id")
    @RequestMapping(value = "selectDetailById", method = RequestMethod.POST)
    RequestResult<BuildingDto> selectDetailById(@RequestParam(value = "id") String id);

    /**
     * @desc 删除建筑物信息
     * @param id
     * @return
     */
    @ApiOperation(value = "删除建筑物",notes = "")
    @ApiImplicitParam(name = "id",value = "id")
    @RequestMapping(value = "deleteBuilding", method = RequestMethod.POST)
    RequestResult remove(@RequestParam(value = "id") String id);

}
