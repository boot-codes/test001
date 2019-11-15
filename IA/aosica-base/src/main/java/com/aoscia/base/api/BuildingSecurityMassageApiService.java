package com.aoscia.base.api;

import com.aoscia.base.dto.BuildingSecurityMassageDto;
import com.aoscia.base.service.BuildingSecurityMassageService;
import com.aosica.common.bean.RequestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ai-planting->BuildingSecurityMassageApiService
 * @description: 建筑物安全信息管理
 * @author: ll
 * @create: 2019-11-11 16:02
 **/
@RestController
public class BuildingSecurityMassageApiService implements BuildingSecurityMassageServiceApi{
    private Logger logger = LoggerFactory.getLogger(BuildingSecurityMassageApiService.class);


    @Autowired
    private BuildingSecurityMassageService buildingSecurityMassageService;

    @Override
    public RequestResult<BuildingSecurityMassageDto> queryBuildingSecurityMassageByBuildingId(String buildingId) {

        return RequestResult.buildOkData(buildingSecurityMassageService.queryBuildingSecurityMassageByBuildingId(buildingId));
    }

    @Override
    public RequestResult update(BuildingSecurityMassageDto dto) {
        buildingSecurityMassageService.update(dto);
        return RequestResult.buildOK();
    }
}
