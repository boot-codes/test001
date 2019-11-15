package com.aoscia.base.api;

import com.aoscia.base.dto.BuildingDto;
import com.aoscia.base.service.impl.BuildingServiceImpl;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.common.exception.AosicaServiceQueryException;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackgeName com.aosica.base.api
 * @ClassName UserService.java
 * @Description: TODO
 * @Author: ll
 * @Date: 2019/8/15 9:50
 * @UpdateUser: ll
 * @UpdateDate: 2019/8/15$ 9:50$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RestController
public class BuildingApiService implements BuildingServiceApi {
    private Logger logger = LoggerFactory.getLogger(BuildingApiService.class);

    @Autowired
    private BuildingServiceImpl buildingServiceImpl ;

    /**
     * @desc 获取建筑物列表
     * @param dto
     * @return
     */
    @Override
    public RequestResultPage<Page<BuildingDto>> selectList(BuildingDto dto) {
        try {
            Page<BuildingDto> page = this.buildingServiceImpl.selectList(dto);
            return  RequestResultPage.buildOK(page) ;
        } catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return  RequestResultPage.buildFail() ;
        }
    }

    /**
     * @desc 新增建筑物
     * @param buildingDto
     */
    @Override
    public RequestResult insert(BuildingDto buildingDto) {
        RequestResult requestResult = null;
        try{
            requestResult = buildingServiceImpl.insert(buildingDto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("建筑物{insert}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }


    /**
     * @desc 修改建筑物
     * @param buildingDto
     */
    @Override
    public RequestResult update(BuildingDto buildingDto) {
        RequestResult requestResult = null;
        try{
            requestResult = buildingServiceImpl.update(buildingDto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("建筑物{update}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    /**
     * @desc 查看建筑物详情信息
     * @param id
     * @return
     */
    @Override
    public RequestResult<BuildingDto> selectDetailById(String id) {
        RequestResult<BuildingDto> requestResult = null;
        try{
            System.out.println("BuildingApiService---------");
            System.out.println(id);
            requestResult = buildingServiceImpl.selectDetailById(id);
            System.out.println("查詢詳情之後");
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("建筑物{selectDetailById}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    @Override
    public RequestResult remove(String id) {
        RequestResult requestResult = null;
        try{
            requestResult = buildingServiceImpl.remove(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("建筑物{deleteBuilding}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }
}
























