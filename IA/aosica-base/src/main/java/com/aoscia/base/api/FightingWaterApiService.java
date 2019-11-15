package com.aoscia.base.api;

import com.aoscia.base.dto.FightingWaterDto;
import com.aoscia.base.service.FightingWaterService;
import com.aosica.common.bean.RequestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @program: ai-planting->FigthingWaterApiService
 * @description: 消防水源对外接口
 * @author: dwj
 * @create: 2019-09-26 15:57
 **/
@RestController
public class FightingWaterApiService implements FightingWaterApi {

    private Logger logger = LoggerFactory.getLogger(FightingWaterApiService.class);

    @Autowired
    private FightingWaterService fightingWaterService;

    /**
     * @desc 消防水源列表
     * @param dto
     * @return
     */
    @Override
    public RequestResult selectList(@RequestBody  FightingWaterDto dto) {
        System.out.println("--------调用消防水源{selectList}接口---------");
        System.out.println("在FigthingWaterApiService打印");
        System.out.println(dto);
        RequestResult requestResult = null;
        try{
            requestResult = fightingWaterService.selectList(dto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防水源{selectList}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    @Override
    public  RequestResult list(HashMap<String,Object> map) {
        System.out.println("--------调用消防水源{selectList}接口---------");
        System.out.println("在FigthingWaterApiService打印");
        System.out.println(map);
        RequestResult requestResult = null;
        try{
            requestResult = fightingWaterService.list(map);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防水源{selectList}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }


    /**
     * @desc 消防水源详情
     * @param id
     * @return
     */
    @Override
    public RequestResult selectDetailById(String id) {
        System.out.println("FightingWaterApiService打印id"+id);
        RequestResult requestResult = null;
        try{
            requestResult = fightingWaterService.selectDetailById(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防水源{selectDetailById}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

    /**
     * @desc 新增或修改消防水源
     * @param fightingWaterDto
     * @return
     */
    @Override
    public RequestResult saveAndUpdate(FightingWaterDto fightingWaterDto) {
        RequestResult requestResult = null;
        try{
            requestResult = fightingWaterService.saveAndUpdate(fightingWaterDto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防水源{saveAndUpdate}接口系统异常"+e.getMessage());
        }
        System.out.println("消防水源{saveAndUpdate}接口系统调用完成");
        System.out.println(requestResult);
        return requestResult;
    }

    @Override
    public RequestResult remove(String id) {
        RequestResult requestResult = null;
        try{
            requestResult = fightingWaterService.remove(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防水源{remove}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }
}
