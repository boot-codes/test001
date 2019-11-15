package com.aoscia.base.api;

import com.aoscia.base.dto.FireLedgerDto;
import com.aoscia.base.service.impl.FireLedgerServiceImpl;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.bean.RequestResultPage;
import com.aosica.common.exception.AosicaServiceQueryException;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ai-planting->FireLedgerApiService
 * @description: 消防台账
 * @author: ll
 * @create: 2019-11-05 17:32
 **/
@RestController
public class FireLedgerApiService implements FireLedgerServiceApi {

    private Logger logger = LoggerFactory.getLogger(FireLedgerApiService.class);

    @Autowired
    private FireLedgerServiceImpl fireLedgerServiceImpl ;


    @Override
    public RequestResultPage<Page<FireLedgerDto>> selectList(FireLedgerDto dto) {
        try {
            Page<FireLedgerDto> page = this.fireLedgerServiceImpl.selectList(dto);
            return  RequestResultPage.buildOK(page) ;
        } catch (AosicaServiceQueryException e) {
            e.printStackTrace();
            return  RequestResultPage.buildFail() ;
        }
    }

    @Override
    public RequestResult saveAndUpdate(FireLedgerDto dto) {
        RequestResult requestResult = null;
        try{
            requestResult = fireLedgerServiceImpl.saveAndUpdate(dto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防台账{saveAndUpdate}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }




    @Override
    public RequestResult<FireLedgerDto> selectDetailById(String id) {
        System.out.println("FireWaterApiService打印id"+id);
        RequestResult requestResult = null;
        try{
            requestResult = fireLedgerServiceImpl.selectDetailById(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防台账{selectDetailById}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }


    @Override
    public RequestResult remove(String id) {
        RequestResult requestResult = null;
        try{
            requestResult = fireLedgerServiceImpl.remove(id);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("消防台账{remove}接口系统异常"+e.getMessage());
        }
        return requestResult;
    }

}
