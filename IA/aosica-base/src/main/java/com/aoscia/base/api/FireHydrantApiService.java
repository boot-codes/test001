package com.aoscia.base.api;

import com.aoscia.base.dto.FireHydrantDto;
import com.aoscia.base.service.impl.FireHydrantServiceImpl;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.common.exception.AosicaServiceQueryException;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ai-planting->FireHydrantApiService
 * @description: 消防栓控制器
 * @author: dwj
 * @create: 2019-09-27 17:06
 **/
@RestController
public class FireHydrantApiService implements FireHydrantServiceApi{

    private Logger logger = LoggerFactory.getLogger(FireHydrantApiService.class);

    @Autowired
    private FireHydrantServiceImpl FireHydrantServiceImpl;

    /**
     * @desc 消防栓列表
     * @param dto
     * @return
     */
    @Override
    public RequestResultPage<Page<FireHydrantDto>> selectList(FireHydrantDto dto) {
        try {
            Page<FireHydrantDto> page = this.FireHydrantServiceImpl.selectList(dto);
            return  RequestResultPage.buildOK(page) ;
        } catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return  RequestResultPage.buildFail() ;
        }
    }

    /**
     * @desc 消防栓详情
     * @param id
     * @return
     */
    @Override
    public RequestResult selectDetailById(String id) {
        RequestResult requestResult = null;
        try{
            requestResult = FireHydrantServiceImpl.selectDetailById(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防栓{selectDetailById}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    /**
     * @desc 新增或修改消防栓
     * @param fireHydrantDto
     * @return
     */
    @Override
    public RequestResult saveAndUpdate(FireHydrantDto fireHydrantDto) {
        RequestResult requestResult = null;
        try{
            requestResult = FireHydrantServiceImpl.saveAndUpdate(fireHydrantDto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防栓{saveAndUpdate}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    @Override
    public RequestResult remove(String id) {
        RequestResult requestResult = null;
        try{
            requestResult = FireHydrantServiceImpl.remove(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防栓{remove}接口系统异常"+e.getMessage());
        }
        return requestResult;

    }
}
