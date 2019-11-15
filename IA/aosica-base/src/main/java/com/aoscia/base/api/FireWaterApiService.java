package com.aoscia.base.api;

import com.aoscia.base.dto.FireWaterDto;
import com.aoscia.base.service.impl.FireWaterServiceImpl;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.common.exception.AosicaServiceQueryException;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ai-planting->FireWaterApiService
 * @description: 消防水源信息
 * @author: ll
 * @create: 2019-11-04 17:09
 **/

@RestController
public class FireWaterApiService implements FireWaterApi {

    private Logger logger = LoggerFactory.getLogger(BuildingApiService.class);

     @Autowired
     private FireWaterServiceImpl fireWaterServiceImpl ;


    @Override
    public RequestResultPage<Page<FireWaterDto>> selectList(FireWaterDto dto) {
        try {
            Page<FireWaterDto> page = this.fireWaterServiceImpl.selectList(dto);
            return  RequestResultPage.buildOK(page) ;
        } catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return  RequestResultPage.buildFail() ;
        }
    }

    @Override
    public RequestResult saveAndUpdate(FireWaterDto dto) {
        RequestResult requestResult = null;
        try{
            requestResult = fireWaterServiceImpl.saveAndUpdate(dto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防水源{saveAndUpdate}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }




    @Override
    public RequestResult<FireWaterDto> selectDetailById(String id) {
        System.out.println("FireWaterApiService打印id"+id);
        RequestResult requestResult = null;
        try{
            requestResult = fireWaterServiceImpl.selectDetailById(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防水源{selectDetailById}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }


    @Override
    public RequestResult remove(String id) {
        RequestResult requestResult = null;
        try{
            requestResult = fireWaterServiceImpl.remove(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防水源{remove}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }
}