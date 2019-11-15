package com.aoscia.base.api;

import com.aoscia.base.dto.RescueTeamDto;
import com.aoscia.base.service.impl.RescueTeamServiceImpl;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.common.exception.AosicaServiceQueryException;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ai-planting->RescueTeamApiService
 * @description: 救援队伍控制器
 * @author: dwj
 * @create: 2019-09-27 15:22
 **/
@RestController
public class RescueTeamApiService implements RescueTeamServiceApi{

    private Logger logger = LoggerFactory.getLogger(RescueTeamApiService.class);

    @Autowired
    private RescueTeamServiceImpl rescueTeamServiceImpl;

    /**
     * @desc 救援队伍列表
     * @param dto
     * @return
     */
    @Override
    public RequestResultPage<Page<RescueTeamDto>> selectList(RescueTeamDto dto) {
        try {
            Page<RescueTeamDto> page = this.rescueTeamServiceImpl.selectList(dto);
            return  RequestResultPage.buildOK(page) ;
        } catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return  RequestResultPage.buildFail() ;
        }
    }

    /**
     * @desc 救援队伍详情
     * @param id
     * @return
     */
    @Override
    public RequestResult selectDetailById(String id) {
        RequestResult requestResult = null;
        try{
            requestResult = rescueTeamServiceImpl.selectDetailById(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("救援队伍{selectDetailById}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    /**
     * @desc 新增或修改救援队伍
     * @param rescueTeamDto
     * @return
     */
    @Override
    public RequestResult saveAndUpdate(RescueTeamDto rescueTeamDto) {
        RequestResult requestResult = null;
        try{
            requestResult = rescueTeamServiceImpl.saveAndUpdate(rescueTeamDto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("救援队伍{saveAndUpdate}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    @Override
    public RequestResult remove(String id) {

        RequestResult requestResult = null;
        try{
            requestResult = rescueTeamServiceImpl.remove(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("救援队伍{remove}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }
}
