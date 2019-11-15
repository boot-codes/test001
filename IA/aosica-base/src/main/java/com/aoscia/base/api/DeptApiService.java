package com.aoscia.base.api;


import com.aoscia.base.dto.DeptDto;
import com.aoscia.base.service.DeptService;
import com.aoscia.base.service.impl.DeptServiceImpl;
import com.aosica.common.bean.RequestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @PackgeName com.aosica.base.api
 * @ClassName UserService.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/15 9:50
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/15$ 9:50$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RestController
public class DeptApiService implements DeptServiceApi {
    private Logger logger = LoggerFactory.getLogger(DeptApiService.class);

    @Autowired
    private DeptService deptService;


    /**
     * @desc　获取当前项目下机构树形
     * @param projectId
     * @return
     */
    @Override
    public RequestResult selectList(String projectId) {
        RequestResult requestResult = null;
        try{
            requestResult =  deptService.selectList(projectId);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("机构{selectList}接口异常"+e.getMessage());
        }
        return  requestResult;
    }

    @Override
    public RequestResult save(DeptDto deptDto) {
        RequestResult requestResult = null;
        try{
            requestResult =  deptService.save(deptDto);
        }catch (Exception e){
            requestResult = RequestResult.buildFail();
            logger.info("机构{save}接口异常"+e.getMessage());
        }
        return requestResult;
    }
}
























