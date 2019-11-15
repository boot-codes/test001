package com.aoscia.base.api;

import com.aoscia.base.dto.LawEnforcementTeamDto;
import com.aoscia.base.service.impl.LawEnforcementTeamServiceImpl;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.common.exception.AosicaServiceQueryException;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ai-planting->LawEnforcementTeamApiService
 * @description: 执法队伍控制器
 * @author: dwj
 * @create: 2019-09-27 16:19
 **/
@RestController
public class LawEnforcementTeamApiService implements LawEnforcementTeamServiceApi{

    private Logger logger = LoggerFactory.getLogger(LawEnforcementTeamApiService.class);

    @Autowired
    private LawEnforcementTeamServiceImpl lawEnforcementTeamServiceImpl;

    /**
     * @desc 执法队伍列表
     * @param dto
     * @return
     */
    @Override
    public RequestResultPage<Page<LawEnforcementTeamDto>> selectList(LawEnforcementTeamDto dto) {
        try {
            Page<LawEnforcementTeamDto> page = this.lawEnforcementTeamServiceImpl.selectList(dto);
            return  RequestResultPage.buildOK(page) ;
        } catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return  RequestResultPage.buildFail() ;
        }
    }

    /**
     * @desc 执法队伍详情
     * @param id
     * @return
     */
    @Override
    public RequestResult selectDetailById(String id) {
        RequestResult requestResult = null;
        try{
            requestResult = lawEnforcementTeamServiceImpl.selectDetailById(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("执法队伍{selectDetailById}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    /**
     * @desc 执法队伍新增或修改
     * @param lawEnforcementTeamDto
     * @return
     */
    @Override
    public RequestResult saveAndUpdate(LawEnforcementTeamDto lawEnforcementTeamDto) {

        System.out.println("进入LawEnforcementTeamApiService--------");
        System.out.println(lawEnforcementTeamDto);
        RequestResult requestResult = null;
        try{
            requestResult = lawEnforcementTeamServiceImpl.saveAndUpdate(lawEnforcementTeamDto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("执法队伍{saveAndUpdate}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    @Override
    public RequestResult remove(String id) {
        RequestResult requestResult = null;
        try{
            requestResult = lawEnforcementTeamServiceImpl.remove(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("执法队伍{remove}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }
}
